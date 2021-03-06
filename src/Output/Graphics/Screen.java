package Output.Graphics;

import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class Screen {

    BufferedImage image;

    public static final int RED = 65536;
    public static final int GREEN = 256;
    public static final int BLUE = 1;

    // Used BufferedImage for speed
    // If still to slow consider VolatileImage
    public Screen() {
        image = new BufferedImage(Window.width, Window.height, BufferedImage.TYPE_INT_RGB);
    }

    public void draw(Graphics g) {
        g.drawImage(image, 0, 0, null);
    }

    public void update(float[] pixels) {
        for (int y = 0; y < Window.height; y++) {
            int y_offset = y * Window.width;
            for (int x = 0; x < Window.width; x++) {
                image.setRGB(x, y,
                        (int) (pixels[(y_offset + x) * 3] * 255) * RED
                                + (int) (pixels[(y_offset + x) * 3 + 1] * 255) * GREEN
                                + (int) (pixels[(y_offset + x) * 3 + 2] * 255));
            }
        }
    }

}
