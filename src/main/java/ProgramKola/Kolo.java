package ProgramKola;

public class Kolo {

    private double promień;


    public double getPromień(){
        return promień;
    }

    public Kolo (){
        this (1.0);
    }
    public Kolo (double r){
        this(r,"coś");
    }
    public Kolo (double r, String j){
        promień = r;
        if (j.equals("km")){
            promień = promień * 1000;
        }
    }


    public double obliczObwódKoła (){
        return 2*Math.PI*promień;
    }


    public static void main(String[] args) {


        Kolo [] kółka = new Kolo [3];

        kółka[0] = new Kolo ();
        kółka[1] = new Kolo (3.5);
        kółka[2] = new Kolo (7,"km");

        for (Kolo x:kółka){
            System.out.println("Promień koła wynosi"+ x.getPromień());
            System.out.println("Obwód koła wynosi"+ x.obliczObwódKoła());
        }

    }
}
