package LetcodeExamples;

import common.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ButtonDemo extends DriverManager {


    By goHomeButtonLocator = By.xpath("//button[@id='home']");
    By locationButtonLocator = By.xpath("//button[@id='position']");
    By colorButtonLocator = By.xpath("//button[@id='color']");
    By propertyButtonLocator = By.xpath("//button[@id='property']");
    By holsButtonLocator = By.xpath("//*[.='Button Hold!']/ancestor::button");

    @Test
    public void buttonTest(){
        createDriver("firefox");
        wait(2);

        driver.get("https://letcode.in/buttons");

        System.out.println(driver.getTitle());//button
        driver.findElement(goHomeButtonLocator).click();
        wait(1);
        System.out.println(driver.getTitle());//home
        driver.navigate().back();
        wait(2);
        System.out.println(driver.getTitle());//button


        Point coordinates = driver.findElement(locationButtonLocator).getLocation();
        System.out.println("X: " + coordinates.getX());
        System.out.println("Y: " + coordinates.getY());


        System.out.println(driver.findElement(colorButtonLocator).getCssValue("background-color"));

        Dimension size = driver.findElement(propertyButtonLocator).getSize();
        System.out.println("Height: "+size.getHeight());
        System.out.println("Width: "+size.getWidth());

        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(holsButtonLocator);
        actions.clickAndHold(element).perform();
    }
}