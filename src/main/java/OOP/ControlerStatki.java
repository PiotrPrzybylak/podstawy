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
    private List <Statek> statkiDoKulepinia = new ArrayList <>();
    private int kasaGracza1 = 1000000;
    private int kasaGracza2 = 1000000;


    public ControlerStatki (){
        statkiGracza1.add( new Krazownik(new Nacja("Gallente"), "Krążownik","Vexor", 300,53565));
        statkiGracza1.add(new Krazownik(new Nacja("Amarr"),"Krążownik","Maller", 294,35545));
        statkiGracza1.add(new Fregata(new Nacja("Gallente"), "zosia", "Tristan", 100, 5600));
        statkiGracza1.add(new Fregata(new Nacja("Gallente"), "Fregata", "Atron", 4000,4000));

        statkiGracza2.add( new Krazownik(new Nacja("Gallente2"), "Krążownik2","Vexor2", 300,53565));
        statkiGracza2.add(new Krazownik(new Nacja("Amarr2"),"Krążownik2","Maller2", 294,35545));
        statkiGracza2.add(new Fregata(new Nacja("Gallente2"), "zosia2", "Tristan2", 100, 5600));
        statkiGracza2.add(new Fregata(new Nacja("Gallente2"), "Fregata2", "Atron2", 4000,4000));

        statkiDoKulepinia.add( new Krazownik(new Nacja("Gallente3"), "Krążownik3","Vexor3", 300,53565));
        statkiDoKulepinia.add(new Krazownik(new Nacja("Amarr3"),"Krążownik3","Maller3", 294,35545));
        statkiDoKulepinia.add(new Fregata(new Nacja("Gallente3"), "Fregata3", "Tristan3", 100, 5600));
        statkiDoKulepinia.add(new Fregata(new Nacja("Gallente3"), "Fregata3", "Atron3", 4000,4000));
    }

    @RequestMapping("/test")
    public String zakupy (
          //@RequestParam(value = "kasaGracza1", required = false) int kasaGracza1,
          //@RequestParam(value = "kasaGracza2", required = false) int kasaGracza2,
          Model model
    ) {
        model.addAttribute("statkiDoKulepinia", statkiDoKulepinia);

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
           // @RequestParam(value = "statkiGracza1", required = false) List statkiGracza1

    ){
       // List<Statek> statkiGracza1 = new ArrayList<>();
        //List<Statek> statkiGracza2 = new ArrayList<>();

        //if (nacja.equals(statek.getNacja())) {
        //    statkiGracza1.add(statek);
       // } else statkiGracza2.add(statek);

      //  model.addAttribute("statkiGracza1", statkiGracza1);




// chce zrobic commita bo na lapku nie dziala i sprawdzic tak cala sprawe
        model.addAttribute("statkiGracza1", this.statkiGracza1);
        model.addAttribute("statkiGracza2", statkiGracza2);
        return "walka";
    }



}



