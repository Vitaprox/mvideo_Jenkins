package pages.common;

import org.openqa.selenium.support.FindBy;

@FindBy(xpath = "//section[contains(@class, 'widget')]")
public class AllowNotificationBlock extends AbstractBlock{

    @FindBy(xpath = ".//a[@class='close']")
    private WebElement closeButton;

    public void clickCloseButton(){
        closeButton.click();
    }

}
