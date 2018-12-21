package OOP;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControlerStatki {
/*
    @RequestMapping("/")
    public String wyswierlanie (){
        return "walka";
    }
*/
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

       List <Statek> listatStatkow = new ArrayList <>();
       //listatStatkow = statkiGracza1;
        listatStatkow.add( new Krazownik(new Nacja("Gallente"), "Krążownik","Vexor", 300,53565));
        listatStatkow.add(new Krazownik(new Nacja("Amarr"),"Krążownik","Maller", 294,35545));
        listatStatkow.add(new Fregata(new Nacja("Gallente"), "Fregata", "Tristan", 100, 5600));
        listatStatkow.add(new Fregata(new Nacja("Gallente"), "Fregata", "Atron", 4000,4000));

        model.addAttribute("listatStatkow", listatStatkow);
        return "walka";
    }



}



