package OOP;

public class Fregata extends Statek {

    private String wielkoscBroni;

    public Fregata(String wielkoscBroni) {
        this.wielkoscBroni = wielkoscBroni;
    }

    public Fregata(Nacja nacja, String typ, String nazwa, int iloscHiSlotów, int ilośćMedSlotów, int ilośćLowSlotów, int zasiegNamierzania, int predkoscBazowa, String wielkoscBroni) {
        super(nacja, typ, nazwa, iloscHiSlotów, ilośćMedSlotów, ilośćLowSlotów, zasiegNamierzania, predkoscBazowa);
        this.wielkoscBroni = wielkoscBroni;
    }

    public Fregata(String typObiektu, Nacja nacja, String typ, String nazwa, int iloscHiSlotów, int ilośćMedSlotów, int ilośćLowSlotów, int zasiegNamierzania, int predkoscBazowa, String wielkoscBroni) {
        super(typObiektu, nacja, typ, nazwa, iloscHiSlotów, ilośćMedSlotów, ilośćLowSlotów, zasiegNamierzania, predkoscBazowa);
        this.wielkoscBroni = wielkoscBroni;
    }


    public String getWielkoscBroni() {
        return wielkoscBroni;
    }

    public String toString () {
        return super.toString() +" Maksymawlna wielkość montowanej broni: " + wielkoscBroni;
    }


}
