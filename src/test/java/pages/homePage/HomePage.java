package pages.homePage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import pages.common.AbstractPage;
import pages.common.WebElement;

import static com.codeborne.selenide.Selenide.$$x;

public class HomePage extends AbstractPage {

    public MostViewedBlock mostViewedBlock = new MostViewedBlock();
    public DayProductsBlock dayProductsBlock = new DayProductsBlock();

    public SalesHitsBlock salesHitsBlock = new SalesHitsBlock();

    @FindBy(tagName = "mvid-promotions-block")
    private WebElement promotionsBlock;

    @FindBy(xpath = "//h2[text()='Хиты продаж']")
    private WebElement headerBestSellers;

    private ElementsCollection sectionBlocks = $$x("//div[contains(@class, 'mp-wrapper')]/*");

    public boolean isPromotionsBlockDisplayed(){
        return promotionsBlock.isDisplayedAfterWaiting(40000);
    }

    public void scrollSectionBlocks(){
        for(SelenideElement el:sectionBlocks){
            el.scrollTo();
        }
    }

}
