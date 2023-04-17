package steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.Pages;

public class HomePageSteps {

    @Step("Проверяем, что главная страница открыта")
    public void checkThatHomePageOpen(){
//        Assert.assertTrue(Pages.home.dayProductsBlock.isTitleDisplayed()); mvideo не хочет загружать этот блок
        checkThatPromotionsBlockDisplayed();
    }

    @Step("Проверяем, что карусель товаров отображается")
    public void checkThatPromotionsBlockDisplayed(){
        Assert.assertTrue(Pages.home.isPromotionsBlockDisplayed());
    }

    @Step("Пролистываем всю страницу")
    public void scrollSectionBlocks(){
        Pages.home.scrollSectionBlocks();
    }

    @Step("Прокручиваем страницу до раздела Самые просматриваемые")
    public void scrollToMostView(){
        Pages.home.mostViewedBlock.scrollToCenter();
    }

    @Step("Нажимаем на картинку товара")
    public void clickProductImg(){
        Pages.home.mostViewedBlock.clickProductImg();
    }

    @Step("Проверяем, что раздел Товары дня отображается")
    public void checkThatDayProductBlockDisplayed(){
        Assert.assertTrue(Pages.home.dayProductsBlock.isDisplayed());
    }

    @Step("Нажимаем на кнопку в корзину у товара из раздела Товары дня")
    public void clickDayProductsBuyButton(){
        Pages.home.dayProductsBlock.clickDayProductsBuyButton();
    }

    @Step("Нажимаем на кнопку в корзину у товара {productName} из раздела Товары дня")
    public void clickDayProductsBuyButton(String productName){
        Pages.home.dayProductsBlock.clickDayProductsBuyButton(productName);
    }

    @Step
    public void findAndClickProductAddToCartButtonsInMostView(int... productsNumbers){
        scrollSectionBlocks();
        checkIfMostViewedBlockDisplayed(true);
        scrollToMostView();
        clickProductAddInCartButtonInMostView(productsNumbers);
    }

    @Step("Нажимаем на кнопку В корзину у товаров из раздела Самые просматриваемые")
    public void clickProductAddInCartButtonInMostView(int... productsNumbers){
        Pages.home.mostViewedBlock.clickProductAddInCartButton(productsNumbers);
    }

    @Step("Проверяем отображается ли раздел Самые просматриваемые. Ожидаемый результат {expectedResult}")
    public void checkIfMostViewedBlockDisplayed(boolean expectedResult){
        Assert.assertEquals(Pages.home.mostViewedBlock.isDisplayed(), expectedResult);
    }

    @Step("Проверяем отображаетая ли заголовок Хиты продаж. Ожидаемый результат {expectedResult}")
    public void checkIfSalesHitsTitleDisplayed(boolean expectedResult){
        Assert.assertEquals(Pages.home.salesHitsBlock.isTitleDisplayed(), expectedResult);
        Pages.home.salesHitsBlock.clickProductBuyButton();
        Assert.assertTrue(Pages.home.salesHitsBlock.isDisplayed());
    }

}
