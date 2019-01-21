package OOP;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControlerStatki {

    private List <StatekSklep> statkiDoKulepinia = new ArrayList <>();
    private List <Statek> statkiZlomowisko = new ArrayList<>();
    private int kosztStatku = 0;

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
            statkiNaSprzedaz = gracz1.getStatki();
            kasaGracza = gracz1.getKasa();
        } else if (ktoSprzedaje.equals("Gracz 2")) {
            statkiNaSprzedaz = gracz2.getStatki();
            kasaGracza = gracz2.getKasa();
        } else if (ktoSprzedaje.equals("Gracz 3")) {
            statkiNaSprzedaz = gracz3.getStatki();
            kasaGracza = gracz3.getKasa();
        }

        // foreach po liscie
        for (int i = 0; i < statkiNaSprzedaz.size(); i++) {
            Statek sprzedany = statkiNaSprzedaz.get(i);
            if (sprzedanyStatek == sprzedany.getEhp()) {
                Statek statek = statkiNaSprzedaz.get(i);
                statkiZlomowisko.add(statek);
                statkiNaSprzedaz.remove(statek);
                break;
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
            gracz1.setStatki(statkiNaSprzedaz);
            gracz1.setKasa(kasaGracza);
        } else if (ktoSprzedaje.equals("Gracz 2")) {
            gracz2.setStatki(statkiNaSprzedaz);
            gracz2.setKasa(kasaGracza);
        } else if (ktoSprzedaje.equals("Gracz 3")) {
            gracz3.setStatki(statkiNaSprzedaz);
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


                if (ktoKupuje.equals("Gracz 1")) {
                    gracz1.setKasa(kasaGracza);
                    gracz1.getStatki().add(tylkoStatek);
                } else if (ktoKupuje.equals("Gracz 2")) {
                    gracz2.setKasa(kasaGracza);
                    gracz2.getStatki().add(tylkoStatek);
                } else if (ktoKupuje.equals("Gracz 3")) {
                    gracz3.setKasa(kasaGracza);
                    gracz3.getStatki().add(tylkoStatek);
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
            statkiNaSprzedaz = gracz1.getStatki();
            kasaGracza = gracz1.getKasa();
        } else if (ktoSprzedaje.equals("Gracz 2")) {
            statkiNaSprzedaz = gracz2.getStatki();
            kasaGracza = gracz2.getKasa();
        } else if (ktoSprzedaje.equals("Gracz 3")) {
            statkiNaSprzedaz = gracz3.getStatki();
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
            // foreach po liscie statki Gracza1
            for (int i = 0; i < gracz1.getStatki().size(); i++) {
                Statek statek = gracz1.getStatki().get(i);

                if (statekGracza1.equals(statek.getNazwa())) {
                    pierwszy = gracz1.getStatki().get(i);
                }
            }

            // foreach po liscie statki Gracza2
            for (int i = 0; i < gracz2.getStatki().size(); i++) {
                Statek statek = gracz2.getStatki().get(i);

                if (statekGracza2.equals(statek.getNazwa())) {
                    drugi = gracz2.getStatki().get(i);
                }
            }
        } else if (ktoWalczy.equals("Gracz 2+3")) {
            // foreach po liscie statki Gracza2
            for (int i = 0; i < gracz2.getStatki().size(); i++) {
                Statek statek = gracz2.getStatki().get(i);

                if (statekGracza2.equals(statek.getNazwa())) {
                    pierwszy = gracz2.getStatki().get(i);
                }
            }

            // foreach po liscie statki Gracza3
            for (int i = 0; i < gracz3.getStatki().size(); i++) {
                Statek statek = gracz3.getStatki().get(i);

                if (statekGracza3.equals(statek.getNazwa())) {
                    drugi = gracz3.getStatki().get(i);
                }
            }
        } else if (ktoWalczy.equals("Gracz 3+1")) {
            // foreach po liscie statki Gracza3
            for (int i = 0; i < gracz3.getStatki().size(); i++) {
                Statek statek = gracz3.getStatki().get(i);

                if (statekGracza3.equals(statek.getNazwa())) {
                    pierwszy = gracz3.getStatki().get(i);
                }
            }

            // foreach po liscie statki Gracza1
            for (int i = 0; i < gracz1.getStatki().size(); i++) {
                Statek statek = gracz1.getStatki().get(i);

                if (statekGracza1.equals(statek.getNazwa())) {
                    drugi = gracz1.getStatki().get(i);
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
        model.addAttribute("statkiGracza1", gracz1.getStatki());
        model.addAttribute("statkiGracza2", gracz2.getStatki());
        model.addAttribute("statkiGracza3", gracz3.getStatki());
        return "walka";
    }


}



