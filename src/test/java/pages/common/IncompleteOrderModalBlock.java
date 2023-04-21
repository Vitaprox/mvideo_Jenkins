package pages.common;

import org.openqa.selenium.support.FindBy;

@FindBy(xpath = "//div[@class='checkout-modal'][h3[text()='У вас есть незавершённый заказ']]")
public class IncompleteOrderModalBlock extends AbstractBlock{

    @FindBy(xpath = ".//button[@title='Вернуть товары в корзину']")
    private WebElement returnProductsButton;

    @FindBy(xpath = ".//button[@title='Продолжить']")
    private WebElement continueButton;

    public boolean isContinueButtonDisplayed(){
        return continueButton.isDisplayedAfterWaiting(3000);
    }

    public void clickContinueButton(){
        continueButton.click();
    }

    public boolean isReturnProductsButtonDisplayed(){
        return returnProductsButton.isDisplayedAfterWaiting(3000);
    }

    public void clickReturnProductsButton(){
        returnProductsButton.click();
    }

}
