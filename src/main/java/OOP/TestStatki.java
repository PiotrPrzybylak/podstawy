package OOP;

import java.util.Random;

public class TestStatki {


   public static boolean czyTrafil() {
      Random r = new Random();
      int losowanie;
      losowanie = r.nextInt(101);

      if (losowanie > 55){
         return true;
      }
      else return false;
   }

   public static String walka(Statek pierwszy, Statek drugi){




      return "dupa";
   }



    public static void main (String [] args){

       ObiektLatajacy ufo = new ObiektLatajacy("statek obcych");
       ObiektLatajacy ufo2 = new ObiektLatajacy("statek obcych 2");

        Statek statek = new Statek();
        Statek statek2 = new Statek();

       Fregata tristan = new Fregata("Statek Kosmiczny", new Nacja("Gallente") , "Fregata" , "Tristan", 3, 3, 3, 46, 738, "Mała");

       // uwaga zamiast klasa fregata mozna dac ObiektLatajacy (ciekawe)
       Fregata atron = new Fregata("Statek Kosmiczny", new Nacja("Gallente"), "Fregata", "Atron", 4, 3, 4,55,500,"Mała");

       Pancernik phoenix = new Pancernik ("Statek Kosmiczny", new Nacja("Caldari"), "Pancernik", "Phoenix", 5, 7, 5, 132, 48, true);
       Pancernik pancernikKasia = new Pancernik(true);

       System.out.println(tristan.getTyp());
       System.out.println(phoenix.getTyp());

       System.out.println("");

       System.out.println(phoenix);
       System.out.println(tristan);

       System.out.println("");

       phoenix.wyswietl();
       tristan.wyswietl();

       System.out.println("");

       ufo.wyswietl();
       statek.wyswietl();

       // przypisac kazda zmienna do kazdej

       // pierwsza proba
       // do przypisanie do klacy odgornej jest mozliwe
       ufo = tristan;
       ufo.wyswietl();
       ufo = phoenix;
       ufo.wyswietl();
       ufo = statek;
       ufo.wyswietl();

       System.out.println(" atron bez zmian ");
       atron.wyswietl();
       System.out.println(" statek2 bez zmian ");
       statek2.wyswietl();
       System.out.println("atron przypisany do statek2 ");
       statek2=atron;
       statek2.wyswietl();
       System.out.println("pancernikKasia bez zmian ");
       pancernikKasia.wyswietl();


       // przypisanie do klady dolnej nie jest mozliwe
       // tristan = ufo;
       // phoenix = ufo;
       // statek = ufo;

       // druga proba
       // nie mogę pryzpisać klas rownolegle / na tym samym poziomie klass
       // tristan =  phoenix;
       // phoenix = tristan;
       System.out.println(" ");
       System.out.println("Bedzie walka krążowników");

       Krazownik vexor = new Krazownik(300,53565);
       Krazownik maller = new Krazownik(294,35545);



       System.out.println(czyTrafil());


       System.out.println(walka(vexor,maller));


    }




}

