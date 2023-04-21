package data;

import org.testng.Assert;
import pages.common.WebElement;
import pages.common.WebElementsCollection;
import steps.Steps;

import java.util.ArrayList;
import java.util.List;

public class ListingProducts {

    private static final WebElementsCollection images = new WebElementsCollection("//a[contains(@class," +
            " 'product-picture-link')]/picture");

    private static final WebElementsCollection prices = new WebElementsCollection("//span[@class = 'price__main-value']");

    private static final WebElementsCollection names = new WebElementsCollection("//a[contains(@class, " +
            "'product-title__text')]");

    private static final WebElementsCollection addInCartButtons = new WebElementsCollection("//mvid-button" +
            "[contains(@class, 'cart-button')]/button");

    private static final WebElementsCollection addInWishlist = new WebElementsCollection("//button" +
            "[@title='Добавить в избранное']");

    private static final WebElementsCollection addInComparison = new WebElementsCollection("//button" +
            "[@title='Добавить в сравнение']");

    public static Product get(int index){
        if(checkThatAllElementsOfProductExist(index)){
            Product product = new Product();
            product.setImg(images.get(index));
            product.setName(names.get(index));
            product.setPrice(prices.get(index));
            product.setAddToCartButton(addInCartButtons.get(index));
            product.setAddToWishlistButton(addInWishlist.get(index));
            product.setAddToComparisonButton(addInComparison.get(index));
            return product;
        } else {
            Assert.fail("Не все элементы товара найдены");
            return null;
        }
    }

    public static Product get(String productName){
        int index = getProductIndex(productName);
        return get(index);
    }

    public static List<Product> getProductList(){
        List<Product> products = new ArrayList<>();
        for(int index = 0; index < images.size(); index++){
            products.add(get(index));
        }
        return products;
    }

    public static List<Integer> getPrices(){
        List<Integer> pricesList = new ArrayList<>();
        for (WebElement element : prices.getWebElementsList()){
            pricesList.add(Steps.base.convertToInt(element.getText()));
        }
        return pricesList;
    }

    public static  List<String> getNames(){
        List<String> namesList = new ArrayList<>();
        for (WebElement element : names.getWebElementsList()){
            namesList.add(element.getText());
        }
        return namesList;
    }

    private static int getProductIndex(String productName){
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).getText().equals(productName)){
                return i;
            }
        }
        return -1;
    }

    private static boolean checkThatAllElementsOfProductExist(int index){
        return images.size() > index && names.size() > index && prices.size() > index && addInCartButtons.size() > index
                && addInWishlist.size() > index && addInComparison.size() > index;
    }

}
