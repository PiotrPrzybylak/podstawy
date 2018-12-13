package OOP;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoTestStatki {
    public static void main (String [] args){

        System.setProperty("spring.profiles.active", "demo");
        System.setProperty("JDBC_DATABASE_URL", "jdbc");
        TestStatki.main(args);
    }
}








