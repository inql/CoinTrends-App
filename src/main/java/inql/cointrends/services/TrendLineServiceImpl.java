package inql.cointrends.services;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class TrendLineServiceImpl implements TrendLineService {



    @Override
    public List<Object[]> generateTrendLine(List<Object[]> input) {
        List<Object[]> result = new LinkedList<>();

        int i = 1;
        while(i+7<input.size()+1){
            int count = 7;
            List<Integer> xAxis = IntStream.rangeClosed(i-1,i+5).boxed().collect(Collectors.toList());
            List<Double> yAxis = new LinkedList<>();
            for(int j =0; j<count; j++){
                yAxis.add((Double)input.get(i-1+j)[1]);
            }
            int xValuesSum = xAxis.stream().mapToInt(Integer::intValue).sum();
            Double yValuesSum = yAxis.stream().mapToDouble(Double::doubleValue).sum();
            Double xySum =0.00;
            Double xxSum =0.00;
            for(int k = 0; k< count; k++){
                xySum += (xAxis.get(k)*yAxis.get(k));
                xxSum += (xAxis.get(k)*xAxis.get(k));
            }
            Double slope = calculateSlope(count,xySum,xxSum,xValuesSum,yValuesSum);
            Double intercept = calculateIntercept(slope,xValuesSum,yValuesSum,count);
            if(i==1){
                Object[] point1 = new Object[2];
                point1[0] = input.get(i-1)[0];
                point1[1] = (slope*xAxis.get(0) + intercept)*2;
                result.add(point1);
            }

            Object[] point2 = new Object[2];
            point2[0] = input.get(i+5)[0];
            point2[1] = (slope*xAxis.get(6) + intercept)*2;

            result.add(point2);
            i+=7;
        }
        return result;

    }

    private Double calculateSlope (int count, Double xySum, Double xxSum, int xValuesSum, Double yValuesSum){
        try{
            return ((count*xySum)-(xValuesSum*yValuesSum))/((count*xxSum)-(xValuesSum*xValuesSum));
        }catch (ArithmeticException e){
            return 0.00;
        }
    }

    private Double calculateIntercept(Double slope, int xValuesSum, Double yValuesSum, int count){
        return (yValuesSum- (slope*xValuesSum))/count;
    }
}
