import java.util.stream.Stream;

public class Utils {

    private static final double[] sigmoid_values = { 4.539786870243442E-5, 4.539786870243442E-5, 4.539786870243442E-5,
            4.539786870243442E-5, 4.539786870243442E-5, 1.233945759862318E-4, 1.233945759862318E-4,
            1.233945759862318E-4, 1.233945759862318E-4, 1.233945759862318E-4, 3.3535013046647827E-4,
            3.3535013046647827E-4, 3.3535013046647827E-4, 3.3535013046647827E-4, 3.3535013046647827E-4,
            9.110511944006456E-4, 9.110511944006456E-4, 9.110511944006456E-4, 9.110511944006456E-4,
            9.110511944006456E-4, 0.002472623156634775, 0.002472623156634775, 0.002472623156634775,
            0.002472623156634775, 0.002472623156634775, 0.006692850924284857, 0.006692850924284857,
            0.006692850924284857, 0.006692850924284857, 0.006692850924284857, 0.017986209962091562,
            0.017986209962091562, 0.017986209962091562, 0.017986209962091562, 0.017986209962091562, 0.04742587317756679,
            0.04742587317756679, 0.04742587317756679, 0.04742587317756679, 0.04742587317756679, 0.11920292202211757,
            0.11920292202211757, 0.11920292202211757, 0.11920292202211757, 0.11920292202211757, 0.2689414213699951,
            0.2689414213699951, 0.2689414213699951, 0.2689414213699951, 0.2689414213699951, 0.5, 0.5, 0.5, 0.5, 0.5,
            0.7310585786300049, 0.7310585786300049, 0.7310585786300049, 0.7310585786300049, 0.7310585786300049,
            0.8807970779778823, 0.8807970779778823, 0.8807970779778823, 0.8807970779778823, 0.8807970779778823,
            0.9525741268224331, 0.9525741268224331, 0.9525741268224331, 0.9525741268224331, 0.9525741268224331,
            0.9820137900379085, 0.9820137900379085, 0.9820137900379085, 0.9820137900379085, 0.9820137900379085,
            0.9933071490757153, 0.9933071490757153, 0.9933071490757153, 0.9933071490757153, 0.9933071490757153,
            0.9975273768433653, 0.9975273768433653, 0.9975273768433653, 0.9975273768433653, 0.9975273768433653,
            0.9990889488055994, 0.9990889488055994, 0.9990889488055994, 0.9990889488055994, 0.9990889488055994,
            0.9996646498695336, 0.9996646498695336, 0.9996646498695336, 0.9996646498695336, 0.9996646498695336,
            0.9998766054240137, 0.9998766054240137, 0.9998766054240137, 0.9998766054240137, 0.9998766054240137, };

    public static double sigmoid(double x) {
        int id = (int) (x * 5 + 50);
        return sigmoid_values[((x >= 0 && x < 100) ? id : 0) + ((x >= 100) ? 99 : 0)];
    }

    public static double sum(double[] values, double[] weights) {
        double sum = 0;
        for (int i = values.length - 1; i >= 0; i--) {
            sum += values[i] * weights[i];
        }
        return sum;
    }

}
