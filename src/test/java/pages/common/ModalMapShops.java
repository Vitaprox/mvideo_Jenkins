package pages.common;

import org.openqa.selenium.support.FindBy;

@FindBy(xpath = "//mvid-pickup-selector-modal/div[contains(@class, 'maps-pickup-selector-modal')]")
public class ModalMapShops extends AbstractBlock{

    final String XPATH_SHOPS_LIST_CONTAINER = "//div[@class='autocomplete-field__items-container']";

    final String XPATH_SHOP_FROM_LIST_WITH_NAME = "//tr[contains(@class, 'maps-pickup-list__row')][.//p[text()='%s']]";

    @FindBy(id = "1")
    private WebElement addressInput;

    @FindBy(xpath = ".//mvid-icon[@type='search']")
    private WebElement searchIcon;

    @FindBy(xpath = ".//button[contains(@class, 'checkout-tabs__button') and normalize-space(text())='Список']")
    private WebElement listButton;

    @FindBy(xpath = ".//mvid-button[@label='Заберу отсюда']")
    private WebElement selectShopButton;

    public boolean isSelectShopButtonDisplayed(){
        return selectShopButton.isDisplayedAfterWaiting();
    }

    public void clickSelectShopButton(){
        selectShopButton.click();
    }

    public boolean isShopRowDisplayed(String shopName){
        return WebElement.get(XPATH_SHOP_FROM_LIST_WITH_NAME, shopName).isDisplayedAfterWaiting();
    }

    public void clickShopRow(String shopName){
        WebElement.get(XPATH_SHOP_FROM_LIST_WITH_NAME, shopName).click();
    }

    public boolean isListButtonDisplayed(){
        return listButton.isDisplayedAfterWaiting();
    }

    public void clickListButton(){
        listButton.click();
    }

    public boolean isAddressInputDisplayed(){
        return addressInput.isDisplayedAfterWaiting();
    }

    public void setAddressInputValue(String text){
        addressInput.setValue(text);
    }

    public void clickAddressInputValue(){
        addressInput.click();
    }

    public boolean isSearchIconDisplayed(){
        return searchIcon.isDisplayedAfterWaiting();
    }

    public void clickSearchIcon(){
        searchIcon.click();
    }

    //Объяединить в степах в одну команду (создать степы)

}
