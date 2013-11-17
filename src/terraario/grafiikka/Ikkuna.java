package terraario.grafiikka;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import terraario.Maailma;

public class Ikkuna implements Runnable {

    private JFrame frame;
    private final Maailma maailma;

    public Ikkuna(Maailma maailma) {
        this.maailma = maailma;
    }

    @Override
    public void run() {
        frame = new JFrame("Terraario");
        frame.setPreferredSize(new Dimension(400, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        Piirtoalusta piirtoalusta = new Piirtoalusta(maailma);
        container.add(piirtoalusta);
    }

    public JFrame getFrame() {
        return frame;
    }
}
