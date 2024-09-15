package booking;

import statistics.BookingVisitor;

public class GermanBooking implements Booking {
    private String paymentMethod;

    public GermanBooking(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    @Override
    public String createHead() {
        return "Deutsche Buchungskopfzeile";
    }

    @Override
    public String createBody() {
        return "Deutscher Buchungstext";
    }

    @Override
    public String createFooter() {
        return "Deutsche Buchungsfußzeile";
    }

    @Override
    public String formatVehicleDetails(Fahrzeug vehicle, PriceDetails priceDetails) {
        return "Fahrzeugdetails für deutsche Buchung: " + vehicle.getDetails() + ", Preis: " + priceDetails.getPrice();
    }

    @Override
    public void accept(BookingVisitor visitor) {
        visitor.visit(this);
    }
}
