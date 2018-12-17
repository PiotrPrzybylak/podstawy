package Sport;

public class Biegacz extends Sportowiec implements Bieganie{


    public Biegacz(String imie, String nazwisko) {
        super(imie, nazwisko);
    }

    @Override
    public void biegnij() {
        System.out.println("Biegnę");
    }

    @Override
    public void walczOMedal() {
        biegnij();
    }
}
