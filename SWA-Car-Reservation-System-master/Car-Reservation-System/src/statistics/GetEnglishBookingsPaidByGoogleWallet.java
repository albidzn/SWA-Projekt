package statistics;

// Concrete Visitor für englische Buchungen, die mit GoogleWallet bezahlt wurden
public class GetEnglishBookingsPaidByGoogleWallet implements BookingVisitor {

    @Override
    public void visit(GermanBooking germanBooking) {
        // Keine Aktion für deutsche Buchungen, da wir nur englische Buchungen verarbeiten
    }

    @Override
    public void visit(EnglishBooking englishBooking) {
        // Prüfen, ob die englische Buchung mit GoogleWallet bezahlt wurde
        if (englishBooking.getPaymentType().equals("GoogleWallet")) {
            System.out.println("Processing English booking paid by GoogleWallet");
            // Hier könnte weitere Logik folgen, wie das Sammeln von Statistiken
        }
    }
}
