package statistics;

import java.util.ArrayList;
import java.util.List;

import booking.EnglishBooking;
import booking.GermanBooking;

public class GetGermanBookingsPaidByVisitor implements BookingVisitor {
    private String paymentType;
    private List<GermanBooking> filteredBookings = new ArrayList<>();

    public GetGermanBookingsPaidByVisitor(String paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public void visit(GermanBooking germanBooking) {
        if (germanBooking.getPaymentType().equals(paymentType)) {
            filteredBookings.add(germanBooking);
        }
    }

    @Override
    public void visit(EnglishBooking englishBooking) {
        // Ignoriert englische Buchungen, da es nur um deutsche Buchungen geht
    }

    public List<GermanBooking> getFilteredBookings() {
        return filteredBookings;
    }
}
