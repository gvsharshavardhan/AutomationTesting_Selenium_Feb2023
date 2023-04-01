package LetcodeExamples;

import common.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class WindowDemo extends DriverManager {

    By homeButtonLocator = By.xpath("//button[@id='home']");

    @Test
    public void windowTest1() {

        createDriver("chrome");
        navigateToThePage("https://letcode.in/windows");
        wait(2);

        click(homeButtonLocator);

        String parentWindowID = driver.getWindowHandle();

        Set<String> allIDs = driver.getWindowHandles();

        for(String id :allIDs){
            if(!id.equals(parentWindowID)){
                driver.switchTo().window(id);
            }
        }

        List<WebElement> headers = driver.findElements(By.xpath("//p[@class='card-header-title is-size-3']"));
        System.out.println("HEADERS are:: ");
        for(WebElement header:headers){
            System.out.println(header.getText());
        }


        driver.switchTo().window(parentWindowID);

        System.out.println("TITLE:: " + driver.getTitle()); //window handling  - letcode


    }

    @Test
    public void windowTest2(){

        By headerLocator = By.xpath("//h1");

        createDriver("chrome");
        navigateToThePage("https://letcode.in/windows");
        wait(2);


        click(By.xpath("//button[@id='multi']"));

        String parentTabID = driver.getWindowHandle();

        Set<String> allIDs = driver.getWindowHandles();

        for(String id:allIDs){
            driver.switchTo().window(id);
            wait(2);
            if(getText(headerLocator).equals("Alert")){
                click(By.id("accept"));
                driver.switchTo().alert().accept();
            }else if(getText(headerLocator).equals("Dropdown")){

                Select select = new Select(driver.findElement(By.id("superheros")));
                List<WebElement> options = select.getOptions();
                for(WebElement option:options){
                    System.out.println(option.getText());
                }
            }
        }

        driver.switchTo().window(parentTabID);
        System.out.println(driver.findElement(headerLocator).getText());//windows


    }




}
