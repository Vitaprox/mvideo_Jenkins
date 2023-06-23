package data;

import pages.common.WebElement;

public class ListingProductFactory {

    private static Product product = new Product();

    private static String XPATH_PRODUCT_NAME_CONTAINER = "//div[contains(@class, 'product-card__title-line-container')]" +
            "[.//a[normalize-space(text())='%s']]";

    private static String XPATH_PRODUCT_IMG = XPATH_PRODUCT_NAME_CONTAINER + "/preceding-sibling::mvid-plp-product-picture[1]";

    private static String XPATH_PRODUCT_PRICE = XPATH_PRODUCT_NAME_CONTAINER + "/following-sibling::div" +
            "//span[@class='price__main-value']";

    private static String XPATH_PRODUCT_NAME = "//div[contains(@class, 'product-card__title-line-container')]" +
            "//a[normalize-space(text())='%s']";

    private static String XPATH_PRODUCT_ADD_TO_CART_BUTTON = XPATH_PRODUCT_NAME_CONTAINER + "/following-sibling" +
            "::mvid-plp-product-checkout//button[@title][./span]";

    private static String XPATH_PRODUCT_ADD_TO_WISH_LIST = XPATH_PRODUCT_NAME_CONTAINER + "/following-sibling" +
            "::mvid-plp-product-checkout//mvid-icon[@type='love']";

    private static String XPATH_PRODUCT_ADD_TO_COMPARISON = XPATH_PRODUCT_NAME_CONTAINER + "/following-sibling" +
            "::mvid-plp-product-checkout//mvid-icon[@type='histogram']";



    private static void setProduct(String productName){
        product.setImg(WebElement.get(XPATH_PRODUCT_IMG, productName));
        product.setPrice(WebElement.get(XPATH_PRODUCT_PRICE, productName));
        product.setName(WebElement.get(XPATH_PRODUCT_NAME, productName));
        product.setAddToCartButton(WebElement.get(XPATH_PRODUCT_ADD_TO_CART_BUTTON, productName));
        product.setAddToWishlistButton(WebElement.get(XPATH_PRODUCT_ADD_TO_WISH_LIST, productName));
        product.setAddToComparisonButton(WebElement.get(XPATH_PRODUCT_ADD_TO_COMPARISON,productName));
    }

    public static Product getProduct(String productName){
        setProduct(productName);
        return product;
    }


}
