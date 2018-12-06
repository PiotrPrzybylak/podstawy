package PobieranieDanych;

import java.util.Scanner;

public class Witaj {
    public static void main (String [] args){


    String imie;

    Scanner odczyt = new Scanner(System.in);

    imie = odczyt.nextLine();

        System.out.println("Witaj "+ imie);


    }
}
