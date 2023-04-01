package LetcodeExamples;

import common.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class InputFields extends DriverManager {

    String fullNameXpath = "//input[@id='fullName']";
    String appendXpath = "//input[@id='join']";
    String getDataXpath = "//input[@id='getMe']";
    String clearXpath = "//input[@id='clearMe']";
    String disabledEditFieldXpath = "//input[@id='noEdit']";
    String readonlyFieldXpath = "//input[@id='dontwrite']";

    @Test
    public void inputFieldTest(){

        createDriver("firefox");
        driver.get("https://letcode.in/edit");
        wait(3);
        driver.findElement(By.xpath(fullNameXpath)).sendKeys("Selenium with Java");


        driver.findElement(By.xpath(appendXpath)).sendKeys("good morning!");
        driver.findElement(By.xpath(appendXpath)).sendKeys(Keys.TAB);


        System.out.println(driver.findElement(By.xpath(getDataXpath)).getAttribute("value"));


        driver.findElement(By.xpath(clearXpath)).clear();


        System.out.println(driver.findElement(By.xpath(disabledEditFieldXpath)).isEnabled()); //false


        System.out.println(driver.findElement(By.xpath(readonlyFieldXpath)).getAttribute("readOnly")); //true






    }




}