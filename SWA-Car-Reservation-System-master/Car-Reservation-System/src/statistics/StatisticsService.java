package statistics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import booking.Booking;

public class StatisticsService {
    private List<Booking> bookings;

    public StatisticsService(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Booking> getBookingsPaidBy(String paymentType) {
        BookingPaymentVisitor visitor = new BookingPaymentVisitor(paymentType);
        for (Booking booking : bookings) {
            booking.accept(visitor);  // Jede Buchung akzeptiert den Visitor
        }
        return visitor.getFilteredBookings();
    }

    // Neue Methode für die Zusammenfassung der Statistiken
    public void displayStatistics() {
        // Map zur Speicherung der Anzahl der Buchungen pro Zahlungsart
        Map<String, Integer> paymentStats = new HashMap<>();

        for (Booking booking : bookings) {
            String paymentType = booking.getPaymentType();
            paymentStats.put(paymentType, paymentStats.getOrDefault(paymentType, 0) + 1);
        }

        // Statistiken ausgeben
        System.out.println("\nZusammenfassung der Buchungen nach Zahlungsart:");
        for (Map.Entry<String, Integer> entry : paymentStats.entrySet()) {
            System.out.println("Zahlungsart: " + entry.getKey() + " - Anzahl der Buchungen: " + entry.getValue());
        }
    }
}
