package tests;

import data.Properties;
import data.RetryAnalyzer;
import listeners.AllureListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import steps.Steps;

@Listeners(AllureListener.class)
public class HomeTests extends AbstractTest{


    @Test//(retryAnalyzer = RetryAnalyzer.class)
    public void checkOpenProductFromMostView(){
        Steps.homePage.scrollSectionBlocks();
        Steps.homePage.scrollToMostView();
        Steps.homePage.clickProductImg();
    }

    @Test(groups = "bug")
    public void checkHeaderButtonsActiveAndDisplayed(){
        Steps.base.header.checkIfHeaderOrderStatusButtonActive(true);
        Steps.base.header.checkIfHeaderProfileButtonActive(true);
        Steps.base.header.checkIfHeaderComparisonButtonActive(false);
        Steps.base.header.checkIfHeaderWishlistButtonActive(false);
        Steps.base.header.checkIfHeaderCartButtonActive(false);
        Steps.base.header.checkIfHeaderOrderStatusButtonDisplayed(true);
        Steps.base.header.checkIfHeaderProfileButtonDisplayed(true);
        Steps.base.header.checkIfHeaderComparisonButtonDisplayed(true);
        Steps.base.header.checkIfHeaderWishlistButtonDisplayed(true);
        Steps.base.header.checkIfHeaderCartButtonDisplayed(true);
    }

    @Test//(retryAnalyzer = RetryAnalyzer.class)
    public void checkMultipleProductsHaveBeenAddedToCart() {
        Steps.homePage.findAndClickProductAddToCartButtonsInMostView(1, 2);
        Steps.base.header.hoverCartButtonInHeader();
        Steps.base.checkThatProductCartTooltipDisplayed();
        Steps.base.checkThatCartTooltipProductDisplayed(Properties.MOST_VIEW_FIRST_PRODUCT_NAME.getValue());
        Steps.base.checkThatCartTooltipProductImgDisplayed(Properties.MOST_VIEW_FIRST_PRODUCT_NAME.getValue());
        Steps.base.checkThatCartTooltipProductNameDisplayed(Properties.MOST_VIEW_FIRST_PRODUCT_NAME.getValue());
        Steps.base.checkThatCartTooltipProductDisplayed(Properties.MOST_VIEW_SECOND_PRODUCT_NAME.getValue());
        Steps.base.checkThatCartTooltipProductImgDisplayed(Properties.MOST_VIEW_SECOND_PRODUCT_NAME.getValue());
        Steps.base.checkThatCartTooltipProductNameDisplayed(Properties.MOST_VIEW_SECOND_PRODUCT_NAME.getValue());
    }

    @Test//(retryAnalyzer = RetryAnalyzer.class)
    public void checkThatProductsAddedToCartWithRequiredQuantityAfterRemove() {
        Steps.homePage.findAndClickProductAddToCartButtonsInMostView(1);
        Steps.base.header.hoverCartButtonInHeader();
        Steps.base.checkThatProductCartTooltipDisplayed();
        Steps.base.hoverProductContainerInCartTooltip(Properties.MOST_VIEW_FIRST_PRODUCT_NAME.getValue());
        Steps.base.checkThatProductRemoveButtonDisplayedInCartTooltip(Properties.MOST_VIEW_FIRST_PRODUCT_NAME.getValue());
        Steps.base.clickProductRemoveButtonInCartTooltip(Properties.MOST_VIEW_FIRST_PRODUCT_NAME.getValue());



    }

}
