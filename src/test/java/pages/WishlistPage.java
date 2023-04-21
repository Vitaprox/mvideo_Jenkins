package pages;

import org.openqa.selenium.support.FindBy;
import pages.common.AbstractPage;
import pages.common.WebElement;

public class WishlistPage extends AbstractPage {

    private final String XPATH_PRODUCT_CONTAINER = "//div[@class='wishlist-item-holder']" +
            "[.//h3[@class='wishlist-product-title']/a[text()='%s']]";

    private final String XPATH_PRODUCT_DELETE_BUTTON = XPATH_PRODUCT_CONTAINER +
            "//span[contains(@class, 'wishlist-action-links-btn__text') and normalize-space(text())='Удалить']";

    @FindBy(xpath = "//h1[@class='wishlist-title' and normalize-space(text())='Избранное']")
    private WebElement mainTitle;

    @FindBy(xpath = "//div[@class='wishlist-image-holder']//img")
    private WebElement firstProductImg;

    @FindBy(xpath = "//div[@class='c-compare-back-link']")
    private WebElement backButton;

    public boolean isMainTitleDisplayed(){
        return mainTitle.isDisplayedAfterWaiting(17000);
    }

    public boolean isFirstProductImgDisplayed(){
        return firstProductImg.isDisplayedAfterWaiting(17000);
    }

    public boolean isProductDisplayed(String productName){
        return WebElement.get(XPATH_PRODUCT_CONTAINER, productName).isDisplayedAfterWaiting(4500);
    }

    public boolean isProductDeleteButtonDisplayed(String productName){
        return WebElement.get(XPATH_PRODUCT_DELETE_BUTTON, productName).isDisplayedAfterWaiting(4500);
    }

    public void clickProductDeleteButton(String productName){
        WebElement.get(XPATH_PRODUCT_DELETE_BUTTON, productName).click();
    }

    public void productShouldNotBeVisible(String productName){
        WebElement.get(XPATH_PRODUCT_CONTAINER, productName).shouldNotBeVisible();
    }

    public boolean isBackButtonDisplayed(){
        return backButton.isDisplayedAfterWaiting(7000);
    }

    public void clickBackButton(){
        backButton.click();
    }

}
