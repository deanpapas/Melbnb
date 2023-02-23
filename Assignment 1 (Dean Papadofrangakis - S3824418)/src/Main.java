/*
 * Main
 * 
 * V2.0
 *
 * 29/03/2022
 */

import java.util.Scanner;
import java.util.*;

/*
 * The Main class is the entry to the Melbnb system. It allows the user to select how they would like to search for a property
 */
public class Main {
    public static void main(String[] args) throws Exception {

        // Opening scanner for user choices
        Scanner scanner = new Scanner(System.in);

        // Home Menu Loop
        boolean MenuWhileSwitch = true;
        while (MenuWhileSwitch == true) {

            System.out.println();
            homeMenu();

            // Validate User Input for Home Menu Choice
            int UserChoice;
            while (true) {

                try {
                    UserChoice = scanner.nextInt();
                    if ((UserChoice >= 1) && (UserChoice <= 4)) {
                        break;
                    }
                    System.out.println("Please Enter a Menu Option (1-4)!");

                } catch (InputMismatchException e) {
                    System.out.println("Please Enter Numbers Only!");
                    scanner.nextLine(); 
                }
            }

            // Home Menu Choice Switch
            switch (UserChoice) {

                case 1: // Location Search
                    MenuSystem ls = new MenuSystem();
                    ls.locationSearch();
                    break;

                case 2: // Type Search
                    MenuSystem ts = new MenuSystem();
                    ts.typeSearch();
                    break;

                case 3: // Rating Filter
                    MenuSystem rs = new MenuSystem();
                    rs.ratingSearch();
                    break;

                case 4: // Exit
                    MenuWhileSwitch = false;
                    break;

            }

        }

        // Close Scanner and Exit Program
        scanner.close();
        System.exit(0);

    }

    // Home Menu Visual
    private static void homeMenu() {
        System.out.println("===============");
        System.out.printf("%10s\n", "Melbnb");
        System.out.println("===============");
        System.out.println("    1) Search by location");
        System.out.println("    2) Browse by type of place");
        System.out.println("    3) Filter by rating");
        System.out.println("    4) Exit");
        System.out.print("Please select an option: ");
    }

}
