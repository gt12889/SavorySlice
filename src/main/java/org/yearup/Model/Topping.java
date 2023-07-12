package org.yearup.Model;


public abstract class Topping
{
    private final String type;
    private String size;

    public Topping(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }

    public void setSize(String size)
    {
        this.size = size;
    }

    public String getSize()
    {
        return size;
    }

    public abstract double getPrice();

}
