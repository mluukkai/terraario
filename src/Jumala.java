
import java.util.Random;
import terraario.Piste;
import terraario.eliot.Carnivore;
import terraario.eliot.Elio;
import terraario.eliot.Herbivori;
import terraario.eliot.Kasvi;

public class Jumala {
    Random arpa = new Random();
        
    public Elio luoLihansyoja(){
        return new Carnivore( new Piste(arpa.nextInt(350) + 10, arpa.nextInt(350) + 10), 8 + arpa.nextInt(10) );
    } 
   
    public Elio luoKasvissyoja(){
        return new Herbivori(new Piste(arpa.nextInt(350) + 10, arpa.nextInt(350) + 10), 1 + arpa.nextInt(10));
    }
    
    public Elio luoKasvi(){
        return new Kasvi(new Piste(arpa.nextInt(350) + 10, arpa.nextInt(350) + 10), 1 + arpa.nextInt(10));
    }
}
