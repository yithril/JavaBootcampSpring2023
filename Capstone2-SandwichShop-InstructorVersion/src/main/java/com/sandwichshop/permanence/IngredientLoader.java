package com.sandwichshop.permanence;

import com.sandwichshop.SideItem;
import com.sandwichshop.Topping;
import com.sandwichshop.enums.ToppingCategory;

import java.util.ArrayList;
import java.util.Arrays;

public class IngredientLoader {
    public static ArrayList<Topping> LoadToppings(){
        ArrayList<Topping> toppingsList = new ArrayList<>();

        final String[] meats = new String[] { "steak", "ham", "salami", "roast beef", "chicken", "bacon"};
        final String[] cheeses = new String[] { "american", "provolone", "cheddar", "swiss" };
        final String[] regularToppings = new String[] { "lettuce", "peppers", "onions", "tomatoes", "jalapenos", "cucumbers", "pickles", "guacamole", "mushrooms"};
        final String[] sauces = new String[] { "mayo", "mustard", "ketchup", "ranch", "thousand island", "vinaigrette" };
        final String[] sides = new String[] { "au jus", "sauce" };

        Arrays.stream(meats).forEach(m -> toppingsList.add(new Topping(m, ToppingCategory.MEAT, 1, 1, false)));
        Arrays.stream(cheeses).forEach(m -> toppingsList.add(new Topping(m, ToppingCategory.CHEESE, .75, .75, false)));
        Arrays.stream(regularToppings).forEach(m -> toppingsList.add(new Topping(m, ToppingCategory.REGULAR_TOPPINGS,  true)));
        Arrays.stream(sauces).forEach(m -> toppingsList.add(new Topping(m, ToppingCategory.SAUCES,  true)));
        Arrays.stream(sides).forEach(m -> toppingsList.add(new Topping(m, ToppingCategory.SIDES,  true)));

        toppingsList.add(new Topping("extra cheese", ToppingCategory.EXTRA_CHEESE, false));
        toppingsList.add(new Topping("extra meat", ToppingCategory.EXTRA_MEAT, false));

        return toppingsList;
    }
}
