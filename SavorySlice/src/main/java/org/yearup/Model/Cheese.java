package org.yearup.Model;

public class Cheese extends Topping
{

    public Cheese(String type)
    {
        super(type);
    }


    @Override
    public double getPrice() //returns price of cheese varying by size of the sandwich
    {
        double price = 0.0;

        if (getSize().equalsIgnoreCase("4"))
        {
            price = .75;
        }
        else if (getSize().equalsIgnoreCase("8"))
        {
            price = 1.50;
        }
        else if (getSize().equalsIgnoreCase("12"))
        {
            price = 2.25;
        }

        return price;
    }
}
