package terraario.eliot;

import java.awt.Color;
import terraario.Maailma;
import terraario.Piste;

public class Herbivori extends Elio {

    public Herbivori(Piste sijainti, double paino) {
        super(sijainti, paino);
    }

    public void syo(Elio elio) {
        this.setPaino(this.getPaino()+elio.getPaino() / 3);
        elio.setPaino(0);
    }

    
    @Override
    public void elele(Maailma maailma) {
        if (getPaino() <= 0) {
            return;
        }

        setPaino(getPaino() * 0.999);

        Elio lahin = null;
        double etaisyys = Double.MAX_VALUE;

        for (Elio elio : maailma.getEliot()) {
            if (!(elio instanceof Kasvi)) {
                continue;
            }

            if (lahin == null) {
                lahin = elio;
                etaisyys = getSijainti().etaisyys(elio.getSijainti());
                continue;
            }

            if (getSijainti().etaisyys(elio.getSijainti()) < etaisyys) {
                etaisyys = getSijainti().etaisyys(elio.getSijainti());
                lahin = elio;
            }
        }

        if (lahin == null) {
            // random sivuttaisliike
            if (Math.random() > 0.5) {
                getSijainti().setX(getSijainti().getX() - 1);
            } else {
                getSijainti().setX(getSijainti().getX() + 1);
            }
            return;
        }

        if (etaisyys < 1) {
            syo(lahin);
            return;
        }

        if (lahin.getSijainti().getX() < getSijainti().getX()) {
            getSijainti().setX(getSijainti().getX() - 1);
        } else if (lahin.getSijainti().getX() > getSijainti().getX()) {
            getSijainti().setX(getSijainti().getX() + 1);
        } else if (lahin.getSijainti().getY() < getSijainti().getY()) {
            getSijainti().setY(getSijainti().getY() - 1);
        } else if (lahin.getSijainti().getY() > getSijainti().getY()) {
            getSijainti().setY(getSijainti().getY() + 1);
        }
    }

    @Override
    public Color getColor() {
        return Color.BLUE;
    }
}
