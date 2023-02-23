/*
 * Booking
 * 
 * V2.0
 *
 * 29/03/2022
 */

/*
 * The Booking class defines the "Booking" Object and defines the relevant
 * getters and setters for the object(s)
 */


import java.time.LocalDate;

public class Booking {

    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private double visitDurationDays;
    private double serviceFeeForVisit;
    private double discountedPrice;
    private double originalRoomPrice;
    private double discountedRoomPrice;
    private double priceForVisit;
    private double discountedPriceForVisit;
    private double finalPrice;
    private Property chosenProperty;

    public Booking(LocalDate checkInDate, LocalDate checkOutDate, double visitDurationDays, double serviceFeeForVisit,
            double originalRoomPrice, double discountedRoomPrice,
            double priceForVisit, double discountedPrice, double discountedPriceForVisit, double finalPrice, Property chosenProperty) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.visitDurationDays = visitDurationDays;
        this.serviceFeeForVisit = serviceFeeForVisit;
        this.originalRoomPrice = originalRoomPrice;
        this.discountedRoomPrice = discountedRoomPrice;
        this.priceForVisit = priceForVisit;
        this.discountedPrice = discountedPrice;
        this.discountedPriceForVisit = discountedPriceForVisit;
        this.finalPrice = finalPrice;
        this.chosenProperty = chosenProperty;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public double getVisitDurationDays() {
        return visitDurationDays;
    }

    public double getServiceFeeForVisit() {
        return serviceFeeForVisit;
    }

    public double getOriginalRoomPrice() {
        return originalRoomPrice;
    }

    public double getDiscountedRoomPrice() {
        return discountedRoomPrice;
    }

    public double getPriceForVisit() {
        return priceForVisit;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public double getDiscountedPriceForVisit() {
        return discountedPriceForVisit;
    }

    public double getFinalPrice(){
        return finalPrice;
    }

    public Property getChosenProperty() {
        return chosenProperty;
    }

}
