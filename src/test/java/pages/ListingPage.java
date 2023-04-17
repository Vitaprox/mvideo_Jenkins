package pages;

import data.ListingProductFactory;
import data.ListingProducts;
import org.openqa.selenium.support.FindBy;
import pages.common.AbstractPage;
import pages.common.WebElement;
import pages.common.WebElementsCollection;

import java.util.*;

public class ListingPage extends AbstractPage {

    private final String XPATH_SORT_DROPDOWN = "//mvid-product-list-controls//div[@class='dropdown__options']";

    private final String XPATH_SORT_DROPDOWN_OPTION_WITH_TEXT = XPATH_SORT_DROPDOWN + "/div[text()=' %s ']";

    private WebElementsCollection paginationElements = new WebElementsCollection("//ul[contains(@class, 'pagination')]/li");

    private WebElementsCollection productRows = new WebElementsCollection("//div[contains(@class, 'product-cards-row')]");

    @FindBy(xpath = "//mvid-plp-product-cards-layout")
    private WebElement productsContainer;

    @FindBy(tagName = "mvid-filters-list")
    private WebElement filtersContainer;

    @FindBy(tagName = "mvid-pagination")
    private WebElement paginationBlock;

    @FindBy(xpath = "//div[@class='dropdown__title'][span[text()='Сначала популярные']]")
    private WebElement sortButton;

    @FindBy(xpath = XPATH_SORT_DROPDOWN)
    private WebElement sortDropdown;

    public void scrollAndClickPaginationBackButton(){
        paginationElements.getWebElementsList().stream().findFirst()
                .get()
                .scrollToCenter()
                .click();
    }

    public void scrollAndClickPaginationNextButton(){
        paginationElements.get(paginationElements.getWebElementsList().size()-1)
                .scrollToCenter()
                .click();
    }

    public boolean isPaginationNextButtonActive(){
        return !paginationElements.get(paginationElements.getWebElementsList().size()-1).hasClass("disabled");
    }

    public boolean isSortDropdownDisplayed() {
        return sortDropdown.isDisplayedAfterWaiting(1500);
    }

    public void scrollAndClickSortButton() {
        sortButton.scrollToCenter().click();
    }

    public void clickDropdownOption(String optionName) {
        WebElement.get(XPATH_SORT_DROPDOWN_OPTION_WITH_TEXT, optionName).click();
    }

    public boolean checkDescSortPrices(){
        List<Integer> sortArray = ListingProducts.getPrices().stream().sorted(Comparator.reverseOrder()).toList();
        List<Integer> actualArray = ListingProducts.getPrices();
        return actualArray.equals(sortArray);
    }

    public void scrollAllProducts() {
        productRows.getWebElementsList().forEach(WebElement::scrollToCenter);
    }

    public List<String> getAllProductNames() {
        return ListingProducts.getNames();
    }

    public void scrollToPagination() {
        paginationBlock.scrollToCenter();
    }

    public boolean isProductsContainerDisplayed() {
        return productsContainer.isDisplayedAfterWaiting(13000);
    }

    public void productsContainerShouldNotBeVisible(){/////////////////////////////?
        productsContainer.shouldNotBeVisible();
    }

    public boolean isFiltersContainerDisplayed() {
        return filtersContainer.isDisplayedAfterWaiting(13000);
    }

    public boolean isProductDisplayed(String productName){
        boolean flag = false;
        for(String name : ListingProducts.getNames()){
            if (name.equals(productName)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public void scrollAndClickProductAddToCartButton(String productName){
        ListingProductFactory.getProduct(productName).getAddToCartButton().scrollToCenter().click();
    }

    public void scrollToProductName(String productName){
        ListingProductFactory.getProduct(productName).getName().scrollToCenter();
    }

    public void addToCartButtonShouldBeActive(String productName){
        ListingProductFactory.getProduct(productName).getAddToCartButton().attrShouldHaveValue("title", "Перейти в корзину");
    }

    public void clickProductAddToCartButton(String productName){
        ListingProductFactory.getProduct(productName).getAddToCartButton().click();
    }

    public String getProductPrice(String productName){
        return ListingProductFactory.getProduct(productName).getPrice().getText();
    }

    public boolean isProductAddToComparisonButtonDisplayed(String productName){
        return ListingProductFactory.getProduct(productName).getAddToComparisonButton().isDisplayedAfterWaiting(7000);
    }

    public void productAddToComparisonButtonShouldBeActive(String productName){
        ListingProductFactory.getProduct(productName).getAddToComparisonButton().shouldHaveClass("active");
    }

    public boolean isProductAddToComparisonButtonActive(String productName){
        return ListingProductFactory.getProduct(productName).getAddToComparisonButton().hasClass("active");
    }

    public boolean isProductAddToWishListButtonDisplayed(String productName){
        return ListingProductFactory.getProduct(productName).getAddToWishlistButton().isDisplayedAfterWaiting(7000);
    }

    public void scrollAndClickProductAddToWishListButton(String productName){
        ListingProductFactory.getProduct(productName).getAddToWishlistButton().scrollToCenter().click();
    }

    public void productAddToWishListButtonShouldBeActive(String productName){
        ListingProductFactory.getProduct(productName).getAddToWishlistButton().shouldHaveClass("active");
    }

    public boolean isProductAddToWishListButtonActive(String productName){
        return ListingProductFactory.getProduct(productName).getAddToWishlistButton().hasClass("active");
    }

    public void scrollAndClickProductAddToComparisonButton(String productName){
        ListingProductFactory.getProduct(productName).getAddToComparisonButton().scrollToCenter().click();
    }

    public void clickProductImg(String productName){
        ListingProductFactory.getProduct(productName).getImg().click();
    }

}
