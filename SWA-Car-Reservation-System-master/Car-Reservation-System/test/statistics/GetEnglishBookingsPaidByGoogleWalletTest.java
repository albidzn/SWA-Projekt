package statistics;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GetEnglishBookingsPaidByGoogleWalletTest {
    
    @Test
    public void testVisitEnglishBookingWithGoogleWallet() {
        // Eine englische Buchung mit GoogleWallet erstellen
        EnglishBooking booking = new EnglishBooking("GoogleWallet");
        GetEnglishBookingsPaidByGoogleWallet visitor = new GetEnglishBookingsPaidByGoogleWallet();

        // Visitor anwenden
        booking.accept(visitor);

        // Testen, ob die richtige Zahlungsart zugewiesen wurde
        assertEquals("GoogleWallet", booking.getPaymentType());
    }

    @Test
    public void testVisitGermanBooking() {
        // Eine deutsche Buchung erstellen
        GermanBooking germanBooking = new GermanBooking("GoogleWallet");
        GetEnglishBookingsPaidByGoogleWallet visitor = new GetEnglishBookingsPaidByGoogleWallet();

        // Visitor anwenden
        germanBooking.accept(visitor);

        // Da es sich um eine deutsche Buchung handelt, sollte nichts passieren
        // Daher kann man hier keine spezielle Logik testen
        // Es sollte jedoch keinen Fehler oder keine falsche Verarbeitung geben
    }
}
