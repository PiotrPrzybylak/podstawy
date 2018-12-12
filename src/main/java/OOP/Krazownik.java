package OOP;

public class Krazownik extends Statek {

    String nazwa;
    int dps;
    int ehp;


    public Krazownik() {
    }

    public Krazownik(String nazwa, int dps, int ehp) {
        this.dps = dps;
        this.ehp = ehp;
    }

    public Krazownik(Nacja nacja, String typ, String nazwa, int iloscHiSlotów, int ilośćMedSlotów, int ilośćLowSlotów, int zasiegNamierzania, int predkoscBazowa, int dps, int ehp) {
        super(nacja, typ, nazwa, iloscHiSlotów, ilośćMedSlotów, ilośćLowSlotów, zasiegNamierzania, predkoscBazowa);
        this.dps = dps;
        this.ehp = ehp;
    }

    public Krazownik(String typObiektu, Nacja nacja, String typ, String nazwa, int iloscHiSlotów, int ilośćMedSlotów, int ilośćLowSlotów, int zasiegNamierzania, int predkoscBazowa, int dps, int ehp) {
        super(typObiektu, nacja, typ, nazwa, iloscHiSlotów, ilośćMedSlotów, ilośćLowSlotów, zasiegNamierzania, predkoscBazowa);
        this.dps = dps;
        this.ehp = ehp;
    }


    public int getDps() {
        return dps;
    }

    public int getEhp() {
        return ehp;
    }

    @Override
    public String getNazwa() {
        return nazwa;
    }
}
