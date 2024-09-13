package statistics;

// Use Case für englische Buchungen, die mit PayPal bezahlt wurden

public class GetEnglishBookingsPaidByPayPal implements BookingVisitor {

    @Override
    public void visit(GermanBooking germanBooking) {
        // Nichts zu tun, da wir uns nur für englische Buchungen interessieren
    }

    @Override
    public void visit(EnglishBooking englishBooking) {
        if (englishBooking.getPaymentType().equals("PayPal")) {
            System.out.println("Processing English booking paid by PayPal");
            // Logik für die Verarbeitung dieser Buchungen
        }
    }
}
