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
    private List <Statek> statkiGracza3 = new ArrayList <>();
    private List <StatekSklep> statkiDoKulepinia = new ArrayList <>();
    private List <Statek> statkiZlomowisko = new ArrayList<>();
    private int kosztStatku = 0;

    Gracz gracz1= new Gracz(statkiGracza1,1000000);
    Gracz gracz2= new Gracz(statkiGracza2,1000000 );
    Gracz gracz3= new Gracz(statkiGracza3,1000000);


    public ControlerStatki (){
        statkiGracza1.add( new Krazownik(new Nacja("Gallente"), "Krążownik","Vexor", 300,53565));
        statkiGracza1.add(new Krazownik(new Nacja("Amarr"),"Krążownik","Maller", 294,35545));
        statkiGracza1.add(new Fregata(new Nacja("Gallente"), "zosia", "Tristan", 100, 5600));
        statkiGracza1.add(new Fregata(new Nacja("Gallente"), "Fregata", "Atron", 4000,4000));

        statkiGracza2.add( new Krazownik(new Nacja("Gallente"), "Krążownik","Vexor", 300,53565));
        statkiGracza2.add(new Krazownik(new Nacja("Amarr"),"Krążownik","Maller", 294,35545));
        statkiGracza2.add(new Fregata(new Nacja("Gallente"), "zosia2", "Tristan", 100, 5600));
        statkiGracza2.add(new Fregata(new Nacja("Gallente"), "Fregata", "Atron", 4000,4000));

        statkiGracza3.add( new Krazownik(new Nacja("Gallente"), "Krążownik","Vexor", 300,53565));
        statkiGracza3.add(new Krazownik(new Nacja("Amarr"),"Krążownik","Maller", 294,35545));
        statkiGracza3.add(new Fregata(new Nacja("Gallente"), "zosia", "Tristan", 100, 5600));
        statkiGracza3.add(new Fregata(new Nacja("Gallente"), "Fregata", "Atron", 4000,4000));

        statkiDoKulepinia.add( new StatekSklep(new Nacja("Gallente"), "Krążownik","Vexor", 300,53565, 30000));
        statkiDoKulepinia.add(new StatekSklep(new Nacja("Amarr"),"Krążownik","Maller", 294,35545, 33000));
        statkiDoKulepinia.add(new StatekSklep(new Nacja("Gallente"), "Fregata", "Tristan", 100, 5600, 10000));
        statkiDoKulepinia.add(new StatekSklep(new Nacja("Gallente"), "Fregata", "Atron", 4000,4000, 8000));
    }

    // tu bedzie metoda sprzedaz
    @RequestMapping("/sprzedazZUrl")
    public String sprzedaz (
            @RequestParam(value = "sprzedanyStatek", required = false) int sprzedanyStatek,
            @RequestParam(value = "ktoSprzedaje", required = false) String ktoSprzedaje,
            Model model
    ){

        List <Statek> statkiNaSprzedaz = new ArrayList <>();
        int kasaGracza = 0;

        if (ktoSprzedaje.equals("Gracz 1")) {
            statkiNaSprzedaz = statkiGracza1;
            kasaGracza = gracz1.getKasa();
        } else if (ktoSprzedaje.equals("Gracz 2")) {
            statkiNaSprzedaz = statkiGracza2;
            kasaGracza = gracz2.getKasa();
        } else if (ktoSprzedaje.equals("Gracz 3")) {
            statkiNaSprzedaz = statkiGracza3;
            kasaGracza = gracz3.getKasa();
        }

        // foreach po liscie
        for (int i = 0; i < statkiNaSprzedaz.size(); i++) {
            Statek sprzedany = statkiNaSprzedaz.get(i);
            if (sprzedanyStatek == sprzedany.getEhp()) {
                Statek statek = statkiNaSprzedaz.get(i);
                statkiZlomowisko.add(statek);
                statkiNaSprzedaz.remove(statek);
            }
        }
            // tu jest metoda dodawania kasy
            for (int i = 0; i < statkiDoKulepinia.size(); i++) {
                StatekSklep bazaStatkow = statkiDoKulepinia.get(i);

                if (sprzedanyStatek == bazaStatkow.getEhp()) {
                    StatekSklep StatekZCena = statkiDoKulepinia.get(i);
                    kasaGracza += StatekZCena.getCena()/2;
                }
            }

        if (ktoSprzedaje.equals("Gracz 1")) {
            statkiGracza1 = statkiNaSprzedaz;
            gracz1.setKasa(kasaGracza);
        } else if (ktoSprzedaje.equals("Gracz 2")) {
            statkiGracza2 = statkiNaSprzedaz;
            gracz2.setKasa(kasaGracza);
        } else if (ktoSprzedaje.equals("Gracz 3")) {
            statkiGracza3 = statkiNaSprzedaz;
            gracz3.setKasa(kasaGracza);
        }
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
        // foreach po liscie
        for (int i = 0; i < statkiDoKulepinia.size(); i++) {
            StatekSklep kupiony = statkiDoKulepinia.get(i);

            int kasaGracza = 0;
            if (ktoKupuje.equals("Gracz 1")) {
                kasaGracza = gracz1.getKasa();
            } else if (ktoKupuje.equals("Gracz 2")) {
                kasaGracza = gracz2.getKasa();
            } else if (ktoKupuje.equals("Gracz 3")) {
                kasaGracza = gracz3.getKasa();
            }

            if (kupionyStatek.equals(kupiony.getNazwa()) && kasaGracza > kupiony.getCena()) {
                StatekSklep statek = statkiDoKulepinia.get(i);
                kasaGracza -= statek.getCena();
                Statek tylkoStatek = (Statek) statek;
                System.out.println(kosztStatku);

                if (ktoKupuje.equals("Gracz 1")) {
                    gracz1.setKasa(kasaGracza);
                    statkiGracza1.add(tylkoStatek);
                } else if (ktoKupuje.equals("Gracz 2")) {
                    gracz2.setKasa(kasaGracza);
                    statkiGracza2.add(tylkoStatek);
                } else if (ktoKupuje.equals("Gracz 3")) {
                    gracz3.setKasa(kasaGracza);
                    statkiGracza3.add(tylkoStatek);
                }
            }
        }
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

        if (ktoSprzedaje.equals("Gracz 1")) {
            statkiNaSprzedaz = statkiGracza1;
            kasaGracza = gracz1.getKasa();
        } else if (ktoSprzedaje.equals("Gracz 2")) {
            statkiNaSprzedaz = statkiGracza2;
            kasaGracza = gracz2.getKasa();
        } else if (ktoSprzedaje.equals("Gracz 3")) {
            statkiNaSprzedaz = statkiGracza3;
            kasaGracza = gracz3.getKasa();
        }

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
        if (ktoKupuje.equals("Gracz 1")){
            kasaDanegoGracza = gracz1.getKasa();
        } else if (ktoKupuje.equals("Gracz 2")){

            kasaDanegoGracza = gracz2.getKasa();
        } else if (ktoKupuje.equals("Gracz 3")){
            kasaDanegoGracza = gracz3.getKasa();
        }

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

        // teraz IFy dla walka dla wszystkich opcji

        if (ktoWalczy.equals("Gracz 1+2")) {
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
        } else if (ktoWalczy.equals("Gracz 2+3")) {
            // foreach po liscie statkiGracza2
            for (int i = 0; i < statkiGracza2.size(); i++) {
                Statek statek = statkiGracza2.get(i);

                if (statekGracza2.equals(statek.getNazwa())) {
                    pierwszy = statkiGracza2.get(i);
                }
            }

            // foreach po liscie statkiGracza3
            for (int i = 0; i < statkiGracza3.size(); i++) {
                Statek statek = statkiGracza3.get(i);

                if (statekGracza3.equals(statek.getNazwa())) {
                    drugi = statkiGracza3.get(i);
                }
            }
        } else if (ktoWalczy.equals("Gracz 3+1")) {
            // foreach po liscie statkiGracza3
            for (int i = 0; i < statkiGracza3.size(); i++) {
                Statek statek = statkiGracza3.get(i);

                if (statekGracza3.equals(statek.getNazwa())) {
                    pierwszy = statkiGracza3.get(i);
                }
            }

            // foreach po liscie statkiGracza1
            for (int i = 0; i < statkiGracza1.size(); i++) {
                Statek statek = statkiGracza1.get(i);

                if (statekGracza1.equals(statek.getNazwa())) {
                    drugi = statkiGracza1.get(i);
                }
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
        model.addAttribute("statkiGracza1", this.statkiGracza1);
        model.addAttribute("statkiGracza2", statkiGracza2);
        model.addAttribute("statkiGracza3", statkiGracza3);
        return "walka";
    }


}



