package dragDrop;

import common.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragDropDemo extends DriverManager {

    @Test
    public void test1() {
        createDriver("chrome");
        navigateToThePage("https://leafground.com/drag.xhtml");

        Actions actions = new Actions(driver);

        WebElement source = driver.findElement(By.xpath("//div[@id='form:drag']"));
        WebElement target = driver.findElement(By.xpath("//div[@id='form:drop_content']"));

        actions.dragAndDrop(source, target).perform();

    }

    @Test
    public void test2() {
        createDriver("chrome");
        navigateToThePage("https://leafground.com/drag.xhtml");

        Actions actions = new Actions(driver);

        WebElement source = driver.findElement(By.xpath("//div[@id='form:conpnl_content']"));

        for (int i = 0; i < 10; i++) {
            actions.dragAndDropBy(source, 200, 0).perform();
            mySleep(250);
            actions.dragAndDropBy(source, 200, 0).perform();
            mySleep(250);
            actions.dragAndDropBy(source, -400, 0).perform();
            mySleep(250);
        }

    }


    @Test
    public void test3Scroll() {
        createDriver("chrome");
        navigateToThePage("https://leafground.com/drag.xhtml");

        Actions actions = new Actions(driver);

        actions.scrollToElement(driver.findElement(By.xpath("//h4[.='Range Slider']"))).perform();

    }
}
