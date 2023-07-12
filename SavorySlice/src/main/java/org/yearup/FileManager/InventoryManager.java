package org.yearup.FileManager;

import org.yearup.Model.*;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager

    //loads all the item options into inventory
{
    public static List<Sandwich> loadSandwiches()
    {
        List<Sandwich> sandwiches = new ArrayList<>();
        sandwiches.add(new Sandwich("White", "4"));
        sandwiches.add(new Sandwich("White", "8"));
        sandwiches.add(new Sandwich("White", "12"));
        sandwiches.add(new Sandwich("Wheat", "4"));
        sandwiches.add(new Sandwich("Wheat", "8"));
        sandwiches.add(new Sandwich("Wheat", "12"));
        sandwiches.add(new Sandwich("Rye", "4"));
        sandwiches.add(new Sandwich("Rye", "8"));
        sandwiches.add(new Sandwich("Rye", "12"));
        sandwiches.add(new Sandwich("Wrap", "4"));
        sandwiches.add(new Sandwich("Wrap", "8"));
        sandwiches.add(new Sandwich("Wrap", "12"));
        return sandwiches;
    }
    public static List<Meat> loadMeats()
    {
        List<Meat> meats = new ArrayList<>();
        meats.add(new Meat("Steak"));
        meats.add(new Meat("Ham"));
        meats.add(new Meat("Salami"));
        meats.add(new Meat("Brisket"));
        meats.add(new Meat("Turkey"));
        meats.add(new Meat("Roast Beef"));
        meats.add(new Meat("Chicken"));
        meats.add(new Meat("Bacon"));
        return meats;
    }
    public static List<Cheese> loadCheese()
    {
        List<Cheese> cheese = new ArrayList<>();
        cheese.add(new Cheese("American"));
        cheese.add(new Cheese("Provolone"));
        cheese.add(new Cheese("Mozzarella"));
        cheese.add(new Cheese("Cheddar"));
        cheese.add(new Cheese("Swiss"));
        return cheese;
    }
    public static List<RegularTopping> loadRegularToppings()
    {
        List<RegularTopping> regularToppings = new ArrayList<>();
        regularToppings.add(new RegularTopping("Lettuce"));
        regularToppings.add(new RegularTopping("Peppers"));
        regularToppings.add(new RegularTopping("Onions"));
        regularToppings.add(new RegularTopping("Tomatoes"));
        regularToppings.add(new RegularTopping("Jalapenos"));
        regularToppings.add(new RegularTopping("Cucumbers"));
        regularToppings.add(new RegularTopping("Pickles"));
        regularToppings.add(new RegularTopping("Olives"));
        regularToppings.add(new RegularTopping("Guacamole"));
        regularToppings.add(new RegularTopping("Mushrooms"));
        return regularToppings;
    }
    public static List<Sauces> loadSauces()
    {
        List<Sauces> sauces = new ArrayList<>();
        sauces.add(new Sauces("Mayo"));
        sauces.add(new Sauces("Mustard"));
        sauces.add(new Sauces("Ketchup"));
        sauces.add(new Sauces("Ranch"));
        sauces.add(new Sauces("Thousand Islands"));
        sauces.add(new Sauces("Vinaigrette"));
        return sauces;
    }
    public static List<Sides> loadSides()
    {
        List<Sides> sides = new ArrayList<>();
        sides.add(new Sides("Au Jus"));
        sides.add(new Sides("Sauce"));
        sides.add(new Sides("SavorySlice Official"));
        return sides;
    }
    public static List<Drinks> loadDrinks()
    {
        List<Drinks> drinks = new ArrayList<>();
        drinks.add(new Drinks("Coke", "small"));
        drinks.add(new Drinks("Coke", "medium"));
        drinks.add(new Drinks("Coke", "large"));
        drinks.add(new Drinks("Diet Coke", "small"));
        drinks.add(new Drinks("Diet Coke", "medium"));
        drinks.add(new Drinks("Diet Coke", "large"));
        drinks.add(new Drinks("Sweet Tea", "small"));
        drinks.add(new Drinks("Sweet Tea", "medium"));
        drinks.add(new Drinks("Sweet Tea", "large"));
        drinks.add(new Drinks("Sprite", "small"));
        drinks.add(new Drinks("Sprite", "medium"));
        drinks.add(new Drinks("Sprite", "large"));
        drinks.add(new Drinks("Unsweet Tea", "small"));
        drinks.add(new Drinks("Unsweet Tea", "medium"));
        drinks.add(new Drinks("Unsweet Tea", "large"));
        drinks.add(new Drinks("Lemonade", "small"));
        drinks.add(new Drinks("Lemonade", "medium"));
        drinks.add(new Drinks("Lemonade", "large"));
        drinks.add(new Drinks("Dr Pepper", "small"));
        drinks.add(new Drinks("Dr Pepper", "medium"));
        drinks.add(new Drinks("Dr Pepper", "large"));
        drinks.add(new Drinks("Diet Dr Pepper", "small"));
        drinks.add(new Drinks("Diet Dr Pepper", "medium"));
        drinks.add(new Drinks("Diet Dr Pepper", "large"));
        return drinks;
    }
    public static List<Chips> loadChips()
    {
        List<Chips> chips = new ArrayList<>();
        chips.add(new Chips("Munchos"));
        chips.add(new Chips("Baked Lays"));
        chips.add(new Chips("Pringles"));
        chips.add(new Chips("Ruffles"));
        chips.add(new Chips("Lay's"));
        chips.add(new Chips("Doritos"));
        chips.add(new Chips("Funyuns"));
        chips.add(new Chips("French fries"));
        chips.add(new Chips("Cookies"));
        chips.add(new Chips("Miss Vickie's Jalapeno"));
        return chips;
    }
}
