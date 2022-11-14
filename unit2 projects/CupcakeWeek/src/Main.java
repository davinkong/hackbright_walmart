import java.util.*;

public class Main {
    public static void main(String[] args) {
        //create a new ArrayList which contains Cupcake objects and name it cupcakeMenu
        ArrayList<Cupcake> cupcakeMenu = new ArrayList<Cupcake>();

        //Create a new Cupcake object named cupcake.
        Cupcake cupcake = new Cupcake();

        //Create a new RedVelvet object named redVelvet.
        RedVelvet redVelvet = new RedVelvet();

        //Create a new Chocolate object named chocolate
        Chocolate chocolate = new Chocolate();

        System.out.println("We are in the middle of creating the cupcake menu. We currently have three cupcakes on the menu but we need to decide on pricing.");

        Scanner input = new Scanner(System.in);

        //regular cupcake
        System.out.println("\nWe are deciding on the price for our standard cupcake. Here is the description: ");
        cupcake.type();
        System.out.println("How much would you like to charge for the cupcake? (Input a numerical number taken to 2 decimal places)");
        String priceText = input.nextLine();
        double price = Double.parseDouble(priceText);
        cupcake.setPrice(price);

        //redVelvet cupcake
        System.out.println("\nWe are deciding on the price for our Red Velvet cupcake. Here is the description: ");
        redVelvet.type();
        System.out.println("How much would you like to charge for the red velvet cupcake? (Input a numerical number taken to 2 decimal places)");
        String priceTextRedVelvet = input.nextLine();
        double redVelvetPrice = Double.parseDouble(priceTextRedVelvet);
        redVelvet.setPrice(redVelvetPrice);

        //chocolate cupcake
        System.out.println("\nWe are deciding on the price for our chocolate cupcake. Here is the description: ");
        chocolate.type();
        System.out.println("How much would you like to charge for the chocolate cupcake? (Input a numerical number taken to 2 decimal places)");
        String priceTextChocolate = input.nextLine();
        double chocolatePrice = Double.parseDouble(priceTextChocolate);
        chocolate.setPrice(chocolatePrice);

        cupcakeMenu.add(cupcake);
        cupcakeMenu.add(redVelvet);
        cupcakeMenu.add(chocolate);


        //Project part2 Soda Machine

        //Create a new ArrayList which contains Drink objects and name it drinkMenu
        ArrayList<Drink> drinkMenu = new ArrayList<Drink>();

        //Create a new Drink object named water
        Drink water = new Drink();

        //Create a new Soda object named soda.
        Soda soda = new Soda();

        //Create a new Milk object named milk.
        Milk milk = new Milk();


        //water pricing
        System.out.println("\nWe are deciding on the price for our water. Here is the description: ");
        water.type();
        System.out.println("How much would you like to charge for the water? (Input a numerical number taken to 2 decimal places)");
        String priceTextWater = input.nextLine();
        double waterPrice = Double.parseDouble(priceTextWater);
        water.setPrice(waterPrice);


        //soda pricing
        System.out.println("\nWe are deciding on the price for our soda. Here is the description: ");
        soda.type();
        System.out.println("How much would you like to charge for the soda? (Input a numerical number taken to 2 decimal places)");
        String priceTextSoda = input.nextLine();
        double sodaPrice = Double.parseDouble(priceTextSoda);
        soda.setPrice(sodaPrice);

        //milk pricing
        System.out.println("\nWe are deciding on the price for our milk. Here is the description: ");
        milk.type();
        System.out.println("How much would you like to charge for the milk? (Input a numerical number taken to 2 decimal places)");
        String priceTextMilk = input.nextLine();
        double milkPrice = Double.parseDouble(priceTextMilk);
        milk.setPrice(milkPrice);

        drinkMenu.add(water);
        drinkMenu.add(soda);
        drinkMenu.add(milk);

        new Order(cupcakeMenu, drinkMenu);
        input.close();


    }

    static class Cupcake{
        public double price;

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void type(){
            System.out.println("A basic, generic cupcake, with vanilla frosting.");
        }
    }

    static class RedVelvet extends Cupcake{
        public void type(){
            System.out.println("A red velvet based cupcake, with cream cheese frosting.");
        }
    }

    static class Chocolate extends Cupcake{
        public void type(){
            System.out.println("A chocolate based cupcake, with chocolate frosting.");
        }
    }

    static class Drink{
        public double price;

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void type(){
            System.out.println("A bottle of water");
        }
    }

    static class Soda extends Drink{
        public void type(){
            System.out.println("A bottle of soda");
        }
    }

    static class Milk extends Drink{
        public void type(){
            System.out.println("A bottle of milk");
        }
    }


}