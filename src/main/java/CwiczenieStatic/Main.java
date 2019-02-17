package CwiczenieStatic;

public class Main {
    public static void main (String [] args){


        CzlonekKlubu cl = new CzlonekKlubu("Adam", "Kowalski");
        CzlonekKlubu cl2 = new CzlonekKlubu("Zosia", "Dupa");
        System.out.println(CzlonekKlubu.dajInta());
        System.out.println(CzlonekKlubu.zmienInta(5));

    }
}
