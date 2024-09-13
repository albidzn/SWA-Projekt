package statistics;

import booking.EnglishBooking;
import booking.GermanBooking;

// Concrete Visitor für deutsche Buchungen, die mit MoneyWallet bezahlt wurden
public class GetGermanBookingsPaidByMoneyWallet implements BookingVisitor {

    @Override
    public void visit(GermanBooking germanBooking) {
        // Prüfen, ob die deutsche Buchung mit MoneyWallet bezahlt wurde
        if (germanBooking.getPaymentType().equals("MoneyWallet")) {
            System.out.println("Processing German booking paid by MoneyWallet");
            // Hier könnte weitere Logik folgen, wie das Sammeln von Statistiken
        }
    }

    @Override
    public void visit(EnglishBooking englishBooking) {
        // Keine Aktion für englische Buchungen, da wir nur deutsche Buchungen verarbeiten
    }
}
