package staleEleException;

import common.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class StaleElementDemo extends DriverManager {

    @Test
    public void test1() {
        createDriver("chrome");
        navigateToThePage("https://letcode.in/buttons");

        WebElement element = driver.findElement(By.id("home"));

        driver.navigate().refresh();
        mySleep(1000);

        click(By.id("home"));

    }


    public void click(By by){
        driver.findElement(by).click();
    }


}
