package com.streamsintro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LineItem lineItem = new LineItem(2, "Crate of Bananas", 20, 100);
        LineItem lineItem2 = new LineItem(3, "Crate of Oranges", 15, 200);
        LineItem lineItem3 = new LineItem(4, "Crate of Honeydew", 35, 25);

        Order order = new Order(1, "Publix");

        order.addItem(lineItem);
        order.addItem(lineItem2);
        order.addItem(lineItem3);

        System.out.printf("Your order is %d", order.getTotal());

        List<String> stringList = new ArrayList<>(Arrays.asList("Bob", "Joe", "Mary", "Karl"));

        System.out.println(stringList);

        //List<LineItem> lineItemList = new ArrayList<>(Arrays.asList());

        //imperative programming
        //You go step by painstaking step

        //declarative programming
        //focused on the result, not how you get there
    }
}
