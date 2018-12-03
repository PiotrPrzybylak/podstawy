package FunkcjeMatWielkLicz;

import java.math.BigInteger;

public class WielkaLiczba {
    public static void main (String [] args){


        BigInteger wielkaLiczba = new BigInteger("121121213123123123123212");
        System.out.println(wielkaLiczba.toString());

        BigInteger wielkaLiczba2 = BigInteger.valueOf(98575677);
        System.out.println(wielkaLiczba2.toString());


        BigInteger suma = wielkaLiczba.add(wielkaLiczba2);
        BigInteger roznica = wielkaLiczba.subtract(wielkaLiczba2);
        BigInteger mnozenie = wielkaLiczba.multiply(wielkaLiczba2);
        BigInteger dzielenie = wielkaLiczba.divide(wielkaLiczba2);

        System.out.println("dodawanie "+ suma.toString());
        System.out.println("odejmowanie "+ roznica.toString());
        System.out.println("mnozenie "+ mnozenie.toString());
        System.out.println("dzielenie "+ dzielenie.toString());



    }
}
