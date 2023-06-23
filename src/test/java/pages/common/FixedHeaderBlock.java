package pages.common;

import org.openqa.selenium.support.FindBy;

@FindBy(xpath = "//div[@class='header_fixed ']")
public class FixedHeaderBlock extends AbstractBlock{

    @FindBy(xpath = ".//div[@data-init='comparisonManager']")
    private WebElement comparisonButton;

    @FindBy(xpath = ".//div[@data-init='change-wishlist-items']")
    private WebElement wishlistButton;


    public boolean isComparisonButtonActive(){
        return comparisonButton.hasNotClassAfterWaiting("header-icon_disabled");
    }

    public boolean isComparisonButtonDisplayed(){
        return comparisonButton.isDisplayedAfterWaiting(7000);
    }

    public void comparisonButtonShouldNotActive(){
        comparisonButton.shouldHaveClass("header-icon_disabled");
    }


    public boolean isWishlistButtonActive(){
        return wishlistButton.hasNotClassAfterWaiting("header-icon_disabled");
    }

    public boolean isWishlistButtonDisplayed(){
        return wishlistButton.isDisplayedAfterWaiting(13000);
    }

    public void wishlistButtonShouldNotActive(){
        wishlistButton.shouldHaveClass("header-icon_disabled");
    }

}
