package steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.Pages;

import static pages.Pages.authorizationModalBlock;

public class ShoppingCartSteps {

    @Step("Проверяем, что главная страница открыта")
    public void checkThatShoppingCartPageOpen(){
        Assert.assertTrue(Pages.shoppingCart.isTitleDisplayed());
        String actualUrl = Steps.base.getURL();
        String expectedUrl = "https://www.mvideo.ru/cart";
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Step("Проверяем, что товар {productName} отображается")
    public void checkThatProductDisplayed(String productName){
        Assert.assertTrue(Pages.shoppingCart.isProductDisplayed(productName));
    }

    @Step("Проверяем итоговую цену корзины. Ожидаемый результат {expectedPrice}")
    public void checkFinalPrice(int expectedPrice){
        String productSumPrices = Steps.base.formatToPrice(Pages.shoppingCart.getSumProductsPrises());
        String actualFinalPrice = Pages.shoppingCart.getFinalPrice();
        Assert.assertTrue(Pages.shoppingCart.isFinalPriceDisplayed());
        Assert.assertEquals(actualFinalPrice, Steps.base.formatToPrice(expectedPrice));
        Assert.assertEquals(actualFinalPrice, productSumPrices);
    }

    @Step("Проверяем количество товара в корзине. Ожидаемый результат {expectedQuantity}")
    public void checkQuantityOfProducts(int expectedQuantity){
        Assert.assertTrue(Pages.shoppingCart.isQuantityOfProductsDisplayed());
        String expectedQuantityOfProducts = expectedQuantity + " "+ Steps.base.getProductDeclension(expectedQuantity);
        String actualQuantityOfProducts = Pages.shoppingCart.getQuantityOfProductsText();
        Assert.assertEquals(actualQuantityOfProducts, expectedQuantityOfProducts);
    }

    @Step("Проверяем, что количество товара {productName} равно {expectedCount}")
    public void checkProductCount(int expectedCount, String productName){
        Assert.assertTrue(Pages.shoppingCart.isQuantityProductDisplayed(productName));

        int actualCount = Pages.shoppingCart.getQuantityProduct(productName);
        Assert.assertEquals(actualCount, expectedCount);
    }

    @Step("Проверяем, что текст 'Удалить' отображается у товара {productName}")
    public void checkThatProductRemoveTitleDisplayed(String productName){
        Assert.assertTrue(Pages.shoppingCart.isProductRemoveTitleDisplayed(productName));
    }

    public void removeProduct(String productName){
        Pages.shoppingCart.clickProductRemoveTitle(productName);
        Pages.shoppingCart.productShouldNotBeDisplayed(productName);
    }

    public void checkThatProductPlusButtonDisplayed(String productName){
        Assert.assertTrue(Pages.shoppingCart.isProductPlusButtonDisplayed(productName));
    }

    public void clickProductPlusButton(String productName){
        int quantity = Pages.shoppingCart.getQuantityProduct(productName);
        Pages.shoppingCart.clickProductPlusButton(productName);
        Pages.shoppingCart.productQuantityShouldHaveValue(quantity+1, productName);
    }

    public void checkIfProductPlusButtonActive(boolean expectedResult, String productName){
        Assert.assertEquals(Pages.shoppingCart.isProductPlusButtonActive(productName), expectedResult);
    }

    public void checkIfCheckoutButtonDisplayed(boolean expectedResult){
        Assert.assertEquals(Pages.shoppingCart.isCheckoutButtonDisplayed(), expectedResult);
    }

    public void clickCheckoutButton(){
        Pages.shoppingCart.clickCheckoutButton();
        Assert.assertTrue(authorizationModalBlock.isDisplayed());
    }

}
