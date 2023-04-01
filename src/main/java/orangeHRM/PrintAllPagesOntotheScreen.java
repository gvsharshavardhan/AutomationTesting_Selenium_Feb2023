package orangeHRM;

import common.DriverManager;
import org.testng.annotations.Test;

public class PrintAllPagesOntotheScreen extends DriverManager {


    @Test
    public void printAllPages(){
        createDriver("firefox");
        loginIntoOrangeHRM();

        


        quiteBrowser();
    }


}