package fidoDynamicXpath;

import common.DriverManager;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class FidoXpath extends DriverManager {


    @Test
    public void fetchPrices() {

        createDriver("chrome");
        driver.get("https://www.fido.ca/phones/");
        wait(3);

        ArrayList<String> phones = new ArrayList<>();
        phones.add("Samsung Galaxy S21 Ultra 5G");
        phones.add("Samsung Galaxy Z Flip3 5G");
        phones.add("TCL Flip");

        String fullPriceXpath = "//p[contains(.,'$$')]/ancestor::div[contains(@class,'h-100 d-flex')]//p[@class='text-body-sm mb-0 text-semi']";


        for (String phone : phones) {
            String price = driver.findElement(By.xpath(fullPriceXpath.replace("$$", phone))).getText();
            System.out.println("Phone: " + phone);
            System.out.println("fullPrice: " + price);
        }

        quiteBrowser();

    }


}