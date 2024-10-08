package booking;

import statistics.BookingVisitor;

public interface Booking {
    String createHead();
    String createBody();
    String createFooter();
    String formatVehicleDetails(Fahrzeug vehicle, PriceDetails priceDetails);
    void accept(BookingVisitor visitor);  // Visitor-Pattern Methode
}
