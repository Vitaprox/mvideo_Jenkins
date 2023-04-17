package pages.homePage;

import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.common.AbstractBlock;
import pages.common.AbstractPage;
import pages.common.WebElement;
import pages.common.WebElementsCollection;

@FindBy(xpath = "//mvid-day-products-block")
public class DayProductsBlock extends AbstractBlock {

    private final String XPATH_PRODUCT_WITH_NAME = "//mvid-day-product[.//a[text()=' %s ']]";

    private final String XPATH_PRODUCT_ADD_TO_CART_BUTTON_WITH_NAME = XPATH_PRODUCT_WITH_NAME +
            "//button[.//span[text()=' В корзину']]";

    private WebElementsCollection dayProductsBuyButton = new WebElementsCollection("//mvid-day-product/button");

    @FindBy(xpath = ".//span[@class='title__text']")
    private WebElement title;

    @FindBy(xpath = ".//button[contains(@class, 'forward')]")
    private WebElement forwardButton;

    public void clickDayProductsBuyButton(String productName) {
        for (int i = 0; i < 3; i++) {
            if (WebElement.get(XPATH_PRODUCT_WITH_NAME, productName).isDisplayedAfterWaiting(1000)) {
                WebElement.get(XPATH_PRODUCT_ADD_TO_CART_BUTTON_WITH_NAME, productName).click();
            } else {
                if(i == 2)
                    Assert.fail();
                forwardButton.click();
            }
        }
    }

    public void clickDayProductsBuyButton() {
        for (WebElement el : dayProductsBuyButton.getWebElementsList()) {
            if (el.isDisplayed()) {
                el.click();
                return;
            }
        }
    }

    public boolean isTitleDisplayed() {
        return title.isDisplayedAfterWaiting(40000);
    }

    public boolean isDisplayed() {
        return container.isDisplayedAfterWaiting(2500);
    }

}
