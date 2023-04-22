package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    public WebDriver driver;

    public void createDriver(String browser) {

        if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equals("edge")) {
            driver = new EdgeDriver();
        } else {
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
    }

    public void loginIntoOrangeHRM() {
        //open the app
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //wait
        wait(3);

        //find the username field on the page
        WebElement usernameElement = driver.findElement(By.name("username"));
        //enter username value into the field
        usernameElement.sendKeys("Admin");

        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.className("orangehrm-login-button"));
        loginButton.click();

        wait(2);
    }


    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException interruptedException) {
            System.out.println(interruptedException);
        }
    }

    public void mySleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException interruptedException) {
            System.out.println(interruptedException);
        }
    }


    public void navigateToThePage(String url) {
        driver.get(url);
    }

    public void enterText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public void click(By by) {
        driver.findElement(by).click();
    }

    public String getText(By by) {
        return driver.findElement(by).getText();
    }

    public void quiteBrowser() {
        driver.quit();
    }


    public boolean isElementPresent(By by) {
        return driver.findElements(by).size() > 0;
    }

}
