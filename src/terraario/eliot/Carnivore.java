package terraario.eliot;

import java.awt.Color;
import terraario.Maailma;
import terraario.Piste;

public class Carnivore extends Herbivori {

    public Carnivore(Piste sijainti, double paino) {
        super(sijainti, paino);
    }

    @Override
    public void elele(Maailma maailma) {
        if (getPaino() <= 0) {
            return;
        }

        setPaino(getPaino() * 0.998);

        Elio lahin = null;
        double etaisyys = Double.MAX_VALUE;

        for (Elio elio : maailma.getEliot()) {
            if (!(elio instanceof Herbivori)) {
                continue;
            }

            if (elio == this) {
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
            super.elele(maailma);
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
        return Color.RED;
    }
}
