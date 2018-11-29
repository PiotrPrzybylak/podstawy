package Zmienne;

public class Test {
    public static void main (String [] args){

        String witaj = "Witaj ";
        String swiecie = "Swiecie";
        String powitanie = witaj + swiecie; // łączenie Stringow

        System.out.println(powitanie);

        String czesc = powitanie.substring(0,5) + " uczniu";

        System.out.println(czesc);
    }
}
