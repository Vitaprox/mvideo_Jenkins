package steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.MakingOrderPartTwoPage.MakingOrderPartTwoPage;
import pages.Pages;

import static pages.Pages.makingOrderPartTwo;

public class MakingOrderPartTwoSteps {

    @Step("Првоеряем, что страница оформления заказа шаг 2 открыта")
    public void checkThatMakingOrderPartTwoOpen(){
        Assert.assertTrue(makingOrderPartTwo.isMainTitleDisplayed());
        Assert.assertEquals(Steps.base.getURL(), "https://www.mvideo.ru/purchase/step2");
    }

    @Step("Проверяем, что лист с товарами отображается")
    public void checkThatProductsListDisplayed(){
        Assert.assertTrue(Pages.makingOrderPartTwo.isProductsListDisplayed());
    }



    @Step("Проверяем, что первый товар из листа с товарами отображается")
    public void checkThatFirstProductInProductListDisplayed(){
        Assert.assertTrue(makingOrderPartTwo.isFirstProductInProductListDisplayed());
    }

    @Step("Кликаем на первый товар из листа с товарами")
    public void clickFirstProductInProductList(){
        makingOrderPartTwo.clickFirstProductInProductList();
        Assert.assertTrue(MakingOrderPartTwoPage.modalBasket.isDisplayed());
    }

    @Step("Проверяем, что на странице первого этапа оформления заказа заголовок модального окна корзины отображается")
    public void checkThatModalOrderBasketTitleDisplayed(){
        Assert.assertTrue(MakingOrderPartTwoPage.modalBasket.isTitleDisplayed());
    }

    @Step("Проверяем, что кнопка 'Закрыть' отображается. Ожидаемый результат: {expectedResult}")
    public void checkThatCloseButtonDisplayed(){
        Assert.assertTrue(MakingOrderPartTwoPage.modalBasket.isCloseButtonDisplayed());
    }

    @Step("Нажимаем на кнопку 'Закрыть'")
    public void clickCloseButton(){
        MakingOrderPartTwoPage.modalBasket.clickCloseButton();
        MakingOrderPartTwoPage.modalBasket.shouldNoTBeVisible();
    }

    @Step("Проверяем, что на странице первого этапа оформления заказа в заголовке модального окна корзины количество" +
            " товаров: {expectedCountProducts}")
    public void checkModalOrderBasketTitleText(int expectedCountProducts){
        String expectedTitle = expectedCountProducts + " " + Steps.base.getProductDeclension(expectedCountProducts) +
                " в заказе";
        Assert.assertEquals(MakingOrderPartTwoPage.modalBasket.getTitleText(), expectedTitle);
    }

    @Step("Проверяем, что на странице первого этапа оформления заказа в модальном окне отображается товар {productName}")
    public void checkThatModalOrderBasketProductDisplayed(String productName){
        Assert.assertTrue(MakingOrderPartTwoPage.modalBasket.isProductDisplayed(productName));
    }

    @Step("Проверяем, что на странице первого этапа оформления заказа в модальном окне отображается фото товара {productName}")
    public void checkThatModalOrderBasketProductImgDisplayed(String productName){
        Assert.assertTrue(MakingOrderPartTwoPage.modalBasket.isProductImgDisplayed(productName));
    }

    @Step("Проверяем, что на странице первого этапа оформления заказа в модальном окне отображается количество товара {productName}")
    public void checkThatModalOrderBasketProductCountDisplayed(String productName){
        Assert.assertTrue(MakingOrderPartTwoPage.modalBasket.isProductCountDisplayed(productName));
    }

    @Step("Проверяем количество товара в модальном окне на странице первого этапа оформления заказа ")
    public void checkModalOrderBasketProductCount(int count, String productName){
        String expectedCount = count + " шт.";
        Assert.assertEquals(MakingOrderPartTwoPage.modalBasket.getProductCount(productName), expectedCount);
    }

    @Step("Проверяем, что на странице первого этапа оформления заказа в модальном окне отображается имя товара {productName}")
    public void checkThatModalOrderBasketProductNameDisplayed(String productName){
        Assert.assertTrue(MakingOrderPartTwoPage.modalBasket.isProductNameDisplayed(productName));
    }
}
