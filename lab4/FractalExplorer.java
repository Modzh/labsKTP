package lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

import static lab4.FractalGenerator.getCoord;

public class FractalExplorer {
    private int size;
    private JImageDisplay imageDisplay;
    private FractalGenerator generator;
    private Rectangle2D.Double range;

    public FractalExplorer(int size) {
        this.size = size;
        generator = new Mandelbrot();
        range = new Rectangle2D.Double(0, 0, size, size);
    }

    public static void main(String[] args) {
        FractalExplorer explorer = new FractalExplorer(800);
        explorer.createAndShowGUI();
        explorer.drawFractal();
    }

    void createAndShowGUI() {
        JFrame frame = new JFrame("Fractal");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        MouseListener mListener = new MouseListener(generator, range);
        frame.addMouseListener(mListener);

        imageDisplay = new JImageDisplay(size, size);
        panel.add(imageDisplay, BorderLayout.CENTER);

        JButton button = new JButton("clear");
        ClearListener listener = new ClearListener(generator, imageDisplay);
        button.addActionListener(listener);
        panel.add(button, BorderLayout.SOUTH);

        frame.getContentPane().add(panel);

        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private void drawFractal() {
        int a = 0;
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                generator.getInitialRange(range);

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
