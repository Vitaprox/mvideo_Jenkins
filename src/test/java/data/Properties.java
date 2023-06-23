package data;

public enum Properties{

    MVIDEO_HOST("mvideo.host"),
    MVIDEO_LOGIN("mvideo.login"),
    MVIDEO_PASSWORD("mvideo.password"),
    MOST_VIEW_FIRST_PRODUCT_NAME("mostView.firstProductName"),
    MOST_VIEW_SECOND_PRODUCT_NAME("mostView.secondProductName"),
    LISTING_APPLE_FIRST_PRODUCT_NAME("listingApple.firstProductName"),
    LISTING_APPLE_SECOND_PRODUCT_NAME("listingApple.secondProductName");

    private final String PROPERTY_NAME;

    Properties(String propertyName){
        PROPERTY_NAME = propertyName;
    }

    public String getValue(){
        return PropertyManager.get(this.PROPERTY_NAME);
    }

    public static String get(Properties property){
        return property.getValue();
    }

}