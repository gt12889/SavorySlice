package org.yearup.Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order
{
    private final List<Sandwich> sandwiches;
    private final List<Chips> chips;
    private final List<Drinks> drinks;

    public Order()
    {
        sandwiches = new ArrayList<>();
        chips = new ArrayList<>();
        drinks = new ArrayList<>();
    }

    public List<Sandwich> getSandwiches()
    {
        return sandwiches;
    }

    public List<Chips> getChips()
    {
        return chips;
    }

    public List<Drinks> getDrinks()
    {
        return drinks;
    }

    public double getTotalPrice()
    {
        double totalPrice = 0.0;

        for (Sandwich sandwich : sandwiches)
        {
            totalPrice += sandwich.getSandwichPrice();
        }

        // Calculate price for chips
        for (Chips chip : chips)
        {
            totalPrice += chip.getPrice();
        }

        // Calculate price for drinks
        for (Drinks drink : drinks)
        {
            totalPrice += drink.getPrice();
        }

        return totalPrice;
    }


    public static String getOrderNumber()
    {
        LocalDateTime currentDateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        String orderNumber = currentDateTime.format(formatter);

        System.out.println("Order Number: " + orderNumber);
        return orderNumber;
    }

    public void addSandwich(Sandwich sandwich)
    {
        this.sandwiches.add(sandwich);
    }

    public void addDrink(Drinks drink)
    {
        this.drinks.add(drink);
    }

    public void addChip(Chips chips)
    {
        this.chips.add(chips);
    }
}
