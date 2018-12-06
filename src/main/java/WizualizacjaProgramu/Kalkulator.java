public class Kalkulator {
    private int pierwsza;
    private int druga;
    private int wynik;

    Kalkulator() {
        System.out.println("aaaa gowno");
    }

    public Double policzPensjeNetto(Double kwota, Double stawkaPodatku) {
        Kalkulator dupa;
        dupa = new Kalkulator();
        dupa.wynik = 99;
        this.wynik= 21;
        Kalkulator pupa;
        pupa = new Kalkulator();

        pupa.wynik = 100;
        Double podatek = kwota * stawkaPodatku / 100;
        Double pensjaNetto = kwota - podatek;
        return pensjaNetto;  }

    public static void main(String[] args) {
        String a = "aa" + "sss";

        new Kalkulator();

        Kalkulator dupa;

        dupa = new Kalkulator();

        dupa.druga =99;


        Double pensja = dupa.policzPensjeNetto(123.,10.);

        Kalkulator sraka = new Kalkulator();

        Kalkulator kupa = null;

        kupa = dupa;

        kupa.pierwsza = 1;

        dupa = null;

        dupa.pierwsza = 15;

    };
}