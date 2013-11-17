package terraario;

import java.util.ArrayList;
import java.util.Random;
import terraario.grafiikka.Ikkuna;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import terraario.eliot.Elio;
import terraario.eliot.Kasvi;

public class Terraario {

    private final Maailma maailma;
    private final Ikkuna ikkuna;
    private final int odotusaika;

    private static Terraario ohjain;

    private Terraario(Maailma maailma, Ikkuna ikkuna, int odotusaika) {
        this.maailma = maailma;
        this.ikkuna = ikkuna;
        this.odotusaika = odotusaika;
    }

    public static void kaynnista(int maailmanLeveys, int maailmanKorkeus, int odotusMillisekunteina) {
        if (ohjain != null) {
            virheKaynnissa();
            return;
        }
        
        Maailma maailma = new Maailma(new ArrayList<Elio>(), maailmanLeveys, maailmanKorkeus);
        Ikkuna ikkuna = new Ikkuna(maailma);
        SwingUtilities.invokeLater(ikkuna);

        ohjain = new Terraario(maailma, ikkuna, odotusMillisekunteina);

        odota();
    }

    public static void kaynnista(int maailmanLeveys, int maailmanKorkeus) {
        kaynnista(maailmanLeveys, maailmanKorkeus, 500);
    }

    public static void kaynnista(int odotusMillisekunteina) {
        kaynnista(20, 20, odotusMillisekunteina);
    }

    public static void kaynnista() {
        kaynnista(20, 20);
    }

    public static void kasvi() {
        if (ohjain == null) {
            virheEiKaynnissa();
            return;
        }

        Random arpa = new Random();
        ohjain.maailma.getEliot().add(
                new Kasvi(new Piste(arpa.nextInt(350) + 10, arpa.nextInt(350) + 10), 1 + arpa.nextInt(10)));

        odota();
    }

    public static void lisaa(Elio elio) {
        if (ohjain == null) {
            virheEiKaynnissa();
            return;
        }

        ohjain.maailma.getEliot().add(elio);
        odota();
    }

    public static void elele() {
        if (ohjain == null) {
            virheEiKaynnissa();
            return;
        }

        ohjain.maailma.elele();

        odota();
    }

    private static void odota() {
        odota(ohjain.odotusaika);
    }

    private static void odota(int millisekuntia) {
        try {
            Thread.sleep(millisekuntia);
        } catch (InterruptedException ex) {
        }

        while (ohjain.ikkuna == null || ohjain.ikkuna.getFrame() == null) {
            try {
                Thread.sleep(25);
            } catch (InterruptedException ex) {

            }
        }

        ohjain.ikkuna.getFrame().repaint();
    }

    private static void virheEiKaynnissa() {
        JOptionPane.showMessageDialog(null,
                "Ohjain pitää ensin käynnistää! Käytä aluksi komentoa \"Terraario.kaynnista();\".");
    }

    private static void virheKaynnissa() {
        JOptionPane.showMessageDialog(null,
                "Terraario on jo käynnissä!");
    }
}
