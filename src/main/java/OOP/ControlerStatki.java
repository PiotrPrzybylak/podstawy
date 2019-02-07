package OOP;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControlerStatki {

     List <StatekSklep> statkiDoKulepinia = new ArrayList <>();
     List <Statek> statkiZlomowisko = new ArrayList<>();

     Gracz gracz = new Gracz();
     Gracz gracz1= new Gracz(new ArrayList <>(),1000000);
     Gracz gracz2= new Gracz(new ArrayList <>(),1000000 );
     Gracz gracz3= new Gracz(new ArrayList <>(),1000000);


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
    }


    public Gracz ktoryGracz (String kto){

        if (kto.equals("Gracz 1")) {
            gracz = gracz1;
        } else if (kto.equals("Gracz 2")) {
            gracz = gracz2;
        } else if (kto.equals("Gracz 3")) {
            gracz = gracz3;
        }

        return gracz;
    }

    // tu bedzie metoda sprzedaz
    @RequestMapping("/sprzedazZUrl")
    public String sprzedaz (
            @RequestParam(value = "sprzedanyStatek", required = false) int sprzedanyStatek,
            @RequestParam(value = "ktoSprzedaje", required = false) String ktoSprzedaje,
            Model model
    ){


        gracz.sprzedajStatek(sprzedanyStatek,ktoryGracz(ktoSprzedaje),statkiZlomowisko, statkiDoKulepinia);

            return "redirect:/sprzedaz?ktoSprzedaje="+ktoSprzedaje;
    }

    //Wersja na potrzeby gracza 1 oraz 2 i 3 z uzyciem kodu URL ze strona startowa
    @RequestMapping("/kupnoZUrl")
    public String kupnoStatkuUrl (
            @RequestParam(value = "kupionyStatek", required = false) String kupionyStatek,
            @RequestParam(value = "ktoKupuje", required = false) String ktoKupuje,
            Model model
    ) {
        System.out.println(ktoKupuje + " kupił statek " + kupionyStatek);

        gracz.kupStatek(kupionyStatek, ktoryGracz(ktoKupuje), statkiDoKulepinia);

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
    ) {
        List <Statek> statkiNaSprzedaz = new ArrayList <>();

        int kasaGracza = 0;
        gracz = ktoryGracz(ktoSprzedaje);

        statkiNaSprzedaz = gracz.getStatki();
        kasaGracza = gracz.getKasa();

        model.addAttribute("ktoSprzedaje", ktoSprzedaje);
        model.addAttribute("statkiNaSprzedaz", statkiNaSprzedaz);
        model.addAttribute("kasaGracza", kasaGracza);
        model.addAttribute("statkiZlomowisko", statkiZlomowisko);

        return "zlomowisko";
    }

    //Wersja na potrzeby gracza 1 oraz 2 i 3 z uzyciem kodu URL
    @RequestMapping("/zakupyURL")
    public String zakupyURL (
            @RequestParam(value = "ktoKupuje", required = false) String ktoKupuje,
            Model model
    ) {
        int kasaDanegoGracza=0;
        gracz = ktoryGracz(ktoKupuje);

        kasaDanegoGracza = gracz.getKasa();

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

        // teraz IFy dla walka dla wszystkich opcji
        if (ktoWalczy.equals("Gracz 1+2")) {
            graczPierwszy=gracz1;
            graczDrugi = gracz2;
        }
        if (ktoWalczy.equals("Gracz 2+3")) {
            graczPierwszy=gracz2;
            graczDrugi = gracz3;
        }
        if (ktoWalczy.equals("Gracz 3+1")) {
            graczPierwszy=gracz3;
            graczDrugi = gracz1;
        }
        // foreach po liscie statki Gracza1
        for (int i = 0; i < graczPierwszy.getStatki().size(); i++) {
            Statek statek = graczPierwszy.getStatki().get(i);

            if (statekGracza1.equals(statek.getNazwa())) {
                pierwszy = graczPierwszy.getStatki().get(i);
            }
        }
        // foreach po liscie statki Gracza2
        for (int i = 0; i < graczDrugi.getStatki().size(); i++) {
            Statek statek = graczDrugi.getStatki().get(i);

            if (statekGracza2.equals(statek.getNazwa())) {
                drugi = graczDrugi.getStatki().get(i);
            }
        }

       String wygranyStatek = TestStatki.walka(pierwszy,drugi);
       System.out.println(wygranyStatek);

      model.addAttribute("ktoWalczy" , "Walczyli " + ktoWalczy);
      model.addAttribute("pierwszy" , "Nazwa statku pierwszego gracza: " + pierwszy.getNazwa());
      model.addAttribute("drugi" , "Nazwa statku pierwszego gracza: " + drugi.getNazwa());
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



