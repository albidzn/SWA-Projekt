package statistics;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GetGermanBookingsPaidByPayPalTest {
    
    @Test
    public void testVisitGermanBookingWithPayPal() {
        // Eine deutsche Buchung mit PayPal erstellen
        GermanBooking booking = new GermanBooking("PayPal");
        GetGermanBookingsPaidByPayPal visitor = new GetGermanBookingsPaidByPayPal();

        // Visitor anwenden
        booking.accept(visitor);

        // Testen, ob die richtige Zahlungsart zugewiesen wurde
        assertEquals("PayPal", booking.getPaymentType());
    }

    @Test
    public void testVisitEnglishBooking() {
        // Eine englische Buchung erstellen
        EnglishBooking englishBooking = new EnglishBooking("PayPal");
        GetGermanBookingsPaidByPayPal visitor = new GetGermanBookingsPaidByPayPal();

        // Visitor anwenden
        englishBooking.accept(visitor);

        // Da es sich um eine englische Buchung handelt, sollte nichts passieren
        // Es sollte jedoch keinen Fehler oder keine falsche Verarbeitung geben
    }
}
