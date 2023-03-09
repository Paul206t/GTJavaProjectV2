import java.util.Scanner;

public class GameLogic {

    //Neccesary variables/assignments
    static Scanner scan = new Scanner(System.in);
    static int carCrash = 0;

    public static void mainMenu() {

        //Provide options to player
        System.out.println("\nMain Menu \n");
        System.out.println("1. Garage");
        System.out.println("2. Race");
        System.out.println("3. Exit");
        System.out.print("\nPlease choose your selection: ");
        int mainMenuSelect = scan.nextInt();

        //Switch-case to define what happens based on user input
        switch (mainMenuSelect) {
            case 1:
                System.out.println("call chooseCar()");
                break;
            case 2:
                System.out.println("call pickRace()");
                laps();
                break;
            case 3:
                System.out.println("\nThanks for playing!");
                System.exit(0);
                break;
        }
    }


    public static void laps() {
        // Asking for number of laps
        System.out.print("\nEnter the number of laps in this race: ");
        int numLaps = scan.nextInt();

        if (numLaps > 10) {
            System.out.println("That's a lot of laps, you should probably dial it back a bit. Let's try 10 or less okay? ");
            laps();
        } else if (numLaps < 1) {
            System.out.println("You've put in less than 1. Let's try this again please. ");
            laps();
        } else {
            // Asking for each lap time
            System.out.println("Please input how many seconds each one of your laps were. \n");
            // Created double type array to store size of it based on what was entered for numLaps
            double[] lapTimes = new double[numLaps];

            // For loop to ask for each Lap time only up to the number of laps that was inputted (lapTimes.length)
            // and stores each lap time that's been input in each next iterated element of the lapTimes Array
            for (int i = 0; i < lapTimes.length; i++) {
                System.out.print("Lap time: ");
                lapTimes[i] = scan.nextDouble();
            }

            // Sets fastest lap initially to first element of lapTimes array
            double fastestTime = lapTimes[0];

            // For loop to compare each element of the array to the next until it gets to the end and sets
            // fastestTime from that element of the lapTimes array, int i starts at index 1 because fastestTime
            // was already set to index 0 for comparison
            for (int i = 1; i < lapTimes.length; i++) {
                if (lapTimes[i] < fastestTime) {
                    fastestTime = lapTimes[i];
                }
            }

            // Print fastestTime
            if (carCrash == 1) {
                System.out.println("\nYou crashed at the finish line because you were driving a 1972 AMC Gremlin.");
                System.out.print("Do ywe have a pre-need funeral policy on file in the event that your loved ones are left behind (y/n)? ");
                String funeralConfirm = scan.next();

                if (funeralConfirm.equals("y") || funeralConfirm.equals("yes") || funeralConfirm.equals("Y") || funeralConfirm.equals("Yes")) {
                    System.out.println("\nGreat! We will be contacting your family shortly. ");
                } else {
                    System.out.println("\nOur sponsor, Hamilton Funeral Home will be contacting your family shortly to talk about at-need arrangements. ");
                }
            } else {
                System.out.format("\nYour fastest lap was: %.1f seconds.\n", fastestTime);
                // Get sum of all lap times and calculate + print the average lap time
                double sumLaps = 0;
                double lengthLapTimes = lapTimes.length;
                for (int i = 0; i < lapTimes.length; i++) {
                    sumLaps += lapTimes[i];
                }
                double avgLapTimes = sumLaps / lengthLapTimes;
                System.out.format("Your average lap time was: %.1f seconds.\n", avgLapTimes);
            }
        }
    }
}
