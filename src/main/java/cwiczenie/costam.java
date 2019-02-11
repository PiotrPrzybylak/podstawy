package cwiczenie;

public class costam {
    public static void main (String [] args){

        String a = "A";
        String b = "B";

        System.out.println("przed metoda SWAP a ="+a+" b= "+b);
        swapString(a,b);
        System.out.println("po metodzie SWAP a ="+a+" b= "+b);


        char c = 'C';
        char d = 'D';
        System.out.println("przed metoda SWAP z char c= "+c+" d= "+d);
        swapCharMaly(c,d);
        System.out.println("po metodzie SWAP z char c ="+c+" d= "+d);

        System.out.println("przed metoda SWAP z Character c ="+c+" d= "+d);
        swapCharWielki(c,d);
        System.out.println("po metodzie SWAP z Character c ="+c+" d= "+d);



        int jeden = 1;
        int dwa = 2;
        System.out.println("przed metoda SWAP jeden ="+jeden+" dwa= "+dwa);
        swapInt(jeden,dwa);
        System.out.println("po metodzie SWAP jeden ="+jeden+" dwa= "+dwa);



        Czlowiek kamil = new Czlowiek(39);
        Czlowiek magda = new Czlowiek(36);

        System.out.println("Kamil wiek"+kamil);
        System.out.println("Magda wiek"+magda);
        swapCzlowiek(kamil,magda);
        System.out.println("Kamil wiek po metodzie swap"+kamil);
        System.out.println("Magda wiek po metodzie swap"+magda);


        System.out.println("przed zmiana "+kamil.getWiek());
        zmienWiek(kamil);
        System.out.println("po zmianie "+kamil.getWiek());

    }


    public static void swapString (String a, String b){
        String tempo = a;
        a= b;
        b = tempo;
    }

    public static void swapCharMaly (char pierwszy, char drugi) {
        char tempo = pierwszy;
        char c = drugi;
        char d = tempo;
    }

    public static void swapCharWielki (Character pierwszy, Character drugi) {
        Character tempo = pierwszy;
        Character c = drugi;
        Character d = tempo;
    }

    public static void swapInt (int pierwszy, int drugi) {
        int tempo = pierwszy;
        int jeden = drugi;
        int dwa = tempo;
    }

    public static void swapCzlowiek (Czlowiek pierwszy, Czlowiek drugi){
        Czlowiek tempo = pierwszy;
        pierwszy = drugi;
        drugi = tempo;
    }

    public static void  zmienWiek ( Czlowiek pierwszy){
        pierwszy.setWiek(40);
    }


    }
