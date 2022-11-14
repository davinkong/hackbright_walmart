import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Order {
    /**
     *  create a public constructor function named Order with the following parameters:
     *  an ArrayList of Cupcake objects named cupcakeMenu, and an ArrayList of Drink objects named drinkMenu
     * @param cupcakeMenu
     * @param drinkMenu
     */
    public Order(ArrayList<Main.Cupcake> cupcakeMenu, ArrayList<Main.Drink> drinkMenu) {
        System.out.println("Hello customer. Would you like to place an order? (Y or N)");
        Scanner input = new Scanner(System.in);
        String placeOrder = input.nextLine();
        ArrayList<Object> order = new ArrayList<Object>();
        if (placeOrder.equalsIgnoreCase("Y")) {
            order.add(LocalDate.now());
            order.add(LocalTime.now());
            System.out.println("Here is the menu.");
            System.out.println("CUPCAKES:");
            int itemNumber = 0;
            for (int i = 0; i < cupcakeMenu.size(); i++) {
                itemNumber++;
                System.out.println(itemNumber);
                //Output the type of cupcake at cupcakeMenu at i by calling the type() method.
                cupcakeMenu.get(i).type();
                //Print “Price: “ with the price being the price of that cupcake.
                System.out.println("Price: $" + cupcakeMenu.get(i).getPrice());
                System.out.println("\n");
            }
            System.out.println("DRINKS:");
            for (int i = 0; i < drinkMenu.size(); i++) {
                itemNumber++;
                System.out.println(itemNumber);
                //Output the type of drink at drinkMenu at i by calling the type() method.
                drinkMenu.get(i).type();
                //Print “Price: “ with the price being the price of that drink.
                System.out.println("Price: $" + drinkMenu.get(i).getPrice());
                System.out.println("\n");
            }

        } else {
            System.out.println("Have a nice day then.");
        }

        //Create a boolean variable named ordering and set it equal to true.
        boolean ordering = true;
        //Create a while loop that continues as long as the value of ordering is true.
        while (ordering) {
            System.out.println("What would you like to order? Please use the number associated with each item to order.");

            int orderChoice = input.nextInt();
            //Call input.nextLine() to correct the terminal scanner input location.
            input.nextLine();

            if (orderChoice == 1) {
                //add the first item from the cupcakeMenu ArrayList to the order ArrayList
                order.add(cupcakeMenu.get(0));
                System.out.println("Item added to order");
            } else if (orderChoice == 2) {
                // add the second item from the cupcakeMenu ArrayList to the order ArrayList
                order.add(cupcakeMenu.get(1));
                System.out.println("Item added to order");
            } else if (orderChoice == 3) {
                // add the third item from the cupcakeMenu ArrayList to the order ArrayList
                order.add(cupcakeMenu.get(2));
                System.out.println("Item added to order");
            } else if (orderChoice == 4) {
                // add the first item from the cupcakeMenu ArrayList to the order ArrayList
                order.add(drinkMenu.get(0));
                System.out.println("Item added to order");
            } else if (orderChoice == 5) {
                // add the second item from the cupcakeMenu ArrayList to the order ArrayList
                order.add(drinkMenu.get(1));
                System.out.println("Item added to order");
            } else if (orderChoice == 6) {
                // add the third item from the cupcakeMenu ArrayList to the order ArrayList
                order.add(drinkMenu.get(2));
                System.out.println("Item added to order");
            } else {
                System.out.println("Sorry, we don’t seem to have that on the menu.");
            }
            System.out.println("Would you like to continue ordering? (Y/N)");
            //Set the String object named placeOrder equal to input.nextLine().
            placeOrder = input.nextLine();
            if (!placeOrder.equalsIgnoreCase("Y")) {
                ordering = false;
            }
        }

        //Print the first item and second item in the order ArrayList.
        System.out.println(order.get(0));
        System.out.println(order.get(1));

        //Create a double variable named subtotal and initialize it to 0.0.
        double subtotal = 0.0;

        for (int i = 2; i < order.size(); i++) {
            //cupcake menu
            if (order.get(i) == cupcakeMenu.get(0)) {
                //Get the value of cupcakeMenu at index 0, and run the type() method on the Cupcake object.
                cupcakeMenu.get(0).type();
                //print the price of that cupcake
                System.out.println(cupcakeMenu.get(0).getPrice());
                //Set subtotal equal to subtotal plus the price of the cupcake.
                subtotal += cupcakeMenu.get(0).getPrice();
            } else if (order.get(i) == cupcakeMenu.get(1)) {
                //Get the value of cupcakeMenu at index 1, and run the type() method on the Cupcake object.
                cupcakeMenu.get(1).type();
                //print the price of that cupcake
                System.out.println(cupcakeMenu.get(1).getPrice());
                //Set subtotal equal to subtotal plus the price of the cupcake.
                subtotal += cupcakeMenu.get(1).getPrice();
            } else if (order.get(i) == cupcakeMenu.get(2)) {
                //Get the value of cupcakeMenu at index 2, and run the type() method on the Cupcake object.
                cupcakeMenu.get(2).type();
                //print the price of that cupcake
                System.out.println(cupcakeMenu.get(2).getPrice());
                //Set subtotal equal to subtotal plus the price of the cupcake.
                subtotal += cupcakeMenu.get(2).getPrice();
            }
            //drink menu
            else if (order.get(i) == drinkMenu.get(0)) {
                //Get the value of drinkMenu at index 0, and run the type() method on the drink object.
                drinkMenu.get(0).type();
                //print the price of that drink
                System.out.println(drinkMenu.get(0).getPrice());
                //Set subtotal equal to subtotal plus the price of the drink.
                subtotal += drinkMenu.get(0).getPrice();
            }else if (order.get(i) == drinkMenu.get(1)) {
                //Get the value of drinkMenu at index 1, and run the type() method on the drink object.
                drinkMenu.get(1).type();
                //print the price of that drink
                System.out.println(drinkMenu.get(1).getPrice());
                //Set subtotal equal to subtotal plus the price of the drink.
                subtotal += drinkMenu.get(1).getPrice();

            } else if (order.get(i) == drinkMenu.get(2)) {
                //Get the value of drinkMenu at index 2, and run the type() method on the drink object.
                drinkMenu.get(2).type();
                //print the price of that drink
                System.out.println(drinkMenu.get(2).getPrice());
                //Set subtotal equal to subtotal plus the price of the drink.
                subtotal += drinkMenu.get(2).getPrice();
            }
            System.out.println("subtotal: $" + subtotal+"\n");

            //call the constructor function for the CreateFile class.
            new CreateFile();

            // call the constructor function for the WriteToFile class, passing in the parameter order.
            new WriteToFile(order);
        }


    }
}

//Create a class named CreateFile
class CreateFile{
    public CreateFile(){
        try {
            //create a File object named salesData and set it equal to a new File object with the name “salesData.txt”
            File saleData = new File("saleData.txt");
            //Create an if statement with the parameter salesData.createNewFile().
            //.createNewFile() will return true if a new file is created.
            if (saleData.createNewFile()){
                //print “File created: “ and the name of the file
                System.out.println("File created: "+ saleData.getName());
            }else {
                System.out.println("File already exists");
            }
        }catch (IOException e){
            System.out.println("An error occurred");
        }
    }
}

//Create a class named WriteToFile
class WriteToFile{
    public WriteToFile(ArrayList<Object> order){
        try {
            /**
             * create a new FileWriter object named fw, and set it equal to new FileWriter object
             * whose constructor parameters are the name of the object,
             * “salesData.txt”, and the boolean true, which is an option that allows for appending to the file
             */
            FileWriter fw = new FileWriter("saleData.txt", true);

            /**
             * Create a new PrintWriter object named salesWriter, and set it equal to new PrintWriter object
             * whose constructor parameter is the FileWriter object fw created previously.
             */
            PrintWriter salesWriter = new PrintWriter(fw);

            //Iterate through each element in order using a for loop to print the values by calling the method
            for (int i=0; i<order.size(); i++){
                //print salesWriter object
                System.out.println(order.get(i));
            }
            //Close salesWriter so the writer cannot continue to be run.
            salesWriter.close();
            System.out.println("Successfully wrote to the file");
        }catch (IOException e){
            System.out.println("An error occurred");
        }

    }
}
