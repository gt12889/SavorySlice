package org.yearup.Model;


import org.yearup.FileManager.InventoryManager;

import java.util.ArrayList;
import java.util.List;


public class Meat extends Topping
{


    public Meat(String type)
    {
        super(type);
    }

    @Override
    public double getPrice() //returns price of the meat varying by size of the sandwich
    {
        double price = 0.0;

        if (getSize().equalsIgnoreCase("4"))
        {
            price = 1.00;
        }
        else if (getSize().equalsIgnoreCase("8"))
        {
            price = 2.00;
        }
        else if (getSize().equalsIgnoreCase("12"))
        {
            price = 3.00;
        }

        return price;
    }









}
