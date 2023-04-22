package javaScriptExecutor;

import common.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavascriptExecutorDemi extends DriverManager {

    @Test
    public void test1() {
        createDriver("chrome");
        navigateToThePage("https://letcode.in/test");

//document.querySelector("cssSelector").style.borderBlock='10px solid blue'

        WebElement inputEle = driver.findElement(By.xpath("//p[contains(.,'Input')]"));

        for (int i = 0; i < 10; i++) {

            ((JavascriptExecutor) driver).executeScript("arguments[0].style.borderBlock='10px solid blue'", inputEle);
            mySleep(200);
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.borderBlock='10px solid red'", inputEle);
            mySleep(200);
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.borderBlock='10px solid white'", inputEle);
            mySleep(200);
        }
    }
}