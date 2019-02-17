package CwiczenieStatic;

public class CzlonekKlubu {
    private String imie;
    private String nazwisko;
    private  int czlonekID;
    private static int ID=0;


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

}
