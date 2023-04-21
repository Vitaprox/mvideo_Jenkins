package steps;

import org.testng.Assert;
import pages.Pages;

public class WishlistPageSteps {

    public void checkThatWishlistPageOpen(){
        Assert.assertTrue(Pages.wishlistPage.isMainTitleDisplayed());
        Assert.assertTrue(Pages.wishlistPage.isFirstProductImgDisplayed());
    }

    public void checkIfProductDisplayed(boolean expectedResult, String productName){
        Assert.assertEquals(Pages.wishlistPage.isProductDisplayed(productName), expectedResult);
    }

    public void checkThatProductDeleteButtonDisplayed(String productName){
        Assert.assertTrue(Pages.wishlistPage.isProductDeleteButtonDisplayed(productName));
    }

    public void clickProductDeleteButton(String productName){
        Pages.wishlistPage.clickProductDeleteButton(productName);
        Pages.wishlistPage.productShouldNotBeVisible(productName);
    }

    public void checkThatBackButtonDisplayed(){
        Assert.assertTrue(Pages.wishlistPage.isBackButtonDisplayed());
    }

    public void clickBackButton(){
        Pages.wishlistPage.clickBackButton();
    }

}
