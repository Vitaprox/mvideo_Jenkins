package pages.common;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$$x;

public class WebElementsCollection {

    private ElementsCollection selenideElements;

    public WebElementsCollection(String xpath){
        this.selenideElements = $$x(xpath);
    }

    public WebElementsCollection(By by){
        this.selenideElements = $$(by);
    }

    public WebElement get(int index) {
        return WebElement.get(selenideElements.get(index));
    }

    public int size() {
        return selenideElements.size();
    }

    public List<WebElement> getWebElementsList(){
        List<WebElement> webElements = new ArrayList<>();
        for (SelenideElement selenideElement : selenideElements) {
            webElements.add(WebElement.get(selenideElement));
        }
        return webElements;
    }

}
