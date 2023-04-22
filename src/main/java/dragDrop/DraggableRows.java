package dragDrop;

import common.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class DraggableRows extends DriverManager {


    @Test
    public void test1(){
        createDriver("chrome");
        navigateToThePage("https://leafground.com/drag.xhtml");

        By source = By.xpath("//h5[contains(.,'Draggable Rows')]/following-sibling::div//td[contains(.,'Bamboo Watch')]/parent::tr");
        By target = By.xpath("//h5[contains(.,'Draggable Rows')]/following-sibling::div//td[contains(.,'Brown Purse')]/parent::tr");

        Actions actions = new Actions(driver);
//        actions.clickAndHold(driver.findElement(target)).pause(Duration.ofMillis(500)).moveToElement(driver.findElement(source)).release().perform();
        actions.dragAndDropBy(driver.findElement(source),0,-400).perform();


    }

}
