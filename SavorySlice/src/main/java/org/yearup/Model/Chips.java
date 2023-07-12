package org.yearup.Model;

public class Chips
{
    private final String type;

    public Chips(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }

    public double getPrice()
    {
        return 1.50;
    }
    public String getChipsDetails()
    {
        return String.format("%-5s %-8s %-30s $ %.2f \n", "", "", type, getPrice());
    }
}