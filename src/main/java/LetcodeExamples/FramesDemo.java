package LetcodeExamples;

import common.DriverManager;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FramesDemo extends DriverManager {

    By fnameLocator = By.xpath("//input[@name='fname']");
    By lnameLocator = By.xpath("//input[@name='lname']");
    By emailLocator = By.xpath("//input[@name='email']");


    @Test
    public void frameTest1() {

        createDriver("chrome");
        navigateToThePage("https://letcode.in/frame");
        wait(2);

        //switchto the frame
        driver.switchTo().frame("firstFr");

        enterText(fnameLocator, "harsha");
        enterText(lnameLocator, "vardhan");

        //2nd switch

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='innerFrame']")));
        enterText(emailLocator, "harsha@busyqa.com");


        driver.switchTo().parentFrame();
        driver.findElement(lnameLocator).clear();


    }


}