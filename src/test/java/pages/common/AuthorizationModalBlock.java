package pages.common;

import org.openqa.selenium.support.FindBy;

@FindBy(xpath = "//div[contains(@class, 'modal-layout--without-title')][//h2[normalize-space(text())='Вход или регистрация']]")
public class AuthorizationModalBlock extends AbstractBlock{

    @FindBy(xpath = ".//button[contains(@class, 'login-form__button--skip')]")
    private WebElement skipButton;

    public boolean isSkipButtonDisplayed(){
        return skipButton.isDisplayedAfterWaiting(3000);
    }

    public void clickSkipButton(){
        skipButton.click();
    }

}
