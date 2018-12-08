package OOP;

public class Fregata extends Statek {

    private String wielkoscBroni;




    public Fregata(String wielkoscBroni) {
        this.wielkoscBroni = wielkoscBroni;
    }

    public Fregata(String nacja, String typ, String nazwa, int iloscHiSlotów, int ilośćMedSlotów, int ilośćLowSlotów, int zasiegNamierzania, int predkoscBazowa, String wielkoscBroni) {
        super(nacja, typ, nazwa, iloscHiSlotów, ilośćMedSlotów, ilośćLowSlotów, zasiegNamierzania, predkoscBazowa);
        this.wielkoscBroni = wielkoscBroni;
    }

    public Fregata(String typ, String nazwa, int iloscHiSlotów, int ilośćMedSlotów, int ilośćLowSlotów, int zasiegNamierzania, int predkoscBazowa, String wielkoscBroni) {
        super(typ, nazwa, iloscHiSlotów, ilośćMedSlotów, ilośćLowSlotów, zasiegNamierzania, predkoscBazowa);
        this.wielkoscBroni = wielkoscBroni;
    }

    public String getWielkoscBroni() {
        return wielkoscBroni;
    }
}
