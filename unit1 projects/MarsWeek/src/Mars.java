
public class Mars {
    public static void main(String[] args) throws InterruptedException {
        String colonyName = "Super Mars";
        int shipPopulation = 300;
        double shipFood = 4000.00;
        boolean landing = true;

        shipFood -= (shipPopulation * 0.75);
        shipFood -= (shipPopulation * 0.75);

        System.out.println(shipFood);

        shipFood = (shipFood * .50)+shipFood;
        shipPopulation += 5;


        String landingLocation = "The Ocean";
        if(landingLocation.equalsIgnoreCase("The Plain")){
            System.out.println("Bbzzz Landing on the Plain");
        }else {
            System.out.println("ERROR!!! Flight plan already set. Landing on the Plain");
        }
        landing = landingCheck(20);


        new GuessingGame();
        new MarsExpedition();
        new FindingsList();
    }

    public static boolean landingCheck(int minutesLeft) throws InterruptedException {
        for(int i=0; i<=minutesLeft; i++){
            if((i % 2 == 0) && (i % 3 == 0)){
                System.out.println("Keep Center");
            } else if (i % 2 == 0){
                System.out.println("Right");
            } else if (i % 3 == 0) {
                System.out.println("Left");
            }else {
                System.out.println("Calculating");
            }
            Thread.sleep(250);
        }
        System.out.println("Landed");
        return false;
    }
}
