package OOP;

public class TestStatki {

    public static void main (String [] args){



       Fregata tristan = new Fregata("Statek Kosmiczny", "Gallente" , "Fregata" , "Tristan", 3, 3, 3, 46, 738, "Mała");

       Pancernik phoenix = new Pancernik ("Statek Kosmiczny", "Caldari", "Pancernik", "Phoenix", 5, 7, 5, 132, 48, true);

       System.out.println(tristan.getTyp());
       System.out.println(phoenix.getTyp());

       System.out.println("");
       System.out.println(phoenix);
       System.out.println(tristan);

       System.out.println("");
       phoenix.wyswietl();
       tristan.wyswietl();





    }


}
