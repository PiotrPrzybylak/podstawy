package Zmienne;

public class Rozwiazanie {
    public static void main (String [] args){

        String ala = "Ala ";
        String ma = "ma ";
        String kota = "kota.";

        String zdanie = ala + ma + kota;

        System.out.println(zdanie);

        System.out.println(zdanie.substring(0,6)); // pierwsze dwa stringi
        System.out.println(zdanie.substring(7,12)); // tylko trzeci string


    }
}
