package org.yearup.FileManager;


import org.yearup.Model.Chips;
import org.yearup.Model.Drinks;
import org.yearup.Model.Order;
import org.yearup.Model.Sandwich;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Calendar;

public class ReceiptManager
{
    private final Order order;


    public ReceiptManager(Order order)
    {
        this.order = order;
    }


    public void saveReceipt()
    {
        String fileName = "ReceiptFile/" + Order.getOrderNumber() + ".txt";

        try (FileWriter filewriter = new FileWriter(fileName);
            PrintWriter writer = new PrintWriter(filewriter))
        {

            // print receipt header
            LocalDate date = LocalDate.now();
            Calendar calendar = Calendar.getInstance();
            String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

                writer.println("Date: " + date + " " + days[calendar.get(Calendar.DAY_OF_WEEK) - 1]);
//                writer.println("Enter customer name: ");

            // print each sandwich
            for (Sandwich item : order.getSandwiches())
            {
                writer.println("Sandwich:" +item.getDescription()+ "\t\t"+ item.getPrice());
                // print each sandwich to the file
            }

            // print each drink
            for(Drinks drink : order.getDrinks()){
                writer.println("Drink: "+ drink.getSize()+"\t\t\t\t\t\t\t\t\t $" + drink.getPrice());
//                writer.println("Price: $" + drink.getPrice());
                writer.println();
            }
            // print each chip
            for(Chips chips : order.getChips())
            {
                writer.println("Chips:" + chips.getType()+"\t\t\t\t\t\t\t\t $" + chips.getPrice());
//                writer.println("Price: $" + chips.getPrice());
                writer.println();
            }

            // print the order total
            writer.println("Total Price: \t\t\t\t\t\t\t\t$ " + order.getTotalPrice());




        } catch (IOException e)
        {
            System.out.println("Some error occurred please try again");
        }
    }
}






