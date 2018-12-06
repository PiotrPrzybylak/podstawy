package PobieranieDanych;

import java.util.Scanner;

public class PracaDomowa {
    public static void main (String [] args){

        double a;
        double b;

        Scanner odczyt = new Scanner(System.in);
        System.out.println("podaj pierwsza liczbe");
        a = odczyt.nextDouble();
        System.out.println("podaj druga liczbe");
        b = odczyt.nextDouble();


        System.out.println("Suma "+a+" + "+b+" = "+(a+b));
        System.out.println("Różnica "+a+" - "+b+" = "+(a-b));
        System.out.println("Iloraz "+a+" - "+b+" = "+(a*b));
        System.out.println("Iloczyn "+a+" - "+b+" = "+(a/b));





    }

}
