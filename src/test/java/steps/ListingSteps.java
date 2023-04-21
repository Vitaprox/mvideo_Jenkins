package steps;

import data.ListingProducts;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.Pages;

public class ListingSteps {

    @Step("Проверяем, что страница листинга открыта")
    public void checkThatListingPageOpened() {
        Assert.assertTrue(Pages.listing.isProductsContainerDisplayed());
        Assert.assertTrue(Pages.listing.isFiltersContainerDisplayed());
        String actualUrl = Steps.base.getURL();
        String expectedUrl = "https://www.mvideo.ru/product-list-page?";
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }

    @Step("Прокручиваем страницу до пагинации")
    public void scrollToPagination() {
        Pages.listing.scrollToPagination();
    }

    @Step("Прокручиваем страницу по всем товарам")
    public void scrollAllProducts() {
        Pages.listing.scrollAllProducts();
    }

    @Step("Проверяем входит ли строка {string} в название каждого товара")
    public void checkThatStringIncludedInEachProductName(String string) {
        for (String name : Pages.listing.getAllProductNames()) {
            Assert.assertTrue(name.toLowerCase().contains(string.toLowerCase()));
        }
    }

    @Step("Прокручиваем страницу и добавляем в корзину товар {productName}")
    public void scrollAndClickProductAddToCartButton(String productName){
        Pages.listing.scrollAndClickProductAddToCartButton(productName);
    }

    @Step("Прокручиваем страницу и добавляем в корзину товар {productName}")
    public void clickProductAddToCartButton(String productName){
        Pages.listing.scrollAndClickProductAddToCartButton(productName);
        Pages.listing.addToCartButtonShouldBeActive(productName);
    }

    @Step("Прокручиваем страницу до имени товара {productName}")
    public void scrollToProductName(String productName){
        Pages.listing.scrollToProductName(productName);
    }

    @Step("Проверяем, что цена товара {productName} {price}")
    public void checkProductPrice(int price, String productName){
        String actualPrice = Pages.listing.getProductPrice(productName);
        String expectedPrice = Steps.base.formatToPrice(price);
        Assert.assertEquals(actualPrice, expectedPrice);
    }

    @Step("Нажимаем на кнопку добавления в понравившиеся у товара {productName}")
    public void scrollAndClickProductAddToWishlistButton(String productName){
        Pages.listing.scrollAndClickProductAddToWishListButton(productName);
        Pages.listing.productAddToWishListButtonShouldBeActive(productName);
    }

    @Step("Проверяем, что кнопка избранных товаров у {productName} отображается")
    public void checkThatProductAddToWishlistButtonDisplayed(String productName){
        Assert.assertTrue(Pages.listing.isProductAddToWishListButtonDisplayed(productName));
    }

    @Step("Проверяем, что кнопка сравнения у {productName} отображается")
    public void checkThatProductAddToComparisonButtonDisplayed(String productName){
        Assert.assertTrue(Pages.listing.isProductAddToComparisonButtonDisplayed(productName));
    }

    @Step("Проверяем, отображается ли кнкопка добавления товара в избранное у товара {productName}. Ожидаемый результат {expectedResult}")
    public void checkIfProductAddToWishlistButtonActive(boolean expectedResult, String productName){
        Assert.assertEquals(Pages.listing.isProductAddToWishListButtonActive(productName), expectedResult);
    }

    @Step("Проверяем, отображается ли кнкопка сравнение у товара {productName}. Ожидаемый результат {expectedResult}")
    public void checkIfProductAddToComparisonButtonActive(boolean expectedResult, String productName){
        Assert.assertEquals(Pages.listing.isProductAddToComparisonButtonActive(productName), expectedResult);
    }

    @Step("Нажимаем на кнопку добавления в сравнения у товара {productName}")
    public void scrollAbdClickProductAddToComparisonButton(String productName){
        Pages.listing.scrollAndClickProductAddToComparisonButton(productName);
        Pages.listing.productAddToComparisonButtonShouldBeActive(productName);
    }

    @Step("Нажимаем на фото товара {productName}")
    public void clickProductImg(String productName){
        Pages.listing.clickProductImg(productName);
    }

    @Step("Нажимаем на кнопку сортировки")
    public void scrollAndClickSortButton(){
        Pages.listing.scrollAndClickSortButton();
        Steps.listing.checkIfSortDropdownDisplayed(true);
    }

    @Step("Проверяем отображается ли выпадающий список сортировки. Ожидаемый результат: {expectedResult}")
    public void checkIfSortDropdownDisplayed(boolean expectedResult){
        Assert.assertEquals(Pages.listing.isSortDropdownDisplayed(), expectedResult);
    }

    @Step("Нажимаем на опцию сортировки {optionName}")
    public void clickDropdownOption(String optionName){
        Pages.listing.clickDropdownOption(optionName);
        newProductsShouldBeVisible();
        Steps.listing.checkIfSortDropdownDisplayed(false);
    }

    @Step("Проверяем, что цены товаров в порядке убывания")
    public void checkDescSortPrices(){
        Assert.assertTrue(Pages.listing.checkDescSortPrices());
    }

    @Step("Дожидаемся, когда появятся новые товары")
    public void newProductsShouldBeVisible(){
        Pages.listing.productsContainerShouldNotBeVisible();
        Assert.assertTrue(Pages.listing.isProductsContainerDisplayed());
    }

    @Step("Ищем товар перебирая страницы")
    public void searchAndClickProductOnAllPages(String productName){
        while (Pages.listing.isPaginationNextButtonActive()){
            scrollAllProducts();
            if(Pages.listing.isProductDisplayed(productName)){
                ListingProducts.get(productName).getAddToCartButton().scrollToCenter().click();
                break;
            } else {
                Pages.listing.scrollAndClickPaginationNextButton();
                newProductsShouldBeVisible();
            }
        }
    }

}
