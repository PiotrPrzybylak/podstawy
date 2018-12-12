package OOP;

public class Pancernik extends Statek {


    public Pancernik() {
    }

    public Pancernik(Nacja nacja, String typ, String nazwa, int dps, int ehp) {
        super(nacja, typ, nazwa, dps, ehp);
    }

    public Pancernik(String typObiektu, Nacja nacja, String typ, String nazwa, int dps, int ehp) {
        super(typObiektu, nacja, typ, nazwa, dps, ehp);
    }

    public String toString () {
       return super.toString();
    }
}
