
import terraario.Terraario;

public class Main {

    public static void main(String[] args) {
        int leveys = 800;
        int korkeus = 600;

        Jumala jumala = new Jumala(leveys, korkeus);

        Terraario.kaynnista(leveys, korkeus, 10);

        Terraario.lisaa(jumala.luoKasvi());
        Terraario.lisaa(jumala.luoKasvi());
        Terraario.lisaa(jumala.luoKasvi());

        for (int i = 0; i < 100; i++) {
            Terraario.elele();
        }

        Terraario.lisaa(jumala.luoKasvissyoja());

        while (true) {
            if (Math.random() < 0.05) {
                Terraario.lisaa(jumala.luoKasvi());
            }

            if (Math.random() < 0.01) {
                Terraario.lisaa(jumala.luoKasvissyoja());
            }

            if (Math.random() < 0.01) {
                Terraario.lisaa(jumala.luoLihansyoja());
            }

            Terraario.elele();

        }

    }
}
