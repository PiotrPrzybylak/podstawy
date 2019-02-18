package CwiczenieWyjatki;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WyjatekTest2 {

    public WyjatekTest2(){
        //checked
    }

    private Scanner otwSkanerNaPliku (File f) throws FileNotFoundException {
        int wynik = 10/0;
        return new Scanner(f);
    }

public static void main (String [] args){

        File plik = new File("D:/path/path");
        WyjatekTest2 wyjatek = new WyjatekTest2();

        Scanner skaner = null;
    try {
        skaner = wyjatek.otwSkanerNaPliku(plik);
    } catch (ArithmeticException a) {
        a.printStackTrace();
        System.out.println("tylko bląd arytmetyczny");
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    System.out.println("instrukcja po bloku catch");
}

}
