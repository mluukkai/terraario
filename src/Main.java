
import terraario.Terrario;

public class Main {

    public static void main(String[] args) {
        Jumala jumala = new Jumala();

        Terrario.kaynnista(800, 600, 5);

        Terrario.lisaa(jumala.luoKasvi());
        Terrario.lisaa(jumala.luoKasvi());
        Terrario.lisaa(jumala.luoKasvi());

        for (int i = 0; i < 100; i++) {
            Terrario.elele();
        }

        Terrario.lisaa(jumala.luoKasvissyoja());

        while (true) {
            if (Math.random() < 0.05) {
                Terrario.lisaa(jumala.luoKasvi());
            }

            if (Math.random() < 0.01) {
                Terrario.lisaa(jumala.luoKasvissyoja());
            }

            if (Math.random() < 0.01) {
                Terrario.lisaa(jumala.luoLihansyoja());
            }

            Terrario.elele();

        }

    }
}
