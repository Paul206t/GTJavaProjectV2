import carpackage.car1;
import carpackage.car2;
import carpackage.car3;
import localepackage.race_locale1;
import localepackage.race_locale2;
import localepackage.race_locale3;
import java.util.Scanner;

public class GameLogic {

    //Variables/assignments
    static Scanner scan = new Scanner(System.in);
    static int carPurchased = 0;
    static int carCrash = 0;
    static int horsePower = 100;
    static String weatherCondition = "Sunny";

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
                chooseCar();
                break;
            case 2:
                pickRace();
                break;
            case 3:
                System.out.println("\nThanks for playing!");
                System.exit(0);
                break;
        }
    }


    public static void chooseCar() {

        // Print out the cars available to you
        System.out.println("\nThe following cars are available to you.");
        System.out.println("1. " + car1.name);
        System.out.println("2. " + car2.name);
        System.out.println("3. " + car3.name);
        System.out.print("\nPlease tell me which car you would like to drive: ");
        int carChosen = scan.nextInt();
        System.out.println(" ");

        // Switch statement to determine which car to assign you based on the number you chose
        switch (carChosen) {
            case 1:
                horsePower = car1.horsePower;
                System.out.println("You have chosen the " + car1.name);
                System.out.println("Your car has a horsepower of " + horsePower + ".");
                break;
            case 2:
                horsePower = car2.horsePower;
                System.out.println("You have chosen the " + car2.name);
                System.out.println("Your car has a horsepower of " + horsePower + ".");
                break;
            case 3:
                horsePower = car3.horsePower;
                System.out.println("You have chosen the " + car3.name);
                System.out.println("Your car has a horsepower of " + horsePower + ".");
                break;
            default:
                System.out.println("Because you can't follow directions I have given you a 1972 AMC Gremlin. Enjoy. ");
                carCrash = 1;
                break;
        }
        carPurchased = 1;
        mainMenu();
    }


    public static void pickRace() {

        String viewStats = "y";

        if(carPurchased == 0){
            System.out.println("\nYou don't have a car! ");
            mainMenu();
        }
        else
        {
            // Print choice of races available
            System.out.println("\nThe following tracks are available.");
            System.out.println("1. " + race_locale1.locale_name);
            System.out.println("2. " + race_locale2.locale_name);
            System.out.println("3. " + race_locale3.locale_name);
            System.out.print("\nPlease tell me where you would like to race: ");
            int raceChosen = scan.nextInt();
            System.out.println(" ");

            // Switch statement to determine which car to assign you based on the number you chose
            switch (raceChosen) {
                case 1:
                    System.out.println("You are now racing on " + race_locale1.locale_name);
                    System.out.print("\nWould you like to view stats of this track? (y/n) ");
                    viewStats = scan.next();
                    if (viewStats.equalsIgnoreCase("y") || viewStats.equalsIgnoreCase("yes")) {
                        System.out.println(race_locale1.locale_name + " is " + race_locale1.locale_length + " is kilometers long.");
                        System.out.println("The longitude and latitude is " + race_locale1.locale_longitude + race_locale1.locale_longitude_dir + " and " + race_locale1.locale_latitude + race_locale1.local_latitude_dir + ".");
                        System.out.println("The current weather condition is: " + weatherCondition);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    System.out.println("You are now racing on " + race_locale2.locale_name);
                    System.out.print("\nWould you like to view stats of this track? (y/n) ");
                    viewStats = scan.next();
                    if (viewStats.equalsIgnoreCase("y") || viewStats.equalsIgnoreCase("yes")) {
                        System.out.println(race_locale2.locale_name + " is " + race_locale2.locale_length + " is kilometers long.");
                        System.out.println("The longitude and latitude is " + race_locale2.locale_longitude + race_locale2.locale_longitude_dir + " and " + race_locale2.locale_latitude + race_locale2.local_latitude_dir + ".");
                        System.out.println("The current weather condition is: " + weatherCondition);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    System.out.println("You are now racing on " + race_locale3.locale_name);
                    System.out.print("\nWould you like to view stats of this track? (y/n) ");
                    viewStats = scan.next();
                    if (viewStats.equalsIgnoreCase("y") || viewStats.equalsIgnoreCase("yes")) {
                        System.out.println(race_locale3.locale_name + " is " + race_locale3.locale_length + " is kilometers long.");
                        System.out.println("The longitude and latitude is " + race_locale3.locale_longitude + race_locale3.locale_longitude_dir + " and " + race_locale3.locale_latitude + race_locale3.local_latitude_dir + ".");
                        System.out.println("The current weather condition is: " + weatherCondition);
                        break;
                    } else {
                        break;
                    }
            }
        }
        // Call the actual race
        laps();
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

                // Get user input to race again
                System.out.print("\nRace again? (y/n) ");
                String raceAgain = scan.next();
                if (raceAgain.equalsIgnoreCase("y") || raceAgain.equalsIgnoreCase("yes")) {
                    laps();
                }
                else {
                    mainMenu();
                }
            }
        }
    }
}
