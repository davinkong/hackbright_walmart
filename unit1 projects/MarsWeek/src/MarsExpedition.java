import java.util.*;

public class MarsExpedition {
    public MarsExpedition() throws InterruptedException {

        Scanner input = new Scanner(System.in);

        System.out.println("Booting up...");
        Thread.sleep(1000);
        System.out.println("...");
        Thread.sleep(1000);
        System.out.println("...");
        Thread.sleep(1000);
        System.out.println("Ready\n");

        /**
         * Get user's name and greet
         */
        System.out.println("Please enter your name: ");
        String name = input.nextLine();
        System.out.println("Hi, "+ name + " - Welcome to the Expedition prep program." +
                " Are you ready to head out into the new world? \nType Y or N");
        String ready = input.next();
        if(ready.equalsIgnoreCase("Y")){
            System.out.println("I knew you would say that. You are team leader for a reason.\n");
        } else if (ready.equalsIgnoreCase("N")) {
            System.out.println("Too bad you are team leader. You have to go.\n");
        }

        /**
         * Team setup
         */
        System.out.println("How many people would you want to add to your team?");
        int teamSize = input.nextInt();
        input.nextLine();
        if(teamSize > 2){
            System.out.print("That’s way to many people. ");
            teamSize = 2;
            System.out.println("We can only send " +teamSize+ " more members.\n");
        } else if (teamSize < 2) {
            System.out.print("That’s not enough. ");
            teamSize = 2;
            System.out.println("You will need " +teamSize+ " more members.\n");

        } else if (teamSize == 2){
            System.out.println("Perfect number!\n");
        }

        /**
         * Snack choice
         */
        System.out.println("You are allowed to bring one snack with you. What do you want to bring?");
        String snack = input.nextLine();
        System.out.println("Nice choice, you will be bringing a "+snack+ " with you.\n");


        /**
         * Choose a vehicle
         */
        System.out.println("Please choose your vehicle, by entering 'a', 'b', or 'c'. ");
        System.out.println("a. Toyota Tacoma");
        System.out.println("b. Lexus NX 300");
        System.out.println("c. Honda Accord");
        String vehicle = input.next();
        String vehicleChoice = "";
        switch (vehicle){
            case "a", "A":
                vehicleChoice = "Toyota Tacoma";
                System.out.println(vehicleChoice + "\n" );
                break;
            case "b", "B":
                vehicleChoice = "Lexus NX 300";
                System.out.println(vehicleChoice + "\n");
                break;
            case "c", "C":
                vehicleChoice = "Honda Accord";
                System.out.println(vehicleChoice + "\n");
                break;
            default:
                System.out.println("Your feet \n");
        }

        /**
         * Final message
         */
        System.out.println("Hi "+ name + ". Your Mars Expedition is ready. \n"
                            + "You have " + teamSize+ " other members to join your team. \n"
                            + "You will also bring a " + snack+ " with you. \n"
                            + "A "+ vehicleChoice + " is your vehicle.\n");
        Thread.sleep(2000);
        System.out.println("Ready...");
        Thread.sleep(2000);
        System.out.println("5...");
        Thread.sleep(500);
        System.out.println("4...");
        Thread.sleep(500);
        System.out.println("3...");
        Thread.sleep(500);
        System.out.println("2...");
        Thread.sleep(500);
        System.out.println("1...");
        Thread.sleep(500);
        System.out.println("Go!\n");

    }


}
