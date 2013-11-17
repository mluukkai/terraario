package terraario.eliot;

import java.awt.Color;
import terraario.Maailma;
import terraario.Piste;

public abstract class Elio {

    private Piste sijainti;
    private double paino;

    public Elio(Piste sijainti, double paino) {
        this.sijainti = sijainti;
        this.paino = paino;
    }

    public abstract void elele(Maailma maailma);

    public abstract Color getColor();

    public double getPaino() {
        return paino;
    }

    public Piste getSijainti() {
        return sijainti;
    }

    public void setPaino(double paino) {
        this.paino = paino;
    }

}
