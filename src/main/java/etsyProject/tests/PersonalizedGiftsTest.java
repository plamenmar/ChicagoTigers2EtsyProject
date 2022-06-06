package etsyProject.tests;

import etsyProject.pages.PersonalizedGiftsPage;
import org.testng.annotations.Test;

public class PersonalizedGiftsTest extends TestBase {
    @Test
    public void validateEstimatedArrival() throws InterruptedException {
        PersonalizedGiftsPage personalizedGiftsPage = new PersonalizedGiftsPage(driver);
        personalizedGiftsPage.chooseEstimatedArrival();
    }
    @Test
    public void validateHighToLowPricesMethod() throws InterruptedException {
        PersonalizedGiftsPage personalizedGiftsPage = new PersonalizedGiftsPage(driver);
        personalizedGiftsPage.validateHightoLowPrices();
    }
}
