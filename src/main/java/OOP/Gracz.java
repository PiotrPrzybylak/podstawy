package OOP;

import java.util.List;

public class Gracz {

    private String nazwa;
    private int kasa;
    private List <Statek> statki;


    public Gracz() {
    }

    public Gracz(String nazwa,List<Statek> statki,int kasa) {
    this.nazwa = nazwa;
    this.statki= statki;
    this.kasa = kasa;
    }


    public int getKasa() {
        return kasa;
    }

    public List<Statek> getStatki() {
        return statki;
    }

   public String getNazwa() { return nazwa;}
}
