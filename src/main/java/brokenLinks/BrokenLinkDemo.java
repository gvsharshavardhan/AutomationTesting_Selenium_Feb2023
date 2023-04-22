package brokenLinks;

import common.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrokenLinkDemo extends DriverManager {


    @Test
    public void test1() throws IOException {

        createDriver("chrome");
        navigateToThePage("https://www.amazon.ca/ref=nav_bb_logo");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//*[@aria-label='More on Amazon']//a"), 14));


        List<String> urls = new ArrayList<>();

        List<WebElement> links = driver.findElements(By.xpath("//*[@aria-label='More on Amazon']//a"));
        for (WebElement link : links) {
            urls.add(link.getAttribute("href"));
        }

        for (String url : urls) {
            HttpURLConnection huc = (HttpURLConnection) (new URL(url).openConnection());
            huc.connect();
            if (huc.getResponseCode() >= 400) {
                System.out.println(huc.getResponseCode() + " :: " + url);
            }
        }


    }
}
