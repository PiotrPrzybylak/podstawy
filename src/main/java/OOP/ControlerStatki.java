package OOP;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControlerStatki {


    private List <Statek> statkiGracza1 = new ArrayList <>();
    private List <Statek> statkiGracza2 = new ArrayList <>();
    private List <StatekSklep> statkiDoKulepinia = new ArrayList <>();
    private int kasaGracza1 = 1000000;
    private int kasaGracza2 = 1000000;
    private int kosztStatku = 0;


    public ControlerStatki (){
        statkiGracza1.add( new Krazownik(new Nacja("Gallente"), "Krążownik","Vexor", 300,53565));
        statkiGracza1.add(new Krazownik(new Nacja("Amarr"),"Krążownik","Maller", 294,35545));
        statkiGracza1.add(new Fregata(new Nacja("Gallente"), "zosia", "Tristan", 100, 5600));
        statkiGracza1.add(new Fregata(new Nacja("Gallente"), "Fregata", "Atron", 4000,4000));

        statkiGracza2.add( new Krazownik(new Nacja("Gallente2"), "Krążownik2","Vexor2", 300,53565));
        statkiGracza2.add(new Krazownik(new Nacja("Amarr2"),"Krążownik2","Maller2", 294,35545));
        statkiGracza2.add(new Fregata(new Nacja("Gallente2"), "zosia2", "Tristan2", 100, 5600));
        statkiGracza2.add(new Fregata(new Nacja("Gallente2"), "Fregata2", "Atron2", 4000,4000));

        statkiDoKulepinia.add( new StatekSklep(new Nacja("Gallente3"), "Krążownik3","Vexor3", 300,53565, 30000));
        statkiDoKulepinia.add(new StatekSklep(new Nacja("Amarr3"),"Krążownik3","Maller3", 294,35545, 33000));
        statkiDoKulepinia.add(new StatekSklep(new Nacja("Gallente3"), "Fregata3", "Tristan3", 100, 5600, 10000));
        statkiDoKulepinia.add(new StatekSklep(new Nacja("Gallente3"), "Fregata3", "Atron3", 4000,4000, 8000));
    }

    @RequestMapping("/kupno")
    public String kupnoStatku (
            @RequestParam(value = "kupionyStatek", required = false) String kupionyStatek,
            Model model
    ) {
        System.out.println("Kupiony statek to"+kupionyStatek);

        // foreach po liscie statkiGracza1
        for (int i = 0; i < statkiDoKulepinia.size(); i++) {
            StatekSklep kupiony = statkiDoKulepinia.get(i);

            if (kupionyStatek.equals(kupiony.getNazwa())&&kasaGracza1 > kupiony.getCena() ) {

                StatekSklep statek = statkiDoKulepinia.get(i);
                kosztStatku = statek.getCena();
                kasaGracza1 -=(int)statek.getCena();
                Statek tylkoStatek = (Statek) statek;
                System.out.println(kosztStatku);
                statkiGracza1.add(tylkoStatek);
            }
        }

        return "redirect:/zakupy";
    }


    @RequestMapping("/zakupy")
    public String zakupy (
          Model model
    ) {
        model.addAttribute("statkiDoKulepinia", statkiDoKulepinia);
        model.addAttribute("kasaGracza1", kasaGracza1);
        model.addAttribute("kasaGracza2", kasaGracza2);

        return "sklep";
    }


    @RequestMapping("/obliczenia")
    public String metodaObliczenia (
            @RequestParam(value = "statekGracza1", required = false) String statekGracza1,
            @RequestParam(value = "statekGracza2", required = false) String statekGracza2,
            Model model
    ){

        System.out.println(statekGracza1);
        System.out.println(statekGracza2);


        Statek pierwszy = new Statek();
        Statek drugi = new Statek();


        // foreach po liscie statkiGracza1
        for (int i = 0; i < statkiGracza1.size(); i++) {
            Statek statek = statkiGracza1.get(i);

            if (statekGracza1.equals(statek.getNazwa())) {
                pierwszy = statkiGracza1.get(i);
            }
        }

        // foreach po liscie statkiGracza2
        for (int i = 0; i < statkiGracza2.size(); i++) {
            Statek statek = statkiGracza2.get(i);

            if (statekGracza2.equals(statek.getNazwa())) {
                drugi = statkiGracza2.get(i);
            }
        }



       String wygranyStatek = TestStatki.walka(pierwszy,drugi);
       System.out.println(wygranyStatek);



       model.addAttribute("statek1" , "Wybrany statek gracza 1 to: " + statekGracza1);
       model.addAttribute("statek2" , "Wybrany statek gracza 2 to: " + statekGracza2);
       model.addAttribute("wygrany" ,wygranyStatek);


        return "wynik";
    }

    @RequestMapping("/")
    public String listatStatkow (
            Model model


    ){

// chce zrobic commita bo na lapku nie dziala i sprawdzic tak cala sprawe
        model.addAttribute("statkiGracza1", this.statkiGracza1);
        model.addAttribute("statkiGracza2", statkiGracza2);
        return "walka";
    }


}



