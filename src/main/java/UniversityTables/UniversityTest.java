package UniversityTables;

import common.DriverManager;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class UniversityTest extends DriverManager {


    @Test
    public void universityTableTest() {
        createDriver("chrome");
        navigateToThePage("https://letcode.in/advancedtable");
        wait(2);


        List<University> universityList = new ArrayList<>();

        String noOfRowsXpath = "//tbody//tr";
        String universityNameXpath = "//tbody//tr[$$]/td[2]";
        String countryXpath = "//tbody//tr[$$]/td[3]";
        String webSitexpath = "//tbody//tr[$$]/td[4]";

        By nextLocator = By.xpath("//a[.='Next']");

        while (true) {
            int noOfRows = driver.findElements(By.xpath(noOfRowsXpath)).size();
            for (int i = 1; i <= noOfRows; i++) {
                University university = new University();
                String uname = driver.findElement(By.xpath(universityNameXpath.replace("$$", Integer.toString(i)))).getText();
                String country = driver.findElement(By.xpath(countryXpath.replace("$$", Integer.toString(i)))).getText();
                String site = driver.findElement(By.xpath(webSitexpath.replace("$$", Integer.toString(i)))).getText();

                university.setUniversityName(uname);
                university.setCountry(country);
                university.setWebsite(site);

                universityList.add(university);
            }

            boolean flag = driver.findElement(nextLocator).getAttribute("class").contains("disabled");
            if (flag) {
                break;
            } else {
                click(nextLocator);
            }
        }

        int j = 1;

        for (University university : universityList) {
            System.out.println(j);
            System.out.println(university);
            j++;

        }


    }


}

