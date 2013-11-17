package terraario.eliot;

import terraario.Maailma;
import terraario.Piste;

public class Kasvi extends Elio {

    public Kasvi(Piste sijainti, double paino) {
        super(sijainti, paino);
    }

    @Override
    public void elele(Maailma maailma) {
        if(getPaino() <= 0) {
            return;
        }
        
        setPaino(getPaino() * 1.001);
    }
}
