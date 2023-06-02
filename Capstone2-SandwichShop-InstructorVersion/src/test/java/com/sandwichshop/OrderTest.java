package com.sandwichshop;

import com.sandwichshop.enums.BreadType;
import com.sandwichshop.enums.ToppingCategory;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    @Test
    public void orderTotal_IsCorrect(){
        Order order = new Order();

        Sandwich sandwich = new Sandwich(2);

        Topping ketchup = new Topping("ketchup", ToppingCategory.SAUCES, 0, 0, true);
        Topping pickles = new Topping("pickles", ToppingCategory.REGULAR_TOPPINGS, 2, 2, true);
        Topping roastBeef = new Topping("roast beef", ToppingCategory.MEAT, 1, 1, false);
        Topping cheese = new Topping("american", ToppingCategory.CHEESE, .75, .75, false);

        sandwich.addTopping(ketchup);
        sandwich.addTopping(roastBeef);
        sandwich.addTopping(cheese);
        sandwich.addTopping(pickles);

        Sandwich sandwich2 = new Sandwich(0);

        sandwich2.addTopping(ketchup);
        sandwich2.addTopping(roastBeef);
        sandwich2.addTopping(cheese);
        sandwich2.addTopping(pickles);

        SideItem chips = new SideItem("chips", 1.5, 0, 0);
        SideItem smallDrink = new SideItem("chips", 2, .5, 0);

        //add all the stuff to the order
        order.addItemToOrder(sandwich2);
        order.addItemToOrder(sandwich);
        order.addItemToOrder(chips);
        order.addItemToOrder(smallDrink);

        //small drink 2, chips 1.5, first sandwich 13.75, second sandwich 7.25
        //in total 24.5
        //I'm using compareTo rather than equals here because it purely checks value, not value and scale
        //BigDecimal is a headache! :P
        assertTrue(order.getOrderTotal().compareTo(new BigDecimal(24.50)) == 0);
    }
}