package terraario.grafiikka;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.AffineTransform;
import java.util.List;
import javax.swing.JPanel;
import terraario.eliot.Elio;
import terraario.Maailma;

public class Piirtoalusta extends JPanel {

    private AffineTransform tempTransform;
    private final Maailma maailma;

    public Piirtoalusta(Maailma maailma) {
        super.setBackground(Color.WHITE);
        this.maailma = maailma;
    }

    private void piirraEliot(Graphics graphics, List<Elio> eliot) {
        for (Elio elio : eliot) {
            graphics.setColor(elio.getColor());

            graphics.fillOval(
                    (int) (elio.getSijainti().getX() - elio.getPaino() / 2),
                    (int) (elio.getSijainti().getY() - elio.getPaino() / 2),
                    (int) elio.getPaino(),
                    (int) elio.getPaino());
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        flip(graphics);

        List<Elio> eliot = maailma.getEliot();

        piirraEliot(graphics, eliot);

        flipBack(graphics);
    }

    private void flip(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;

        Insets insets = getInsets();
        int h = getHeight() - insets.top - insets.bottom;
        tempTransform = g2d.getTransform();
        g2d.scale(1.0, -1.0);
        g2d.translate(0, -h - insets.top);
    }

    private void flipBack(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setTransform(tempTransform);
    }
}
