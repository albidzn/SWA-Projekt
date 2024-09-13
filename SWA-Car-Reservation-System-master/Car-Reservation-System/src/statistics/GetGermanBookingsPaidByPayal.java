package statistics;

import booking.EnglishBooking;
import booking.GermanBooking;

// Use Case für deutsche Buchungen, die mit PayPal bezahlt wurden
public class GetGermanBookingsPaidByPayPal implements BookingVisitor {
    
    @Override
    public void visit(GermanBooking germanBooking) {
        if (germanBooking.getPaymentType().equals("PayPal")) {
            System.out.println("Processing German booking paid by PayPal");
            // Logik für die Verarbeitung dieser Buchungen
        }
    }

    @Override
    public void visit(EnglishBooking englishBooking) {
        // Nichts zu tun, da wir uns nur für deutsche Buchungen interessieren
    }
}
