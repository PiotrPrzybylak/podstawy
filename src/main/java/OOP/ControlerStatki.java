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
    private int kasaGracza1 = 1000000;
    private int kasaGracza2 = 1000000;
    private int kasaGracza3 = 1000000;
    private int kosztStatku = 0;

    Gracz gracz1= new Gracz(statkiGracza1,kasaGracza1);
    Gracz gracz2= new Gracz(statkiGracza2,kasaGracza2 );
    Gracz gracz3= new Gracz(statkiGracza3,kasaGracza3);


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
        if (ktoSprzedaje.equals("Gracz 1")) {

            // foreach po liscie statkiGracza1
            for (int i = 0; i < statkiGracza1.size(); i++) {
                Statek sprzedany = statkiGracza1.get(i);

                if (sprzedanyStatek == sprzedany.getEhp()) {
                    Statek statek = statkiGracza1.get(i);
                    statkiZlomowisko.add(statek);
                    statkiGracza1.remove(statek);
                }
            }
            // tu jest metoda dodawania kasy
            for (int i = 0; i < statkiDoKulepinia.size(); i++) {
                StatekSklep bazaStatkow = statkiDoKulepinia.get(i);

                if (sprzedanyStatek == bazaStatkow.getEhp()) {
                    StatekSklep StatekZCena = statkiDoKulepinia.get(i);
                    int cenaSprzdanegoStatku = StatekZCena.getCena();
                    kasaGracza1 += (cenaSprzdanegoStatku/2);
                }
            }
        }

        else if (ktoSprzedaje.equals("Gracz 2")){
            // foreach po liscie statkiGracza2
            for (int i = 0; i < statkiGracza2.size(); i++) {
                Statek sprzedany = statkiGracza2.get(i);

                if (sprzedanyStatek == sprzedany.getEhp()) {
                    Statek statek = statkiGracza2.get(i);
                    statkiZlomowisko.add(statek);
                    statkiGracza2.remove(statek);
                }
            }
            // tu jest metoda dodawania kasy
            for (int i = 0; i < statkiDoKulepinia.size(); i++) {
                StatekSklep bazaStatkow = statkiDoKulepinia.get(i);

                if (sprzedanyStatek == bazaStatkow.getEhp()) {
                    StatekSklep StatekZCena = statkiDoKulepinia.get(i);
                    int cenaSprzdanegoStatku = StatekZCena.getCena();
                    kasaGracza2 += (cenaSprzdanegoStatku/2);
                }
            }
        }

        else if (ktoSprzedaje.equals("Gracz 3")){
            // foreach po liscie statkiGracza3
            for (int i = 0; i < statkiGracza3.size(); i++) {
                Statek sprzedany = statkiGracza3.get(i);

                if (sprzedanyStatek == sprzedany.getEhp()) {
                    Statek statek = statkiGracza3.get(i);
                    statkiZlomowisko.add(statek);
                    statkiGracza3.remove(statek);
                }
            }
            // tu jest metoda dodawania kasy
            for (int i = 0; i < statkiDoKulepinia.size(); i++) {
                StatekSklep bazaStatkow = statkiDoKulepinia.get(i);

                if (sprzedanyStatek == bazaStatkow.getEhp()) {
                    StatekSklep StatekZCena = statkiDoKulepinia.get(i);
                    int cenaSprzdanegoStatku = StatekZCena.getCena();
                    kasaGracza3 += (cenaSprzdanegoStatku/2);
                }
            }
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

    //Wersja na potrzeby gracza 1 oraz 2 i 3
    @RequestMapping("/kupno")
    public String kupnoStatku (
            @RequestParam(value = "kupionyStatek", required = false) String kupionyStatek,
            @RequestParam(value = "ktoKupuje", required = false) String ktoKupuje,
            Model model
    ) {
        //
        // System.out.println("Gracz 1 kupił statek "+kupionyStatek);

        // foreach po liscie statkiDoKulepinia
        for (int i = 0; i < statkiDoKulepinia.size(); i++) {
            StatekSklep kupiony = statkiDoKulepinia.get(i);

            if (ktoKupuje.equals("Gracz 1") && kupionyStatek.equals(kupiony.getNazwa()) && kasaGracza1 > kupiony.getCena()) {

                StatekSklep statek = statkiDoKulepinia.get(i);
                kosztStatku = statek.getCena();
                kasaGracza1 -= statek.getCena();
                Statek tylkoStatek = statek;
                System.out.println(kosztStatku);
                statkiGracza1.add(tylkoStatek);
                kosztStatku = 0;
            } else if (ktoKupuje.equals("Gracz 2") && kupionyStatek.equals(kupiony.getNazwa()) && kasaGracza2 > kupiony.getCena()) {

                StatekSklep statek = statkiDoKulepinia.get(i);
                kosztStatku = statek.getCena();
                kasaGracza2 -= statek.getCena();
                Statek tylkoStatek = statek;
                System.out.println(kosztStatku);
                statkiGracza2.add(tylkoStatek);
                kosztStatku = 0;
            } else if (ktoKupuje.equals("Gracz 3") && kupionyStatek.equals(kupiony.getNazwa()) && kasaGracza3 > kupiony.getCena()) {

                StatekSklep statek = statkiDoKulepinia.get(i);
                kosztStatku = statek.getCena();
                kasaGracza3 -= statek.getCena();
                Statek tylkoStatek = statek;
                System.out.println(kosztStatku);
                statkiGracza3.add(tylkoStatek);
                kosztStatku = 0;
            }

        }

        return "redirect:/zakupy";
    }


    //Wersja na potrzeby gracza 1
    @RequestMapping("/kupnoGracza1")
    public String kupnoStatku1 (
            @RequestParam(value = "kupionyStatek", required = false) String kupionyStatek,
            Model model
    ) {
        System.out.println("Gracz 1 kupił statek "+kupionyStatek);

        // foreach po liscie statkiGracza1
        for (int i = 0; i < statkiDoKulepinia.size(); i++) {
            StatekSklep kupiony = statkiDoKulepinia.get(i);

            if (kupionyStatek.equals(kupiony.getNazwa())&&kasaGracza1 > kupiony.getCena() ) {

                StatekSklep statek = statkiDoKulepinia.get(i);
                kosztStatku = statek.getCena();
                kasaGracza1 -= statek.getCena();
                Statek tylkoStatek = statek;
                System.out.println(kosztStatku);
                statkiGracza1.add(tylkoStatek);
                kosztStatku = 0;
            }
        }

        return "redirect:/zakupyGracza1";
    }

    //Wersja na potrzeby gracza 2
        @RequestMapping("/kupnoGracza2")
        public String kupnoStatku2 (
                @RequestParam(value = "kupionyStatek", required = false) String kupionyStatek,
                Model model
    ) {
            System.out.println("Gracz 2 kupił statek"+kupionyStatek);

            // foreach po liscie statkiGracza2
            for (int i = 0; i < statkiDoKulepinia.size(); i++) {
                StatekSklep kupiony = statkiDoKulepinia.get(i);

                if (kupionyStatek.equals(kupiony.getNazwa())&&kasaGracza2 > kupiony.getCena() ) {

                    StatekSklep statek = statkiDoKulepinia.get(i);
                    kosztStatku = statek.getCena();
                    kasaGracza2 -= statek.getCena();
                    Statek tylkoStatek = statek;
                    System.out.println(kosztStatku);
                    statkiGracza2.add(tylkoStatek);
                    kosztStatku = 0;
                }
            }

            return "redirect:/zakupyGracza2";
        }

        //Wersja na potrzeby gracza 3
        @RequestMapping("/kupnoGracza3")
        public String kupnoStatku3 (
                @RequestParam(value = "kupionyStatek", required = false) String kupionyStatek,
                Model model
    ) {
            System.out.println("Gracz 3 kupił statek"+kupionyStatek);

            // foreach po liscie statkiGracza3
            for (int i = 0; i < statkiDoKulepinia.size(); i++) {
                StatekSklep kupiony = statkiDoKulepinia.get(i);

                if (kupionyStatek.equals(kupiony.getNazwa())&&kasaGracza3 > kupiony.getCena() ) {

                    StatekSklep statek = statkiDoKulepinia.get(i);
                    kosztStatku = statek.getCena();
                    kasaGracza3 -= statek.getCena();
                    Statek tylkoStatek = statek;
                    System.out.println(kosztStatku);
                    statkiGracza3.add(tylkoStatek);
                    kosztStatku = 0;
                }
            }

            return "redirect:/zakupyGracza3";
        }

    //Wersja na potrzeby gracza 1 oraz 2 i 3 z uzyciem kodu URL
    @RequestMapping("/ktoKupuje")
    public String ktoKupuje (
            @RequestParam(value = "ktoKupuje", required = false) String ktoKupuje,
            Model model
    ) {
        model.addAttribute("ktoKupuje", ktoKupuje);
        model.addAttribute("statkiDoKulepinia", statkiDoKulepinia);
        model.addAttribute("kasaGracza1", kasaGracza1);
        model.addAttribute("kasaGracza2", kasaGracza2);
        model.addAttribute("kasaGracza3", kasaGracza3);

        return "ktoKupujeWybor";
    }




    // tu bedzie sprzedaz
    @RequestMapping ("/sprzedaz")
    public String sprzedaz (
          //  @RequestParam(value = "ktoSprzedaje", required = false) String ktoSprzedaje,
            @RequestParam(value = "ktoSprzedaje", required = false) String ktoSprzedaje,
            Model model
    ) {
        model.addAttribute("ktoSprzedaje", ktoSprzedaje);
        model.addAttribute("statkiGracza1", statkiGracza1);
        model.addAttribute("statkiGracza2", statkiGracza2);
        model.addAttribute("statkiGracza3", statkiGracza3);
        model.addAttribute("kasaGracza1", kasaGracza1);
        model.addAttribute("kasaGracza2", kasaGracza2);
        model.addAttribute("kasaGracza3", kasaGracza3);
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


    //Wersja na potrzeby gracza 1 oraz 2 i 3
    @RequestMapping("/zakupy")
    public String zakupy (
            Model model
    ) {
        model.addAttribute("statkiDoKulepinia", statkiDoKulepinia);
        model.addAttribute("kasaGracza1", kasaGracza1);
        model.addAttribute("kasaGracza2", kasaGracza2);
        model.addAttribute("kasaGracza3", kasaGracza3);

        return "sklep";
    }

    //Kopia na potrzeby gracza 1
    @RequestMapping("/zakupyGracza1")
    public String zakupy1 (
          Model model
    ) {
        model.addAttribute("statkiDoKulepinia", statkiDoKulepinia);
        model.addAttribute("kasaGracza1", kasaGracza1);

        return "sklepGracza1";
    }

    //Wersja na potrzeby gracza 2
    @RequestMapping("/zakupyGracza2")
    public String zakupy2 (
            Model model
    ) {
        model.addAttribute("statkiDoKulepinia", statkiDoKulepinia);
        model.addAttribute("kasaGracza2", kasaGracza2);

        return "sklepGracza2";
    }

    //Wersja na potrzeby gracza 3
    @RequestMapping("/zakupyGracza3")
    public String zakupy3 (
           Model model
    ) {
            model.addAttribute("statkiDoKulepinia", statkiDoKulepinia);
            model.addAttribute("kasaGracza3", kasaGracza3);

            return "sklepGracza3";
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



