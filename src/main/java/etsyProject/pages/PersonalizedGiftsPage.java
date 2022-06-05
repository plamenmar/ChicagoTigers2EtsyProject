package etsyProject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalizedGiftsPage {

    public PersonalizedGiftsPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/div[2]/div/ul/li[1]/a/div[2]/p[2]")
    WebElement personalizedGifts;

    @FindBy(xpath = "//span[contains(text(),'Estimated Arrival')]")
    WebElement estimatedArrivalButton;

    @FindBy(xpath = "//a//label[contains(text(),'By Jun 12')]")
    WebElement arrivalDate;


    public void chooseEstimatedArrival() throws InterruptedException {
        personalizedGifts.click();
        estimatedArrivalButton.click();
        Thread.sleep(2000);
        arrivalDate.click();
    }
}
