package Output.Inputs;

import java.awt.Robot;
import java.awt.image.BufferedImage;

import Output.Graphics.Screen;

import java.awt.Rectangle;

public class ScreenCapture {
    public static void capture(Robot r, Rectangle rect, float[] inputs) {
        BufferedImage img = r.createScreenCapture(rect);
        for (int y = 0; y < rect.height; y++) {
            int y_offset = y * rect.width;
            for (int x = 0; x < rect.width; x++) {
                int offset = (y_offset + x) * 3;
                int rgb = img.getRGB(x, y);
                inputs[offset] = rgb / Screen.RED / 255f;
                inputs[offset + 1] = rgb / Screen.GREEN / 255f;
                inputs[offset + 2] = rgb / 255f;
            }
        }
    }
}
