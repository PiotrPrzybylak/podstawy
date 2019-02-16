package testKopiowaniaListy;

import OOP.*;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Statek> listaGraczaTest = new ArrayList<>();

        Gracz graczTest = new Gracz(listaGraczaTest, 10000);

        graczTest.getStatki().add( new Krazownik(new Nacja("Gallente"), "Krążownik","Vexor", 300,53565));
        graczTest.getStatki().add(new Krazownik(new Nacja("Amarr"),"Krążownik","Maller", 294,35545));
        graczTest.getStatki().add(new Fregata(new Nacja("Gallente"), "Fregata", "Tristan", 100, 5600));
        graczTest.getStatki().add(new Fregata(new Nacja("Gallente"), "Fregata", "Atron", 4000,4000));

        System.out.println("graczTest dodawanie statkow metoda getStatki.add");
        System.out.println(graczTest.getStatki());

graczTest.getStatki().add(new Krazownik(new Nacja("Gallente"), "Krążownik","Vexor", 300,53565));

    ArrayList<Statek> lista = new ArrayList<>();

        lista.add(new Krazownik(new Nacja("Gallente"), "Krążownik","Vexor", 300,53565));
        lista.add(new Krazownik(new Nacja("Amarr"),"Krążownik","Maller", 294,35545));

        Gracz graczCostam = new Gracz(lista, 10000);

//         Gracz graczTest  graczCostam;
        System.out.println("graczCostam dodawanie statkow bezposternio do obiektu lista");
        System.out.println(graczCostam.getStatki());

        lista.clear();
        listaGraczaTest.add(new Krazownik(new Nacja("Gallente"), "Krążownik","Vexor", 300,53565));


        System.out.println("graczCostam kasowanie obiektu lista");
        System.out.println(graczCostam.getStatki());
        System.out.println("graczTest ddodawanie statkow bezposternio do obiektu lista ");
        System.out.println(graczTest.getStatki());

    }

}
