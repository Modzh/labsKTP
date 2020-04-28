package lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

import static lab4.FractalGenerator.getCoord;

public class FractalExplorer {
    private int size;
    private JImageDisplay imageDisplay;
    private FractalGenerator generator;
    private Rectangle2D.Double range;

    private FractalExplorer(int size) {
        this.size = size;
        generator = new Mandelbrot();
        range = new Rectangle2D.Double(0, 0, size, size);
    }

    /**
     * launches main app with picture sized 800*800
     * @param args
     */
    public static void main(String[] args) {
        FractalExplorer explorer = new FractalExplorer(800);
        explorer.createAndShowGUI();
        explorer.drawFractal();
    }

    void createAndShowGUI() {
        JFrame frame = new JFrame("Fractal");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new BorderLayout());

        //mouse click zooms into current picture by redrawing fractal with new coordinates
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                double xCoord = getCoord(range.x, range.x + range.width, size, e.getX());
                double yCoord = getCoord(range.y, range.y + range.height, size, e.getY());
                generator.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
                drawFractal();
            }
        });

        //"clear" button recreates the picture with default parameters
        JButton button = new JButton("clear");
        button.addActionListener(e -> {
            generator.getInitialRange(range);
            drawFractal();
        });
        panel.add(button, BorderLayout.SOUTH);

        imageDisplay = new JImageDisplay(size, size);
        panel.add(imageDisplay, BorderLayout.CENTER);

        //initiating default range
        generator.getInitialRange(range);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    void drawFractal() {
        int a = 0;
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                double xCoord = getCoord(range.x, range.x + range.width, size, x);
                double yCoord = getCoord(range.y, range.y + range.height, size, y);

                int numIters = generator.numIterations(xCoord, yCoord);
                paintPixel(x, size - 1 - y, numIters);
            }
        }
        imageDisplay.repaint();


    }

    private void paintPixel(int x, int y, int numIters) {
        int rgbColor = numIters == -1 ? 0 : Color.HSBtoRGB(0.7f + (float) numIters / 200f, 1f, 1f);
        imageDisplay.drawPixel(x, y, rgbColor);
    }


}
