package OOP;

import java.util.Random;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestStatki {


   public static boolean czyTrafil() {
      Random r = new Random();
      int losowanie;
      losowanie = r.nextInt(101);

      if (losowanie > 55){
         return true;
      } else return false;
   }

   public static String walka (Statek pierwszy, Statek drugi){
      String pierwszyNazwa = pierwszy.getNazwa();
      int atakPierszyStatek = pierwszy.getDps();
      int zyciePierwszyStatek = pierwszy.getEhp();

      String drugiNazwa = drugi.getNazwa();
      int atakDrugiStatek = drugi.getDps();
      int zycieDrugiStatek = drugi.getEhp();

      while (zyciePierwszyStatek > 0 && zycieDrugiStatek > 0 ){
         if(czyTrafil()){
            zyciePierwszyStatek -= atakDrugiStatek;
         }
         if(czyTrafil()){
            zycieDrugiStatek -= atakPierszyStatek;
         }

      }

      if (zyciePierwszyStatek>zycieDrugiStatek){
         return "Bitwę wygrał statek " + pierwszyNazwa +
                 "\nPunkty zycia " + pierwszyNazwa + " = " + zyciePierwszyStatek +
                 "\nPunkty zycia " + drugiNazwa + " = " + zycieDrugiStatek   ;


      } else return "Bitwę wygrał statek " + drugiNazwa +
              "\nPunkty zycia " + pierwszyNazwa + " = " + zyciePierwszyStatek +
              "\nPunkty zycia " + drugiNazwa + " = " + zycieDrugiStatek   ;

      }










    public static void main (String [] args){

       SpringApplication.run(TestStatki.class, args);

       ObiektLatajacy ufo = new ObiektLatajacy("statek obcych");
       ObiektLatajacy ufo2 = new ObiektLatajacy("statek obcych 2");

        Statek statek = new Statek();
        Statek statek2 = new Statek();

       Fregata tristan = new Fregata(new Nacja("Gallente"), "Fregata", "Tristan", 100, 5600);

       // uwaga zamiast klasa fregata mozna dac ObiektLatajacy (ciekawe)
       Fregata atron = new Fregata(new Nacja("Gallente"), "Fregata", "Atron", 4000,4000);

       Pancernik phoenix = new Pancernik (new Nacja("Caldari"), "Pancernik", "Phoenix", 800, 111000);

       Pancernik pancernikKasia = new Pancernik();

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

       Krazownik vexor = new Krazownik(new Nacja("Gallente"), "Krążownik","Vexor", 300,53565);
       Krazownik maller = new Krazownik(new Nacja("Amarr"),"Krążownik","Maller", 294,35545);



       System.out.println(czyTrafil());


       System.out.println(walka(vexor,maller));
       System.out.println(walka(tristan,atron));



    }




}

