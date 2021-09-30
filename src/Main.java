import java.lang.Math;
import java.util.Random;

import jdk.jshell.execution.Util;

import java.util.Arrays;

public class Main {
    private final static double[][] data = { { 1, 0, 1, 0, 1 }, { 0, 1, 0, 1, 1 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 },
            { 0, 0, 1, 0, 0 }, { 0, 0, 1, 1, 0 }, { 0, 1, 0, 0, 0 }, { 0, 1, 0, 1, 0 }, { 1, 0, 0, 0, 0 },
            { 1, 0, 0, 1, 0 }, { 1, 0, 1, 1, 0 }, };
    // private final static double[][] data = { { 1, 1, 1, 1, 1 } };

    public static void main(String[] args) {
        int[] size = { 4, 2, 1 };
        Network net = new Network(size);
        System.out.print(net);

        // for (int i = -10; i < 10; i++) {
        // System.out.println(Utils.sigmoid(i));
        // }

        Random rn = new Random();
        for (int i = 0; i < 1000000; i++) {
            int ran = (int) (rn.nextDouble() * data.length);
            double output = net.calc_output(Arrays.copyOfRange(data[ran], 0, 4))[0];
            System.out.println(Math.abs(data[ran][4] - output) + ", " + data[ran][4] + ", " + output);
            double[] correct = { data[ran][4] };
            net.learn(correct);
        }
        System.out.print(net);

        // System.out.print("{");
        // for (int i = 0; i < 1024; i++) {
        // double val = 1 / (1 + Math.pow(Math.E, (10 - i / 51.2)));
        // System.out.print(val + ", ");
        // if (i % 64 == 63) {
        // System.out.println();
        // }

        // }
        // System.out.print("};");

    }

}
