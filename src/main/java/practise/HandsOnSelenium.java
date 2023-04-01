package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandsOnSelenium {

    static By checkbox1 = By.id("my-check-1");
    static By checkbox2 = By.id("my-check-2");


    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");

        Thread.sleep(1000);

        driver.findElement(By.id("my-text-id")).sendKeys("Anusha");
        driver.findElement(By.name("my-password")).sendKeys("manju");
        driver.findElement(By.name("my-textarea")).sendKeys("Nandhini");


        if (driver.findElement(By.name("my-disabled")).isEnabled()) {
            driver.findElement(By.name("my-disabled")).sendKeys("Harsha");
        }

        if (!driver.findElement(By.name("my-readonly")).getAttribute("readonly").equals("true")) {
            driver.findElement(By.name("my-readonly")).sendKeys("Selenium");
        }


        if(driver.findElement(checkbox1).isSelected()){
            driver.findElement(checkbox1).click();
        }

        if(driver.findElement(checkbox2).isSelected()){
            driver.findElement(checkbox2).click();
        }


        String radioOption = "Default radio";

    }

}
