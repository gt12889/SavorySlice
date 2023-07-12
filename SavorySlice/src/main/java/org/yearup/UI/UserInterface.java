package org.yearup.UI;

import org.yearup.FileManager.InventoryManager;
import org.yearup.FileManager.ReceiptManager;
import org.yearup.Model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class UserInterface
{
    private final Map<String, Integer> itemMap = new HashMap<>();

    Scanner sc = new Scanner(System.in);
    Order currentOrder;

    public UserInterface()
    {
        currentOrder = new Order(); //creates a new order
    }

    public void run()
    {
        homeScreen();
    }

    public void homeScreen()
    {

        //loads the home screen upon running

        String input;
        System.out.println(ColorCodes.PURPLE + "    \n\n\t\t\t\t\t\t\tWelcome to the"+ColorCodes.RESET);
        System.out.println(ColorCodes.CYAN + "\t\t\t\t\t\t    SavorySlice"+ColorCodes.RESET);
        System.out.println(ColorCodes.GREEN + "\t\t\t\t\t\t    Eat & Meet"+ColorCodes.RESET);
        System.out.println(ColorCodes.YELLOW + "  \n  Home Screen");
        System.out.println("----------------------------------------------------"+ColorCodes.RESET);
        System.out.println(ColorCodes.CYAN + "\t 1 - New Order ");
        System.out.println("\t 2 - Exit "+ColorCodes.RESET);
        System.out.print("Please select a command: ");
        input = sc.nextLine().strip();

        switch (input)
        {
            case "1":
            {
                orderScreen();

                break;
            }
            case "2":
            {
                System.out.println("Thank you, see you next time!");
                System.exit(1);
                break;

            }
            default:
            {
                System.out.println(ColorCodes.RED + "Invalid Input! Please Try again." + ColorCodes.RESET);
            }
        }

        System.out.println(ColorCodes.YELLOW + "===================================================="+ColorCodes.RESET);
    }


    public String getUserInputString(String message)
    {
        System.out.print(message);
        return sc.nextLine().strip();
    }

    public void orderScreen() //default order screen
    {
        String input;
        System.out.println(ColorCodes.YELLOW + "\n\n    Order Screen");
        System.out.println("----------------------------------------------------"+ColorCodes.RESET);
        System.out.println("1 - Add Sandwich ");
        System.out.println("2 - Add Drinks ");
        System.out.println("3 - Add Chips ");
        System.out.println("4 - Checkout ");
        System.out.println("5 - Cancel " );
        System.out.print("Please select a command: ");
        input = sc.nextLine();

        switch (input)
        {
            case "1" -> AddSandwich();
            case "2" -> AddDrinks();
            case "3" -> AddChips();
            case "4" -> CheckOut();
            case "5" -> homeScreen();
            default -> {
                System.out.println(ColorCodes.RED + "Invalid Input! Please Try again." + ColorCodes.RESET);
                homeScreen();
            }
        }

        System.out.println(ColorCodes.YELLOW + "===================================================="+ColorCodes.RESET);
    }

    private void AddSandwich()
    {
        System.out.println();
        System.out.println(ColorCodes.YELLOW + "\n\n    Add Sandwich");
        System.out.println("----------------------------------------------------"+ColorCodes.RESET);

        boolean addMoreItems; //stays false until user selects to add more items to display options
        Topping topping;
        int selectedNumber;
        Sandwich sandwich = null;
        List<Sandwich> sandwichList = InventoryManager.loadSandwiches();
        List<Meat> meatList = InventoryManager.loadMeats();
        List<Cheese> cheeseList = InventoryManager.loadCheese();
        List<RegularTopping> regularToppingList = InventoryManager.loadRegularToppings();
        List<Sauces> saucesList = InventoryManager.loadSauces();
        List<Sides> sidesList = InventoryManager.loadSides();

        String lastPrintedType = "";
        System.out.println(ColorCodes.YELLOW + "Breads" + ColorCodes.RESET);

        for (int i = 0; i < sandwichList.size(); i++)
        {
            Sandwich s = sandwichList.get(i);
            String currentType = s.getType();

            if (!currentType.equals(lastPrintedType))
            {
                System.out.println("\t" + (i + 1) + ". " + currentType);
                lastPrintedType = currentType;
            }
        }

        String bread = getUserInputString("Select your bread: ");
        String size = getUserInputString("What size of sandwich (4\" 8\" 12\"): ");
        String isToasted = getUserInputString("Would you like the bread toasted?(y/n): ");

        selectedNumber = Integer.parseInt(bread);

        if (selectedNumber >= 1 && selectedNumber <= sandwichList.size())
        {
            Sandwich selectedSandwich = sandwichList.get(selectedNumber - 1);
            sandwich = new Sandwich(selectedSandwich.getType(), size);
            sandwich.setToasted(isToasted);
        }
        else
        {
            System.out.println("Invalid option selected.");
        }

        System.out.println(ColorCodes.YELLOW + "Meats" + ColorCodes.RESET);

        for (int i = 0; i < meatList.size(); i++)
        {
            Meat meat = meatList.get(i);
            String currentType = meat.getType();

            if (!currentType.equals(lastPrintedType))
            {
                System.out.println("\t" + (i + 1) + ". " + currentType);
                lastPrintedType = currentType;
            }
        }

        String meat = getUserInputString("Select your meat or leave empty to skip: ");
        if (!meat.isEmpty()) {
            selectedNumber = Integer.parseInt(meat);

            if (selectedNumber >= 1 && selectedNumber <= meatList.size()) {
                Meat selectedMeat = meatList.get(selectedNumber - 1);
                topping = new Meat(selectedMeat.getType());
                sandwich.add(topping);
            } else {
                System.out.println("Invalid option selected.");
            }

            addMoreItems = true;

            while (addMoreItems) {
                String addMoreOption = getUserInputString("Do you want to add another meat? (y/n): ");

                if (!addMoreOption.equalsIgnoreCase("y")) {
                    addMoreItems = false;
                } else {
                    String m = getUserInputString("Select your meat: ");
                    selectedNumber = Integer.parseInt(m);

                    if (selectedNumber >= 1 && selectedNumber <= meatList.size()) {
                        Meat selectedMeat = meatList.get(selectedNumber - 1);
                        topping = new Meat(selectedMeat.getType());
                        sandwich.add(topping);
                    } else {
                        System.out.println("Invalid option selected.");
                    }
                }
            }
        }

        System.out.println(ColorCodes.YELLOW + "Cheeses" + ColorCodes.RESET);

        for (int i = 0; i < cheeseList.size(); i++)
        {
            Cheese cheese = cheeseList.get(i);
            String currentType = cheese.getType();

            if (!currentType.equals(lastPrintedType))
            {
                System.out.println("\t" + (i + 1) + ". " + currentType);
                lastPrintedType = currentType;
            }
        }

        String cheese = getUserInputString("Select your cheese or leave empty skip: ");
        if (!cheese.isEmpty()) {
            selectedNumber = Integer.parseInt(cheese);

            if (selectedNumber >= 1 && selectedNumber <= cheeseList.size()) {
                Cheese selectedCheese = cheeseList.get(selectedNumber - 1);
                topping = new Cheese(selectedCheese.getType());
                sandwich.add(topping);
            } else {
                System.out.println("Invalid option selected.");
            }

            addMoreItems = true;
            while (addMoreItems) {
                String addMoreOption = getUserInputString("Do you want to add another cheese? (y/n): ");

                if (!addMoreOption.equalsIgnoreCase("y")) {
                    addMoreItems = false;
                } else {
                    String c = getUserInputString("Select your cheese: ");
                    selectedNumber = Integer.parseInt(c);

                    if (selectedNumber >= 1 && selectedNumber <= cheeseList.size()) {
                        Cheese selectedCheese = cheeseList.get(selectedNumber - 1);
                        topping = new Cheese(selectedCheese.getType());
                        sandwich.add(topping);
                    } else {
                        System.out.println("Invalid option selected.");
                    }
                }
            }
        }

        System.out.println(ColorCodes.YELLOW + "Regular Toppings" + ColorCodes.RESET);

        for (int i = 0; i < regularToppingList.size(); i++)
        {
            RegularTopping r = regularToppingList.get(i);
            String currentType = r.getType();

            if (!currentType.equals(lastPrintedType))
            {
                System.out.println("\t" + (i + 1) + ". " + currentType);
                lastPrintedType = currentType;
            }
        }

        String toppings = getUserInputString("Select your toppings: ");
        if (!toppings.isEmpty()) {
            selectedNumber = Integer.parseInt(toppings);

            if (selectedNumber >= 1 && selectedNumber <= regularToppingList.size()) {
                RegularTopping selectedReg = regularToppingList.get(selectedNumber - 1);
                topping = new RegularTopping(selectedReg.getType());
                sandwich.add(topping);
            } else {
                System.out.println("Invalid option selected.");
            }

            addMoreItems = true;
            while (addMoreItems) {
                String addMoreOption = getUserInputString("Do you want to add another topping? (y/n): ");

                if (!addMoreOption.equalsIgnoreCase("y")) {
                    addMoreItems = false;
                } else {
                    String t = getUserInputString("Select your toppings: ");
                    selectedNumber = Integer.parseInt(t);

                    if (selectedNumber >= 1 && selectedNumber <= regularToppingList.size()) {
                        RegularTopping selectedReg = regularToppingList.get(selectedNumber - 1);
                        topping = new RegularTopping(selectedReg.getType());
                        sandwich.add(topping);
                    } else {
                        System.out.println("Invalid option selected.");
                    }
                }
            }
        }

        System.out.println(ColorCodes.YELLOW + "Sauces" + ColorCodes.RESET);

        for (int i = 0; i < saucesList.size(); i++)
        {
            Sauces sauces = saucesList.get(i);
            String currentType = sauces.getType();

            //loops through the sauces list and checks it with the input
            if (!currentType.equals(lastPrintedType))
            {
                System.out.println("\t" + (i + 1) + ". " + currentType);
                lastPrintedType = currentType;
            }
        }

        String sauce = getUserInputString("Select your sauce or skip: ");
        if (!sauce.isEmpty()) {
            selectedNumber = Integer.parseInt(sauce);

            if (selectedNumber >= 1 && selectedNumber <= saucesList.size()) {
                Sauces selectedSauce = saucesList.get(selectedNumber - 1);
                topping = new Sauces(selectedSauce.getType());
                sandwich.add(topping);
            } else {
                System.out.println("Invalid option selected.");
            }

            addMoreItems = true;
            while (addMoreItems) {
                String addMoreOption = getUserInputString("Do you want to add another sauce? (y/n): ");

                if (!addMoreOption.equalsIgnoreCase("y")) {
                    addMoreItems = false;
                } else {
                    String s = getUserInputString("Select your sauce: ");
                    selectedNumber = Integer.parseInt(s);

                    if (selectedNumber >= 1 && selectedNumber <= saucesList.size()) {
                        Sauces selectedSauce = saucesList.get(selectedNumber - 1);
                        topping = new Sauces(selectedSauce.getType());
                        sandwich.add(topping);
                    } else {
                        System.out.println("Invalid option selected.");
                    }
                }
            }
        }


        System.out.println();
        System.out.print("Would you like to add a side? (y/n): ");
        String addSideOption = sc.nextLine().strip();

        if (addSideOption.equalsIgnoreCase("y"))
        {
            System.out.println(ColorCodes.YELLOW + "Sides" + ColorCodes.RESET);

            for (int i = 0; i < sidesList.size(); i++)
            {
                Sides sides = sidesList.get(i);
                String currentType = sides.getType();

                if (!currentType.equals(lastPrintedType))
                {
                    System.out.println("\t" + (i + 1) + ". " + currentType);
                    lastPrintedType = currentType;
                }
            }

            String sides = getUserInputString("Select your side: ");
            selectedNumber = Integer.parseInt(sides);

            if (selectedNumber >= 1 && selectedNumber <= sidesList.size())
            {
                Sides selectedSide = sidesList.get(selectedNumber - 1);
                topping = new Sides(selectedSide.getType());
                sandwich.add(topping);
            }
            else
            {
                System.out.println("Invalid option selected.");
            }

            addMoreItems = true;
            while (addMoreItems)
            {
                String addMoreOption = getUserInputString("Do you want to add another side? (y/n): ");

                if (!addMoreOption.equalsIgnoreCase("y"))
                {
                    addMoreItems = false;
                }
                else
                {
                    String s = getUserInputString("Select your side: ");
                    selectedNumber = Integer.parseInt(s);

                    if (selectedNumber >= 1 && selectedNumber <= sidesList.size())
                    {
                        Sides selectedSide = sidesList.get(selectedNumber - 1);
                        topping = new Sides(selectedSide.getType());
                        sandwich.add(topping);
                    }
                    else
                    {
                        System.out.println("Invalid option selected.");
                    }
                }
            }
        }

        currentOrder.addSandwich(sandwich);
        updateQuantityMap(sandwich.getType(), itemMap);

        System.out.println();
        System.out.println("Your sandwich order is complete.");
        System.out.println("\n\nSaving your order....");

        try
        {
            TimeUnit.SECONDS.sleep(2);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println("Your sandwich order is complete.");
        System.out.println("\n\nSaving your order....");
        System.out.println(ColorCodes.YELLOW + "===================================================="+ColorCodes.RESET);

        orderScreen();
    }


    private void AddDrinks() //prompts user to add drinks to the current order
    {
        List<Drinks> drinksList = InventoryManager.loadDrinks();

        String lastPrintedType = "";

        String size = getUserInputString("Select drink size (S, M ,L): ");
        System.out.println(ColorCodes.YELLOW + "Drinks" + ColorCodes.RESET);

        for (int i = 0; i < drinksList.size(); i++)
        {
            Drinks drinks = drinksList.get(i);
            String currentType = drinks.getType();

            if (!currentType.equals(lastPrintedType))
            {
                System.out.println("\t" + (i + 1) + ". " + currentType);
                lastPrintedType = currentType;
            }
        }

        String d = getUserInputString("Select your drink: ");

        int selectedNumber = Integer.parseInt(d);

        if (selectedNumber >= 1 && selectedNumber <= drinksList.size())
        {
            Drinks selectedDrink = drinksList.get(selectedNumber - 1);
            Drinks drinks = new Drinks(selectedDrink.getType(), size);
            currentOrder.addDrink(drinks);
            updateQuantityMap(drinks.getType(), itemMap);
        }
        else
        {
            System.out.println("Invalid option selected.");
        }

        boolean addMoreItems = true;
        while (addMoreItems)
        {
            String addMoreOption = getUserInputString("Do you want to add another drink? (y/n): ");

            if (!addMoreOption.equalsIgnoreCase("y")) //allows for extra items to be added
            {
                addMoreItems = false;
            }
            else
            {
                size = getUserInputString("Select drink size (S, M ,L): ");
                String dr = getUserInputString("Select your drink: ");

                selectedNumber = Integer.parseInt(dr);

                if (selectedNumber >= 1 && selectedNumber <= drinksList.size())
                {
                    Drinks selectedDrink = drinksList.get(selectedNumber - 1);
                    Drinks drinks = new Drinks(selectedDrink.getType(), size);
                    currentOrder.addDrink(drinks);
                    updateQuantityMap(drinks.getType(), itemMap);
                }
                else
                {
                    System.out.println("Invalid option selected.");
                }
            }
        }

        System.out.println("\n\nSaving your order....");
        System.out.println(ColorCodes.YELLOW + "===================================================="+ColorCodes.RESET);

        try
        {
            TimeUnit.SECONDS.sleep(2);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        orderScreen();
    }


    private void AddChips()
    {
        List<Chips> chipsList = InventoryManager.loadChips();
        System.out.println(ColorCodes.YELLOW + "Chips" + ColorCodes.RESET);

        String lastPrintedType = "";

        for (int i = 0; i < chipsList.size(); i++)
        {
            Chips chips = chipsList.get(i);
            String currentType = chips.getType();

            if (!currentType.equals(lastPrintedType))
            {
                System.out.println("\t" + (i + 1) + ". " + currentType);
                lastPrintedType = currentType;
            }
        }

        String c = getUserInputString("Select your Chips: ");

        int selectedNumber = Integer.parseInt(c);

        if (selectedNumber >= 1 && selectedNumber <= chipsList.size())
        {
            Chips selectedChip = chipsList.get(selectedNumber - 1);
            Chips chip = new Chips(selectedChip.getType());
            currentOrder.addChip(chip);
            updateQuantityMap(chip.getType(), itemMap);
        }
        else
        {
            System.out.println("Invalid option selected.");
        }

        boolean addMoreItems = true;
        while (addMoreItems)
        {
            String addMoreOption = getUserInputString("Do you want to add another chip? (y/n): ");

            if (!addMoreOption.equalsIgnoreCase("y"))
            {
                addMoreItems = false;
            }
            else
            {
                String ch = getUserInputString("Select your Chips: ");

                selectedNumber = Integer.parseInt(ch);

                if (selectedNumber >= 1 && selectedNumber <= chipsList.size())
                {
                    Chips selectedChip = chipsList.get(selectedNumber - 1);
                    Chips chip = new Chips(selectedChip.getType());
                    currentOrder.addChip(chip);
                    updateQuantityMap(chip.getType(), itemMap);
                }
                else
                {
                    System.out.println("Invalid option selected.");
                }
            }
        }

        System.out.println("\n\nSaving your order....");
        System.out.println(ColorCodes.YELLOW + "===================================================="+ColorCodes.RESET);

        try
        {
            TimeUnit.SECONDS.sleep(2);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        orderScreen();
    }

    private void updateQuantityMap(String itemName, Map<String, Integer> quantityMap)
    {
        if (quantityMap.containsKey(itemName))
        {
            int currentQuantity = quantityMap.get(itemName);
            quantityMap.put(itemName, currentQuantity + 1);
        }
        else
        {
            quantityMap.put(itemName, 1);
        }
    }


    private void CheckOut()
    {
        if(currentOrder == null)
        {
            System.out.println("No active order. Please start a new order.");
            return;
        }

        int quantity;
        System.out.println("Order details:");
        ReceiptManager receiptManager = new ReceiptManager(currentOrder);
        receiptManager.saveReceipt();
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.printf("%-5s %-10s %-30s %s \n", "Qty", "Size", "Item", "Price");
        System.out.println("--------------------------------------------------------------------------------------");

        for(Sandwich item : currentOrder.getSandwiches())
        {
            quantity = itemMap.getOrDefault(item.getType(), 0);
            System.out.println(quantity + item.getDescription());
        }

        // list drinks
        Map<String, Integer> printedItems = new HashMap<>();

        for (Drinks drink : currentOrder.getDrinks())
        {
            String itemKey = drink.getType() + drink.getSize();

            // Check if the item has already been printed
            if (printedItems.containsKey(itemKey))
            {
                continue; // Skip this iteration
            }

            printedItems.put(itemKey, 1);

            quantity = itemMap.getOrDefault(drink.getType(), 0);
            System.out.println(quantity + drink.getDrinkDetails());
        }

        // list chips
        for(Chips chips: currentOrder.getChips())
        {
            String itemKey = chips.getType();

            if (printedItems.containsKey(itemKey))
            {
                continue;
            }

            printedItems.put(itemKey,1);

            quantity = itemMap.getOrDefault(chips.getType(), 0);
            System.out.println(quantity + chips.getChipsDetails());
        }

        double totalCost = currentOrder.getTotalPrice();

        System.out.println("Total cost: $ " + totalCost);
        System.out.println("======================================================================================");
        System.out.println();
        System.out.println("Order placed successfully!");

        try
        {
            TimeUnit.SECONDS.sleep(2);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        // clear out the order
        currentOrder = new Order();
        orderScreen();
    }
}
