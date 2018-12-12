package OOP;

public class Statek extends ObiektLatajacy {

    private  Nacja nacja;

    private String typ;
    private String nazwa;
    int dps;
    int ehp;


    public Statek() {
    }

    public Statek(Nacja nacja, String typ, String nazwa, int dps, int ehp) {
        this.nacja = nacja;
        this.typ = typ;
        this.nazwa = nazwa;
        this.dps = dps;
        this.ehp = ehp;
    }

    public Statek(String typObiektu, Nacja nacja, String typ, String nazwa, int dps, int ehp) {
        super(typObiektu);
        this.nacja = nacja;
        this.typ = typ;
        this.nazwa = nazwa;
        this.dps = dps;
        this.ehp = ehp;
    }

    public Nacja getNacja() {
        return nacja;
    }

    public String getTyp() {
        return typ;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getDps() {
        return dps;
    }

    public int getEhp() {
        return ehp;
    }


    public String toString (){
      return super.toString()+ nacja + ", Typ Statku: "+ typ + ", Nazwa: "+nazwa+ " DPS" + dps + " EHP " + ehp;
    }


}
