package OOP;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControlerStatki {

    @RequestMapping("/")
    public String wyswierlanie (){
        return "walka";
    }

    @RequestMapping("/all")
    public String listatStatkow (
            Model model,
            @RequestParam(value = "nacja", required = false) Nacja nacja
    ){
        List<Statek> statkiGracza1 = new ArrayList<>();
        List<Statek> statkiGracza2 = new ArrayList<>();

        if (nacja.equals(Nacja("Gallente"))) {
            statkiGracza1.add(statek);
        } else statkiGracza2.add(statek);


        model.addAttribute("nacja", statkiGracza1);
        return "nacja";
    }



}



