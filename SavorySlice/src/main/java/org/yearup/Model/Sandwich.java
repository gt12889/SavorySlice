package org.yearup.Model;

import java.util.ArrayList;
import java.util.List;


public class Sandwich implements AddItems<Topping>
{
    private List<Topping> toppings;
    String type;
    String size;
    String toasted;



    public Sandwich(String type, String size)
    {
        toppings = new ArrayList<>();

        this.type = type;
        this.size = size;
    }

    public Sandwich()
    {
        this.type = "White";
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getSize()
    {
        return size;
    }

    public void setSize(String size)
    {
        this.size = size;
    }

    public String getToasted()
    {
        if (toasted.equalsIgnoreCase("y"))
        {
            return "toasted";
        }
        else
        {
            return "";
        }
    }

    public double getPrice()
    {
        // calculate the price fo the sandwich
        double price = 5.5;

        if (size.equalsIgnoreCase("8"))
        {
            price = 7.0;
        }
        else if (size.equalsIgnoreCase("12"))
        {
            price = 8.5;
        }

        return price;
    }

    public double getSandwichPrice()
    {
        // calculate the price of the sandwich
        double totalPrice = getPrice();

        // loop through all the toppings and get the price
        int meatCount = 0;
        int cheeseCount = 0;

        for (Topping t : toppings)
        {
            if(t instanceof Meat m)
            {
                meatCount++;
                if (meatCount == 1)
                {
                    totalPrice += m.getPrice();
                }
                else
                {
                    totalPrice += (m.getPrice() + (m.getPrice() * 0.5));
                }
            }
            if(t instanceof Cheese c )
            {
                cheeseCount++;
                if (cheeseCount == 1)
                {
                    totalPrice += c.getPrice();
                }
                else
                {
                    totalPrice += (c.getPrice() + (c.getPrice() * 0.4));
                }
            }
        }

        return totalPrice;
    }

    public void setToasted(String toasted)
    {
        this.toasted = toasted;
    }


    public String getDescription()
    {   // loop through all toppings and display the name
        StringBuilder description = new StringBuilder();
        description.append(String.format("%7s\" %11s %-1s %-20s $ %.2f \n",size, type, getToasted(), "bread", getPrice()));

        for (Topping t : toppings)
        {
            if(t instanceof Meat m)
            {
                description.append(String.format("%-6s %-8s %-31s $ %.2f \n", "", "", m.getType(), m.getPrice()));
            }
            if(t instanceof Cheese c )
            {
                description.append(String.format("%-6s %-8s %-31s $ %.2f \n", "", "", c.getType(), c.getPrice()));
            }
            if(t instanceof RegularTopping r)
            {
                description.append(String.format("%-6s %-8s %-35s   %s \n", "", "", r.getType(), ""));
            }
            if(t instanceof Sauces s)
            {
                description.append(String.format("%-6s %-8s %-35s   %s \n", "", "", s.getType(), ""));
            }
            if(t instanceof Sides sd)
            {
                description.append(String.format("%-6s %-8s %-35s   %s \n", "", "", sd.getType(), ""));
            }
        }
        return description.toString();
    }

    @Override
    public void add(Topping topping)
    {
        topping.setSize(this.size);
        toppings.add(topping);
    }

    //adds topping depending on type and size
}



