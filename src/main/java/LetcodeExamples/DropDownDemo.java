package LetcodeExamples;

import common.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DropDownDemo extends DriverManager {
    By fruitsDropDown = By.xpath("//select[@id='fruits']");
    By superHerosDropDown = By.xpath("//select[@id='superheros']");

    @Test
    public void dropDownTest() {

        createDriver("chrome");
        driver.get("https://letcode.in/dropdowns");
        wait(2);


        //1
        Select select = new Select(driver.findElement(fruitsDropDown));
        select.selectByVisibleText("Apple");

        String notification = driver.findElement(By.xpath("//p[@class='subtitle']")).getText();


        //validation points
        Assert.assertTrue(notification.contains("Apple"));


        //2
        /**
         * AAA
         * 1. A -> Arrange, testdata
         * 2. A -> Act, actual flow of the testcase
         * 3. A -> Assertion, validations
         */

        //testData //setup
        List<String> superHeros = Arrays.asList("Black Panther","Doctor Strange","Fantastic Four");


        //selection logic
        select = new Select(driver.findElement(superHerosDropDown));
        if (select.isMultiple()) {

            for(String superhero:superHeros){
                select.selectByVisibleText(superhero);
            }

        } else {
            select.selectByVisibleText("Hellboy");
        }

        //getting values from screen
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        List<String> superHerosFromApp = new ArrayList<>();

        for (WebElement option : selectedOptions) {
            superHerosFromApp.add(option.getText());
        }

        //Assertion
        Assert.assertTrue(superHerosFromApp.containsAll(superHeros));
    }

    @Test
    public void DropDown3Test(){
        createDriver("chrome");
        driver.get("https://letcode.in/dropdowns");
        wait(2);

        Select select = new Select(driver.findElement(By.xpath("//select[@id='lang']")));

        List<WebElement> allOptions = select.getOptions();

        System.out.println("All options are:: ");
        for(WebElement option : allOptions){
            System.out.println(option.getText());
        }

        select.selectByVisibleText(allOptions.get(allOptions.size()-1).getText());
    }


}