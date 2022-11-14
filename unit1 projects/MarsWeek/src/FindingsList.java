import java.util.*;

import javax.swing.text.html.HTMLDocument;

public class FindingsList {

    public FindingsList() throws InterruptedException {

        Scanner scan = new Scanner(System.in);
        /**
         * Storing samples
         */
        Thread.sleep(500);
        System.out.println("Welcome back!\n");

        ArrayList<String> storing = new ArrayList<String>();
        storing.add("rock");
        storing.add("weird rock");
        storing.add("smooth rock");
        storing.add("not rock");

        System.out.println("Everything is downloaded: " + storing);
        System.out.println("\nThere is non-rock on the list, we need to remove it!");
        storing.remove("not rock");
        System.out.println("\n" + storing + "\nPerfect!");

        /**
         * Fossils
         */
        Thread.sleep(1000);
        HashMap<String, String> fossils = new HashMap<>();
        fossils.put("Bird Fossil", "The fossil has wings implying it was capable of flight");
        fossils.put("Fish Fossil", "The fossil is vaguely fish shaped implies there was once water");
        fossils.put("Tooth Fossil", "The tooth from an unknown fossil");
        System.out.println("Fossil data downloaded.\n");

        System.out.println("\nWhich of the fossils would you like to learn more about? \nType: Bird, Fish, or Tooth: \n");
        String chooseFossil = scan.nextLine();
        if (chooseFossil.equalsIgnoreCase("Bird")) {
            System.out.println("Fossil: "+ chooseFossil +"\nDescription: " + fossils.get("Bird Fossil"));
        } else if (chooseFossil.equalsIgnoreCase("Fish")) {
            System.out.println("Fossil: "+ chooseFossil +"\nDescription: "+ fossils.get("Fish Fossil"));
        } else if (chooseFossil.equalsIgnoreCase("Tooth")) {
            System.out.println("Fossil: "+ chooseFossil +"\nDescription: "+ fossils.get("Tooth Fossil"));
        }

        /**
         * Special supply lists
         */
        Thread.sleep(700);

        HashSet<String> supplies = new HashSet<>();
        supplies.add("Food");
        supplies.add("Water");
        supplies.add("Gum");
        Iterator itrBefore = supplies.iterator();
        System.out.println("\nSupplies Before Expedition: ");
        while (itrBefore.hasNext()) {
            System.out.println(itrBefore.next());

        }

        supplies.remove("Food");
        Iterator itrAfter = supplies.iterator();
        System.out.println("\nSupplies After Expedition: ");
        while (itrAfter.hasNext()) {
            System.out.println(itrAfter.next());
        }
    }


}
