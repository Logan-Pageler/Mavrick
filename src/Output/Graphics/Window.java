package Output.Graphics;

import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JPanel {
    public static int width, height;
    static Screen screen;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        screen.draw(g);
    }

    public static void update_pixels(float[] pixels) {
        screen.update(pixels);
    }

    public static void init_window(int width, int height) {
        Window.width = width;
        Window.height = height;
        screen = new Screen();

        SwingUtilities.invokeLater(() -> {
            var panel = new Window();
            panel.setBackground(Color.GREEN.darker());
            var frame = new JFrame("A simple graphics program");
            frame.setSize(width, height);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(panel, BorderLayout.CENTER);
            frame.setVisible(true);
        });

    }

}
