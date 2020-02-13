package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Hotel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BookingPage;

public class BookingSearchSteps {
    private static final String BOOKING_URL = "https://www.booking.com/searchresults.en-gb.html";
    private BookingPage booking;
    public WebDriver driver;
    String hotel;


    @Given("User on the search page")
    public void userOnTheSearchPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(BOOKING_URL);
        booking = new BookingPage(driver);
    }

    @And("Hotels name {string}")
    public void hotelsName(String arg0) {
        booking.searchHotel(arg0);
    }

    @When("User performs search")
    public void userPerformsSearch(String hotelName) {
        hotel = hotelName;
        booking.searchHotel(hotelName);
    }

    @Then("model.Hotel {string} appears in the search")
    public void hotelAppearsInTheSearch(String arg0) {

    }

    @And("model.Hotel {string} has rating {string}")
    public void hotelHasRating(String arg0, String arg1) {
    }
}
