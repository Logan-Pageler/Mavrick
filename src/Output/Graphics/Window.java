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
    public static int[] pixels;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < hieght; y++) {
                g.setR
            }
        }

    }

    public static void update_pixels(int[] pixels){
        Window.pixels = pixels;
    }

    public static void init_window(int width, int height) {
        Window.width = width;
        Window.height = height;

        SwingUtilities.invokeLater(() -> {
            var panel = new Window();
            panel.setBackground(Color.GREEN.darker());
            var frame = new JFrame("A simple graphics program");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(panel, BorderLayout.CENTER);
            frame.setVisible(true);
        });
    
    }
    
}
