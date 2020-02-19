package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BookingPage;
import pages.BookingResultPage;

import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class BookingSearchSteps {
    private static final String BOOKING_URL = "https://www.booking.com/searchresults.en-gb.html";
    private BookingPage booking;
    private BookingResultPage result;
    private WebDriver driver;


    @Given("User on the search page")
    public void userOnTheSearchPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(BOOKING_URL);
        booking = new BookingPage(driver);
        result = new BookingResultPage(driver);
    }
    @And("Hotels in {string}")
    public void hotelsIn(String countryHotel) {
        booking.searchHotel(countryHotel);
    }


    @When("User performs search")
    public void userPerformsSearch() {
        booking.clickSearchButton();
    }

    @Then("Hotel {string} appears in the search")
    public void hotelAppearsInTheSearch(String arg0) {
        List<String> res = result.getResultsHotel();
        assertThat(String.format("There are no results for search string '%s' on first search page", arg0),
                res.contains(arg0));
    }


    @And("Hotel {string} has rating {string}")
    public void hotelHasRating(String arg0, String arg1) {
        String rating = driver.findElement(result.getRating(arg0)).getText();
        assertEquals(rating, arg1);
    }
}
