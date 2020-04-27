package lab4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearListener implements ActionListener {
    private FractalGenerator generator;
    private JImageDisplay imageDisplay;


    public ClearListener(FractalGenerator generator, JImageDisplay imageDisplay) {
        this.generator = generator;
        this.imageDisplay = imageDisplay;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
