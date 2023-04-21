package pages.common;

import org.openqa.selenium.support.FindBy;

@FindBy(xpath = "//mvid-header-icon-tooltip/div[contains(@class, 'tooltip__item')][.//button[text()=' Сравнить товары ']]")
public class ComparisonTooltipBlock extends AbstractBlock{

    private String XPATH_PRODUCT_CONTAINER = "//div[contains(@class, 'item-wrapper')][.//a[text()='%s']]";

    private String XPATH_PRODUCT_NAME = "//a[@title='Перейти на страницу товара' and text()='%s']";

    private String XPATH_PRODUCT_IMG = XPATH_PRODUCT_CONTAINER + "//a[contains(@class, 'img-container')]";

    private String XPATH_PRODUCT_REMOVE_BUTTON = XPATH_PRODUCT_CONTAINER + "//div[@title='Удалить товары']";

    public boolean isProductRemoveButtonDisplayed(String productName){
        return WebElement.get(XPATH_PRODUCT_REMOVE_BUTTON, productName).isDisplayedAfterWaiting(2500);
    }

    public void clickProductRemoveButton(String productName){
        WebElement.get(XPATH_PRODUCT_REMOVE_BUTTON, productName).click();
    }

    public void hoverProductContainer(String productName){
        WebElement.get(XPATH_PRODUCT_CONTAINER, productName).hover();
    }

    public boolean isProductContainerDisplayed(String productName){
        return WebElement.get(XPATH_PRODUCT_CONTAINER, productName).isDisplayedAfterWaiting(2000);
    }

    public void productContainerShouldNotBeVisible(String productName){
        WebElement.get(XPATH_PRODUCT_CONTAINER, productName).shouldNotBeVisible();
    }

    public boolean isProductNameDisplayed(String productName){
        return WebElement.get(XPATH_PRODUCT_NAME, productName).isDisplayedAfterWaiting(3000);
    }

    public boolean isProductImgDisplayed(String productName){
        return WebElement.get(XPATH_PRODUCT_IMG, productName).isDisplayedAfterWaiting(3000);
    }
}
