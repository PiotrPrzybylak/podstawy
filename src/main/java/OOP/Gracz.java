package OOP;

import java.util.List;

public class Gracz {

    private int kasa;
    private List <Statek> statki;


    public Gracz() {
    }

    public Gracz(List<Statek> statki,int kasa) {
    this.statki= statki;
    this.kasa = kasa;
    }


    public int getKasa() {
        return kasa;
    }

    public List<Statek> getStatki() {
        return statki;
    }


    public void setKasa(int kasa) {
        this.kasa = kasa;
    }

    public void setStatki(List<Statek> statki) {
        this.statki = statki;
    }
}
