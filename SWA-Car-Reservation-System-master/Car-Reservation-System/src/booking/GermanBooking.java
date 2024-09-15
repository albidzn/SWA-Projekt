package booking;

public class GermanBooking implements Booking{

	@Override
	public String createHead() {
		return "Buchungskopf (Deutsch): Ihre Reservierungsdetails";
	}

	@Override
	public String createBody() {
		return "Buchungstext (Deutsch): Sie haben ein Fahrzeug reserviert.";
	}

	@Override
	public String createFooter() {
		return "Buchungsfußzeile (Deutsch): Vielen Dank für Ihre Buchung.";
	}
	
    @Override
    public String formatVehicleDetails(Fahrzeug vehicle, PriceDetails priceDetails) {
        return "Fahrzeug: " + vehicle.getKategorie() + " - " + vehicle.getModell() + "\n" +
               "Automatik: " + vehicle.isAutomatik() + "\n" +
               "Klimaanlage: " + vehicle.isKlimaanlage() + "\n" +
               "Navigationssystem: " + vehicle.isNavigationssystem() + "\n" +
               "Preis: " + priceDetails.berechneGesamtpreis() + " Euro";
    }

}
