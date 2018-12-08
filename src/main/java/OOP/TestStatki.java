package OOP;

public class TestStatki {

    public static void main (String [] args){



       Fregata tristan = new Fregata("Statek Kosmiczny", "Amarr" , "Fregata" , "Tristan", 3, 3, 3, 46, 738, "Mała");

       Pancernik phoenix = new Pancernik ("Statek Kosmiczny", "Gallente", "Pancernik", "Phoenix", 5, 7, 5, 132, 48, true);

       System.out.println(tristan.getTyp());
       System.out.println(phoenix.getTyp());
       System.out.println(phoenix);






    }


}
