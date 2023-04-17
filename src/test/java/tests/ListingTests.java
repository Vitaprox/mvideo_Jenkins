package tests;

import data.Properties;
import data.RetryAnalyzer;
import listeners.AllureListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import steps.Steps;

@Listeners(AllureListener.class)
public class ListingTests extends AbstractTest{

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void checkProductsSearch(){
        Steps.base.header.checkThatSearchInputDisplayed();
        Steps.base.header.setSearchInputValue("Apple");
        Steps.base.header.clickSearchButton();
        Steps.listing.scrollAllProducts();
        Steps.listing.checkThatStringIncludedInEachProductName("apple");
        Steps.listing.scrollAndClickProductAddToCartButton("Смартфон Apple iPhone 13 Pro Max 256GB Graphite");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void checkSortProducts(){
        Steps.base.header.checkThatSearchInputDisplayed();
        Steps.base.header.setSearchInputValue("Apple");
        Steps.base.header.clickSearchButton();
        Steps.listing.scrollAllProducts();
        Steps.listing.checkThatStringIncludedInEachProductName("apple");
        Steps.listing.scrollAndClickSortButton();
        Steps.listing.clickDropdownOption("Сначала дороже");
        Steps.listing.checkDescSortPrices();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void searchAppleProduct(){
        Steps.base.header.checkThatSearchInputDisplayed();
        Steps.base.header.setSearchInputValue("Apple");
        Steps.base.header.clickSearchButton();
        Steps.listing.searchAndClickProductOnAllPages("Смартфон Apple iPhone 14 128Gb Starlight");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void checkProductAttributes(){
        Steps.base.header.checkThatSearchInputDisplayed();
        Steps.base.header.setSearchInputValue("Apple");
        Steps.base.header.clickSearchButton();
        Steps.listing.scrollToProductName("Смартфон Apple iPhone 13 128GB Midnight");
        Steps.listing.checkProductPrice(64799, "Смартфон Apple iPhone 13 128GB Midnight");
        Steps.listing.scrollAndClickProductAddToWishlistButton("Смартфон Apple iPhone 13 128GB Midnight");
        Steps.listing.scrollAbdClickProductAddToComparisonButton("Смартфон Apple iPhone 13 128GB Midnight");
        Steps.listing.clickProductAddToCartButton("Смартфон Apple iPhone 13 128GB Midnight");
        Steps.base.header.checkHeaderCartButtonCountNumber(1);
        Steps.listing.clickProductImg("Смартфон Apple iPhone 13 128GB Midnight");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void checkThatProductWishlistSavedAfterRefreshListingPage(){
        Steps.base.header.checkIfHeaderWishlistButtonDisplayed(true);
        Steps.base.header.checkIfHeaderWishlistButtonActive(false);
        Steps.base.header.searchProductsUsingSearchInput("Apple");
        Steps.listing.checkThatProductAddToWishlistButtonDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.listing.checkIfProductAddToWishlistButtonActive(false, Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.listing.scrollAndClickProductAddToWishlistButton(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.base.header.checkIfHeaderWishlistButtonActive(true);
        Steps.base.header.checkHeaderWishlistButtonCountNumber(1);
        Steps.base.header.hoverWishlistButton();
        Steps.base.checkThatWishlistTooltipDisplayed();
        Steps.base.checkThatWishlistTooltipProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.base.refreshPage();
        Steps.listing.checkThatListingPageOpened();
        Steps.base.header.checkIfHeaderWishlistButtonActive(true);
        Steps.base.header.checkHeaderWishlistButtonCountNumber(1);
        Steps.base.header.hoverWishlistButton();
        Steps.base.checkThatWishlistTooltipDisplayed();
        Steps.base.checkThatWishlistTooltipProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void checkThatProductComparisonSavedAfterRefreshListingPage(){
        Steps.base.header.checkIfHeaderComparisonButtonDisplayed(true);
        Steps.base.header.checkIfHeaderComparisonButtonActive(false);
        Steps.base.header.searchProductsUsingSearchInput("Apple");
        Steps.listing.checkThatProductAddToComparisonButtonDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.listing.checkIfProductAddToComparisonButtonActive(false, Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.listing.scrollAbdClickProductAddToComparisonButton(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.base.header.checkIfHeaderComparisonButtonActive(true);
        Steps.base.header.checkHeaderComparisonButtonCountNumber(1);
        Steps.base.header.hoverComparisonButton();
        Steps.base.checkThatComparisonTooltipDisplayed();
        Steps.base.checkThatComparisonTooltipProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.base.refreshPage();
        Steps.listing.checkThatListingPageOpened();
        Steps.base.header.checkIfHeaderComparisonButtonActive(true);
        Steps.base.header.checkHeaderComparisonButtonCountNumber(1);
        Steps.base.header.hoverComparisonButton();
        Steps.base.checkThatComparisonTooltipDisplayed();
        Steps.base.checkThatComparisonTooltipProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void checkRemoveProductFromWishlist(){
        Steps.base.header.checkIfHeaderWishlistButtonDisplayed(true);
        Steps.base.header.checkIfHeaderWishlistButtonActive(false);
        Steps.base.header.searchProductsUsingSearchInput("Apple");
        Steps.listing.checkThatProductAddToWishlistButtonDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.listing.checkIfProductAddToWishlistButtonActive(false, Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.listing.scrollAndClickProductAddToWishlistButton(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.base.header.checkIfHeaderWishlistButtonActive(true);
        Steps.base.header.checkHeaderWishlistButtonCountNumber(1);
        Steps.base.header.hoverWishlistButton();
        Steps.base.checkThatWishlistTooltipDisplayed();
        Steps.base.checkThatWishlistTooltipProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.base.hoverProductContainerInWishlistTooltip(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.base.checkThatProductRemoveButtonDisplayedInWishlistTooltip(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.base.clickProductRemoveButtonInWishlistTooltip(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.base.header.checkHeaderWishlistButtonCountNumber(0);
        Steps.base.header.checkIfHeaderWishlistButtonActive(false);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void checkRemoveProductFromComparison(){
        Steps.base.header.checkIfHeaderComparisonButtonDisplayed(true);
        Steps.base.header.checkIfHeaderComparisonButtonActive(false);
        Steps.base.header.searchProductsUsingSearchInput("Apple");
        Steps.listing.checkThatProductAddToComparisonButtonDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.listing.checkIfProductAddToComparisonButtonActive(false, Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.listing.scrollAbdClickProductAddToComparisonButton(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.base.header.checkIfHeaderComparisonButtonActive(true);
        Steps.base.header.checkHeaderComparisonButtonCountNumber(1);
        Steps.base.header.hoverComparisonButton();
        Steps.base.checkThatComparisonTooltipDisplayed();
        Steps.base.checkThatComparisonTooltipProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.base.hoverProductContainerInComparisonTooltip(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.base.checkThatProductRemoveButtonDisplayedInComparisonTooltip(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.base.clickProductRemoveButtonInComparisonTooltip(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.base.header.checkHeaderComparisonButtonCountNumber(0);
        Steps.base.header.checkIfHeaderComparisonButtonActive(false);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void checkRemoveProductFromWishlistUsingAddButton(){
        Steps.base.header.checkIfHeaderWishlistButtonDisplayed(true);
        Steps.base.header.checkIfHeaderWishlistButtonActive(false);
        Steps.base.header.searchProductsUsingSearchInput("Apple");
        Steps.listing.checkThatProductAddToWishlistButtonDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.listing.checkIfProductAddToWishlistButtonActive(false, Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.listing.scrollAndClickProductAddToWishlistButton(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.base.header.checkIfHeaderWishlistButtonActive(true);
        Steps.base.header.checkHeaderWishlistButtonCountNumber(1);
        Steps.base.header.hoverWishlistButton();
        Steps.base.checkThatWishlistTooltipDisplayed();
        Steps.base.checkThatWishlistTooltipProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.listing.scrollAndClickProductAddToWishlistButton(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.base.header.checkHeaderWishlistButtonCountNumber(0);
        Steps.base.header.checkIfHeaderWishlistButtonActive(false);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void checkRemoveProductFromComparisonUsingAddButton(){
        Steps.base.header.checkIfHeaderComparisonButtonDisplayed(true);
        Steps.base.header.checkIfHeaderComparisonButtonActive(false);
        Steps.base.header.searchProductsUsingSearchInput("Apple");
        Steps.listing.checkThatProductAddToComparisonButtonDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.listing.checkIfProductAddToComparisonButtonActive(false, Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.listing.scrollAbdClickProductAddToComparisonButton(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.base.header.checkIfHeaderComparisonButtonActive(true);
        Steps.base.header.checkHeaderComparisonButtonCountNumber(1);
        Steps.base.header.hoverComparisonButton();
        Steps.base.checkThatComparisonTooltipDisplayed();
        Steps.base.checkThatComparisonTooltipProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.listing.scrollAbdClickProductAddToComparisonButton(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.base.header.checkHeaderComparisonButtonCountNumber(0);
        Steps.base.header.checkIfHeaderComparisonButtonActive(false);
    }

}
