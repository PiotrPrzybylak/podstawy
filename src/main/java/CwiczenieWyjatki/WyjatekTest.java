package CwiczenieWyjatki;

public class WyjatekTest {

    public  WyjatekTest (){
        //unchecked
    }

    private int dzielenie (int a, int b) throws ArithmeticException  {
        int wynik = 0;
      try {
            wynik = a/b;
      //  } catch (ArithmeticException ae2){
        //    ae2.printStackTrace();
          //  System.out.println("Przechwycenie w metodzie dzielenia");
        }

        finally {
            System.out.println("blok ktory sie zawsze wykonuje ten z metody dzielenie");
        }
        return wynik;
    }

public static void main (String [] args){


        WyjatekTest wyjatek = new WyjatekTest();

        try {
            wyjatek.dzielenie(8, 0);
        } catch (ArithmeticException ae) {
          //  ae.printStackTrace();
            //System.out.println("Przechwycenie w main");
        }

//        finally {
  //          System.out.println("blok ktory sie zawsze wykonuje ten z metody main");
    //    }

        int a = 100;

    System.out.println("a= "+a);
}


}
