package LetcodeExamples;

import common.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TablesDemo extends DriverManager {

    @Test
    public void tableTest1() {
        int sum = 0;
        createDriver("chrome");
        navigateToThePage("https://letcode.in/table");
        wait(2);


        List<WebElement> headerElements = driver.findElements(By.xpath("//table[@id='shopping']/thead//th"));
        List<String> headers = new ArrayList<>();
        for (WebElement element : headerElements) {
            headers.add(element.getText());
        }

        int indexofPrice = headers.indexOf("Price") + 1;

        List<WebElement> priceElements =  driver.findElements(By.xpath("//table[@id='shopping']/tbody//tr/td["+indexofPrice+"]"));
        for(WebElement price : priceElements){
           sum = sum + Integer.parseInt(price.getText());
        }


        int totalFromApp = Integer.parseInt(driver.findElement(By.xpath("//table[@id='shopping']/tfoot/td["+indexofPrice+"]/b")).getText());

        Assert.assertEquals(totalFromApp, sum, "Total is not equal to the result shown in the app");

    }
}
