package OOP;

public class TestStatki {

    public static void main (String [] args){

       ObiektLatajacy ufo = new ObiektLatajacy("statek obcych");

        Statek statek = new Statek();

       Fregata tristan = new Fregata("Statek Kosmiczny", new Nacja("Gallente") , "Fregata" , "Tristan", 3, 3, 3, 46, 738, "Mała");


       Pancernik phoenix = new Pancernik ("Statek Kosmiczny", new Nacja("Caldari"), "Pancernik", "Phoenix", 5, 7, 5, 132, 48, true);

      // System.out.println(tristan.getTyp());
      // System.out.println(phoenix.getTyp());

       System.out.println("");

      // System.out.println(phoenix);
      // System.out.println(tristan);

       System.out.println("");

      // phoenix.wyswietl();
      // tristan.wyswietl();

       System.out.println("");

      // ufo.wyswietl();
      // statek.wyswietl();

       // przypisac kazda zmienna do kazdej

       // pierwsza proba
       // do przypisanie do klacy odgornej jest mozliwe
       // ufo = tristan;
       // ufo = phoenix;
       // ufo = statek;

       // przypisanie do klady dolnej nie jest mozliwe
       // tristan = ufo;
       // phoenix = ufo;
       // statek = ufo;

       // druga proba
       // nie mogę pryzpisać klas rownolegle / na tym samym poziomie klass
       //tristan =  phoenix;
       //phoenix = tristan;


    }
}
