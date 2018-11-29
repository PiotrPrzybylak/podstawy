package OperatoryMatLog;

public class Operatory {
    public static void main (String [] args){

        int a = 17;
        int b = 4;
        int c =a+b;
        System.out.println(c);
        c=a-b;
        System.out.println(c);
        c=a*b;
        System.out.println(c);
        c=a/b;
        System.out.println(c);
        c=a%b;
        System.out.println(c);
        c =(a+b)/3;
        System.out.println(c);

        double d = 17;
        double e;
        e=d/b;
        System.out.println(e);


        a+=b; // a=a+b
        System.out.println(a);
        a-=b; // a=a-b
        System.out.println(a);
        a*=b; // a=a*b
        System.out.println(a);
        a/=b; // a=a/b
        System.out.println(a);

        int aa = 5;
        int bb = 3;
        System.out.println("najpierw a ="+aa);
        System.out.println("najpierw b ="+bb);
        System.out.println("przyklad c=a+b++");
        int cc = aa+bb++;
        System.out.println("a ="+aa);
        System.out.println("b ="+bb);
        System.out.println("c ="+cc);
        System.out.println("przyklad c=(a++)+b");
        cc = aa+++bb;
        System.out.println("a ="+aa);
        System.out.println("b ="+bb);
        System.out.println("c ="+cc);


        int aaa = 5;
        int bbb = 3;
        System.out.println("operatory logiczne boolean");
        boolean prawda = aaa>bbb; // prawda= true
        System.out.println(prawda);
        boolean falsz = aaa<bbb; // falsz=folse
        System.out.println(falsz);
        boolean porownanie = aaa==bbb; // falsz=folse
        System.out.println(porownanie);
        boolean koniunkcja = (aaa>bbb)&&(aaa!=bbb); //prawda i prawda
        System.out.println(koniunkcja);
    }
}
