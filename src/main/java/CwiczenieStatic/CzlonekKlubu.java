package CwiczenieStatic;

public class CzlonekKlubu {
    static private String nazwaKlubu = new String("Widzew");

    private String imie;
    private String nazwisko;
    private  int czlonekID;
    private static int ID=0;


    public int getCzlonekID() {
        return this.czlonekID;
    }

    public static int getCzlonekID2(CzlonekKlubu czlowiek) {
        return czlowiek.czlonekID;
    }

    public CzlonekKlubu (String imie, String nazwisko){
        this.imie= imie;
        this.nazwisko=nazwisko;
        this.czlonekID=++ID;
        System.out.println("Nowy członek: imie: "+imie+" nazwisko "+nazwisko+" jego ID "+czlonekID);
    }

    public static int dajInta (){

        return ID;
    }

    public static int zmienInta (int a){
        return ID+a;
    }


    public static void powiekszCzlonka( CzlonekKlubu czlonek) {
        ID++;

        czlonek.czlonekID++;
    }

    public void skolinizuj(CzlonekKlubu innyCzlonek) {
        innyCzlonek.czlonekID = this.czlonekID;
        innyCzlonek.imie = this.imie;
        innyCzlonek.nazwisko = "Niewolnik pana " + this.nazwisko;
    }


    @Override
    public String toString() {
        return "CzlonekKlubu{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", czlonekID=" + czlonekID +
                '}';
    }
}
