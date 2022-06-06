package etsyProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonalizedGiftsPage {

    public PersonalizedGiftsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/div[2]/div/ul/li[1]/a/div[2]/p[2]")
    WebElement personalizedGifts;

    @FindBy(xpath = "//span[contains(text(),'Estimated Arrival')]")
    WebElement estimatedArrivalButton;

    @FindBy(xpath = "//a//label[contains(text(),'By Jun 12')]")
    WebElement arrivalDate;

    @FindBy(xpath =
            "//p[@class='wt-text-title-01 wt-text-center-xs wt-text-truncate--multi-line wt-text-black query-with-image-text wt-mb-xs-1 wt-hide-xs wt-show-lg']")
    WebElement buttonGiftForDad;

    @FindBy(xpath = "//span[contains(text(),'Sort by')]")
    WebElement sortByButton;

    @FindBy(xpath = "//span[@class='currency-value']")
    List<WebElement> allPrices;

    @FindBy(xpath = "//a[contains(text(), 'Highest ')]")
    WebElement sortHighest;

    public void chooseEstimatedArrival() throws InterruptedException {
        personalizedGifts.click();
        estimatedArrivalButton.click();
        Thread.sleep(2000);
        arrivalDate.click();
    }
    public void validateHightoLowPrices() throws InterruptedException {
        buttonGiftForDad.click();
        Thread.sleep(2000);
        sortByButton.click();
        sortHighest.click();
        Thread.sleep(3000);
        List<Double> actualPrices = new ArrayList<>(allPrices.size());
        List<Double> expectedPrices = new ArrayList<>(allPrices.size());
        for (int i = 0; i < allPrices.size(); i++) {
            actualPrices.add(Double.parseDouble(allPrices.get(i).getText().replace(",", "")));
            expectedPrices.add(Double.parseDouble(allPrices.get(i).getText().replace(",", "")));
        }
        Collections.sort(expectedPrices);
        Collections.reverse(expectedPrices);
        System.out.println("Actual prices: " + actualPrices);
        System.out.println("Expected prices: " + expectedPrices);
        Assert.assertEquals(actualPrices, expectedPrices);

    }

}
