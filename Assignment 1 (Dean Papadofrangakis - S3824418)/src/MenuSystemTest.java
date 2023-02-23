/*
 * MenuSystemTest
 * 
 * V1.0
 *
 * 29/03/2022
 */

/*
 * The MenuSystemTest class hold the test statements for the MenuSystem class and its relevant methods.
 */

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MenuSystemTest {

    
    private MenuSystem TestSystem;
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setupCreator() {
        TestSystem = new MenuSystem();
    }

    @After
    public void restoreStreams() {
        System.setOut(originalErr);
        System.setErr(originalOut);

    }

    // PropertyCreator
    @Test
    public void propertyCreator_FileNotExist() {

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);

        TestSystem.propertyCreator("non-existing-path", ps);

        try {
            String programOutput = os.toString("UTF8");
            String expectedOutput = "File not found.";
            assertEquals(expectedOutput, programOutput);
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void propertyCreator_nullValue() {

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);

        TestSystem.propertyCreator(null, ps);

        try {
            String programOutput = os.toString("UTF8");
            String expectedOutput = "File is null.";
            assertEquals(expectedOutput, programOutput);
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        }
    }

    // BookingCalculations
    @Test
    public void testNormalBookingCalculations() {
        Property testProperty = new Property("", "", "", "", "", 0, 0, 40.0, 10.0, 11.0, 5.0);
        LocalDate testCheckInDate = LocalDate.parse("2022-10-12");
        LocalDate testCheckOutDate = LocalDate.parse("2022-10-22");
        Booking programOutput = TestSystem.bookingCalculation(testProperty, testCheckInDate, testCheckOutDate);

        assertEquals(10.0, programOutput.getVisitDurationDays(), 0);
        assertEquals(100.0, programOutput.getServiceFeeForVisit(), 0);
        assertEquals(38.0, programOutput.getDiscountedPrice(), 0);
        assertEquals(400.0, programOutput.getOriginalRoomPrice(), 0);
        assertEquals(380.0, programOutput.getDiscountedRoomPrice(), 0);
        assertEquals(511.0, programOutput.getPriceForVisit(), 0);
        assertEquals(491.0, programOutput.getDiscountedPriceForVisit(), 0);

    }

    @Test
    public void testEmptyBookingCalculations() {
        Property testProperty = new Property("", "", "", "", "", 0, 0, 0, 0, 0, 0);
        LocalDate testCheckInDate = LocalDate.parse("2022-10-22");
        LocalDate testCheckOutDate = LocalDate.parse("2022-10-22");
        Booking programOutput = TestSystem.bookingCalculation(testProperty, testCheckInDate, testCheckOutDate);

        assertEquals(0, programOutput.getVisitDurationDays(), 0);
        assertEquals(0, programOutput.getServiceFeeForVisit(), 0);
        assertEquals(0, programOutput.getDiscountedPrice(), 0);
        assertEquals(0, programOutput.getOriginalRoomPrice(), 0);
        assertEquals(0, programOutput.getDiscountedRoomPrice(), 0);
        assertEquals(0, programOutput.getPriceForVisit(), 0);
        assertEquals(0, programOutput.getDiscountedPriceForVisit(), 0);

    }


}
