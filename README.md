# DELIcious-Capstone-Team-3 - The Savory Slice ##

Point of Sales Application for DELI-cious :sandwich: 

This project is the point of sales application for the Savory Slice , a custom sandwich shop. Currently at the Savory Slice, our customers can fully customize their sandwich orders. Until recently, we have been managing all orders in person and are currently taking all orders on paper. But our business is growing, and we need a way to automate the order process (and eventually even make it available online) :chart_with_upwards_trend:. 

This application takes full advantage of Object Oriented Analysis and Design :gear:

In other words, we worked with OOP concepts throughout this process - creating classes and interfaces as necessary to build this solution. As we begin this project, we started by creating a class diagram of the classes and interfaces that we will need. This will be our starting point, and it may change as the application progresses throughout the week. We would keep our diagram current and updating with thourough communication between the team on Slack and constant commits and merges :pencil:. 

## Features :sparkles: 
The Point of Sales application for DELI-cious aims to provide the following features:

#### Order Management:
The application allows the creation, modification, and deletion of sandwich orders.
#### Customization:
Customers can fully customize their sandwich orders by selecting various ingredients, toppings, and condiments.
#### Pricing and Billing:
The application calculates the total price of the order based on the selected ingredients and provides an itemized bill for the customer.

#### Inventory Management:
The application keeps track of ingredient inventory, ensuring that ingredients are available for order.
#### Reporting: 
Generate reports on sales, popular ingredients, and other relevant statistics to assist in business analysis. The program will generate a copy of completed orders in a receipt txt file wit the current date and items for each order.

## Object-Oriented Analysis and Design :computer:
This project emphasizes the use of Object-Oriented Analysis and Design (OOAD) principles and concepts. The application makes effective use of classes, interfaces, and other OOP constructs. By leveraging OOAD, the application can achieve modularity, encapsulation, and extensibility, making it easier to maintain and enhance in the future.

### Class Diagram :pencil2:
The starting point for this project is to create a class diagram that outlines the necessary classes and interfaces. The class diagram serves as a blueprint for the application's structure and relationships between different components. It would be regularly updated and saved in the repository.

### Repository :file_folder:
This project utilizes a version control system, such as Git, to manage the source code and collaborate with other developers. The four of us worked with effective communication and collaboration -either through Zoom or the Slack workspace - to avoid any conflicts. 

#### Source code files: 
Implement the classes, interfaces, and other components based on the class diagram and project requirements.

#### Interesting piece of code:
The Topping class is an abstract class that serves as a base for specific types of toppings. It has member variables for the type and size of the topping, as well as methods to get and set the size. It also declares an abstract method to calculate the price, which subclasses must implement. The AddItems interface is a generic interface with a single method to add an item of any type to a collection. These are two recently learned concepts that we were able to succesffully implement to add toppings and sides.

Let's make ordering even more efficient and intuitive for our customers at the Savory Slice! :blush:

## Pictures: ##

![home-screen](https://github.com/gdzierzon/DELIcious-Capstone-Team-3/assets/130225802/56f784a3-0d72-4f78-ac77-257db217fcb5)

![sandwich](https://github.com/gdzierzon/DELIcious-Capstone-Team-3/assets/130225802/e2517beb-39b2-465c-84e6-a12a1a8dc43f)

![order](https://github.com/gdzierzon/DELIcious-Capstone-Team-3/assets/130225802/fde472bc-ed1a-4346-9d73-385b99ac100f)

![cheese](https://github.com/gdzierzon/DELIcious-Capstone-Team-3/assets/130225802/5803f958-bb56-423e-aa05-01c093424533)

![meats](https://github.com/gdzierzon/DELIcious-Capstone-Team-3/assets/130225802/593e025c-a3da-458d-b479-999ba3b45869)

![order create](https://github.com/gdzierzon/DELIcious-Capstone-Team-3/assets/130225802/ee377686-65c4-4ddc-a97a-1c99363a23a5)

![Chips](https://github.com/gdzierzon/DELIcious-Capstone-Team-3/assets/130225802/4a0571a0-b197-4fe0-8b19-5c072a7a3273)

![checkout](https://github.com/gdzierzon/DELIcious-Capstone-Team-3/assets/130225802/c1d31bbb-2fe7-4b5a-9461-eed42cccfa8e)

