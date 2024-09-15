package advertising;

import java.util.ArrayList;
import java.util.List;

import booking.Booking;
import booking.Fahrzeug;
import booking.InsuranceDetails;
import booking.PriceDetails;

public class CarReservationSystem implements Subject {
    private List<Observer> observers;

    public CarReservationSystem() {
        this.observers = new ArrayList<>();
    }

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
    
    public void bookCar(String car, String customer) {
        System.out.println(customer + " hat das Auto " + car + " gebucht.");
        notifyObservers("Auto gebucht: " + car);
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

        // Nach erfolgreicher Buchung Benachrichtigung senden
        notifyObservers("Auto gebucht: " + vehicle.getModell());

        return bookingDetails;
        }    
}
