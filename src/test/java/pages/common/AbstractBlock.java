package pages.common;

import org.openqa.selenium.support.FindBy;

import java.lang.reflect.Field;

public abstract class AbstractBlock {

    public AbstractBlock() {
        WebElement container = getClassWebElement(this);
        AbstractPage.initWebElements(AbstractPage.getWebElementsFields(this), this, container);
        setContainerField(container, this);
    }

    protected WebElement container;

    public boolean isDisplayed() {
        return container.isDisplayedAfterWaiting(7000);
    }

    public void shouldNoTBeVisible(){
        container.shouldNotBeVisible();
    }

    public void scrollToCenter() {
        container.scrollToCenter();
    }

    private void setContainerField(WebElement container, Object pageObject) {
        Field containerField = getDeclaredField("container", pageObject.getClass().getSuperclass());
        AbstractPage.setField(containerField, pageObject, container);
    }

    private WebElement getClassWebElement(Object pageObject) {
        FindBy findBy = pageObject.getClass().getAnnotation(FindBy.class);
        return WebElement.get(findBy.xpath());
    }

    private Field getDeclaredField(String fieldName, Class<?> clazz) {
        try {
            return clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

}
