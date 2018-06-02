import java.util.List;

public class AverageRainfall {

    static double calculateTotalRainFall(List<Double> rainFall) {
        Double totalRain = 0.00; // The sum of Rainfall.
        int index;  // the array index
        for (index = 0; index < rainFall.size(); index++){
            totalRain = totalRain + rainFall.get(index);
        }
        return totalRain;
    }

    static double calculateAverageRainFall(List<Double> rainFall) {
        Double averageRain; // The average Rainfall.
        averageRain = calculateTotalRainFall(rainFall) / rainFall.size();
        return averageRain;
    }

}  // end class AverageRainfall
