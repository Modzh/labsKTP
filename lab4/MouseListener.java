package lab4;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class MouseListener extends MouseAdapter {

    private FractalGenerator generator;
    private Rectangle2D.Double range;



    public MouseListener(FractalGenerator generator, Rectangle2D.Double range) {
        this.generator = generator;
        this.range = range;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        range.x = x;
        range.y = y;
        generator.recenterAndZoomRange(range, x, y, 0.5);

    }
}
