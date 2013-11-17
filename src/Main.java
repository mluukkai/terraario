
import terraario.Ohjain;

public class Main {

    public static void main(String[] args) {
        Ohjain.kaynnista(800, 600, 5);

        Ohjain.kasvi();
        Ohjain.kasvi();
        Ohjain.kasvi();

        for (int i = 0; i < 100; i++) {
            Ohjain.elele();
        }

        Ohjain.herbivori();

        while (true) {
            if (Math.random() < 0.05) {
                Ohjain.kasvi();
            }

            if (Math.random() < 0.01) {
                Ohjain.herbivori();
            }

            if (Math.random() < 0.01) {
                Ohjain.carnivore();
            }

            Ohjain.elele();

        }

    }
}
