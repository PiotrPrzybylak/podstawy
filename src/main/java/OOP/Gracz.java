package OOP;

import java.util.ArrayList;
import java.util.List;

public class Gracz {

    private int kasa;
    private List<Statek> statki;

    public Gracz() {
    }

    public Gracz(List<Statek> statki, int kasa) {
        this.statki = statki;
        this.kasa = kasa;
    }

    public int getKasa() {
        return kasa;
    }

    public List<Statek> getStatki() {
        return statki;
    }



    // metoda kupowania
    public void kupStatek(String kupionyStatek, Gracz ktoryGracz, List<StatekSklep> statkiDoKulepinia) {


        for (int i = 0; i < statkiDoKulepinia.size(); i++) {
            StatekSklep kupiony = statkiDoKulepinia.get(i);

            if (kupionyStatek.equals(kupiony.getNazwa()) && this.kasa > kupiony.getCena()) {
                StatekSklep statek = statkiDoKulepinia.get(i);
                this.kasa -= statek.getCena();
                Statek tylkoStatek = (Statek) statek;
                this.statki.add(tylkoStatek);
            }

        }
    }

    // metoda sprzedawania
    public void sprzedajStatek(int sprzedanyStatek, Gracz ktoryGracz, List <Statek>statkiZlomowisko, List<StatekSklep> statkiDoKulepinia ) {
       List <Statek> statkiNaSprzedaz = new ArrayList<>();


        statkiNaSprzedaz = this.getStatki();
        // foreach po liscie
        for (int i = 0; i < statkiNaSprzedaz.size(); i++) {
            Statek sprzedany = statkiNaSprzedaz.get(i);
            if (sprzedanyStatek == sprzedany.getEhp()) {
                statkiZlomowisko.add(statkiNaSprzedaz.get(i));
                statkiNaSprzedaz.remove(statkiNaSprzedaz.get(i));
                break;
            }
        }
        // tu jest metoda dodawania kasy
        for (int i = 0; i < statkiDoKulepinia.size(); i++) {
            StatekSklep bazaStatkow = statkiDoKulepinia.get(i);

            if (sprzedanyStatek == bazaStatkow.getEhp()) {
                this.kasa += statkiDoKulepinia.get(i).getCena()/2;
            }
        }


    }
}
