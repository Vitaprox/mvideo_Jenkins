package steps;

import steps.baseSteps.BaseSteps;
import steps.baseSteps.MapShopsSteps;

public class Steps {
    public static HomePageSteps homePage = new HomePageSteps();
    public static BaseSteps base = new BaseSteps();
    public static ShoppingCartSteps shoppingCart = new ShoppingCartSteps();
    public static ListingSteps listing = new ListingSteps();
    public static WishlistPageSteps wishlist = new WishlistPageSteps();
    public static MakingOrderPartOneSteps makingOrderPartOne = new MakingOrderPartOneSteps();

    public static MakingOrderPartTwoSteps makingOrderPartTwo = new MakingOrderPartTwoSteps();
}
