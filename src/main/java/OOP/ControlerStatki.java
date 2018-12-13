package OOP;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControlerStatki {

    @RequestMapping("/")
    public String wyswierlanie (){
        return "walka";
    }



}



