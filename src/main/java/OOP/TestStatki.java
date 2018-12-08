package OOP;

public class TestStatki {

    public static void main (String [] args){

        Nacja amarr = new Nacja("amarr");

       Fregata tristan = new Fregata("Amarr" , "Fregata" , "Tristan", 3, 3, 3, 46, 738, "Mała");

       Pancernik phoenix = new Pancernik ("Gallente", "Pancernik", "Phoenix", 5, 7, 5, 132, 48, true);
       System.out.println(amarr);
       System.out.println(tristan.getTyp());
       System.out.println(phoenix.getTyp());
       System.out.println(phoenix);






    }


}
