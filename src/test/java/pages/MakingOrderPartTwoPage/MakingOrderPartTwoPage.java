package pages.MakingOrderPartTwoPage;

import org.openqa.selenium.support.FindBy;
import pages.common.AbstractPage;
import pages.common.WebElement;

public class MakingOrderPartTwoPage extends AbstractPage {

    public static ModalBasketBlock modalBasket = new ModalBasketBlock();

    private final String XPATH_PRODUCT_LIST_XPATH = "//div[@class='materials-list__items']";

    @FindBy(xpath = "//h1[text()='Оформление заказа. Шаг 2 из 2']")
    private WebElement mainTitle;

    @FindBy(xpath = XPATH_PRODUCT_LIST_XPATH)
    private WebElement productsList;

    @FindBy(xpath = XPATH_PRODUCT_LIST_XPATH + "/div[contains(@class, 'materials-list__item')]")
    private WebElement firstProductInProductList;

    public boolean isFirstProductInProductListDisplayed(){
        return firstProductInProductList.isDisplayedAfterWaiting();
    }

    public void clickFirstProductInProductList(){
        firstProductInProductList.click();
    }


    public boolean isMainTitleDisplayed(){
        return mainTitle.isDisplayedAfterWaiting(9000);
    }

    public boolean isProductsListDisplayed(){
        return productsList.isDisplayedAfterWaiting(2000);
    }

    public void clickProductsList(){
        productsList.click();
    }
}
