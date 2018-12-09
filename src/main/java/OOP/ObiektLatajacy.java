package OOP;

public class ObiektLatajacy {
    private String typObiektu;

    public ObiektLatajacy() {
    }

    public ObiektLatajacy(String typObiektu) {
        this.typObiektu = typObiektu;
    }


    public String getTypObiektu() {
        return typObiektu;
    }

    public String toString () {
        return "Typ obiektu latajacego: " + typObiektu;
    }

   public void wyswietl(){
        System.out.println(toString());
    }

}

