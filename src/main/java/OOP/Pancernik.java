package OOP;

public class Pancernik extends Statek {
    private boolean modułOblężniczy;

    public Pancernik(boolean modułOblężniczy) {
        this.modułOblężniczy = modułOblężniczy;
    }

    public Pancernik(String nacja, String typ, String nazwa, int iloscHiSlotów, int ilośćMedSlotów, int ilośćLowSlotów, int zasiegNamierzania, int predkoscBazowa, boolean modułOblężniczy) {
        super(nacja, typ, nazwa, iloscHiSlotów, ilośćMedSlotów, ilośćLowSlotów, zasiegNamierzania, predkoscBazowa);
        this.modułOblężniczy = modułOblężniczy;
    }

    public Pancernik(String typ, String nazwa, int iloscHiSlotów, int ilośćMedSlotów, int ilośćLowSlotów, int zasiegNamierzania, int predkoscBazowa, boolean modułOblężniczy) {
        super(typ, nazwa, iloscHiSlotów, ilośćMedSlotów, ilośćLowSlotów, zasiegNamierzania, predkoscBazowa);
        this.modułOblężniczy = modułOblężniczy;
    }

    public boolean isModułOblężniczy() {
        return modułOblężniczy;
    }
}
