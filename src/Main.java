import java.lang.Math;
import java.util.Random;

import Components.Network;
import Output.Graphics.Window;
import Output.Inputs.ScreenCapture;
import jdk.jshell.execution.Util;

import java.util.Arrays;
import java.awt.Robot;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        Window.init_window(500, 500);
        Robot r = null;
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        Rectangle rect = new Rectangle(50, 50, 550, 550);
        float[] pixels = new float[500 * 500 * 3];
        for (int i = 0; i < 500 * 500 * 3; i += 1) {
            pixels[i] = 1;
        }
        while (true) {
            ScreenCapture.capture(r, rect, pixels);
            Window.update_pixels(pixels);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        // int[] size = { 4, 4, 2, 1 };
        // Network net = new Network(size);

        // System.out.println(net);
        // Network net2 = new Network(net.toString());
        // System.out.println(net2);
        // net2.save("Save.txt");
        // Network net3 = Network.load("Save.txt");
        // System.out.println(net3);

    }

}
