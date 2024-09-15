package booking;

public interface Booking {
    String createHead();
    String createBody();
    String createFooter();
    String formatVehicleDetails(Fahrzeug vehicle, PriceDetails priceDetails);
}
