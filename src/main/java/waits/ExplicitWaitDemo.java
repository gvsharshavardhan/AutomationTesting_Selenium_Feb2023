package waits;

import common.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWaitDemo extends DriverManager {

    @Test
    public void test1() {

        createDriver("chrome");
        navigateToThePage("https://chercher.tech/practice/explicit-wait");

        driver.findElement(By.cssSelector("#alert")).click();

        //Explicit wait
        WebDriverWait alertwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        alertwait.until(ExpectedConditions.alertIsPresent());

        System.out.println("Alert Text:: "+driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();


        quiteBrowser();

    }

    @Test
    public void test2() {

        createDriver("chrome");
        navigateToThePage("https://chercher.tech/practice/explicit-wait");

        driver.findElement(By.cssSelector("#populate-text")).click();

        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#h2"),"Selenium Webdriver"));


        System.out.println(driver.findElement(By.cssSelector("#h2")).getText());

        quiteBrowser();

//        ExpectedConditions.presenceOfElementLocated(By.cssSelector("#hidden"));
//        ExpectedConditions.elementToBeClickable(By.id("disable"));
//        ExpectedConditions.elementToBeSelected(By.id());

    }

}
