package booking;

import java.util.ArrayList;
import java.util.List;

import advertising.Observer;
import advertising.Subject;

public class BookingService implements Subject {
    private List<Observer> observers = new ArrayList<>();
    
	@Override
	public void registerObserver(Observer observer) {
        observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
        observers.remove(observer);
		
	}

	@Override
	public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
	}
        public String createBooking(Booking booking, Fahrzeug vehicle, PriceDetails priceDetails, InsuranceDetails insuranceDetails) {
            String head = booking.createHead();
            String vehicleDetails = booking.formatVehicleDetails(vehicle, priceDetails);
            String body = booking.createBody();
            String footer = booking.createFooter();

            String bookingDetails = head + "\n" +
                                    vehicleDetails + "\n" +
                                    body + "\n" + 
                                    footer;

            // Informiere alle Beobachter über die neue Buchung
            notifyObservers("Auto gebucht: " + vehicle.getModell());

            return bookingDetails;
        }
}
