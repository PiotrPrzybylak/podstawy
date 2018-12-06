package FunkcjeMatWielkLicz;


import java.math.BigInteger;

public class KalkulatorWielkaLiczba {
    public static void main (String [] args){


        BigInteger a = new BigInteger("-123456");
        BigInteger b = new BigInteger("876596897");


        BigInteger suma = a.add(b);
        BigInteger odejmowanie = a.subtract(b);
        BigInteger mnozenie = a.multiply(b);
        BigInteger dzielenie = a.divide(b);

        System.out.println("suma ="+ suma.toString());
        System.out.println("odejmowanie ="+ odejmowanie.toString());
        System.out.println("mnozenie ="+ mnozenie.toString());
        System.out.println("dzielenie ="+ dzielenie.toString());

        BigInteger potega = a.pow(2);
        BigInteger warBezWzgledna = a.abs();

        System.out.println(potega);
        System.out.println(warBezWzgledna);







    };

}
