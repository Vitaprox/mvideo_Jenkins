package steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.MakingOrderPartOnePage.MakingOrderPartOnePage;
import pages.Pages;

import static pages.Pages.*;

public class MakingOrderPartOneSteps {

    @Step("Проверяем, что страница создания заказа шаг 1 открылась")
    public void checkThatMakingOrderPartOneOpen(){
        Assert.assertTrue(Pages.makingOrderPartOne.isContainerDisplayed());
        Assert.assertEquals(Steps.base.getURL(), "https://www.mvideo.ru/purchase/step1");
    }

    @Step("Проверяем, что карта магазинов отображается. Ожидаемый результат: {expectedResult}")
    public void checkThatMapShopsDisplayed(boolean expectedResult){
        Assert.assertEquals(makingOrderPartOne.isMapShopsDisplayed(), expectedResult);
    }

    @Step("Нажимаем на карту магазинов")
    public void clickMapShops(){
        makingOrderPartOne.clickMapShops();
        Assert.assertTrue(Pages.modalMapShops.isDisplayed());
    }

    @Step("Проверяем, что кнопка Далее отображается. Ожидаемый результат: {expectedResult}")
    public void checkThatPaymentButtonDisplayed(boolean expectedResult){
        Assert.assertEquals(makingOrderPartOne.isPaymentButtonDisplayed(), expectedResult);
    }

    @Step("Нажимаем кнопку Далее")
    public void clickPaymentButton(){
        makingOrderPartOne.clickPaymentButton();
    }

    @Step("Проверяем, что блок товаров отображается")
    public void checkThatProductsBlockDisplayed(){
        Assert.assertTrue(Pages.makingOrderPartOne.isProductsBlockContainerDisplayed());
    }

    @Step("Проверяем, что заголовок блока товаров отображается")
    public void checkThatProductsBlockTitleDisplayed(){
        Assert.assertTrue(Pages.makingOrderPartOne.isProductsBlockTitleDisplayed());
    }

    @Step("Проверяем, что в заголовке блока товаров количество товаров: {expectedCountProducts}")
    public void checkProductsBlockTitleText(int expectedCountProducts){
        String expectedTitle = expectedCountProducts + " " + Steps.base.getProductDeclension(expectedCountProducts);
        Assert.assertEquals(Pages.makingOrderPartOne.getProductBlockTitleText(), expectedTitle);
    }

    @Step("Проверяем, что лист с товарами отображается")
    public void checkThatProductsListDisplayed(){
        Assert.assertTrue(Pages.makingOrderPartOne.isProductsListDisplayed());
    }

    @Step("Нажимаем на лист с товарами")
    public void clickProductsList(){
        Pages.makingOrderPartOne.clickProductsList();
        Assert.assertTrue(MakingOrderPartOnePage.modalBasket.isDisplayed());
    }

    @Step("Ждем, когда кнопка изменения магазина появится")
    public void changeShopButtonShouldBeVisible(){
        makingOrderPartOne.changeShopButtonShouldBeVisible();
    }

    @Step("Ожидаем, когда пропадет окно загрузки")
    public void loadingBlockShouldTonBeVisible(){
        makingOrderPartOne.loadingBlockShouldBeVisible();
        makingOrderPartOne.loadingBlockShouldNotBeVisible();
    }

    @Step("Проверяем, что на странице первого этапа оформления заказа заголовок модального окна корзины отображается")
    public void checkThatModalOrderBasketTitleDisplayed(){
        Assert.assertTrue(MakingOrderPartOnePage.modalBasket.isTitleDisplayed());
    }

    @Step("Проверяем, что кнопка 'Закрыть' отображается. Ожидаемый результат: {expectedResult}")
    public void checkThatCloseButtonDisplayed(){
        Assert.assertTrue(MakingOrderPartOnePage.modalBasket.isCloseButtonDisplayed());
    }

    @Step("Нажимаем на кнопку 'Закрыть'")
    public void clickCloseButton(){
        MakingOrderPartOnePage.modalBasket.clickCloseButton();
        MakingOrderPartOnePage.modalBasket.shouldNoTBeVisible();
    }

    @Step("Проверяем, что на странице первого этапа оформления заказа в заголовке модального окна корзины количество" +
            " товаров: {expectedCountProducts}")
    public void checkModalOrderBasketTitleText(int expectedCountProducts){
        String expectedTitle = expectedCountProducts + " " + Steps.base.getProductDeclension(expectedCountProducts) +
                " в заказе";
        Assert.assertEquals(MakingOrderPartOnePage.modalBasket.getTitleText(), expectedTitle);
    }

    @Step("Проверяем, что на странице первого этапа оформления заказа в модальном окне отображается товар {productName}")
    public void checkThatModalOrderBasketProductDisplayed(String productName){
        Assert.assertTrue(MakingOrderPartOnePage.modalBasket.isProductDisplayed(productName));
    }

    @Step("Проверяем, что на странице первого этапа оформления заказа в модальном окне отображается фото товара {productName}")
    public void checkThatModalOrderBasketProductImgDisplayed(String productName){
        Assert.assertTrue(MakingOrderPartOnePage.modalBasket.isProductImgDisplayed(productName));
    }

    @Step("Проверяем, что на странице первого этапа оформления заказа в модальном окне отображается количество товара {productName}")
    public void checkThatModalOrderBasketProductCountDisplayed(String productName){
        Assert.assertTrue(MakingOrderPartOnePage.modalBasket.isProductCountDisplayed(productName));
    }

    @Step("Проверяем количество товара в модальном окне на странице первого этапа оформления заказа ")
    public void checkModalOrderBasketProductCount(int count, String productName){
        String expectedCount = count + " шт.";
        Assert.assertEquals(MakingOrderPartOnePage.modalBasket.getProductCount(productName), expectedCount);
    }

    @Step("Проверяем, что на странице первого этапа оформления заказа в модальном окне отображается имя товара {productName}")
    public void checkThatModalOrderBasketProductNameDisplayed(String productName){
        Assert.assertTrue(MakingOrderPartOnePage.modalBasket.isProductNameDisplayed(productName));
    }

}
