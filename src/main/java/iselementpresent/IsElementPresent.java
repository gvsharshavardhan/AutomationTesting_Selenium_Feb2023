package iselementpresent;

import common.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class IsElementPresent extends DriverManager {

    @Test
    public void test1() {

        createDriver("chrome");
        navigateToThePage("https://leafground.com/button.xhtml");

        if (isPresent(By.cssSelector("button[id*='image123']"))) {
            driver.findElement(By.cssSelector("button[id*='image123']")).click();
        }else{
            System.out.println("button with id  :: image123 is not present on the page");
        }


    }

    public boolean isPresent(By by) {
        return driver.findElements(by).size() > 0;
    }

}