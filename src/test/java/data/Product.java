package data;

import pages.common.WebElement;

public class Product {

    private WebElement img;
    private WebElement price;
    private WebElement name;
    private WebElement addToCartButton;
    private WebElement addToWishlistButton;
    private WebElement addToComparisonButton;

    public WebElement getImg() {
        return img;
    }

    public WebElement getPrice() {
        return price;
    }

    public WebElement getName() {
        return name;
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public WebElement getAddToWishlistButton() {
        return addToWishlistButton;
    }

    public WebElement getAddToComparisonButton() {
        return addToComparisonButton;
    }

    void setImg(WebElement img) {
        this.img = img;
    }

    void setPrice(WebElement price) {
        this.price = price;
    }

    void setName(WebElement name) {
        this.name = name;
    }

    void setAddToCartButton(WebElement addToCartButton) {
        this.addToCartButton = addToCartButton;
    }

    void setAddToWishlistButton(WebElement addToWishlistButton) {
        this.addToWishlistButton = addToWishlistButton;
    }

    void setAddToComparisonButton(WebElement addToComparisonButton) {
        this.addToComparisonButton = addToComparisonButton;
    }
}
