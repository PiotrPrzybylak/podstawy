package OOP;

public class Krazownik extends Statek {
    public Krazownik() {
    }

    public Krazownik(Nacja nacja, String typ, String nazwa, int dps, int ehp) {
        super(nacja, typ, nazwa, dps, ehp);
    }

    public Krazownik(String typObiektu, Nacja nacja, String typ, String nazwa, int dps, int ehp) {
        super(typObiektu, nacja, typ, nazwa, dps, ehp);
    }

}
