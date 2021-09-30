package Output.Graphics;

import java.awt.*;
import java.awt.image.VolatileImage;

public class Screen {
    VolatileImage image;

    public Screen(int width, int height) {

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsConfiguration gc = ge.getDefaultScreenDevice().getDefaultConfiguration();
        do {
            image = gc.createCompatibleVolatileImage(width, height);
        } while (image.validate(gc) == VolatileImage.IMAGE_INCOMPATIBLE);

    }

    public void draw_screen(Graphics g) {

    }

}
