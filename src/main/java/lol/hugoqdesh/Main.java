package lol.hugoqdesh;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Main extends JPanel {
    private final BufferedImage image;

    public Main() {
        int width = 1920;
        int height = 1080;
        int n = 255;
        setPreferredSize(new Dimension(width, height));
        this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for(int i = 0; i < height; i++) {
            double y = (i / 1920.0) * 7 - 2;

            for(int j = 0; j < width; j++) {
                double x = (j / 1080.0) * 4 - 4;

                double zImaginary = 0;
                double zReal = 0;

                int count = 0;
                while (count < n) {
                    double tempReal = zReal * zReal - zImaginary * zImaginary + x;
                    double tempImaginary = 2 * zReal * zImaginary + y;

                    zReal = tempReal;
                    zImaginary = tempImaginary;

                    if (zReal * zReal + zImaginary * zImaginary > 4) {
                        break;
                    }
                    count++;
                }
                image.setRGB(j, i, count * 0x010101);
            }
        }
    }

    static void main() {
        JFrame frame = new JFrame("Mandelbrot Set");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Main());
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }
}
