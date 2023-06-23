package pages.homePage;

import org.openqa.selenium.support.FindBy;
import pages.common.AbstractBlock;
import pages.common.WebElement;

@FindBy(xpath = "//mvid-simple-product-collection[h2[text()='Хиты продаж']]")
public class SalesHitsBlock extends AbstractBlock {

    @FindBy(xpath = ".//h2")
    private WebElement title;

    @FindBy(xpath = ".//button[contains(@class, 'mv-main-button--primary')]")
    private WebElement productBuyButton;

    public void clickProductBuyButton(){
        productBuyButton.click();
    }

    public boolean isTitleDisplayed(){
        return title.isDisplayedAfterWaiting(3000);
    }



}
