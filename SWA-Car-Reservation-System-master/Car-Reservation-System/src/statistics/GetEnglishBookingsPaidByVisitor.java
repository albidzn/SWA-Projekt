package statistics;

import java.util.ArrayList;
import java.util.List;

import booking.EnglishBooking;
import booking.GermanBooking;

public class GetEnglishBookingsPaidByVisitor implements BookingVisitor {
    private String paymentType;
    private List<EnglishBooking> filteredBookings = new ArrayList<>();

    public GetEnglishBookingsPaidByVisitor(String paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public void visit(GermanBooking germanBooking) {
        // Ignoriert deutsche Buchungen, da es nur um englische Buchungen geht
    }

    @Override
    public void visit(EnglishBooking englishBooking) {
        if (englishBooking.getPaymentType().equals(paymentType)) {
            filteredBookings.add(englishBooking);
        }
    }

    public List<EnglishBooking> getFilteredBookings() {
        return filteredBookings;
    }
}
