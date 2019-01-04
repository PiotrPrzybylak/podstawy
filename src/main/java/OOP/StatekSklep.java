package OOP;

public class StatekSklep extends Statek{

    private int cena;

    public StatekSklep() {
    }

    public StatekSklep(Nacja nacja, String typ, String nazwa, int dps, int ehp, int cena) {
        super(nacja, typ, nazwa, dps, ehp);
        this.cena = cena;
    }

    public StatekSklep(String typObiektu, Nacja nacja, String typ, String nazwa, int dps, int ehp, int cena) {
        super(typObiektu, nacja, typ, nazwa, dps, ehp);
        this.cena = cena;
    }

    public int getCena() {
        return cena;
    }
}
