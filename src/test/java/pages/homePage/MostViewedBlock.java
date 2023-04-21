package pages.homePage;

import org.openqa.selenium.support.FindBy;
import pages.common.AbstractBlock;
import pages.common.WebElement;
import pages.common.WebElementsCollection;

import java.util.List;

@FindBy(xpath = "//mvid-simple-product-collection[h2[text()='Самые просматриваемые']]")
public class MostViewedBlock extends AbstractBlock {

    private final String XPATH_CONTAINER = "//mvid-simple-product-collection[h2[text()='Самые просматриваемые']]";

    private final String XPATH_PRODUCT_CONTAINER = "";

    @FindBy(xpath = ".//div[@class='product-mini-card__image ng-star-inserted']")
    private WebElement productImg;

    private WebElementsCollection addInCartButtons = new WebElementsCollection("//mvid-simple-product-collection" +
            "[h2[text()='Самые просматриваемые']]//button[@title='Добавить в корзину']");

    public void clickProductAddInCartButton(int... arguments){
        List<WebElement> buttons = addInCartButtons.getWebElementsList();
        for (int index:arguments){
            buttons.get(--index).click().shouldHaveClass("mv-main-button--outline");
        }
    }

    public void clickProductImg() {
        productImg.click();
    }

}
