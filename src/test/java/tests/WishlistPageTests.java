package tests;

import com.codeborne.selenide.Selenide;
import data.Properties;
import org.testng.annotations.Test;
import steps.Steps;

public class WishlistPageTests extends AbstractTest{

    @Test(groups = "bug")
    public void checkRemoveProductFromWishlistInWishlistPage(){
        Steps.base.header.checkIfHeaderWishlistButtonDisplayed(true);
        Steps.base.header.checkIfHeaderWishlistButtonActive(false);
        Steps.base.header.searchProductsUsingSearchInput("Apple");
        Steps.listing.checkThatProductAddToWishlistButtonDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.listing.checkIfProductAddToWishlistButtonActive(false, Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.listing.scrollAndClickProductAddToWishlistButton(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.base.header.checkIfHeaderWishlistButtonActive(true);

        Steps.base.header.clickHeaderWishlistButton();
        Steps.base.checkThatFixedHeaderWishlistButtonDisplayed(true);
        Steps.base.checkIfFixedHeaderWishlistButtonActive(true);

        Steps.wishlist.checkIfProductDisplayed(true, Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.wishlist.checkThatProductDeleteButtonDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());

        Steps.base.closeAllowNotification();
        Steps.base.closeWidgetWindows();
        Steps.wishlist.clickProductDeleteButton(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.base.fixedHeaderWishlistButtonShouldNotBeActive();
    }

    @Test(groups = "bug")
    public void checkWishlistBackButton(){
        Steps.base.header.checkIfHeaderWishlistButtonDisplayed(true);
        Steps.base.header.checkIfHeaderWishlistButtonActive(false);
        Steps.base.header.searchProductsUsingSearchInput("Apple");
        Steps.listing.checkThatProductAddToWishlistButtonDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.listing.checkIfProductAddToWishlistButtonActive(false, Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.listing.scrollAndClickProductAddToWishlistButton(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.base.header.checkIfHeaderWishlistButtonActive(true);
        Steps.base.header.clickHeaderWishlistButton();
        Steps.wishlist.checkIfProductDisplayed(true, Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());

        Steps.wishlist.checkThatBackButtonDisplayed();
        Steps.wishlist.clickBackButton();
        Steps.listing.checkThatListingPageOpened();
    }

}
