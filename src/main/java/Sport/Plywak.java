package Sport;

public class Plywak extends Sportowiec implements Plywanie {


    public Plywak(String imie, String nazwisko) {
        super(imie, nazwisko);
    }

    @Override
    public void plyn() {
        System.out.println("Płyń");
        System.out.println(this);
    }

    @Override
    public void walczOMedal() {
        plyn();

    }
}
