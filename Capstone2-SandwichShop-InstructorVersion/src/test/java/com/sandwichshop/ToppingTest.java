package com.sandwichshop;

import com.sandwichshop.enums.ToppingCategory;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ToppingTest {
    @Test
    public void toppingReturnsCorrectPrice(){
        Topping ketchup = new Topping("ketchup", ToppingCategory.SAUCES, 0, 0, true);
        Topping roastBeef = new Topping("roast beef", ToppingCategory.MEAT, 1, 1, false);

        assertTrue(ketchup.getPrice(0).equals(new BigDecimal(0)));
        assertTrue(roastBeef.getPrice(0).equals(new BigDecimal(1)));
        assertTrue(roastBeef.getPrice(1).equals(new BigDecimal(2)));
        assertTrue(roastBeef.getPrice(2).equals(new BigDecimal(3)));
    }

    @Test
    public void sideItemReturnsCorrectPrice(){
        SideItem sideItem = new SideItem("drink", 2, .5, 0);
        SideItem sideItem2 = new SideItem("medium drink", 2, .5, 1);
        SideItem sideItem3 = new SideItem("large drink", 2, .5, 2);
        SideItem chips = new SideItem("large drink", 1.5, 0, 2);

        //Because BigDecimal is an object, assert equals will always fail!
        assertTrue(sideItem.getPrice().equals(new BigDecimal(2)));
        assertTrue(sideItem2.getPrice().equals(new BigDecimal(2.5)));
        assertTrue(sideItem3.getPrice().equals(new BigDecimal(3)));
        assertTrue(chips.getPrice().equals(new BigDecimal(1.5)));
    }
}