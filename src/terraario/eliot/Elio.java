package terraario.eliot;

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

    public void syo(Elio elio) {
        this.paino += elio.getPaino() / 4;
        elio.setPaino(0);
    }

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
