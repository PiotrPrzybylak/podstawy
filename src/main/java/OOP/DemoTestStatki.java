package OOP;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




@SpringBootApplication
public class DemoTestStatki {
    public static void main (String [] args){

        System.setProperty("spring.profiles.active", "demo");
        System.setProperty("JDBC_DATABASE_URL", "jdbc");
        TestStatki.main(args);
    }






}








