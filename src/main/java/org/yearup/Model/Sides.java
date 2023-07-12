package org.yearup.Model;

public class Sides extends Topping
{
    public Sides(String type)
    {
        super(type);
    }

    @Override
    public double getPrice()
    {
        return 0;
    }
}


