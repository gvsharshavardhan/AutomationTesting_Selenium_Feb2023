package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Scanner;

public class FirstSeleniumScript {

    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the browser name:  ");
        String browser = sc.nextLine();

        if(browser.equals("firefox")){
            driver = new FirefoxDriver();
        }else if(browser.equals("edge")){
            driver = new EdgeDriver();
        }else{
            driver = new ChromeDriver();
        }


        //open the app
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //wait
        Thread.sleep(3000);

        //find the username field on the page
        WebElement usernameElement = driver.findElement(By.name("username"));
        //enter username value into the field
        usernameElement.sendKeys("Admin");

        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.className("orangehrm-login-button"));
        loginButton.click();

        Thread.sleep(2000);

        driver.quit();

    }
}