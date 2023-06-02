package com.sandwichshop.userinterface;

import com.sandwichshop.Order;
import com.sandwichshop.Sandwich;
import com.sandwichshop.SideItem;
import com.sandwichshop.Topping;
import com.sandwichshop.enums.BreadType;
import com.sandwichshop.enums.ToppingCategory;
import com.sandwichshop.interfaces.OrderItem;
import com.sandwichshop.permanence.IngredientLoader;
import com.sandwichshop.permanence.ReceiptWriter;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

public class UserInterface {
    private static List<Topping> toppings = IngredientLoader.LoadToppings();
    private static Order order = new Order();
    public static void mainScreen(){
        runWelcomeScreen();
    }


    private static boolean runWelcomeScreen(){
        boolean welcomeScreenRunning = true;
        Scanner scanner = new Scanner(System.in);

        while(welcomeScreenRunning){
            showWelcomeScreen();
            int input = scanner.nextInt();

            switch(input){
                case 1:
                    runMainScreen();
                    break;
                case 2:
                    System.out.println("Peace out!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }

        return false;
    }

    private static void showWelcomeScreen(){
        System.out.println("Welcome to the Wrap Factory! Your one stop shop for stuff you could've made at home!");
        System.out.println("Please select from the following options: ");
        System.out.println("1. Start new order");
        System.out.println("2. Exit");
    }

    private static void runMainScreen(){
        boolean runningMainScreen = true;
        Scanner scanner = new Scanner(System.in);

        while(runningMainScreen){
            showMainScreen();
            var input = scanner.nextInt();

            switch(input){
                case 1:
                    makeSandwich();
                    runningMainScreen = false;
                    break;
                case 2:
                    handleDrinkMenu();
                    break;
                case 3:
                    System.out.println("Side of chips added to order!");
                    order.addItemToOrder(new SideItem("Chips", 1.5, 0, 0));
                    break;
                case 4:
                    showOrderItems();
                    break;
                case 5:
                    if(order.getOrderItems().size() == 0){
                        System.out.println("That would require you to buy something.");
                    }
                    else{
                        System.out.println("Thanks for shopping with us and putting our kids through college!");
                        System.out.println("Printing receipt...");
                        ReceiptWriter.writeOrderToReceipt(order);
                        order = new Order();
                        runningMainScreen = false;
                    }
                    break;
                case 6:
                    runningMainScreen = false;
                    break;
                default:
                    System.out.println("Can't you read numbers?");
            }

        }
    }

    private static void showOrderItems(){
        if(order.getOrderItems().size() == 0){
            System.out.println("No items in your cart!");
        }
        else{
            int counter = 1;
            System.out.println("Items in your cart:");
            for(OrderItem item : order.getOrderItems()){
                System.out.printf("%d. (%s) %s %n", counter, currencyFormat(item.getPrice()), item.getName());
                counter++;
            }
        }
    }

    private static void showMainScreen(){
        if(order.getOrderTotal().compareTo(new BigDecimal(0)) > 0){
            System.out.printf("Your current order total is %s for %d item(s) %n", currencyFormat(order.getOrderTotal()), order.getOrderItems().size());
        }
        System.out.println("What would you like to add to your order?");
        System.out.println("1. Add an overpriced sandwich");
        System.out.println("2. Add a cavity inducing drink");
        System.out.println("3. Add your daily requirement of salt in a single bag.");
        System.out.println("4. Check your cart.");
        System.out.println("5. Checkout");
        System.out.println("6. Back");
    }

    private static void handleDrinkMenu(){
        boolean isSelectingDrink = true;
        Scanner scanner = new Scanner(System.in);

        while(isSelectingDrink){
            showDrinkMenu();
            var input = scanner.nextInt();

            switch(input){
                case 1:
                    System.out.println("Small Drink added to order!");
                    order.addItemToOrder(new SideItem("Small Drink", 2, .5, 0));
                    isSelectingDrink = false;
                    break;
                case 2:
                    System.out.println("Medium Drink added to order!");
                    order.addItemToOrder(new SideItem("Medium Drink", 2, .5, 1));
                    isSelectingDrink = false;
                    break;
                case 3:
                    System.out.println("Large Drink added to order!");
                    order.addItemToOrder(new SideItem("Large Drink", 2, .5, 2));
                    isSelectingDrink = false;
                    break;
                case 4:
                    isSelectingDrink = false;
                default:
                    System.out.println("You seriously can't pick a number between 1 and 4?");
            }
        }
    }
    private static void showDrinkMenu(){
        System.out.println("Select fountain drink size");
        System.out.println("1. Small");
        System.out.println("2. Medium");
        System.out.println("3. Large");
        System.out.println("4. Back");
    }
    private static void makeSandwich(){
        System.out.println("Alright, let's make you a sammich!");

        Sandwich sandwich = new Sandwich(handleSandwichSize());
        sandwich.setBreadType(handleBreadMenu());
        sandwich.setToasted(handleToastedMenu());
        displayToppingMenu(sandwich);

        System.out.println("Sandwich has been added to your order!");
        order.addItemToOrder(sandwich);
        runMainScreen();
    }

    private static int handleSandwichSize(){
        boolean handleSandwichSizeMenu = true;
        Scanner scanner = new Scanner(System.in);

        while(handleSandwichSizeMenu){
            displaySandwichSizes();
            var input = scanner.nextInt();

            switch (input){
                case 1:
                    return 0;
                case 2:
                    return 1;
                case 3:
                    return 2;
                default:
                    System.out.println("That's not an option.");
            }
        }

        return 0;
    }

    private static void displaySandwichSizes(){
        System.out.println("Please select a sandwich size");
        System.out.println("1. 4 inches");
        System.out.println("2. 8 inches");
        System.out.println("3. 12 inches");
    }

    private static BreadType handleBreadMenu(){
        Scanner scanner = new Scanner(System.in);

        boolean breadMenuIsRunning = true;

        while(breadMenuIsRunning){
            showBreadMenu();
            var input = scanner.nextInt();

            switch(input){
                case 1:
                    return BreadType.WHEAT;
                case 2:
                    return BreadType.WHITE;
                case 3:
                    return BreadType.RYE;
                case 4:
                    return BreadType.WRAP;
                default:
                    System.out.println("Invalid. Try again.");
            }
        }

        return BreadType.WHEAT;
    }

    private static void showBreadMenu(){
        System.out.println("What kind of bread would you like?");
        System.out.println("1. Wheat");
        System.out.println("2. White");
        System.out.println("3. Rye");
        System.out.println("4. Wrap");
    }

    private static boolean handleToastedMenu(){
        boolean isToasting = true;
        Scanner scanner = new Scanner(System.in);

        while(isToasting){
            showToastedMenu();

            switch(scanner.nextInt()){
                case 1:
                    isToasting = false;
                    return true;
                case 2:
                    isToasting = false;
                    return false;
                default:
                    System.out.println("It's a 1 or a 2. It's not that hard.");
            }
        }

        return false;
    }
    private static void showToastedMenu(){
        System.out.println("Would you like your sandwich toasted?");
        System.out.println("1. YES");
        System.out.println("2. NO");
    }
    private static void displayToppingMenu(Sandwich sandwich){
        Scanner scanner = new Scanner(System.in);

        boolean addingTopping = true;

        while(addingTopping){
            var toppingHash = organizeToppingMenu(sandwich);
            var done = toppingHash.keySet().stream().mapToInt(x -> x).max().orElse(0) + 1;
            System.out.println("Toppings menu:");

            if(sandwich.getToppings().size() > 0){
                System.out.printf("Your sandwich has the following toppings on it: %s %n", sandwich.getToppings().stream().map(x -> x.getName()).collect(Collectors.toList()).toString().replace("[", "")
                        .replace("]", "")
                        .replace(" ", ""));
            }

            for(Map.Entry<Integer, ToppingCategory> entry: toppingHash.entrySet())
                System.out.printf("%d. %s %n", entry.getKey(), entry.getValue().name());
            System.out.printf("%d. Done adding toppings", done);
            int input = scanner.nextInt();
            if(!toppingHash.containsKey(input) && input != done){
                System.out.println("That's not a thing, try again.");
            }
            else if(input == done){
                addingTopping = false;
            }
            else{
                showToppingMenu(toppingHash.get(input), sandwich);
            }
        }
    }
    private static HashMap<Integer, ToppingCategory> organizeToppingMenu(Sandwich sandwich){
        HashMap<Integer, ToppingCategory> toppingMenu = new HashMap<>();
        int counter = 1;
        boolean extraCheese = false;
        boolean extraMeat = false;

        //Have to have meat in order to have extra meat.
        if(sandwich.getToppings().stream().anyMatch(x -> x.getToppingCategory() == ToppingCategory.MEAT)){
            extraMeat = true;
        }

        if(sandwich.getToppings().stream().anyMatch(x -> x.getToppingCategory() == ToppingCategory.CHEESE)){
            extraCheese = true;
        }

        for(ToppingCategory category : ToppingCategory.values()){
            if(category == ToppingCategory.EXTRA_CHEESE && !extraCheese) {
                continue;
            }

            if(category == ToppingCategory.EXTRA_MEAT && !extraMeat){
                continue;
            }

            toppingMenu.put(counter, category);
            counter++;
        }

        return toppingMenu;
    }
    private static void showToppingMenu(ToppingCategory category, Sandwich sandwich){
        var toppingList = toppings.stream()
                                .filter(x -> x.getToppingCategory() == category)
                                .sorted(Comparator.comparing(Topping::getName))
                                .collect(Collectors.toList());

        boolean isSelectingATopping = true;
        Scanner scanner = new Scanner(System.in);

        while(isSelectingATopping){
            int counter = 1;
            System.out.printf("Here is a list of %s to choose from: %n", category.name());
            System.out.printf("Price: %s %n", currencyFormat(toppingList.get(0).getPrice(sandwich.getSize())));
            for(Topping topping : toppingList){
                System.out.printf("%d. Add %s %n", counter, topping.getName(), currencyFormat(topping.getPrice(sandwich.getSize())));
                counter ++;
            }
            var input = scanner.nextInt();

            try{
                System.out.printf("Adding %s to your sandwich! Yum! %n", toppingList.get(input - 1).getName());
                sandwich.addTopping(toppingList.get(input - 1));
                isSelectingATopping = false;
            }
            catch(IndexOutOfBoundsException exception){
                System.out.println("Please learn how numbers work.");
            }
        }
    }

    private static String currencyFormat(BigDecimal n) {
        return NumberFormat.getCurrencyInstance().format(n);
    }
}
