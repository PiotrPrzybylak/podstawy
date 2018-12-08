package OOP;

public class TestStatki {

    public static void main (String [] args){

        Nacja amarr = new Nacja("amarr");

       Fregata tristan = new Fregata("Amarr" , "Fregata" , "Tristan", 3, 3, 3, 46, 738, "Mała");

       System.out.println(amarr);
       System.out.println(tristan.getTyp());




    }


}
