package org.yearup.Model;

public class Sauces extends Topping
{
    public Sauces(String type)
    {
        super(type);
    }

    @Override
    public double getPrice()
    {
        return 0;
    }
}
