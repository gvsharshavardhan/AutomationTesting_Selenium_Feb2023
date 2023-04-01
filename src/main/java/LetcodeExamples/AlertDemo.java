package LetcodeExamples;

import common.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertDemo extends DriverManager {

    @Test
    public void alertTest1() {
        createDriver("chrome");
        driver.get("https://letcode.in/alert");
        wait(2);

        driver.findElement(By.xpath("//button[@id='accept']")).click();

        String alert1Text = "Hey! Welcome to LetCode";


        Alert alert = driver.switchTo().alert();

        String alertTextFromApp = alert.getText();

        Assert.assertEquals(alertTextFromApp, alert1Text, "alert 1 text is not as expected!");

        alert.accept();

        wait(2);

    }


}
