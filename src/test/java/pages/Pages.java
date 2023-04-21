package pages;

import pages.MakingOrderPartOnePage.MakingOrderPartOnePage;
import pages.MakingOrderPartTwoPage.MakingOrderPartTwoPage;
import pages.common.*;
import pages.homePage.HomePage;

public class Pages {

    public static HomePage home = new HomePage();
    public static ListingPage listing = new ListingPage();
    public static HeaderBlock header = new HeaderBlock();

    public static FixedHeaderBlock fixedHeader = new FixedHeaderBlock();
    public static ShoppingCartPage shoppingCart = new ShoppingCartPage();

    public static ShoppingCartTooltipBlock shoppingCartTooltip = new ShoppingCartTooltipBlock();

    public static WishListTooltipBlock wishlistTooltip = new WishListTooltipBlock();

    public static ComparisonTooltipBlock comparisonTooltip = new ComparisonTooltipBlock();

    public static WishlistPage wishlistPage = new WishlistPage();

    public static AllowNotificationBlock allowNotification = new AllowNotificationBlock();

    public static AuthorizationModalBlock authorizationModalBlock = new AuthorizationModalBlock();

    public static MakingOrderPartOnePage makingOrderPartOne = new MakingOrderPartOnePage();

    public static MakingOrderPartTwoPage makingOrderPartTwo = new MakingOrderPartTwoPage();

    public static IncompleteOrderModalBlock incompleteOrderModalBlock = new IncompleteOrderModalBlock();

    public static  ModalMapShops modalMapShops = new ModalMapShops();
}
