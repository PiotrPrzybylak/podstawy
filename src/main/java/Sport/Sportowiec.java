package Sport;



abstract public class Sportowiec {

   private String imie;
   private String nazwisko;

    public Sportowiec(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }


    public abstract void walczOMedal();

   public void wyswietl (){
        System.out.println("Imie: "+ imie + " , Nazwisko: " + nazwisko);
       System.out.println(this);
       System.out.println(this.getClass());
    }



}
