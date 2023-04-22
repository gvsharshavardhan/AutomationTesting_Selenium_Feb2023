package browserMethods;

import common.DriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrowserTests extends DriverManager {

    @Test
    public void test1() {

        createDriver("chrome");
        driver.manage().window().maximize();
        navigateToThePage("https://www.w3schools.com/js/js_loop_forof.asp");
        driver.manage().window().minimize();

        wait(2);
        quiteBrowser();



    }


}
