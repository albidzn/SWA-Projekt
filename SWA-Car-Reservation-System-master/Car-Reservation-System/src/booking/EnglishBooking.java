package booking;

public class EnglishBooking implements Booking {

	@Override
	public String createHead() {
		return "Booking Head (English): Your reservation details";
	}

	@Override
	public String createBody() {
		return "Booking Body (English): You have reserved a vehicle.";
	}

	@Override
	public String createFooter() {
		return "Booking Footer (English): Thank you for your reservation.";
	}
	
    @Override
    public String formatVehicleDetails(Fahrzeug vehicle, PriceDetails priceDetails) {
        return "Vehicle: " + vehicle.getKategorie() + " - " + vehicle.getModell() + "\n" +
               "Automatic: " + vehicle.isAutomatik() + "\n" +
               "Air Conditioning: " + vehicle.isKlimaanlage() + "\n" +
               "Navigation System: " + vehicle.isNavigationssystem() + "\n" +
               "Price: " + priceDetails.berechneGesamtpreis() + " EUR";
    }
}
