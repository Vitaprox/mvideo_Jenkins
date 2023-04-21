package pages.MakingOrderPartOnePage;

import org.openqa.selenium.support.FindBy;
import pages.common.AbstractPage;
import pages.common.WebElement;

public class MakingOrderPartOnePage extends AbstractPage {

    public static ModalBasketBlock modalBasket = new ModalBasketBlock();

    @FindBy(xpath = "//div[@class='checkout-step1'][h1[text()='Оформление заказа. Шаг 1 из 2']]")
    private WebElement container;

    @FindBy(xpath = "//div[@class='checkout-pickup-selection__map']")
    private WebElement mapShops;

    @FindBy(xpath = "//div[contains(@class, 'checkout-step1__materials')]")
    private WebElement productsBlockContainer;

    @FindBy(xpath = "//h2[@class='checkout-available-material-list__title']")
    private WebElement productsBlockTitle;

    @FindBy(xpath = "//div[@class='materials-list__items']")
    private WebElement productsList;

    @FindBy(xpath = "//mvid-payment-button/button")
    private WebElement paymentButton;

    @FindBy(xpath = "//button[contains(@class, 'checkout-pickup-selection__reselection-button')]")
    private WebElement changeShopButton;

    @FindBy(xpath = "//div[contains(@class, 'checkout-step1__loading')]")
    private WebElement loadingBlock;

    public void loadingBlockShouldBeVisible(){
        loadingBlock.shouldBeVisible();
    }

    public void loadingBlockShouldNotBeVisible(){
        loadingBlock.shouldNotBeVisible();
    }

    public void changeShopButtonShouldBeVisible(){
        changeShopButton.shouldBeVisible();
    }

    public boolean isPaymentButtonDisplayed(){
        return paymentButton.isDisplayedAfterWaiting(3000);
    }

    public void clickPaymentButton(){
        paymentButton.click();
    }

    public boolean isProductsListDisplayed(){
        return productsList.isDisplayedAfterWaiting(2000);
    }

    public void clickProductsList(){
        productsList.click();
    }

    public boolean isProductsBlockTitleDisplayed(){
        return productsBlockTitle.isDisplayedAfterWaiting(3000);
    }

    public String getProductBlockTitleText(){
        return productsBlockTitle.getText();
    }

    public boolean isProductsBlockContainerDisplayed(){
        return productsBlockContainer.isDisplayedAfterWaiting(12000);
    }

    public boolean isMapShopsDisplayed(){
        return mapShops.isDisplayedAfterWaiting(6000);
    }

    public void clickMapShops(){
        mapShops.click();
    }

    public boolean isContainerDisplayed(){
        return container.isDisplayedAfterWaiting(15000);
    }

}
