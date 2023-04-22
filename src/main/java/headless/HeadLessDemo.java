package headless;

import common.DriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HeadLessDemo extends DriverManager {

    @Test
    public void test1(){

        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);

        ChromeDriver d = new ChromeDriver(options);
        d.get("https://letcode.in/test");

        System.out.println(d.getTitle());


    }


}
