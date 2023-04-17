package pages.common;

import org.openqa.selenium.support.FindBy;

@FindBy(xpath = "//div[@class='layout__header']")
public class HeaderBlock extends AbstractBlock{

    private final String XPATH_CART_BUTTON = ".//mvid-header-icon[@title='Корзина']";

    private final String XPATH_WISHLIST_BUTTON = ".//mvid-header-icon[@title='Избранное']";

    private final String XPATH_COMPARISON_BUTTON = ".//mvid-header-icon[@title='Сравнение']";

    @FindBy(xpath = ".//button[contains(@class, 'secondary-header__back-button')]")
    private WebElement headerBackButton;

    @FindBy(xpath = ".//a[contains(@class, 'logo')]/img")
    private WebElement logo;

    @FindBy(xpath = ".//mvid-header-icon[.//p[text()='Статус заказа']]")
    private WebElement orderStatusButton;

    @FindBy(xpath = ".//mvid-header-icon[.//mvid-profile-tooltip]")
    private WebElement profileButton;

    @FindBy(xpath = XPATH_COMPARISON_BUTTON)
    private WebElement comparisonButton;

    @FindBy(xpath = XPATH_COMPARISON_BUTTON + "//mvid-bubble")
    private WebElement comparisonButtonCount;

    @FindBy(xpath = XPATH_WISHLIST_BUTTON)
    private WebElement wishlistButton;

    @FindBy(xpath = XPATH_WISHLIST_BUTTON + "//mvid-bubble")
    private WebElement wishlistButtonCount;

    @FindBy(xpath = XPATH_CART_BUTTON)
    private WebElement cartButton;

    @FindBy(xpath = XPATH_CART_BUTTON + "//mvid-bubble")
    private WebElement cartButtonCount;

    @FindBy(xpath = ".//mvid-input//input[@class='input__field']")
    private WebElement searchInput;

    @FindBy(xpath = ".//div[contains(@class, 'search-icon-wrap')]")
    private WebElement searchButton;

    public void clickWishlistButton(){
        wishlistButton.click();
    }

    public boolean isHeaderBackButtonDisplayed(){
        return headerBackButton.isDisplayedAfterWaiting(3000);
    }

    public void clickHeaderBackButton(){
        headerBackButton.click();
    }

    public void hoverCartButton(){
        cartButton.hover();
    }

    public void hoverWishlistButton(){
        wishlistButton.hover();
    }

    public void hoverComparisonButton(){
        comparisonButton.hover();
    }

    public void clickSearchButton(){
        searchButton.click();
    }

    public boolean isSearchInputDisplayed(){
        return searchInput.isDisplayedAfterWaiting(7000);
    }

    public void setSearchInputValue(String text){
        searchInput.setValue(text);
    }

    public void clickCartButton(){
        cartButton.click();
    }

    public void cartButtonCountShouldNotBeVisible(){
        cartButtonCount.shouldNotBeVisible();
    }

    public void cartButtonCountShouldBeVisible(){
        cartButtonCount.shouldBeVisible();
    }

    public int getCartButtonCountNumber(){
        return Integer.parseInt(cartButtonCount.getText());
    }

    public boolean isWishlistButtonCountDisplayed(){
        return wishlistButtonCount.isDisplayedAfterWaiting(2000);
    }

    public int getWishlistButtonCountNumber(){
        return Integer.parseInt(wishlistButtonCount.getText());
    }

    public void wishlistButtonCountShouldNotBeVisible(){
        wishlistButtonCount.shouldNotBeVisible();
    }

    public int getComparisonButtonCountNumber(){
        return Integer.parseInt(comparisonButtonCount.getText());
    }

    public void comparisonButtonCountShouldNotBeVisible(){
        comparisonButtonCount.shouldNotBeVisible();
    }

    public boolean isOrderStatusButtonActive(){
        return orderStatusButton.hasNotClassAfterWaiting("disabled");
    }

    public boolean isProfileButtonActive(){
        return profileButton.hasNotClassAfterWaiting("disabled");
    }

    public boolean isComparisonButtonActive(){
        return comparisonButton.hasNotClassAfterWaiting("disabled");
    }

    public boolean isWishlistButtonActive(){
        return wishlistButton.hasNotClassAfterWaiting("disabled");
    }

    public boolean isCartButtonActive(){
        return cartButton.hasNotClassAfterWaiting("disabled");
    }

    public boolean isOrderStatusButtonDisplayed(){
        return orderStatusButton.isDisplayedAfterWaiting(750);
    }

    public boolean isProfileButtonDisplayed(){
        return profileButton.isDisplayedAfterWaiting(750);
    }

    public boolean isComparisonButtonDisplayed(){
        return comparisonButton.isDisplayedAfterWaiting(750);
    }

    public boolean isWishlistButtonDisplayed(){
        return wishlistButton.isDisplayedAfterWaiting(750);
    }

    public boolean isCartButtonDisplayed(){
        return cartButton.isDisplayedAfterWaiting(750);
    }

    public boolean isLogoDisplayed(){
        return logo.isDisplayedAfterWaiting(12000);
    }
}
