package statistics;

import booking.EnglishBooking;
import booking.GermanBooking;

// Use Case für deutsche Buchungen, die mit GoogleWallet bezahlt wurden
public class GetGermanBookingsPaidByGoogleWallet implements BookingVisitor {

    @Override
    public void visit(GermanBooking germanBooking) {
        if (germanBooking.getPaymentType().equals("GoogleWallet")) {
            System.out.println("Processing German booking paid by GoogleWallet");
            // Logik für die Verarbeitung dieser Buchungen
        }
    }

    @Override
    public void visit(EnglishBooking englishBooking) {
        // Nichts zu tun
    }
}


