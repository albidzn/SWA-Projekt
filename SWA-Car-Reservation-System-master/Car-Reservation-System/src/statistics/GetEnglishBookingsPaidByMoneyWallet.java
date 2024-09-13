package statistics;

import booking.EnglishBooking;
import booking.GermanBooking;

// Concrete Visitor für englische Buchungen, die mit MoneyWallet bezahlt wurden
public class GetEnglishBookingsPaidByMoneyWallet implements BookingVisitor {

    @Override
    public void visit(GermanBooking germanBooking) {
        // Keine Aktion für deutsche Buchungen, da wir nur englische Buchungen verarbeiten
    }

    @Override
    public void visit(EnglishBooking englishBooking) {
        // Prüfen, ob die englische Buchung mit MoneyWallet bezahlt wurde
        if (englishBooking.getPaymentType().equals("MoneyWallet")) {
            System.out.println("Processing English booking paid by MoneyWallet");
            // Hier könnte weitere Logik folgen, wie das Sammeln von Statistiken
        }
    }
}
