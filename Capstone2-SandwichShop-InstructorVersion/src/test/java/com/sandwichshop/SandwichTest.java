package com.sandwichshop;

import com.sandwichshop.enums.BreadType;
import com.sandwichshop.enums.ToppingCategory;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SandwichTest {
    @Test
    public void breadSandwich(){
        Sandwich sandwich = new Sandwich(1);

        sandwich.setBreadType(BreadType.WHITE);
        sandwich.setToasted(true);

        assertTrue(sandwich.getPrice().compareTo(new BigDecimal(7)) == 0);
    }
    @Test
    public void sandwichPriceIsCorrect_PremiumNonPremiumMixed(){
        Sandwich sandwich = new Sandwich(2);
        Sandwich sandwich1 = new Sandwich(1);
        Sandwich sandwich2 = new Sandwich(0);

        Topping ketchup = new Topping("ketchup", ToppingCategory.SAUCES, 0, 0, true);
        Topping pickles = new Topping("pickles", ToppingCategory.REGULAR_TOPPINGS, 2, 2, true);
        Topping roastBeef = new Topping("roast beef", ToppingCategory.MEAT, 1, 1, false);
        Topping cheese = new Topping("american", ToppingCategory.CHEESE, .75, .75, false);

        sandwich.addTopping(ketchup);
        sandwich.addTopping(roastBeef);
        sandwich.addTopping(cheese);
        sandwich.addTopping(pickles);

        sandwich1.addTopping(ketchup);
        sandwich1.addTopping(roastBeef);
        sandwich1.addTopping(cheese);
        sandwich1.addTopping(pickles);

        sandwich2.addTopping(ketchup);
        sandwich2.addTopping(roastBeef);
        sandwich2.addTopping(cheese);
        sandwich2.addTopping(pickles);

        assertTrue(sandwich.getPrice().equals(new BigDecimal(13.75)));
        assertTrue(sandwich1.getPrice().equals(new BigDecimal(10.5)));
        assertTrue(sandwich2.getPrice().equals(new BigDecimal(7.25)));
    }
}