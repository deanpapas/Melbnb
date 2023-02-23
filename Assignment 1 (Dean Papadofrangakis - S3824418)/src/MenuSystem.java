/*
 * MenuSysem
 * 
 * V2.0
 *
 * 29/03/2022
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.io.*;

/*
 * The MenuSystem class provides the methods behind each menu selection in the main home menu.
 * It allows the user to search for properties 3 different ways and then book their chosen property.
 */
public class MenuSystem {

    // Declare Path for File
    String FilePath = "Melbnb.csv";

    // ByteArrayOutputStream
    ByteArrayOutputStream os = new ByteArrayOutputStream();

    // PrintStream
    PrintStream ps = new PrintStream(os);

    // Making ArrayList for Property Objects
    private ArrayList<Property> PropertyList = new ArrayList<Property>();

    // Create Array for Search Result Storage
    private ArrayList<Property> SearchResults = new ArrayList<Property>();

    // Opening Scanner
    private Scanner scanner = new Scanner(System.in);

    // Add Property Obejcts to ArrayList "PropertyList" from file "Melbnb.csv"
    public void propertyCreator(String path, PrintStream pcs) {

        try (Scanner filescanner = new Scanner(new File(path));) { // Opening scanner for Melbnb.csv file
            filescanner.nextLine(); // Skip first line
            while (filescanner.hasNext()) { // Loop until the last line (until line isnt empty)
                String line = filescanner.nextLine();
                String[] arrOfStr = line.split(",", 11); // Split line into array of 11 values
                PropertyList.add(new Property(arrOfStr[0], arrOfStr[1], arrOfStr[2], // Parse Array Values into object
                        arrOfStr[3], arrOfStr[4], Integer.parseInt(arrOfStr[5]), Double.parseDouble(arrOfStr[6]),
                        Double.parseDouble(arrOfStr[7]), Double.parseDouble(arrOfStr[8]),
                        Double.parseDouble(arrOfStr[9]),
                        Double.parseDouble(arrOfStr[10])));
            }

            filescanner.close(); // closing scanner

        } catch (NullPointerException e) {
            pcs.print("File is null.");
        } catch (FileNotFoundException e) {
            pcs.print("File not found.");
        }
    }

    // Search by Location
    public void locationSearch() {

        // Menu Visuals
        System.out.print("Please provide a location: ");

        // Reading and Writing in property Objects
        propertyCreator(FilePath, ps);

        // Take and Validate User Input
        String UserLocation;
        while (true) {
            try {
                UserLocation = scanner.next();
                if (UserLocation.matches("[a-zA-Z_]+")) {
                    break;
                }
                System.out.println("Please Enter Letters Only!");

            } catch (InputMismatchException e) {
                System.out.println("Please Enter Letters Only!");
                scanner.nextLine(); // needed to clear buffer
            }
        }

        // Loop through PropertyList to find properties that contain user input and
        // write them into SearchResults Arraylist
        for (int i = 0; i < PropertyList.size(); i++) {
            if (PropertyList.get(i).getlOCATION().toUpperCase().contains(UserLocation.toUpperCase())) {
                SearchResults.add(PropertyList.get(i));
            }
        }

        if (SearchResults.isEmpty()) { // Check if there were any search results
            System.out.println("Not Properties Matched Your Search!");
        } else {

            System.out.println("==============================");
            System.out.println("> Select from Results");
            System.out.println("==============================");
            printSearchResults(SearchResults);// Loop through SearchResults and print them for user

        }
    }

    // Search by Type
    public void typeSearch() {

        // Reading and Writing in property Objects
        propertyCreator(FilePath, ps);

        System.out.println("==============================");
        System.out.println("> Browse By Type of Place");
        System.out.println("==============================");
        System.out.println("    1) Private room");
        System.out.println("    2) Entire place");
        System.out.println("    3) Shared room");
        System.out.println("    4) Return to Main Menu");
        System.out.print("Please select an option: ");

        // Take and Validate User Input
        int UserType;
        while (true) {
            try {
                UserType = scanner.nextInt();
                if (UserType >= 1 && UserType <= 4) {
                    break;
                }
                System.out.println("Please Enter a Menu Option (1-4): ");

            } catch (InputMismatchException e) {
                System.out.println("Please Enter a Number");
                scanner.nextLine(); // needed to clear buffer
            }
        }

        // Switch case 1-4 for menu options
        switch (UserType) {

            case 1: // Find Properties with a Private Room
                System.out.println("==============================");
                System.out.println("> Select From Private Room List");
                System.out.println("==============================");

                // Add Properties with type Private Room to Search Results ArrayList
                for (int i = 0; i < PropertyList.size(); i++) {
                    if (PropertyList.get(i).gettYPE_OF_PLACE().contains(PropertyTypes.Types.TYPE1.toString())) {
                        SearchResults.add(PropertyList.get(i));
                    }
                }

                printSearchResults(SearchResults);
                break;

            case 2: // Find Properties with an Entire Place
                System.out.println("==============================");
                System.out.println("> Select From Entire Place List");
                System.out.println("==============================");

                // Add Properties with type Entire Place to Search Results ArrayList
                for (int i = 0; i < PropertyList.size(); i++) {
                    if (PropertyList.get(i).gettYPE_OF_PLACE().contains(PropertyTypes.Types.TYPE2.toString())) {
                        SearchResults.add(PropertyList.get(i));
                    }
                }

                printSearchResults(SearchResults);// Loop through SearchResults and print them for user
                break;

            case 3: // Find Properties with a Shared Room
                System.out.println("==============================");
                System.out.println("> Select From Shared Room List");
                System.out.println("==============================");

                // Add Properties with type Shared Room to Search Results ArrayList
                for (int i = 0; i < PropertyList.size(); i++) {
                    if (PropertyList.get(i).gettYPE_OF_PLACE().contains(PropertyTypes.Types.TYPE3.toString())) {
                        SearchResults.add(PropertyList.get(i));
                    }
                }

                printSearchResults(SearchResults);
                break;

            case 4: // Exit
                break;

        }

    }

    // Search by Rating
    public void ratingSearch() {

        // Reading and Writing in property Objects
        propertyCreator(FilePath, ps);

        System.out.print("Please provide the minimum rating: ");

        // Take and Validate User Input
        double UserRating;
        while (true) {
            try {
                UserRating = scanner.nextDouble();
                if (UserRating > 0 && UserRating <= 5) {
                    break;
                }
                System.out.println("Please Enter a Number between 0 and 5");

            } catch (InputMismatchException e) {
                System.out.println("Please Enter a Number between 0 and 5");
                scanner.nextLine();
            }
        }

        // Loop through ArrayList to find properties with raitng higher then or equal to
        // the user input and add them to
        // search results array list
        for (int i = 0; i < PropertyList.size(); i++) {
            if (PropertyList.get(i).getrATING() >= UserRating) {
                SearchResults.add(PropertyList.get(i));
            }
        }

        if (SearchResults.isEmpty()) { // Check if there were any search results
            System.out.println("Not Properties Matched Your Search!");
        } else {

            System.out.println("==============================");
            System.out.println("> Select From Matching List");
            System.out.println("==============================");
            printSearchResults(SearchResults);// Loop through SearchResults and print them for user

        }

    }

    // Booking Dates
    public void bookingDates(Property chosenproperty) {

        // Get Current Date
        LocalDate CurrentDate = LocalDate.now();

        // Create Formatter
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("==============================");
        System.out.println("> Provide Dates");
        System.out.println("==============================");
        System.out.print("Please Enter Check-In Date (dd/mm/yyyy): ");
        // Take and Validate User input as a future date
        LocalDate CheckInDate;
        while (true) {
            try {
                String CheckInString = scanner.next();
                CheckInDate = LocalDate.parse(CheckInString, dateFormat);
                if (CheckInDate.isAfter(CurrentDate)) {
                    break;
                }
                System.out.println("Please Enter A Future Date!");

            } catch (DateTimeParseException e) {
                System.out.println("Please Enter A Date (dd/mm/yyyy): ");
            }
        }

        System.out.print("Please Enter CheckOut Date (dd/mm/yyyy): ");

        // Take and Validate User input
        LocalDate CheckOutDate;
        while (true) {
            try {
                String CheckOutString = scanner.next();
                CheckOutDate = LocalDate.parse(CheckOutString, dateFormat);
                if (CheckOutDate.isAfter(CheckInDate)) {
                    break;
                }
                System.out.println("Please Enter A Date After Check In!");

            } catch (DateTimeParseException e) {
                System.out.println("Please Enter A Date (dd/mm/yyyy): ");
            }
        }

        Booking bookingDetails = bookingCalculation(chosenproperty, CheckInDate, CheckOutDate); // Creates Booking
                                                                                                // object based on User
                                                                                                // chosen property,
                                                                                                // check in date and
                                                                                                // check out date
        printBookingDetails(bookingDetails); // Prints details of the booking object
        bookingConfirmation(bookingDetails); // Asks user to confirm details within booking object

    }

    // Print SearchResults Arraylist
    public void printSearchResults(ArrayList<Property> SearchResults) {
        for (int i = 0; i < SearchResults.size(); i++) {
            System.out.printf("    %d) %s%n", (i + 1), SearchResults.get(i).getnAME());
        }
        System.out.printf("    %d) %s%n", (SearchResults.size() + 1), "Exit");
        System.out.print("Please select an option: ");

        // Take user input absed on options from search results
        int UserSearchChoice;
        while (true) {
            try {
                UserSearchChoice = scanner.nextInt();
                if ((UserSearchChoice >= 1) && (UserSearchChoice <= SearchResults.size() + 1)) {
                    break;
                }
                System.out.println("Please Enter a Menu Option!");

            } catch (InputMismatchException e) {
                System.out.println("Please Enter Numbers Only!");
                scanner.nextLine();
            }
        }

        if (UserSearchChoice == (SearchResults.size() + 1)) { // Exiting to main menu

        } else { // Pass property object to booking method based on user choice
            bookingDates(SearchResults.get(UserSearchChoice - 1));
        }
    }

    // Booking Details/Prices
    public Booking bookingCalculation(Property chosenproperty, LocalDate CheckInDate, LocalDate CheckOutDate) {

        // Variables/Calculations
        double visitDurationDays = ChronoUnit.DAYS.between(CheckInDate, CheckOutDate);

        double serviceFee = chosenproperty.getsERVICE_FEE();
        double serviceFeeForVisit = serviceFee * visitDurationDays;
        double cleaningFee = chosenproperty.getcLEANING_FEE();

        double originalPrice = chosenproperty.getpRICE_PER_NIGHT();
        double discountedPrice = (chosenproperty.getpRICE_PER_NIGHT()
                * ((100 - chosenproperty.getwEEKLY_DISCOUNT()) / 100));

        double originalRoomPrice = originalPrice * visitDurationDays;
        double discountedRoomPrice = discountedPrice * visitDurationDays;

        double priceForVisit = ((originalPrice + serviceFee) * visitDurationDays) + cleaningFee;
        double discountedPriceForVisit = ((discountedPrice + serviceFee) * visitDurationDays) + cleaningFee;

        // Declares final price based on whether or not the discount was applied due to
        // the 7 day requirement
        double finalPrice;
        if (visitDurationDays >= 7) {
            finalPrice = discountedPriceForVisit;
        } else {
            finalPrice = priceForVisit;
        }

        // Creating booking object
        Booking bookingDetails = new Booking(CheckInDate, CheckOutDate, visitDurationDays, serviceFeeForVisit,
                originalRoomPrice, discountedRoomPrice, priceForVisit, discountedPrice, discountedPriceForVisit,
                finalPrice, chosenproperty);

        // Return object
        return bookingDetails;
    }

    // Print Booking Details
    public void printBookingDetails(Booking bookingDetails) {

        final int SPLIT_CONSTANT = 3;

        // Splitting Property Description into 3 seperate parts
        String propertyDescription = bookingDetails.getChosenProperty().getdESCRIPTION();
        final int mid = propertyDescription.length() / SPLIT_CONSTANT;
        String[] splitDescription = { propertyDescription.substring(0, mid),
                propertyDescription.substring(mid, mid * 2), propertyDescription.substring(mid * 2) };

        // Print Property Details
        System.out.println("==============================");
        System.out.println("> Show Property Details");
        System.out.println("==============================");
        System.out.printf("Property: %s%s%n", "                  ", bookingDetails.getChosenProperty().getnAME());
        System.out.printf("Type Of Place: %s%s%n", "             ",
                bookingDetails.getChosenProperty().gettYPE_OF_PLACE());
        System.out.printf("Location: %s%s%n", "                  ", bookingDetails.getChosenProperty().getlOCATION());
        System.out.printf("Rating: %s%.2f%n", "                    ", bookingDetails.getChosenProperty().getrATING());
        System.out.printf("Description:                %s%n", splitDescription[0]); // Part 1 of description
        System.out.printf("                            %s%n", splitDescription[1]); // Part 2 of description
        System.out.printf("                            %s%n", splitDescription[2]); // Part 3 of description
        System.out.printf("Max Number Of Guests: %s%d%n", "      ", bookingDetails.getChosenProperty().getmAX_GUESTS());
        System.out.printf("Price:             %s$%.2f ($%.2f * %.2f %s%n", "         ",
                bookingDetails.getOriginalRoomPrice(), bookingDetails.getChosenProperty().getpRICE_PER_NIGHT(),
                bookingDetails.getVisitDurationDays(), "nights)");
        if (bookingDetails.getVisitDurationDays() >= 7) { // Printing total as discounted price
            System.out.printf("Discounted Price:           $%.2f ($%.2f * %.2f %s%n",
                    bookingDetails.getDiscountedRoomPrice(),
                    bookingDetails.getDiscountedPrice(),
                    bookingDetails.getVisitDurationDays(), "nights)");
            System.out.printf("Service Fee:                $%.2f ($%.2f * %.2f %s%n",
                    bookingDetails.getServiceFeeForVisit(),
                    bookingDetails.getChosenProperty().getsERVICE_FEE(),
                    bookingDetails.getVisitDurationDays(), "nights)");
            System.out.printf("Cleaning Fee:               $%.2f%n",
                    bookingDetails.getChosenProperty().getcLEANING_FEE());
            System.out.printf("Total:                      $%.2f%n", bookingDetails.getDiscountedPriceForVisit());
        } else { // Printing total as normal price
            System.out.printf("Discounted Price:           N/A (<7 Days)%n");
            System.out.printf("Service Fee:                $%.2f ($%.2f * %.2f %s%n",
                    bookingDetails.getServiceFeeForVisit(),
                    bookingDetails.getChosenProperty().getsERVICE_FEE(),
                    bookingDetails.getVisitDurationDays(), "nights)");
            System.out.printf("Cleaning Fee:               $%.2f%n",
                    bookingDetails.getChosenProperty().getcLEANING_FEE());
            System.out.printf("Total:                      $%.2f%n", bookingDetails.getPriceForVisit());
        }

    }

    // Booking Confirmation
    public void bookingConfirmation(Booking bookingDetails) {

        System.out.print("Would you like to reserve the property (Y/N)?: ");

        String userReserve = inputCharacterValidation(); // Take and Validate user input using method

        // Variables
        String guestName;
        String guestSurname;
        String guestEmail;
        int totalGuests;

        // Requesting user information after confirmation of booking choice
        if (userReserve.contentEquals("Y")) {
            System.out.println("==============================");
            System.out.println("> Provide Personal Information");
            System.out.println("==============================");
            System.out.print("Please provide your given name: ");
            guestName = scanner.next();
            System.out.print("Please provide your surname: ");
            guestSurname = scanner.next();
            System.out.print("Please provide your email: ");
            guestEmail = scanner.next();
            System.out.print("Number of Guests: ");
            while (true) { // Ensuring that user doesnt not enter number larger then the max amout of
                           // guests based on chosen property
                try {
                    String Guests = scanner.next();
                    totalGuests = Integer.parseInt(Guests);
                    if (totalGuests <= bookingDetails.getChosenProperty().getmAX_GUESTS()) {
                        break;
                    }
                    System.out.printf("This property doesnt allow more then %d %s%n%s",
                            bookingDetails.getChosenProperty().getmAX_GUESTS(),
                            "guests at a time.", "Please Enter A New Number: ");

                } catch (NumberFormatException e) {
                    System.out.println("Please Enter A Number: ");
                    scanner.next(); // needed to clear buffer
                }
            }

            System.out.print("Confirm and Pay (Y/N): ");
            String finalUserChoice = inputCharacterValidation(); // Take and Validate user input using method

            //Printing final confirmation of booking details
            if (finalUserChoice.contentEquals("Y")) {
                System.out.println("==============================");
                System.out.println("Congratulations! Your trip is booked. A receipt has been sent to your email.");
                System.out.println("Details of your trip are below.");
                System.out.println("Your host will contact you before your trip. Enjoy your stay!");
                System.out.println("==============================");
                System.out.printf("Name: %s %s%n", guestName, guestSurname);
                System.out.printf("Email: %s%n", guestEmail);
                System.out.printf("Your stay: %s %s %s%n", bookingDetails.getChosenProperty().getnAME(), "by",
                        bookingDetails.getChosenProperty().gethOST());
                System.out.printf("Who's coming: %d%n", totalGuests);
                System.out.printf("Check-in Date: %1$td/%1$tm/%1$ty%n", bookingDetails.getCheckInDate());
                System.out.printf("Checkout Date: %1$td/%1$tm/%1$ty%n%n", bookingDetails.getCheckOutDate());
                System.out.printf("Total Payment: $%.2f%n", bookingDetails.getFinalPrice());
                System.exit(1);
            }
        }
    }

    // Validate Character User Input
    public String inputCharacterValidation() {

        // Ensures user enteres either "Y,y" or "N,n"
        while (true) {
            try {
                String input = scanner.next().toUpperCase();
                if (input.matches("[a-zA-Z_]+")) {
                    if (input.contentEquals("Y") | input.contentEquals("N")) {
                        return input;
                    }
                }
                System.out.println("Please Enter (Y/N)");

            } catch (InputMismatchException e) {
                System.out.println("Please Enter (Y/N)");
                scanner.next();
            }

        }
    }

}
