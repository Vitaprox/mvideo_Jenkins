package pages.MakingOrderPartOnePage;

import org.openqa.selenium.support.FindBy;
import pages.common.AbstractBlock;
import pages.common.WebElement;

@FindBy(xpath = "//div[contains(@class, 'modal-layout')][h3[contains(@class, 'modal-layout__title')]]")
public class ModalBasketBlock extends AbstractBlock {

    private String XPATH_PRODUCT = "//div[contains(@class, 'items-list-modal__item')][//span[text()=' %s ']]";

    private String XPATH_PRODUCT_COUNT = XPATH_PRODUCT + "//span[contains(@class,'items-list-modal__quantity')]";

    private String XPATH_PRODUCT_IMG = XPATH_PRODUCT + "//img";

    private String XPATH_PRODUCT_NAME = "//div[contains(@class, 'items-list-modal__item')]//span[text()=' %s ']";

    @FindBy(xpath = ".//h3[contains(@class, 'modal-layout__title')]")
    private WebElement title;

    @FindBy(xpath = ".//mvid-icon[@type='close']")
    private WebElement closeButton;

    public boolean isTitleDisplayed(){
        return title.isDisplayedAfterWaiting(1500);
    }

    public String getTitleText(){
        return title.getText();
    }

    public boolean isProductDisplayed(String productName){
        return WebElement.get(XPATH_PRODUCT, productName).isDisplayed();
    }

    public boolean isProductImgDisplayed(String productName){
        return WebElement.get(XPATH_PRODUCT_IMG, productName).isDisplayed();
    }

    public boolean isProductCountDisplayed(String productName){
        return WebElement.get(XPATH_PRODUCT_COUNT, productName).isDisplayed();
    }

    public String getProductCount(String productName){
        return WebElement.get(XPATH_PRODUCT_COUNT, productName).getText();
    }

    public boolean isProductNameDisplayed(String productName){
        return WebElement.get(XPATH_PRODUCT_NAME, productName).isDisplayed();
    }

    public boolean isCloseButtonDisplayed(){
        return closeButton.isDisplayedAfterWaiting(6000);
    }

    public void clickCloseButton(){
        closeButton.click();
    }
}
