package OOP;

public class Pancernik extends Statek {
    private boolean modułOblężniczy;

    public Pancernik(boolean modułOblężniczy) {
        this.modułOblężniczy = modułOblężniczy;
    }

    public Pancernik(Nacja nacja, String typ, String nazwa, int iloscHiSlotów, int ilośćMedSlotów, int ilośćLowSlotów, int zasiegNamierzania, int predkoscBazowa, boolean modułOblężniczy) {
        super(nacja, typ, nazwa, iloscHiSlotów, ilośćMedSlotów, ilośćLowSlotów, zasiegNamierzania, predkoscBazowa);
        this.modułOblężniczy = modułOblężniczy;
    }

    public Pancernik(String typObiektu, Nacja nacja, String typ, String nazwa, int iloscHiSlotów, int ilośćMedSlotów, int ilośćLowSlotów, int zasiegNamierzania, int predkoscBazowa, boolean modułOblężniczy) {
        super(typObiektu, nacja, typ, nazwa, iloscHiSlotów, ilośćMedSlotów, ilośćLowSlotów, zasiegNamierzania, predkoscBazowa);
        this.modułOblężniczy = modułOblężniczy;
    }


    public boolean isModułOblężniczy() {
        return modułOblężniczy;
    }

    public String toString () {
       return super.toString()+ " Obecność modułu oblężniczego: " + modułOblężniczy;
    }
}
