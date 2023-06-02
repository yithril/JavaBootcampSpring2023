package com.sandwichshop.interfaces;

import java.math.BigDecimal;

public interface OrderItem {
    BigDecimal getPrice();
    String getName();
}
