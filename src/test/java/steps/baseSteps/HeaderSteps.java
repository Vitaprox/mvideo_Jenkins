package steps.baseSteps;

import io.qameta.allure.Step;
import org.testng.Assert;
import steps.Steps;

import static pages.Pages.header;

public class HeaderSteps {
    @Step("Проверяем, что логотип отображается")
    public void checkThatLogoInHeaderDisplayed() {
        Assert.assertTrue(header.isLogoDisplayed());
    }

    @Step("Нажимаем на кнопку понравившихся товаров")
    public void clickHeaderWishlistButton(){
        header.clickWishlistButton();
        Steps.wishlist.checkThatWishlistPageOpen();
    }

    @Step("Проверяем, что кнопка Статус заказа активна. Ожидаемый результат: {expectedResult}")
    public void checkIfHeaderOrderStatusButtonActive(boolean expectedResult) {
        Assert.assertEquals(header.isOrderStatusButtonActive(), expectedResult);
    }

    @Step("Проверяем, что кнопка Профиль активна. Ожидаемый результат: {expectedResult}")
    public void checkIfHeaderProfileButtonActive(boolean expectedResult) {
        Assert.assertEquals(header.isProfileButtonActive(), expectedResult);
    }

    @Step("Проверяем, что кнопка Сравнение в хедере активна. Ожидаемый результат: {expectedResult}")
    public void checkIfHeaderComparisonButtonActive(boolean expectedResult) {
        Assert.assertEquals(header.isComparisonButtonActive(), expectedResult);
    }

    @Step("Проверяем, что кнопка Понравившиеся в хедере активна. Ожидаемый результат: {expectedResult}")
    public void checkIfHeaderWishlistButtonActive(boolean expectedResult) {
        Assert.assertEquals(header.isWishlistButtonActive(), expectedResult);
    }

    @Step("Проверяем, что кнопка Корзина активна. Ожидаемый результат: {expectedResult}")
    public void checkIfHeaderCartButtonActive(boolean expectedResult) {
        Assert.assertEquals(header.isCartButtonActive(), expectedResult);
    }

    @Step("Проверяем, что кнопка Статус заказа отображается. Ожидаемый результат: {expectedResult}")
    public void checkIfHeaderOrderStatusButtonDisplayed(boolean expectedResult) {
        Assert.assertEquals(header.isOrderStatusButtonDisplayed(), expectedResult);
    }

    @Step("Проверяем, что кнопка Профиль отображается. Ожидаемый результат: {expectedResult}")
    public void checkIfHeaderProfileButtonDisplayed(boolean expectedResult) {
        Assert.assertEquals(header.isProfileButtonDisplayed(), expectedResult);
    }

    @Step("Проверяем, что кнопка Сравнение отображается. Ожидаемый результат: {expectedResult}")
    public void checkIfHeaderComparisonButtonDisplayed(boolean expectedResult) {
        Assert.assertEquals(header.isComparisonButtonDisplayed(), expectedResult);
    }

    @Step("Проверяем, что кнопка Понравившиеся отображается. Ожидаемый результат: {expectedResult}")
    public void checkIfHeaderWishlistButtonDisplayed(boolean expectedResult) {
        Assert.assertEquals(header.isWishlistButtonDisplayed(), expectedResult);
    }

    @Step("Проверяем, что кнопка Корзина отображается. Ожидаемый результат: {expectedResult}")
    public void checkIfHeaderCartButtonDisplayed(boolean expectedResult) {
        Assert.assertEquals(header.isCartButtonDisplayed(), expectedResult);
    }

    @Step("Проверяем счетчик кнопки Корзины. Ожидаемый результат: {expectedProductInCart}")
    public void checkHeaderCartButtonCountNumber(int expectedProductInCart) {
        if (expectedProductInCart == 0) {
            header.cartButtonCountShouldNotBeVisible();
        } else {
            Assert.assertEquals(header.getCartButtonCountNumber(), expectedProductInCart);
        }
    }

    @Step("Проверяем счетчик кнопки понравившихся товаров. Ожидаемый результат: {expectedProductInWishlist}")
    public void checkHeaderWishlistButtonCountNumber(int expectedProductInWishlist) {
        if (expectedProductInWishlist == 0) {
            header.wishlistButtonCountShouldNotBeVisible();
        } else {
            Assert.assertEquals(header.getWishlistButtonCountNumber(), expectedProductInWishlist);
        }
    }

    @Step("Проверяем счетчик кнопки сравнения. Ожидаемый результат: {expectedProductInComparison}")
    public void checkHeaderComparisonButtonCountNumber(int expectedProductInComparison) {
        if (expectedProductInComparison == 0) {
            header.comparisonButtonCountShouldNotBeVisible();
        } else {
            Assert.assertEquals(header.getComparisonButtonCountNumber(), expectedProductInComparison);
        }
    }

    @Step("Нажимаем на кнопку Корзина")
    public void clickHeaderCartButton() {
        header.clickCartButton();
        Steps.shoppingCart.checkThatShoppingCartPageOpen();
    }

    @Step("Проверяем, что кнопка 'Назад' в хедере")
    public void checkThatHeaderBackButtonDisplayed(){
        Assert.assertTrue(header.isHeaderBackButtonDisplayed());
    }

    @Step("Нажимаем на кнопку 'Назад' в хедере")
    public void clickHeaderBackButton(){
        header.clickHeaderBackButton();
    }

    @Step("Наводим курсор на кнопку корзины в хедере")
    public void hoverCartButtonInHeader(){
        header.hoverCartButton();
    }

    @Step("Наводим курсор на кнопку понравившихся товаров")
    public void hoverWishlistButton(){
        header.hoverWishlistButton();
    }

    @Step("Наводим курсор на кнопку сравнения товаров")
    public void hoverComparisonButton(){
        header.hoverComparisonButton();
    }

    @Step("Проверяем, что поле поиска отображается")
    public void checkThatSearchInputDisplayed() {
        Assert.assertTrue(header.isSearchInputDisplayed());
    }

    @Step("Вводим в поисковую строку текст {text}")
    public void setSearchInputValue(String text) {
        header.setSearchInputValue(text);
    }

    @Step("Нажимаем на кнопку поиска")
    public void clickSearchButton() {
        header.clickSearchButton();
        Steps.listing.checkThatListingPageOpened();
    }

    @Step("Находим товары по запросу {searchText}")
    public void searchProductsUsingSearchInput(String searchText){
        checkThatSearchInputDisplayed();
        setSearchInputValue(searchText);
        clickSearchButton();
    }
}
