package steps.baseSteps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.Pages;
import steps.Steps;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static pages.Pages.*;

public class BaseSteps {

    public HeaderSteps header = new HeaderSteps();

    public MapShopsSteps mapShopsSteps = new MapShopsSteps();


    @Step("Проверяем, что кнопка Сравнение в измененном хедере активна. Ожидаемый результат: {expectedResult}")
    public void checkIfFixedHeaderComparisonButtonActive(boolean expectedResult) {
        Assert.assertEquals(fixedHeader.isComparisonButtonActive(), expectedResult);
    }

    @Step("Проверяем, что кнопка Сравнение в измененном хедере отображается")
    public void checkThatFixedHeaderComparisonButtonDisplayed(boolean expectedResult){
        Assert.assertTrue(fixedHeader.isComparisonButtonDisplayed());
    }

    @Step("Дожидаемся, пока кнопка сравнения товаров в измененном хедере станет неактивной")
    public void fixedHeaderComparisonButtonShouldNotBeActive(){
        fixedHeader.comparisonButtonShouldNotActive();
    }

    @Step("Проверяем, что кнопка Понравившиеся в исправленном хедере активна. Ожидаемый результат: {expectedResult}")
    public void checkIfFixedHeaderWishlistButtonActive(boolean expectedResult) {
        Assert.assertEquals(fixedHeader.isWishlistButtonActive(), expectedResult);
    }

    @Step("Проверяем, что кнопка Понравившиеся в измененном хедере отображается")
    public void checkThatFixedHeaderWishlistButtonDisplayed(boolean expectedResult){
        Assert.assertTrue(fixedHeader.isWishlistButtonDisplayed());
    }

    @Step("Дожидаемся, пока кнопка понравившихся товаров в измененном хедере станет неактивной")
    public void fixedHeaderWishlistButtonShouldNotBeActive(){
        fixedHeader.wishlistButtonShouldNotActive();
    }



    @Step("Получаем URL страницы")
    public String getURL() {
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }

    @Step("Нажимаем назад в браузере")
    public void clickBrowserBackButton(){
        Selenide.back();
    }

    @Step("Обновляем страницу")
    public void refreshPage(){
        Selenide.refresh();
    }

    @Step("Проверяем, что кнопка удаления товара {productName} отображается в тултипе корзины")
    public void checkThatProductRemoveButtonDisplayedInCartTooltip(String productName){
        Assert.assertTrue(shoppingCartTooltip.isProductRemoveButtonDisplayed(productName));
    }

    @Step("Проверяем, что кнопка удаления товара {productName} отображается в тултипе понравившихся товаров")
    public void checkThatProductRemoveButtonDisplayedInWishlistTooltip(String productName){
        Assert.assertTrue(wishlistTooltip.isProductRemoveButtonDisplayed(productName));
    }

    @Step("Проверяем, что кнопка удаления товара {productName} отображается в тултипе сравнения товаров")
    public void checkThatProductRemoveButtonDisplayedInComparisonTooltip(String productName){
        Assert.assertTrue(comparisonTooltip.isProductRemoveButtonDisplayed(productName));
    }

    @Step("Нажимаем на кнопку 'Удалить товар из корзины' у товара {productName} в тултипе корзины")
    public void clickProductRemoveButtonInCartTooltip(String productName){
        shoppingCartTooltip.clickProductRemoveButton(productName);
        productContainerShouldNotBeVisibleInCartTooltip(productName);
    }

    @Step("Дожидаемся пока товар {productName} не будет отображаться в тултипе корзины")
    public void productContainerShouldNotBeVisibleInCartTooltip(String productName){
        shoppingCartTooltip.productContainerShouldNotBeVisible(productName);
    }


    @Step("Нажимаем на кнопку 'Удалить товар из понравившихся' у товара {productName} в тултипе понравившихся товаров")
    public void clickProductRemoveButtonInWishlistTooltip(String productName){
        wishlistTooltip.clickProductRemoveButton(productName);
        productContainerShouldNotBeVisibleInWishlistTooltip(productName);
    }

    @Step("Дожидаемся пока товар {productName} не будет отображаться в тултипе понравившихся товаров")
    public void productContainerShouldNotBeVisibleInWishlistTooltip(String productName){
        wishlistTooltip.productContainerShouldNotBeVisible(productName);
    }

    @Step("Нажимаем на кнопку 'Удалить товар из сравнения' у товара {productName} в тултипе сравнения товаров")
    public void clickProductRemoveButtonInComparisonTooltip(String productName){
        comparisonTooltip.clickProductRemoveButton(productName);
        productContainerShouldNotBeVisibleInComparisonTooltip(productName);
    }

    @Step("Дожидаемся пока товар {productName} не будет отображаться в тултипе сравнения товаров")
    public void productContainerShouldNotBeVisibleInComparisonTooltip(String productName){
        comparisonTooltip.productContainerShouldNotBeVisible(productName);
    }

    @Step("Наводим курсор на контейнер товара {productName} в тултипе корзины")
    public void hoverProductContainerInCartTooltip(String productName){
        shoppingCartTooltip.hoverProductContainer(productName);
    }

    @Step("Наводим курсор на контейнер товара {productName} в тултипе понравившихся товаров")
    public void hoverProductContainerInWishlistTooltip(String productName){
        wishlistTooltip.hoverProductContainer(productName);
    }

    @Step("Наводим курсор на контейнер товара {productName} в тултипе сравнения товаров")
    public void hoverProductContainerInComparisonTooltip(String productName){
        comparisonTooltip.hoverProductContainer(productName);
    }

    @Step("Проверяем, что товар {productName} из тултипа корзины отображается")
    public void checkThatCartTooltipProductDisplayed(String productName){
        Assert.assertTrue(shoppingCartTooltip.isProductContainerDisplayed(productName));
    }

    @Step("Проверяем, что имя товара {productName} из тултипа корзины отображается")
    public void checkThatCartTooltipProductNameDisplayed(String productName){
        Assert.assertTrue(Pages.shoppingCartTooltip.isProductNameDisplayed(productName));
    }

    @Step("Проверяем, что изображение товара {productName} из тултипа корзины отображается")
    public void checkThatCartTooltipProductImgDisplayed(String productName){
        Assert.assertTrue(Pages.shoppingCartTooltip.isProductImgDisplayed(productName));
    }

    @Step("Проверяем, что тултип корзины отображается")
    public void checkThatProductCartTooltipDisplayed(){
        Assert.assertTrue(shoppingCartTooltip.isDisplayed());
    }

    @Step("Проверяем, что тултип сравнения товаров отображается")
    public void checkThatComparisonTooltipDisplayed(){
        Assert.assertTrue(comparisonTooltip.isDisplayed());
    }

    @Step("Проверяем, что товара {productName} из тултипа сравнения товаров отображается")
    public void checkThatComparisonTooltipProductDisplayed(String productName){
        Assert.assertTrue(comparisonTooltip.isProductContainerDisplayed(productName));
    }

    @Step("Проверяем, что тултип понравившихся товаров отображается")
    public void checkThatWishlistTooltipDisplayed(){
        Assert.assertTrue(wishlistTooltip.isDisplayed());
    }

    @Step("Проверяем, что товара {productName} из тултипа понравившихся товаров отображается")
    public void checkThatWishlistTooltipProductDisplayed(String productName){
        Assert.assertTrue(wishlistTooltip.isProductContainerDisplayed(productName));
    }

    @Step("Закрываем окно, которое запрашивает разрешения для включения оповещений")
    public void closeAllowNotification(){
        if (allowNotification.isDisplayed()){
            allowNotification.clickCloseButton();
            allowNotification.shouldNoTBeVisible();
        }
    }

    @Step("Проверяем, что в окне авторизации отображается кнопка пропустить. Ожидаемый результат {expectedResult}")
    public void checkIfModalAuthorizationSkipButtonDisplayed(boolean expectedResult){
        Assert.assertEquals(authorizationModalBlock.isSkipButtonDisplayed(), expectedResult);
    }

    @Step("Нажимаем на кнопку пропустить в окне авторизации")
    public void clickModalAuthorizationSkipButton(){
        authorizationModalBlock.clickSkipButton();
        Steps.makingOrderPartOne.checkThatMakingOrderPartOneOpen();
    }

    @Step("Проверяем, отображается ли окно незавршенного заказа, ожидаемый результат {expectedResult}")
    public void checkIfIncompleteOrderModalBlockDisplayed(boolean expectedResult){
        Assert.assertEquals(incompleteOrderModalBlock.isDisplayed(), expectedResult);
    }

    @Step("Проверяем, что кнопка Продолжить в окне незавершенного товара отображается")
    public void checkThatIncompleteOrderContinueButtonDisplayed(){
        Assert.assertTrue(incompleteOrderModalBlock.isContinueButtonDisplayed());
    }

    @Step("Нажимаем на кнопку Продолжить в окне незавршенного заказа")
    public void clickIncompleteOrderContinueButton(){
        incompleteOrderModalBlock.clickContinueButton();
        Steps.makingOrderPartOne.checkThatMakingOrderPartOneOpen();
    }

    @Step("Проверяем, что кнопка Вернуть товары в корзину отображается")
    public void checkThatReturnProductsButtonDisplayed(){
        Assert.assertTrue(incompleteOrderModalBlock.isReturnProductsButtonDisplayed());
    }

    @Step("Нажимаем на кнопку Вернуть товары в корзину")
    public void clickReturnProductsButton(){
        incompleteOrderModalBlock.clickReturnProductsButton();
    }


    @Step("Закрываем все всплывающие окна товаров")
    public void closeProductsWindows() {
        executeJavaScript("let elements = document.getElementByClassName('tooltip__item');" +
                "for (let elem of elements)" +
                "elem.style.display = 'none';");
    }

    @Step("Превращаем число в строку с пробелами через 3 знака")
    public String formatToPrice(int number) {
        return Integer.toString(number).replaceAll("(\\d)(?=(\\d{3})+$)", "$1 ") + " ₽";
    }

    @Step("Получаем слово 'товар' в нужном склонении")
    public String getProductDeclension(int number) {
        String declension = "";
        int decimalNumber = number % 100;
        if (decimalNumber > 10 && decimalNumber < 15) declension = "товаров";
        else {
            int endNumber = number % 10;
            declension = switch (endNumber) {
                case 1 -> "товар";
                case 2, 3, 4 -> "товара";
                default -> "товаров";
            };
        }

        return declension;
    }

    @Step("Преобразуем строку {text} в int")
    public int convertToInt(String text) {
        return Integer.parseInt(text.replaceAll("\\D", ""));
    }

    @Step("Закрываем все всплывающие окна с товарами")
    public void closeProductWindows(){
        executeJavaScript("let elements = document.getElementsByClassName('tooltip__item');" +
                "for (let elem of elements) " +
                "elem.style.display = 'none';");
    }

    @Step("Закрываем все всплывающие окна виджетов товарами")
    public void closeWidgetWindows(){
        executeJavaScript("let elements = document.getElementsByClassName('widget');" +
                "for (let elem of elements) " +
                "elem.style.display = 'none';");
    }
    //let elements = document.getElementsByClassName('widget');
    //for (let elem of elements) elem.style.display = 'none';
}
