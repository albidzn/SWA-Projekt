package statistics;

import java.util.List;
import java.util.ArrayList;

public class StatisticsService {
    private List<Booking> bookings;

    public StatisticsService(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void getGermanBookingsPaidBy(String paymentType) {
        BookingVisitor visitor = new PaymentTypeVisitor(paymentType);
        for (Booking booking : bookings) {
            if (booking instanceof GermanBooking) {
                booking.accept(visitor);
            }
        }
    }

    public void getEnglishBookingsPaidBy(String paymentType) {
        BookingVisitor visitor = new PaymentTypeVisitor(paymentType);
        for (Booking booking : bookings) {
            if (booking instanceof EnglishBooking) {
                booking.accept(visitor);
            }
        }
    }
}
