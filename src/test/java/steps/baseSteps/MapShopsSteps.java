package steps.baseSteps;

import io.qameta.allure.Step;
import org.testng.Assert;

import static pages.Pages.modalMapShops;

public class MapShopsSteps {

    @Step("Проверяем, что кнопка 'Список' отображается")
    public void checkThatListButtonDisplayed(){
        Assert.assertTrue(modalMapShops.isListButtonDisplayed());
    }

    @Step("Нажимаем на кнопку 'Список'")
    public void clickListButton(){
        modalMapShops.clickListButton();
    }

    @Step("Проверяем, что магазин {shopName} отображается в списке")
    public void checkThatShopRowDisplayed(String shopName){
        Assert.assertTrue(modalMapShops.isShopRowDisplayed(shopName));
    }

    @Step("Кликаем на магазин {shopName} в списке")
    public void clickShopRow(String shopName){
        modalMapShops.clickShopRow(shopName);
    }

    @Step("Проверяем, что кнопка выбора магазина отображается")
    public void checkThatSelectShopButton(){
        Assert.assertTrue(modalMapShops.isSelectShopButtonDisplayed());
    }

    @Step("Кликаем на кнопку выбора магазина")
    public void clickSelectShopButton(){
        modalMapShops.clickSelectShopButton();
    }
}
