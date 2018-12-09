package OOP;

public class Statek extends ObiektLatajacy {

    private String nacja;
    private String typ;
    private String nazwa;
    private int iloscHiSlotów;
    private int ilośćMedSlotów;
    private int ilośćLowSlotów;
    private int zasiegNamierzania;
    private int predkoscBazowa;


    public Statek() {
    }

    public Statek(String nacja, String typ, String nazwa, int iloscHiSlotów, int ilośćMedSlotów, int ilośćLowSlotów, int zasiegNamierzania, int predkoscBazowa) {
        this.nacja = nacja;
        this.typ = typ;
        this.nazwa = nazwa;
        this.iloscHiSlotów = iloscHiSlotów;
        this.ilośćMedSlotów = ilośćMedSlotów;
        this.ilośćLowSlotów = ilośćLowSlotów;
        this.zasiegNamierzania = zasiegNamierzania;
        this.predkoscBazowa = predkoscBazowa;
    }

    public Statek(String typObiektu, String nacja, String typ, String nazwa, int iloscHiSlotów, int ilośćMedSlotów, int ilośćLowSlotów, int zasiegNamierzania, int predkoscBazowa) {
        super(typObiektu);
        this.nacja = nacja;
        this.typ = typ;
        this.nazwa = nazwa;
        this.iloscHiSlotów = iloscHiSlotów;
        this.ilośćMedSlotów = ilośćMedSlotów;
        this.ilośćLowSlotów = ilośćLowSlotów;
        this.zasiegNamierzania = zasiegNamierzania;
        this.predkoscBazowa = predkoscBazowa;
    }

    public String getNacja() {
        return nacja;
    }

    public String getTyp() {
        return typ;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getIloscHiSlotów() {
        return iloscHiSlotów;
    }

    public int getIlośćMedSlotów() {
        return ilośćMedSlotów;
    }

    public int getIlośćLowSlotów() {
        return ilośćLowSlotów;
    }

    public int getZasiegNamierzania() {
        return zasiegNamierzania;
    }

    public int getPredkoscBazowa() {
        return predkoscBazowa;
    }


    public String toString (){
      return "Nacja: "+ nacja + ", Typ Statku: "+ typ + ", nazwa: "+nazwa+", Ilość dostępnych slotów Hi: "+iloscHiSlotów+ ", Ilość dostępnych slotów MEd: "+ilośćMedSlotów+  ", Ilość dostępnych slotów Low: "+ilośćLowSlotów+", Zasieg namierzania: "+zasiegNamierzania+", Predkosc bazowa statku: "+predkoscBazowa;
    }
    public void wyswietl(){
        System.out.println(toString());
    }
}
