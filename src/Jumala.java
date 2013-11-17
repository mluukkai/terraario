
import java.util.Random;
import terraario.Piste;
import terraario.eliot.Carnivore;
import terraario.eliot.Elio;
import terraario.eliot.Herbivori;
import terraario.eliot.Kasvi;

public class Jumala {

    private int maailmanLeveys;
    private int maailmanKorkeus;
    private Random arpa;

    public Jumala(int maailmanLeveys, int maailmanKorkeus) {
        this.maailmanLeveys = maailmanLeveys;
        this.maailmanKorkeus = maailmanKorkeus;
        arpa = new Random();
    }

    public Elio luoLihansyoja() {
        return new Carnivore(arvoSijainti(), 8 + arpa.nextInt(8));
    }

    public Elio luoKasvissyoja() {
        return new Herbivori(arvoSijainti(), 4 + arpa.nextInt(4));
    }

    public Elio luoKasvi() {
        return new Kasvi(arvoSijainti(), 2 + arpa.nextInt(2));
    }

    private Piste arvoSijainti() {
        return new Piste(arpa.nextInt(maailmanLeveys) + 1,
                arpa.nextInt(maailmanKorkeus) + 1);
    }
}
