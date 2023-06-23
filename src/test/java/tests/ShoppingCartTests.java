package tests;

import com.codeborne.selenide.Selenide;
import data.Properties;
import data.RetryAnalyzer;
import io.qameta.allure.Description;
import listeners.AllureListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import steps.Steps;

@Listeners(AllureListener.class)
public class ShoppingCartTests extends AbstractTest{

    @Test(groups = "bug")//(retryAnalyzer = RetryAnalyzer.class)
    @Description("Проверяем переход на страницу корзины")
    public void checkTransitionToShoppingCart(){
        Steps.homePage.checkThatDayProductBlockDisplayed();
        Steps.homePage.clickDayProductsBuyButton();
        Steps.base.header.checkIfHeaderCartButtonActive(true);
        Steps.base.header.checkHeaderCartButtonCountNumber(1);
        Steps.base.header.clickHeaderCartButton();
        Steps.shoppingCart.checkQuantityOfProducts(1);
    }

    @Test//(retryAnalyzer = RetryAnalyzer.class)
    @Description("Проверяем добавление нескольких товаров в корзину")
    public void checkMultipleProductsHaveBeenAddedToCart(){
        Steps.homePage.scrollSectionBlocks();
        Steps.homePage.checkIfMostViewedBlockDisplayed(true);
        Steps.homePage.scrollToMostView();
        Steps.homePage.clickProductAddInCartButtonInMostView(1, 2, 3);
        Steps.base.header.clickHeaderCartButton();
        //Steps.shoppingCart.checkFinalPrice(94998);
    }

//    @Test(retryAnalyzer = RetryAnalyzer.class)
//    public void checkNumberOfProductInCartAfterRemoveInTooltip(){
//        Steps.base.header.searchProductsUsingSearchInput("Apple");
//        Steps.listing.clickProductAddToCartButton(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.base.header.hoverCartButtonInHeader();
//        Steps.base.checkThatProductCartTooltipDisplayed();
//        Steps.base.checkThatCartTooltipProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.base.hoverProductContainerInCartTooltip(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.base.checkThatProductRemoveButtonDisplayedInCartTooltip(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.base.clickProductRemoveButtonInCartTooltip(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.listing.clickProductAddToCartButton(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.base.header.hoverCartButtonInHeader();
//        Steps.base.checkThatCartTooltipProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.base.header.clickHeaderCartButton();
//        Steps.shoppingCart.checkThatProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkProductCount(1, Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//    }
//
//    @Test(retryAnalyzer = RetryAnalyzer.class)
//    public void checkNumberOfProductInCartAfterRemoveInShoppingPage(){
//        Steps.base.header.searchProductsUsingSearchInput("Apple");
//        Steps.listing.clickProductAddToCartButton(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.base.header.hoverCartButtonInHeader();
//        Steps.base.checkThatProductCartTooltipDisplayed();
//        Steps.base.checkThatCartTooltipProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.base.header.clickHeaderCartButton();
//        Steps.shoppingCart.checkThatProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkProductCount(1, Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkThatProductRemoveTitleDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.removeProduct(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.base.header.checkThatHeaderBackButtonDisplayed();
//        Steps.base.header.clickHeaderBackButton();
//        Steps.homePage.checkThatHomePageOpen();
//        Steps.base.header.searchProductsUsingSearchInput("Apple");
//        Steps.listing.clickProductAddToCartButton(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.base.header.hoverCartButtonInHeader();
//        Steps.base.checkThatCartTooltipProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.base.header.clickHeaderCartButton();
//        Steps.shoppingCart.checkThatProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkProductCount(1, Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//    }
//
//    @Test(retryAnalyzer = RetryAnalyzer.class)
//    public void checkNumberOfProductMoreOneInCartAfterRemoveInShoppingPage(){
//        Steps.base.header.searchProductsUsingSearchInput("Apple");
//        Steps.listing.clickProductAddToCartButton(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.base.header.hoverCartButtonInHeader();
//        Steps.base.checkThatProductCartTooltipDisplayed();
//        Steps.base.checkThatCartTooltipProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.base.header.clickHeaderCartButton();
//        Steps.shoppingCart.checkThatProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkProductCount(1, Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkThatProductPlusButtonDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkIfProductPlusButtonActive(true, Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.clickProductPlusButton(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkProductCount(2, Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkThatProductRemoveTitleDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.removeProduct(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.base.header.checkThatHeaderBackButtonDisplayed();
//        Steps.base.header.clickHeaderBackButton();
//        Steps.homePage.checkThatHomePageOpen();
//        Steps.base.header.searchProductsUsingSearchInput("Apple");
//        Steps.listing.clickProductAddToCartButton(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.base.header.hoverCartButtonInHeader();
//        Steps.base.checkThatCartTooltipProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.base.header.clickHeaderCartButton();
//        Steps.shoppingCart.checkThatProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkProductCount(1, Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//    }
//
//    @Test(retryAnalyzer = RetryAnalyzer.class)
//    public void checkThatProductCartSavedAfterListingPageRefresh(){
//        Steps.base.header.searchProductsUsingSearchInput("Apple");
//        Steps.listing.clickProductAddToCartButton(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.listing.clickProductAddToCartButton(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
//        Steps.base.header.hoverCartButtonInHeader();
//        Steps.base.checkThatProductCartTooltipDisplayed();
//        Steps.base.checkThatCartTooltipProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.base.checkThatCartTooltipProductDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
//        Steps.base.refreshPage();
//        Steps.listing.checkThatListingPageOpened();
//        Steps.base.header.hoverCartButtonInHeader();
//        Steps.base.checkThatCartTooltipProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.base.checkThatCartTooltipProductDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
//    }
//
//    @Test(retryAnalyzer = RetryAnalyzer.class)
//    public void checkThatProductCartSavedAfterShoppingCartPageRefresh(){
//        Steps.base.header.searchProductsUsingSearchInput("Apple");
//        Steps.listing.clickProductAddToCartButton(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.listing.clickProductAddToCartButton(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
//        Steps.base.header.hoverCartButtonInHeader();
//        Steps.base.checkThatProductCartTooltipDisplayed();
//        Steps.base.checkThatCartTooltipProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.base.checkThatCartTooltipProductDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
//        Steps.base.header.clickHeaderCartButton();
//        Steps.shoppingCart.checkThatProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkProductCount(1, Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkThatProductDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkProductCount(1, Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
//        Steps.base.refreshPage();
//        Steps.shoppingCart.checkThatShoppingCartPageOpen();
//        Steps.shoppingCart.checkThatProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkProductCount(1, Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkThatProductDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkProductCount(1, Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
//    }
//
//    @Test(retryAnalyzer = RetryAnalyzer.class)
//    public void checkThatNumberOfProductInCartSavedAfterShoppingCartPageRefresh(){
//        Steps.base.header.searchProductsUsingSearchInput("Apple");
//        Steps.listing.clickProductAddToCartButton(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.base.header.hoverCartButtonInHeader();
//        Steps.base.checkThatProductCartTooltipDisplayed();
//        Steps.base.checkThatCartTooltipProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.base.header.clickHeaderCartButton();
//        Steps.shoppingCart.checkThatProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkProductCount(1, Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkThatProductPlusButtonDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkIfProductPlusButtonActive(true, Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.clickProductPlusButton(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkProductCount(2, Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.base.refreshPage();
//        Steps.shoppingCart.checkThatShoppingCartPageOpen();
//        Steps.shoppingCart.checkThatProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkProductCount(2, Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//    }
//
//    @Test(retryAnalyzer = RetryAnalyzer.class)
//    public void checkSaveProductsInCartAfterCancellationOrderWithHeaderBackButton(){
//        Steps.base.header.searchProductsUsingSearchInput("Apple");
//        Steps.listing.clickProductAddToCartButton(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.base.header.checkIfHeaderCartButtonActive(true);
//        Steps.base.header.checkHeaderCartButtonCountNumber(1);
//        Steps.listing.clickProductAddToCartButton(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
//        Steps.base.header.checkHeaderCartButtonCountNumber(2);
//        Steps.base.header.clickHeaderCartButton();
//        Steps.shoppingCart.checkThatProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkThatProductDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkProductCount(1, Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkIfCheckoutButtonDisplayed(true);
//        Steps.shoppingCart.clickCheckoutButton();
//        Steps.base.checkIfModalAuthorizationSkipButtonDisplayed(true);
//        Steps.base.clickModalAuthorizationSkipButton();
//        Steps.makingOrderPartOne.checkThatProductsBlockDisplayed();
//        Steps.makingOrderPartOne.checkThatProductsBlockTitleDisplayed();
//        Steps.makingOrderPartOne.checkProductsBlockTitleText(2);
//        Steps.base.header.checkThatHeaderBackButtonDisplayed();
//        Steps.base.header.clickHeaderBackButton();
//        Steps.shoppingCart.checkThatShoppingCartPageOpen();
//        Steps.shoppingCart.checkThatProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkThatProductDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
//    }
//
//    @Test(retryAnalyzer = RetryAnalyzer.class)
//    public void checkSaveProductsInCartAfterCancellationOrderWithBrowserBackButton(){
//        Steps.base.header.searchProductsUsingSearchInput("Apple");
//        Steps.listing.clickProductAddToCartButton(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.base.header.checkIfHeaderCartButtonActive(true);
//        Steps.base.header.checkHeaderCartButtonCountNumber(1);
//        Steps.listing.clickProductAddToCartButton(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
//        Steps.base.header.checkHeaderCartButtonCountNumber(2);
//        Steps.base.header.clickHeaderCartButton();
//        Steps.shoppingCart.checkThatProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkThatProductDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkProductCount(1, Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkIfCheckoutButtonDisplayed(true);
//        Steps.shoppingCart.clickCheckoutButton();
//        Steps.base.checkIfModalAuthorizationSkipButtonDisplayed(true);
//        Steps.base.clickModalAuthorizationSkipButton();
//        Steps.makingOrderPartOne.checkThatProductsBlockDisplayed();
//        Steps.makingOrderPartOne.checkThatProductsBlockTitleDisplayed();
//        Steps.makingOrderPartOne.checkProductsBlockTitleText(2);
//        Steps.base.header.checkThatHeaderBackButtonDisplayed();
//        Steps.base.clickBrowserBackButton();
//        Steps.shoppingCart.checkThatShoppingCartPageOpen();
//        Steps.base.checkIfIncompleteOrderModalBlockDisplayed(true);
//        Steps.base.checkThatReturnProductsButtonDisplayed();
//        Steps.base.clickReturnProductsButton();
//        Steps.shoppingCart.checkThatProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkThatProductDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
//    }
//
//    @Test(retryAnalyzer = RetryAnalyzer.class)
//    public void checkSaveProductsInOrderAfterCancellationOrderWithHeaderBackButton(){
//        Steps.base.header.searchProductsUsingSearchInput("Apple");
//        Steps.listing.clickProductAddToCartButton(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.base.header.checkIfHeaderCartButtonActive(true);
//        Steps.base.header.checkHeaderCartButtonCountNumber(1);
//        Steps.listing.clickProductAddToCartButton(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
//        Steps.base.header.checkHeaderCartButtonCountNumber(2);
//        Steps.base.header.clickHeaderCartButton();
//        Steps.shoppingCart.checkThatProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkThatProductDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkProductCount(1, Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkIfCheckoutButtonDisplayed(true);
//        Steps.shoppingCart.clickCheckoutButton();
//        Steps.base.checkIfModalAuthorizationSkipButtonDisplayed(true);
//        Steps.base.clickModalAuthorizationSkipButton();
//        Steps.makingOrderPartOne.checkThatProductsBlockDisplayed();
//        Steps.makingOrderPartOne.checkThatProductsBlockTitleDisplayed();
//        Steps.makingOrderPartOne.checkProductsBlockTitleText(2);
//        Steps.base.header.checkThatHeaderBackButtonDisplayed();
//        Steps.base.clickBrowserBackButton();
//        Steps.shoppingCart.checkThatShoppingCartPageOpen();
//        Steps.base.checkIfIncompleteOrderModalBlockDisplayed(true);
//        Steps.base.checkThatIncompleteOrderContinueButtonDisplayed();
//        Steps.base.clickIncompleteOrderContinueButton();
//        Steps.makingOrderPartOne.checkThatProductsBlockDisplayed();
//        Steps.makingOrderPartOne.checkThatProductsBlockTitleDisplayed();
//        Steps.makingOrderPartOne.checkProductsBlockTitleText(2);
//    }
//
//    @Test
//    @Description("Проверка, что добавленные в корзину товары сохраняеются при возвращении с оформления заказа шаг 2 на шаг 1" +
//            "с помощью кнопки 'Назад' в хедере")
//    public void checkThatProductsSavedAfterClickingHeaderBackButtonOnMakingOrderPartOnePage(){
//        Steps.base.header.searchProductsUsingSearchInput("Apple");
//        Steps.listing.clickProductAddToCartButton(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.base.header.checkIfHeaderCartButtonActive(true);
//        Steps.base.header.checkHeaderCartButtonCountNumber(1);
//        Steps.listing.clickProductAddToCartButton(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
//        Steps.base.header.checkHeaderCartButtonCountNumber(2);
//        Steps.base.header.clickHeaderCartButton();
//        Steps.shoppingCart.checkThatProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkThatProductDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkProductCount(1, Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkProductCount(1, Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkIfCheckoutButtonDisplayed(true);
//        Steps.shoppingCart.clickCheckoutButton();
//        Steps.base.checkIfModalAuthorizationSkipButtonDisplayed(true);
//        Steps.base.clickModalAuthorizationSkipButton();
//        Steps.makingOrderPartOne.checkThatMakingOrderPartOneOpen();
//        Steps.makingOrderPartOne.checkThatMapShopsDisplayed(true);
//        Steps.makingOrderPartOne.clickMapShops();
//        Steps.base.mapShopsSteps.checkThatListButtonDisplayed();
//        Steps.base.mapShopsSteps.clickListButton();
//        Steps.base.mapShopsSteps.checkThatShopRowDisplayed("Балашиха, мкрн.Железнодорожный, ул.Советская, д.9, ТЦ «Эдельвейс»");
//        Steps.base.mapShopsSteps.clickShopRow("Балашиха, мкрн.Железнодорожный, ул.Советская, д.9, ТЦ «Эдельвейс»");
//        Steps.base.mapShopsSteps.checkThatSelectShopButton();
//        Steps.base.mapShopsSteps.clickSelectShopButton();
//        Steps.makingOrderPartOne.loadingBlockShouldTonBeVisible();
//        Steps.makingOrderPartOne.changeShopButtonShouldBeVisible();
//        Steps.makingOrderPartOne.clickPaymentButton();
//        Steps.makingOrderPartTwo.checkThatMakingOrderPartTwoOpen();
//        Steps.makingOrderPartTwo.checkThatProductsListDisplayed();
//        Steps.makingOrderPartTwo.clickFirstProductInProductList();
//        Steps.makingOrderPartTwo.checkThatModalOrderBasketTitleDisplayed();
//        Steps.makingOrderPartTwo.checkModalOrderBasketTitleText(2);
//        Steps.makingOrderPartTwo.checkThatModalOrderBasketProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.makingOrderPartTwo.checkThatModalOrderBasketProductDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
//        Steps.makingOrderPartTwo.checkThatModalOrderBasketProductImgDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.makingOrderPartTwo.checkThatModalOrderBasketProductImgDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
//        Steps.makingOrderPartTwo.checkThatModalOrderBasketProductNameDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.makingOrderPartTwo.checkThatModalOrderBasketProductNameDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
//        Steps.makingOrderPartTwo.checkThatModalOrderBasketProductCountDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.makingOrderPartTwo.checkThatModalOrderBasketProductCountDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
//        Steps.makingOrderPartTwo.checkModalOrderBasketProductCount(1, Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.makingOrderPartTwo.checkModalOrderBasketProductCount(1, Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
//        Steps.makingOrderPartTwo.checkThatCloseButtonDisplayed();
//        Steps.makingOrderPartTwo.clickCloseButton();
//        Steps.base.header.clickHeaderBackButton();
//        Steps.makingOrderPartOne.checkThatMakingOrderPartOneOpen();
//        Steps.base.header.clickHeaderBackButton();
//        Steps.shoppingCart.checkThatShoppingCartPageOpen();
//        Steps.shoppingCart.checkThatProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkThatProductDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkProductCount(1, Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
//        Steps.shoppingCart.checkProductCount(1, Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
//    }



}
