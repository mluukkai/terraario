package terraario;

import terraario.eliot.Elio;
import java.util.ArrayList;
import java.util.List;

public class Maailma {

    private final List<Elio> eliot;
    private final int leveys;
    private final int korkeus;

    public Maailma(List<Elio> eliot, int maailmanLeveys, int maailmanKorkeus) {
        this.eliot = eliot;
        this.leveys = maailmanLeveys;
        this.korkeus = maailmanKorkeus;
    }

    public int leveys() {
        return leveys;
    }

    public int korkeus() {
        return korkeus;
    }

    public List<Elio> getEliot() {
        return eliot;
    }

    public void elele() {
        List<Elio> poistettavat = new ArrayList<Elio>();
        for (Elio elio : eliot) {
            elio.elele(this);
            
            if(elio.getPaino() <= 0) {
                poistettavat.add(elio);
            }
        }
        
        eliot.removeAll(poistettavat);
    }
}
