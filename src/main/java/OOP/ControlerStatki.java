package OOP;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;
import java.util.HashMap;


import java.util.ArrayList;
import java.util.List;

@Controller
public class ControlerStatki {

   private Map <String,Gracz> gracze = new HashMap <>();
   private List <StatekSklep> statkiDoKulepinia = new ArrayList <>();
   private List <Statek> statkiZlomowisko = new ArrayList<>();

   private Gracz gracz1= new Gracz(new ArrayList <>(),1000000);
   private Gracz gracz2= new Gracz(new ArrayList <>(),1000000);
   private Gracz gracz3= new Gracz(new ArrayList <>(),1000000);


    public ControlerStatki (){

        gracz1.getStatki().add( new Krazownik(new Nacja("Gallente"), "Krążownik","Vexor", 300,53565));
        gracz1.getStatki().add(new Krazownik(new Nacja("Amarr"),"Krążownik","Maller", 294,35545));
        gracz1.getStatki().add(new Fregata(new Nacja("Gallente"), "Fregata", "Tristan", 100, 5600));
        gracz1.getStatki().add(new Fregata(new Nacja("Gallente"), "Fregata", "Atron", 4000,4000));

        gracz2.getStatki().add( new Krazownik(new Nacja("Gallente"), "Krążownik","Vexor", 300,53565));
        gracz2.getStatki().add(new Krazownik(new Nacja("Amarr"),"Krążownik","Maller", 294,35545));
        gracz2.getStatki().add(new Fregata(new Nacja("Gallente"), "Fregata", "Tristan", 100, 5600));
        gracz2.getStatki().add(new Fregata(new Nacja("Gallente"), "Fregata", "Atron", 4000,4000));

        gracz3.getStatki().add( new Krazownik(new Nacja("Gallente"), "Krążownik","Vexor", 300,53565));
        gracz3.getStatki().add(new Krazownik(new Nacja("Amarr"),"Krążownik","Maller", 294,35545));
        gracz3.getStatki().add(new Fregata(new Nacja("Gallente"), "Fregata", "Tristan", 100, 5600));
        gracz3.getStatki().add(new Fregata(new Nacja("Gallente"), "Fregata", "Atron", 4000,4000));

        statkiDoKulepinia.add( new StatekSklep(new Nacja("Gallente"), "Krążownik","Vexor", 300,53565, 30000));
        statkiDoKulepinia.add(new StatekSklep(new Nacja("Amarr"),"Krążownik","Maller", 294,35545, 33000));
        statkiDoKulepinia.add(new StatekSklep(new Nacja("Gallente"), "Fregata", "Tristan", 100, 5600, 10000));
        statkiDoKulepinia.add(new StatekSklep(new Nacja("Gallente"), "Fregata", "Atron", 4000,4000, 8000));

        gracze.put("Gracz1", gracz1);
        gracze.put("Gracz2", gracz2);
        gracze.put("Gracz3", gracz3);
    }


    void tworzenieGraczaWMapie (String nazwa){
        String zmienna = nazwa;
        gracze.put(zmienna, new Gracz(new ArrayList <>(),1000000));

    }

    private Gracz ktoryGracz (String kto) throws Wyjatek {
        Gracz gracz = gracze.get(kto);
        return gracz;
    }

    @RequestMapping("/dodajGracza")
    public String dodajGracza (
            @RequestParam(value = "NazwaGracza", required = false) String NazwaGracza
    ){
        tworzenieGraczaWMapie(NazwaGracza);
        //dupa debuging!
        System.out.println(gracze.keySet());

        return "redirect:/dodawanie";
    }




    // tu bedzie metoda sprzedaz
    @RequestMapping("/sprzedazZUrl")
    public String sprzedaz (
            @RequestParam(value = "sprzedanyStatek", required = false) int sprzedanyStatek,
            @RequestParam(value = "ktoSprzedaje", required = false) String ktoSprzedaje
    ) throws Wyjatek {
        ktoryGracz(ktoSprzedaje).sprzedajStatek(sprzedanyStatek, statkiZlomowisko, statkiDoKulepinia);
        return "redirect:/sprzedaz?ktoSprzedaje="+ktoSprzedaje;
    }

    //Wersja na potrzeby gracza 1 oraz 2 i 3 z uzyciem kodu URL ze strona startowa
    @RequestMapping("/kupnoZUrl")
    public String kupnoStatkuUrl (
            @RequestParam(value = "kupionyStatek", required = false) String kupionyStatek,
            @RequestParam(value = "ktoKupuje", required = false) String ktoKupuje
    ) throws Wyjatek {
        System.out.println(ktoKupuje + " kupił statek " + kupionyStatek);
        ktoryGracz(ktoKupuje).kupStatek(kupionyStatek, statkiDoKulepinia);
        return "redirect:/zakupyURL?ktoKupuje=" + ktoKupuje;
    }
    //Wersja na potrzeby gracza 1 oraz 2 i 3 z uzyciem kodu URL
    @RequestMapping("/ktoKupuje")
    public String ktoKupuje (
            @RequestParam(value = "ktoKupuje", required = false) String ktoKupuje,
            Model model
    ) {
        model.addAttribute("ktoKupuje", ktoKupuje);
        model.addAttribute("statkiDoKulepinia", statkiDoKulepinia);
        model.addAttribute("kasaGracza1", gracz1.getKasa());
        model.addAttribute("kasaGracza2", gracz2.getKasa());
        model.addAttribute("kasaGracza3", gracz3.getKasa());
        return "ktoKupujeWybor";
    }

    // tu bedzie sprzedaz
    @RequestMapping ("/sprzedaz")
    public String sprzedaz (
            @RequestParam(value = "ktoSprzedaje", required = false) String ktoSprzedaje,
            Model model
    ) throws Wyjatek {
        List <Statek> statkiNaSprzedaz;
        statkiNaSprzedaz = ktoryGracz(ktoSprzedaje).getStatki();
        int kasaGracza = ktoryGracz(ktoSprzedaje).getKasa();

        model.addAttribute("ktoSprzedaje", ktoSprzedaje);
        model.addAttribute("statkiNaSprzedaz", statkiNaSprzedaz);
        model.addAttribute("kasaGracza", kasaGracza);
        model.addAttribute("statkiZlomowisko", statkiZlomowisko);

        return "zlomowisko";
    }

    @RequestMapping ("/dodawanie")
    public String dodawanie (
            Model model
    ) {
        model.addAttribute("ListaGraczy",gracze);
        return "gracze";
    }




    //Wersja na potrzeby gracza 1 oraz 2 i 3 z uzyciem kodu URL
    @RequestMapping("/zakupyURL")
    public String zakupyURL (
            @RequestParam(value = "ktoKupuje", required = false) String ktoKupuje,
            Model model
    ) throws Wyjatek {
        int kasaDanegoGracza = ktoryGracz(ktoKupuje).getKasa();

        model.addAttribute("ktoKupuje", ktoKupuje);
        model.addAttribute("statkiDoKulepinia", statkiDoKulepinia);
        model.addAttribute("kasaDanegoGracza", kasaDanegoGracza);

        return "sklepZUrl";
    }

    @RequestMapping("/obliczenia")
    public String metodaObliczenia (
            @RequestParam(value = "statekGracza1", required = false) String statekGracza1,
            @RequestParam(value = "statekGracza2", required = false) String statekGracza2,
            @RequestParam(value = "statekGracza3", required = false) String statekGracza3,
            @RequestParam(value = "ktoWalczy", required = false) String ktoWalczy,
            Model model
    ){

        System.out.println(statekGracza1);
        System.out.println(statekGracza2);
        System.out.println(statekGracza3);


       Statek pierwszy = new Statek();
       Statek drugi = new Statek();
       Gracz graczPierwszy = new Gracz();
       Gracz graczDrugi = new Gracz();
       String wybranyStatekGraczPrierwszy ="";
       String wybranyStatekGraczDrugi ="";

        // teraz IFy dla walka dla wszystkich opcji
        if (ktoWalczy.equals("Gracz1i2")) {
            System.out.println("walczy gracz 1 oraz 2");
            graczPierwszy=gracz1;
            wybranyStatekGraczPrierwszy = statekGracza1;
            graczDrugi = gracz2;
            wybranyStatekGraczDrugi = statekGracza2;
        }
        else if (ktoWalczy.equals("Gracz2i3")) {
            System.out.println("walczy gracz 2 oraz 3");
            graczPierwszy=gracz2;
            wybranyStatekGraczPrierwszy = statekGracza2;
            graczDrugi = gracz3;
            wybranyStatekGraczDrugi = statekGracza3;
        }
        else if (ktoWalczy.equals("Gracz3i1")) {
            System.out.println("walczy gracz 3 oraz 1");
            graczPierwszy=gracz3;
            wybranyStatekGraczPrierwszy = statekGracza3;
            graczDrugi = gracz1;
            wybranyStatekGraczDrugi = statekGracza1;
        }

        // foreach po liscie statki Gracza1
        for (int i = 0; i < graczPierwszy.getStatki().size(); i++) {
            Statek statek = graczPierwszy.getStatki().get(i);

            if (wybranyStatekGraczPrierwszy.equals(statek.getNazwa())) {
                pierwszy = graczPierwszy.getStatki().get(i);
            }
        }
        // foreach po liscie statki Gracza2
        for (int i = 0; i < graczDrugi.getStatki().size(); i++) {
            Statek statek = graczDrugi.getStatki().get(i);

            if (wybranyStatekGraczDrugi.equals(statek.getNazwa())) {
               drugi = graczDrugi.getStatki().get(i);
            }
        }

       String wygranyStatek = TestStatki.walka(pierwszy,drugi);
       System.out.println(wygranyStatek);

      model.addAttribute("ktoWalczy" , "Walczyli " + ktoWalczy);
      model.addAttribute("pierwszy" , "Nazwa statku pierwszego gracza: " + pierwszy.getNazwa());
      model.addAttribute("drugi" , "Nazwa statku drugiego gracza: " + drugi.getNazwa());
      model.addAttribute("wygrany" ,wygranyStatek);


        return "wynik";
    }

    @RequestMapping("/")
    public String listatStatkow (
            Model model
    ){

// chce zrobic commita bo na lapku nie dziala i sprawdzic tak cala sprawe
        model.addAttribute("statkiGracza1", gracz1.getStatki());
        model.addAttribute("statkiGracza2", gracz2.getStatki());
        model.addAttribute("statkiGracza3", gracz3.getStatki());
        return "walka";
    }
}



