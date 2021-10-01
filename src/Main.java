import java.lang.Math;
import java.util.Random;

import Output.Graphics.Window;
import jdk.jshell.execution.Util;

import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        // Window.init_window(500, 500);
        // int[] pixels = new int[500 * 500 * 3];
        // for (int i = 0; i < 500 * 500 * 3; i += 1) {
        //     pixels[i] = 1;
        // }
        // Window.update_pixels(pixels);
        // System.out.println("hi");
        int[] size = {4, 4, 2, 1};
        Network net = new Network(size);

        System.out.println(net);
        Network net2 = new Network(net.toString());
        System.out.println(net2);

    }

}
