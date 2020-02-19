package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingPage extends BasePage{

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchInput;
    @FindBy(xpath = "//button[@type='submit']")
    private  WebElement buttonSubmit;
    @FindBy(xpath = "//span[contains(text(), 'Search')]")
    private WebElement wordSearchInForm;

    public BookingPage(WebDriver driver) {
        super(driver);
    }
    public void searchHotel(String countryHotel){
        searchInput.click();
        searchInput.sendKeys(countryHotel);
    }
    public void clickSearchButton(){
        wordSearchInForm.click();
        buttonSubmit.click();
    }
}
