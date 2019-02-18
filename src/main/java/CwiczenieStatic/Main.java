package CwiczenieStatic;

import static org.codehaus.groovy.runtime.InvokerHelper.asList;

public class Main {
    public static void main (String [] args){


        CzlonekKlubu cl =  new CzlonekKlubu("Adam", "Kowalski");
        CzlonekKlubu cl2 = new CzlonekKlubu("Zosia", "Dupa");
        CzlonekKlubu.powiekszCzlonka(cl);
        System.out.println("stan czlonekID dla cl= "+cl.getCzlonekID());

        System.out.println(cl.dajInta());
        System.out.println(CzlonekKlubu.zmienInta(5));


        Class<CzlonekKlubu> x = CzlonekKlubu.class;
        System.out.println(asList(x.getMethods()));
        System.out.println(x);


        cl.getCzlonekID();

        CzlonekKlubu.getCzlonekID2(cl);

        cl.skolinizuj(cl2);

        System.out.println(cl);
        System.out.println(cl2);

    }
}
