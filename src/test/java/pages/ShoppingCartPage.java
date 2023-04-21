package pages;

import org.openqa.selenium.support.FindBy;
import pages.common.AbstractPage;
import pages.common.WebElement;
import pages.common.WebElementsCollection;

public class ShoppingCartPage extends AbstractPage {

    //mvid-cart-item[//a[contains(@class, 'cart-item__name')]]
    private final String XPATH_PRODUCT_CONTAINER = "//mvid-cart-item[//a[contains(@class, 'cart-item__name') and text()='%s']]";

    private final String XPATH_PRODUCT_QUANTITY = XPATH_PRODUCT_CONTAINER + "//span[@class='change-quantity__count']";

    private final String XPATH_PRODUCT_REMOVE_TITLE = XPATH_PRODUCT_CONTAINER + "//span[text()=' Удалить']";

    private final String XPATH_PRODUCT_PLUS_BUTTON = XPATH_PRODUCT_CONTAINER + "//button[contains(@class, 'change-quantity__button_plus')]";

    @FindBy(xpath = "//h1[contains(@class, 'cart__title') and normalize-space(text())='Корзина']")
    private WebElement title;

    @FindBy(xpath = "//button[contains(@class, 'cart-total__button-total')][div[normalize-space(text())='Перейти к оформлению']]")
    private WebElement checkoutButton;

    @FindBy(xpath = "//p[contains(@class, 'cart-total__item-total_title') and contains(text(), '₽')]")
    private WebElement finalPrice;

    @FindBy(xpath = "//p[contains(@class, 'cart-total__item') and contains(text(), 'товар')]")
    private WebElement quantityOfProducts;

    private WebElementsCollection productsFinalPrises = new WebElementsCollection("//ul[@class='cart-items']" +
            "//span[@class='price__main-value']");

    public void productQuantityShouldHaveValue(int value, String productName){
        WebElement.get(XPATH_PRODUCT_QUANTITY, productName).shouldHaveText(Integer.toString(value));
    }

    public boolean isProductPlusButtonActive(String productName){
        return !WebElement.get(XPATH_PRODUCT_PLUS_BUTTON, productName).hasClass("change-quantity__button_disabled");
    }

    public boolean isProductPlusButtonDisplayed(String productName){
        return WebElement.get(XPATH_PRODUCT_PLUS_BUTTON, productName).isDisplayedAfterWaiting(2000);
    }

    public void clickProductPlusButton(String productName){
        WebElement.get(XPATH_PRODUCT_PLUS_BUTTON, productName).click();
    }

    public boolean isProductRemoveTitleDisplayed(String productName){
        return WebElement.get(XPATH_PRODUCT_REMOVE_TITLE, productName).isDisplayedAfterWaiting(1500);
    }

    public void clickProductRemoveTitle(String productName){
        WebElement.get(XPATH_PRODUCT_REMOVE_TITLE, productName).click();
    }

    public boolean isQuantityProductDisplayed(String productName){
        return WebElement.get(XPATH_PRODUCT_QUANTITY, productName).isDisplayedAfterWaiting(2000);
    }

    public int getQuantityProduct(String productName){
        return Integer.parseInt(WebElement.get(XPATH_PRODUCT_QUANTITY, productName).getText());
    }

    public boolean isQuantityOfProductsDisplayed(){
        return quantityOfProducts.isDisplayedAfterWaiting(8000);
    }

    public String getQuantityOfProductsText(){
        return quantityOfProducts.getText();
    }

    public boolean isFinalPriceDisplayed(){
        return finalPrice.isDisplayedAfterWaiting(8000);
    }

    public String getFinalPrice(){
        return finalPrice.getText();
    }

    public int getSumProductsPrises(){
        int sum = 0;
        for(WebElement el:productsFinalPrises.getWebElementsList()){
            String strPrice = el.getText();
            strPrice = strPrice.replaceAll("\\D","");
            int price = Integer.parseInt(strPrice);
            sum+=price;
        }
        return sum;
    }

    public boolean isCheckoutButtonDisplayed(){
        return checkoutButton.isDisplayedAfterWaiting(8000);
    }

    public void clickCheckoutButton(){
        checkoutButton.click();
    }

    public boolean isProductDisplayed(String productName){
        return WebElement.get(XPATH_PRODUCT_CONTAINER, productName).isDisplayedAfterWaiting(8000);
    }

    public void productShouldNotBeDisplayed(String productName){
        WebElement.get(XPATH_PRODUCT_CONTAINER, productName).shouldNotBeVisible();
    }

    public boolean isTitleDisplayed(){
        return title.isDisplayedAfterWaiting(8000);
    }
}
