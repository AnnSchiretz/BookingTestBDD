package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.stream.Collectors;

public class BookingResultPage extends BasePage {
    @FindBy(css =".nodates_hotels .sr-hotel__name")
    private List<WebElement> resultsHotel;
    String ratingHotel = "//div[@class='bui-review-score__badge']";


    public BookingResultPage(WebDriver driver) {
        super(driver);
    }
    public List<String> getResultsHotel(){
        return resultsHotel.stream().map(WebElement::getText)
                .filter(result-> !result.isEmpty()).collect(Collectors.toList());
    }
    public By getRating(String hotel){
        By rating = By.xpath(String.format(ratingHotel,hotel));
        return rating;
    }
}
