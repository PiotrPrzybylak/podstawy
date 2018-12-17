package Sport;

public class Piecioboista extends Sportowiec implements Bieganie, Plywanie {


    public Piecioboista(String imie, String nazwisko) {
        super(imie, nazwisko);
    }

    @Override
    public void biegnij() {
        System.out.println("Biegnę");
    }

    @Override
    public void plyn() {
        System.out.println("Płyń");
    }


    public void rozpocznijSzermierke (){
        System.out.println("Rozpoczynam szermierkę");
    }

    public void rozpocznijJazdeKonna (){
        System.out.println("Rozpoczynam jazdę konną");
    }

    public void strzelaj (){
        System.out.println("Rozpoczynam strzelanie");
    }

    @Override
    public void walczOMedal() {
        biegnij();
        plyn();
        rozpocznijSzermierke ();
        rozpocznijJazdeKonna ();
        strzelaj();


    }
}
