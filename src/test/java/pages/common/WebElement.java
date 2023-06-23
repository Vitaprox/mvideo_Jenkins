package pages.common;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class WebElement {

    private final String AFTER = "::after";

    private final String BEFORE = "::before";

    private SelenideElement element;

    private WebElement() {
    }

    private WebElement(SelenideElement element) {
        this.element = element;
    }

    public String getOwnText() {
        return normalizeSpaceSymbols(element.getOwnText());
    }

    public boolean hasAttribute(String attributeName) {
        return element.has(attribute(attributeName));
    }

    public WebElement shouldHaveCss(String propertyName, String propertyValue) {
        element.shouldHave(cssValue(propertyName, propertyValue));
        return this;
    }

    public boolean hasCssAfterWaiting(String propertyName, String propertyValue){
        try {
            element.shouldHave(cssValue(propertyName,propertyValue));
            return true;
        } catch (com.codeborne.selenide.ex.ElementNotFound | com.codeborne.selenide.ex.ElementShould e) {
            return false;
        }
    }

    public WebElement shouldNotHaveCss(String propertyName, String propertyValue) {
        element.shouldNotHave(cssValue(propertyName, propertyValue));
        return this;
    }

    public WebElement shouldHaveAttr(String attrName) {
        element.shouldHave(attribute(attrName));
        return this;
    }

    public WebElement shouldNotHaveAttr(String attrName) {
        element.shouldNotHave(attribute(attrName));
        return this;
    }

    public boolean hasSize() {
        boolean flag = false;
        Dimension size = element.getSize();
        if (size.width != 0 && size.height != 0) flag = true;
        return flag;
    }

    public String getCssValue(String css) {
        return element.getCssValue(css);
    }

    public int getAllNumbersFromText() {
        return Integer.parseInt(element.getText().replaceAll("[^0-9]", ""));
    }

    public String val() {
        return element.val();
    }

    public Dimension getSize() {
        return element.getSize();
    }

    public void shouldHaveClass(String className) {
        element.shouldHave(cssClass(className));
    }

    public void shouldNotBeExist(){
        element.shouldNotBe(exist);
    }

    public void shouldBeExist(){
        element.shouldBe(exist);
    }

    public void shouldNotHaveClass(String className) {
        element.shouldNotHave(cssClass(className));
    }

    public WebElement find(String cssSelector) {
        return new WebElement(element.find(cssSelector));
    }

    public WebElement find(By by) {
        return new WebElement(element.find(by));
    }

    public void pressEnter() {
        element.pressEnter();
    }

    public String attr(String text) {
        return element.attr(text);
    }

    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    public WebElement hover() {
        element.hover();
        return this;
    }

    public boolean hasClass(String className) {
        return element.has(cssClass(className));
    }

    public WebElement setValue(String text) {
        element.setValue(text);
        return this;
    }

    public WebElement scrollToCenter() {
        element.scrollIntoView("{block: 'center'}");
        return this;
    }

    @CanIgnoreReturnValue
    public WebElement click() {
        element.click();
        return this;
    }

    public WebElement shouldBeVisible() {
        element.shouldBe(Condition.visible);
        return this;
    }

    public WebElement shouldBeVisible(int waitingSeconds) {
        element.shouldBe(Condition.visible, Duration.ofSeconds(waitingSeconds));
        return this;
    }

    public WebElement shouldNotBeVisible() {
        element.shouldNotBe(Condition.visible, Duration.ofMillis(14000));
        return this;
    }

    public String getText() {
        return normalizeSpaceSymbols(element.getText());
    }

    public static WebElement get(String xpath, Object... arguments) {
        WebElement result = new WebElement();
        result.element = $x(String.format(xpath, arguments));
        return result;
    }

    public static WebElement get(By by) {
        WebElement result = new WebElement();
        result.element = $(by);
        return result;
    }

    public static WebElement get(SelenideElement selenideElement) {
        WebElement result = new WebElement();
        result.element = selenideElement;
        return result;
    }

    public void afterShouldBeVisible() {
        element.shouldBe(pseudo(AFTER, "display", "block"));
    }

    public boolean isAfterDisplayed() {
        return isPseudoDisplayed(AFTER);
    }

    public boolean isBeforeDisplayed() {
        return isPseudoDisplayed(BEFORE);
    }

    private boolean isPseudoDisplayed(String pseudoName) {
        return !element.pseudo(pseudoName, "display").equals("none");
    }

    public String getAfterText() {
        return getPseudoText(AFTER);
    }

    public String getBeforeText() {
        return getPseudoText(BEFORE);
    }

    public WebElement attrShouldHaveValue(String attr, String value) {
        element.shouldHave(attribute(attr, value));
        return this;
    }

    public boolean attrHasValueAfterWaiting(String attr, String value){
        try {
            element.shouldHave(attribute(attr, value), Duration.ofSeconds(2));
            return true;
        } catch (com.codeborne.selenide.ex.ElementNotFound | com.codeborne.selenide.ex.ElementShould e) {
            return false;
        }
    }

    public WebElement attrShouldNotHaveValue(String attr, String value) {
        element.shouldNotHave(attribute(attr, value));
        return this;
    }

    public boolean isDisplayedAfterWaiting(int millis) {
        try {
            element.shouldBe(visible, Duration.ofMillis(millis));
            return true;
        } catch (com.codeborne.selenide.ex.ElementNotFound | com.codeborne.selenide.ex.ElementShould e) {
            return false;
        }
    }

    public boolean isDisplayedAfterWaiting() {
        try {
            element.shouldBe(visible);
            return true;
        } catch (com.codeborne.selenide.ex.ElementNotFound | com.codeborne.selenide.ex.ElementShould e) {
            return false;
        }
    }

    public boolean isNotDisplayedAfterWaiting() {
        try {
            element.shouldNotBe(visible);
            return true;
        } catch (com.codeborne.selenide.ex.ElementNotFound | com.codeborne.selenide.ex.ElementShouldNot e) {
            return false;
        }
    }

    public boolean hasClassAfterWaiting(String nameClass) {
        try {
            element.shouldHave(cssClass(nameClass));
            return true;
        } catch (com.codeborne.selenide.ex.ElementNotFound | com.codeborne.selenide.ex.ElementShould e) {
            return false;
        }
    }

    public boolean hasNotClassAfterWaiting(String nameClass) {
        try {
            element.shouldNotHave(cssClass(nameClass),Duration.ofMillis(750));
            return true;
        } catch (com.codeborne.selenide.ex.ElementNotFound | com.codeborne.selenide.ex.ElementShouldNot e) {
            return false;
        }
    }

    public boolean hasTextAfterWaiting(String text) {
        try {
            element.shouldHave(text(text));
            return true;
        } catch (com.codeborne.selenide.ex.ElementNotFound | com.codeborne.selenide.ex.ElementShould e) {
            return false;
        }
    }

    public void shouldNotExist(){
        element.shouldNotBe(exist);
    }

    public WebElement shouldHaveText(String text) {
        element.shouldHave(text(text));
        return this;
    }

    private String getPseudoText(String pseudoName) {
        return element.pseudo(pseudoName).replaceAll("^\"|\"$", "");
    }

    private String normalizeSpaceSymbols(String text) {
        return text.replaceAll(" ", " ");
    }
}
