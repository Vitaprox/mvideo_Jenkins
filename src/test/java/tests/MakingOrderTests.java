package tests;

import data.Properties;
import data.RetryAnalyzer;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import steps.Steps;

public class MakingOrderTests extends AbstractTest{

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void checkProductsInMakingOrderPartOne(){
        Steps.base.header.searchProductsUsingSearchInput("Apple");
        Steps.listing.clickProductAddToCartButton(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.base.header.checkIfHeaderCartButtonActive(true);
        Steps.base.header.checkHeaderCartButtonCountNumber(1);
        Steps.listing.clickProductAddToCartButton(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
        Steps.base.header.checkHeaderCartButtonCountNumber(2);
        Steps.base.header.clickHeaderCartButton();
        Steps.shoppingCart.checkIfCheckoutButtonDisplayed(true);
        Steps.shoppingCart.clickCheckoutButton();
        Steps.base.checkIfModalAuthorizationSkipButtonDisplayed(true);
        Steps.base.clickModalAuthorizationSkipButton();
        Steps.makingOrderPartOne.checkThatProductsBlockDisplayed();
        Steps.makingOrderPartOne.checkThatProductsBlockTitleDisplayed();
        Steps.makingOrderPartOne.checkProductsBlockTitleText(2);
        Steps.makingOrderPartOne.checkThatProductsListDisplayed();
        Steps.makingOrderPartOne.clickProductsList();
        Steps.makingOrderPartOne.checkThatModalOrderBasketTitleDisplayed();
        Steps.makingOrderPartOne.checkModalOrderBasketTitleText(2);
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductImgDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductImgDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductNameDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductNameDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductCountDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductCountDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkModalOrderBasketProductCount(1, Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkModalOrderBasketProductCount(1, Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("Проверяем, что если не выбран адрес магазина, при нажатии кнопки Далее ничего не происходит")
    public void checkThatIfStoreAddressNotSelectedNothingHappensWhenClickPaymentButton(){
        Steps.base.header.searchProductsUsingSearchInput("Apple");
        Steps.listing.clickProductAddToCartButton(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.base.header.checkIfHeaderCartButtonActive(true);
        Steps.base.header.checkHeaderCartButtonCountNumber(1);
        Steps.listing.clickProductAddToCartButton(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
        Steps.base.header.checkHeaderCartButtonCountNumber(2);
        Steps.base.header.clickHeaderCartButton();
        Steps.shoppingCart.checkIfCheckoutButtonDisplayed(true);
        Steps.shoppingCart.clickCheckoutButton();
        Steps.base.checkIfModalAuthorizationSkipButtonDisplayed(true);
        Steps.base.clickModalAuthorizationSkipButton();
        Steps.makingOrderPartOne.checkThatMakingOrderPartOneOpen();
        Steps.makingOrderPartOne.checkThatPaymentButtonDisplayed(true);
        Steps.makingOrderPartOne.clickPaymentButton();
        Steps.makingOrderPartOne.checkThatMakingOrderPartOneOpen();
    }

    @Test
    @Description("Проверка, что добавленные в корзину товары сохраняеются при возвращении с оформления заказа шаг 2 на шаг 1" +
            "с помощью кнопки 'Назад' в хедере")
    public void checkThatProductsSavedAfterClickingHeaderBackButtonOnMakingOrderPartOnePage(){
        Steps.base.header.searchProductsUsingSearchInput("Apple");
        Steps.listing.clickProductAddToCartButton(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.base.header.checkIfHeaderCartButtonActive(true);
        Steps.base.header.checkHeaderCartButtonCountNumber(1);
        Steps.listing.clickProductAddToCartButton(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
        Steps.base.header.checkHeaderCartButtonCountNumber(2);
        Steps.base.header.clickHeaderCartButton();
        Steps.shoppingCart.checkIfCheckoutButtonDisplayed(true);
        Steps.shoppingCart.clickCheckoutButton();
        Steps.base.checkIfModalAuthorizationSkipButtonDisplayed(true);
        Steps.base.clickModalAuthorizationSkipButton();
        Steps.makingOrderPartOne.checkThatMakingOrderPartOneOpen();
        Steps.makingOrderPartOne.checkThatProductsBlockDisplayed();
        Steps.makingOrderPartOne.checkThatProductsBlockTitleDisplayed();
        Steps.makingOrderPartOne.checkProductsBlockTitleText(2);
        Steps.makingOrderPartOne.checkThatProductsListDisplayed();
        Steps.makingOrderPartOne.clickProductsList();
        Steps.makingOrderPartOne.checkThatModalOrderBasketTitleDisplayed();
        Steps.makingOrderPartOne.checkModalOrderBasketTitleText(2);
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductImgDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductImgDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductNameDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductNameDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductCountDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductCountDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkModalOrderBasketProductCount(1, Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkModalOrderBasketProductCount(1, Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatCloseButtonDisplayed();
        Steps.makingOrderPartOne.clickCloseButton();
        Steps.makingOrderPartOne.checkThatMapShopsDisplayed(true);
        Steps.makingOrderPartOne.clickMapShops();
        Steps.base.mapShopsSteps.checkThatListButtonDisplayed();
        Steps.base.mapShopsSteps.clickListButton();
        Steps.base.mapShopsSteps.checkThatShopRowDisplayed("Балашиха, мкрн.Железнодорожный, ул.Советская, д.9, ТЦ «Эдельвейс»");
        Steps.base.mapShopsSteps.clickShopRow("Балашиха, мкрн.Железнодорожный, ул.Советская, д.9, ТЦ «Эдельвейс»");
        Steps.base.mapShopsSteps.checkThatSelectShopButton();
        Steps.base.mapShopsSteps.clickSelectShopButton();
        Steps.makingOrderPartOne.loadingBlockShouldTonBeVisible();
        Steps.makingOrderPartOne.changeShopButtonShouldBeVisible();
        Steps.makingOrderPartOne.clickPaymentButton();
        Steps.makingOrderPartTwo.checkThatMakingOrderPartTwoOpen();
        Steps.makingOrderPartTwo.checkThatProductsListDisplayed();
        Steps.makingOrderPartTwo.clickFirstProductInProductList();
        Steps.makingOrderPartTwo.checkThatModalOrderBasketTitleDisplayed();
        Steps.makingOrderPartTwo.checkModalOrderBasketTitleText(2);
        Steps.makingOrderPartTwo.checkThatModalOrderBasketProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.makingOrderPartTwo.checkThatModalOrderBasketProductDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
        Steps.makingOrderPartTwo.checkThatModalOrderBasketProductImgDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.makingOrderPartTwo.checkThatModalOrderBasketProductImgDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
        Steps.makingOrderPartTwo.checkThatModalOrderBasketProductNameDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.makingOrderPartTwo.checkThatModalOrderBasketProductNameDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
        Steps.makingOrderPartTwo.checkThatModalOrderBasketProductCountDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.makingOrderPartTwo.checkThatModalOrderBasketProductCountDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
        Steps.makingOrderPartTwo.checkModalOrderBasketProductCount(1, Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.makingOrderPartTwo.checkModalOrderBasketProductCount(1, Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
        Steps.makingOrderPartTwo.checkThatCloseButtonDisplayed();
        Steps.makingOrderPartTwo.clickCloseButton();
        Steps.base.header.clickHeaderBackButton();
        Steps.makingOrderPartOne.checkThatMakingOrderPartOneOpen();
        Steps.makingOrderPartOne.checkThatProductsBlockDisplayed();
        Steps.makingOrderPartOne.checkThatProductsBlockTitleDisplayed();
        Steps.makingOrderPartOne.checkThatProductsListDisplayed();
        Steps.makingOrderPartOne.clickProductsList();
        Steps.makingOrderPartOne.checkThatModalOrderBasketTitleDisplayed();
        Steps.makingOrderPartOne.checkModalOrderBasketTitleText(2);
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductImgDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductImgDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductNameDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductNameDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductCountDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductCountDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkModalOrderBasketProductCount(1, Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkModalOrderBasketProductCount(1, Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
    }

    @Test
    @Description("Проверка, что добавленные в корзину товары сохраняеются при возвращении с оформления заказа шаг 2 на шаг 1" +
            "с помощью кнопки 'Назад' в браузере")
    public void checkThatProductsSavedAfterClickingBrowserBackButtonOnMakingOrderPartOnePage(){
        Steps.base.header.searchProductsUsingSearchInput("Apple");
        Steps.listing.clickProductAddToCartButton(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.base.header.checkIfHeaderCartButtonActive(true);
        Steps.base.header.checkHeaderCartButtonCountNumber(1);
        Steps.listing.clickProductAddToCartButton(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
        Steps.base.header.checkHeaderCartButtonCountNumber(2);
        Steps.base.header.clickHeaderCartButton();
        Steps.shoppingCart.checkIfCheckoutButtonDisplayed(true);
        Steps.shoppingCart.clickCheckoutButton();
        Steps.base.checkIfModalAuthorizationSkipButtonDisplayed(true);
        Steps.base.clickModalAuthorizationSkipButton();
        Steps.makingOrderPartOne.checkThatMakingOrderPartOneOpen();
        Steps.makingOrderPartOne.checkThatProductsBlockDisplayed();
        Steps.makingOrderPartOne.checkThatProductsBlockTitleDisplayed();
        Steps.makingOrderPartOne.checkProductsBlockTitleText(2);
        Steps.makingOrderPartOne.checkThatProductsListDisplayed();
        Steps.makingOrderPartOne.clickProductsList();
        Steps.makingOrderPartOne.checkThatModalOrderBasketTitleDisplayed();
        Steps.makingOrderPartOne.checkModalOrderBasketTitleText(2);
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductImgDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductImgDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductNameDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductNameDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductCountDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductCountDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkModalOrderBasketProductCount(1, Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkModalOrderBasketProductCount(1, Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatCloseButtonDisplayed();
        Steps.makingOrderPartOne.clickCloseButton();
        Steps.makingOrderPartOne.checkThatMapShopsDisplayed(true);
        Steps.makingOrderPartOne.clickMapShops();
        Steps.base.mapShopsSteps.checkThatListButtonDisplayed();
        Steps.base.mapShopsSteps.clickListButton();
        Steps.base.mapShopsSteps.checkThatShopRowDisplayed("Балашиха, мкрн.Железнодорожный, ул.Советская, д.9, ТЦ «Эдельвейс»");
        Steps.base.mapShopsSteps.clickShopRow("Балашиха, мкрн.Железнодорожный, ул.Советская, д.9, ТЦ «Эдельвейс»");
        Steps.base.mapShopsSteps.checkThatSelectShopButton();
        Steps.base.mapShopsSteps.clickSelectShopButton();
        Steps.makingOrderPartOne.loadingBlockShouldTonBeVisible();
        Steps.makingOrderPartOne.changeShopButtonShouldBeVisible();
        Steps.makingOrderPartOne.clickPaymentButton();
        Steps.makingOrderPartTwo.checkThatMakingOrderPartTwoOpen();
        Steps.makingOrderPartTwo.checkThatProductsListDisplayed();
        Steps.makingOrderPartTwo.clickFirstProductInProductList();
        Steps.makingOrderPartTwo.checkThatModalOrderBasketTitleDisplayed();
        Steps.makingOrderPartTwo.checkModalOrderBasketTitleText(2);
        Steps.makingOrderPartTwo.checkThatModalOrderBasketProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.makingOrderPartTwo.checkThatModalOrderBasketProductDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
        Steps.makingOrderPartTwo.checkThatModalOrderBasketProductImgDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.makingOrderPartTwo.checkThatModalOrderBasketProductImgDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
        Steps.makingOrderPartTwo.checkThatModalOrderBasketProductNameDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.makingOrderPartTwo.checkThatModalOrderBasketProductNameDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
        Steps.makingOrderPartTwo.checkThatModalOrderBasketProductCountDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.makingOrderPartTwo.checkThatModalOrderBasketProductCountDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
        Steps.makingOrderPartTwo.checkModalOrderBasketProductCount(1, Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.makingOrderPartTwo.checkModalOrderBasketProductCount(1, Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
        Steps.makingOrderPartTwo.checkThatCloseButtonDisplayed();
        Steps.makingOrderPartTwo.clickCloseButton();
        Steps.base.clickBrowserBackButton();
        Steps.makingOrderPartOne.checkThatMakingOrderPartOneOpen();
        Steps.makingOrderPartOne.checkThatProductsBlockDisplayed();
        Steps.makingOrderPartOne.checkThatProductsBlockTitleDisplayed();
        Steps.makingOrderPartOne.checkThatProductsListDisplayed();
        Steps.makingOrderPartOne.clickProductsList();
        Steps.makingOrderPartOne.checkThatModalOrderBasketTitleDisplayed();
        Steps.makingOrderPartOne.checkModalOrderBasketTitleText(2);
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductImgDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductImgDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductNameDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductNameDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductCountDisplayed(Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkThatModalOrderBasketProductCountDisplayed(Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkModalOrderBasketProductCount(1, Properties.LISTING_APPLE_FIRST_PRODUCT_NAME.getValue());
        Steps.makingOrderPartOne.checkModalOrderBasketProductCount(1, Properties.LISTING_APPLE_SECOND_PRODUCT_NAME.getValue());
    }
}
