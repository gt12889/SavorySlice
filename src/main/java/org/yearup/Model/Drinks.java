package org.yearup.Model;

public class Drinks
{
    private final String size;
    private final String type;

    public Drinks(String type, String size)
    {
        this.type = type;
        this.size = size;
    }


    public String getType()
    {
        return type;
    }

    public String getSize()
    {
        return size;
    }


    public double getPrice()
    {
        double price = 0.0;

        if (getSize().equalsIgnoreCase("S"))
        {
            price = 2.00;
        }
        else if (getSize().equalsIgnoreCase("M"))
        {
            price = 2.50;
        }
        else if (getSize().equalsIgnoreCase("L"))
        {
            price = 3.00;
        }

        return price;
    }

    public String getDrinkDetails()
    {

        return String.format("%-5s %-8s %-30s $ %.2f \n", "", size.toUpperCase(), type, getPrice());

    }

}
