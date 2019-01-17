package OOP;

import java.util.List;

public class Gracz {

    private String nazwa;
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


}
