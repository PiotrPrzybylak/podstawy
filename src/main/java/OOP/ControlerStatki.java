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

    public ControlerStatki (){
        statkiGracza1.add( new Krazownik(new Nacja("Gallente"), "Krążownik","Vexor", 300,53565));
        statkiGracza1.add(new Krazownik(new Nacja("Amarr"),"Krążownik","Maller", 294,35545));
        statkiGracza1.add(new Fregata(new Nacja("Gallente"), "zosia", "Tristan", 100, 5600));
        statkiGracza1.add(new Fregata(new Nacja("Gallente"), "Fregata", "Atron", 4000,4000));

        statkiGracza2.add( new Krazownik(new Nacja("Gallente2"), "Krążownik2","Vexor2", 300,53565));
        statkiGracza2.add(new Krazownik(new Nacja("Amarr2"),"Krążownik2","Maller2", 294,35545));
        statkiGracza2.add(new Fregata(new Nacja("Gallente2"), "zosia2", "Tristan2", 100, 5600));
        statkiGracza2.add(new Fregata(new Nacja("Gallente2"), "Fregata2", "Atron2", 4000,4000));
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
           // System.out.println(i);
           // PiggyBank piggyBank = piggyBanks.get(i);
            Statek statek = statkiGracza1.get(i);

            if (statekGracza1.equals(statek.getNazwa())) {
               //filtered.add(piggyBank);
                pierwszy = statkiGracza1.get(i);
            }
        }

        // foreach po liscie statkiGracza2
        for (int i = 0; i < statkiGracza2.size(); i++) {
            // System.out.println(i);
            // PiggyBank piggyBank = piggyBanks.get(i);
            Statek statek = statkiGracza2.get(i);

            if (statekGracza1.equals(statek.getNazwa())) {
                //filtered.add(piggyBank);
                drugi = statkiGracza2.get(i);
            }
        }

        /*
        if (statekGracza1.equals(statekGracza1(statek.getNazwa()))){
            pierwszy = statkiGracza1.get(0);
        }
        if (statekGracza1 !=null){
            drugi = statkiGracza2.get(1);
        }
        */

       TestStatki.walka(pierwszy,drugi);
        System.out.println(TestStatki.walka(pierwszy,drugi));

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



