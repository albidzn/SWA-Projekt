package booking;

import statistics.BookingVisitor;

public class EnglishBooking implements Booking {
    private String paymentMethod;

    public EnglishBooking(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    @Override
    public String createHead() {
        return "English Booking Header";
    }

    @Override
    public String createBody() {
        return "English Booking Body";
    }

    @Override
    public String createFooter() {
        return "English Booking Footer";
    }

    @Override
    public String formatVehicleDetails(Fahrzeug vehicle, PriceDetails priceDetails) {
        return "Vehicle details for English booking: " + vehicle.getDetails() + ", Price: " + priceDetails.getPrice();
    }

    @Override
    public void accept(BookingVisitor visitor) {
        visitor.visit(this);
    }
}
