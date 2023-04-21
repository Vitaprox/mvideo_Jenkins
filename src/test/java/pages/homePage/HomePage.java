package pages.homePage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
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
            el.scrollIntoView("{block: 'center'}");
            Selenide.sleep(100);
//            if(!el.find(By.xpath("./*")).isDisplayed()){
//                System.out.println(el);
//            }
//            el.find(By.xpath("./*")).shouldBe(Condition.visible);
        }
    }

}
