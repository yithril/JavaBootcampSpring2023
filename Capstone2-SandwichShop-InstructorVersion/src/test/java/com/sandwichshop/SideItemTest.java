package com.sandwichshop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SideItemTest {
    @Test
    public void sideItemPrice_CalculatesCorrectly(){
        SideItem chips = new SideItem("chips", 1.5, 0, 0);
        SideItem smallDrink = new SideItem("chips", 2, .5, 0);
        SideItem mediumDrink = new SideItem("chips", 2, .5, 1);
        SideItem largeDrink = new SideItem("chips", 2, .5, 2);

        assertTrue(chips.getPrice().equals(new BigDecimal(1.5)));
        assertTrue(smallDrink.getPrice().equals(new BigDecimal(2)));
        assertTrue(mediumDrink.getPrice().equals(new BigDecimal(2.5)));
        assertTrue(largeDrink.getPrice().equals(new BigDecimal(3)));
    }
}