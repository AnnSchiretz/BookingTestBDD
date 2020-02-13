package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingPage extends BasePage{

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchInput;
    @FindBy(xpath = "//button[@type='submit']")
    private  WebElement buttonSubmit;

    public BookingPage(WebDriver driver) {
        super(driver);
    }
    public void searchHotel(String hotel){
        searchInput.click();
        searchInput.sendKeys(hotel);
        buttonSubmit.click();
    }
}
