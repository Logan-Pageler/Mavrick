import java.lang.Math;
import java.util.Random;
import java.util.Arrays;

public class Main {
    private final static double[][] data = {
        {
            1, 0, 1, 0, 1
        },
        {
            0, 1, 0, 1, 1
        },
        {
            0, 0, 0, 0, 0
        },
        {
            0, 0, 0, 1, 0
        },
        {
            0, 0, 1, 0, 0
        },
        {
            0, 0, 1, 1, 0
        },
        {
            0, 1, 0, 0, 0
        },
        {
            0, 1, 0, 1, 0
        },
        {
            1, 0, 0, 0, 0
        },
        {
            1, 0, 0, 1, 0
        },
        {
            1, 0, 1, 1, 0
        },
    };
    public static void main(String[] args) {
        int[] size = {4, 2, 1};
        Network net = new Network(size);
        System.out.print(net);

        Random rn = new Random();
        for(int i = 0; i < 10000; i++) {
            int ran = (int)(rn.nextDouble() * data.length);

            System.out.print(net.calc_output(Arrays.copyOfRange(data[ran], 0, 4))[0]);
            double [] correct = {data[ran][4]};
            net.learn(correct);
        }
        // System.out.print("{");
        // for (int i = 0; i < 100; i++) {
        // double val = 1 / (1 + Math.pow(Math.E, (10 - i / 5)));
        // System.out.print(val + ", ");
        // if (i % 10 == 9) {
        // System.out.println();
        // }

        // }
        // System.out.print("};");

    }

}
