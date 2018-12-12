package OOP;

public class Fregata extends Statek {


    public Fregata() {
    }

    public Fregata(Nacja nacja, String typ, String nazwa, int dps, int ehp) {
        super(nacja, typ, nazwa, dps, ehp);
    }

    public Fregata(String typObiektu, Nacja nacja, String typ, String nazwa, int dps, int ehp) {
        super(typObiektu, nacja, typ, nazwa, dps, ehp);
    }

    public String toString () {
        return super.toString();
    }


}
