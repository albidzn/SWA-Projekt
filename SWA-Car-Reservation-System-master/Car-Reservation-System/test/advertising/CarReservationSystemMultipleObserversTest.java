package advertising;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarReservationSystemMultipleObserversTest {
    private CarReservationSystem carReservationSystem;
    private AdvertisingSystem advertisingSystem1;
    private AdvertisingSystem advertisingSystem2;
    private MessagingSystem messagingSystem1;
    private MessagingSystem messagingSystem2;

    @BeforeEach
    void setUp() {
        // Zwei MessagingSysteme erstellen
        messagingSystem1 = new MessagingSystem();
        messagingSystem2 = new MessagingSystem();

        // Zwei AdvertisingSysteme erstellen
        advertisingSystem1 = new AdvertisingSystem(messagingSystem1);
        advertisingSystem2 = new AdvertisingSystem(messagingSystem2);

        // CarReservationSystem erstellen
        carReservationSystem = new CarReservationSystem();

        // Beide AdvertisingSysteme als Observer registrieren
        carReservationSystem.registerObserver(advertisingSystem1);
        carReservationSystem.registerObserver(advertisingSystem2);
    }

    @Test
    void testMultipleObserversNotification() {
        // Umleiten der Standardausgabe auf einen Output-Stream, um die Konsole zu überprüfen
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Buchung durchführen
        carReservationSystem.bookCar("BMW X5", "John Doe");

        // Überprüfen, ob die Nachricht für beide Observer auf der Konsole ausgegeben wurde
        String expectedOutput = "John Doe hat das Auto BMW X5 gebucht.\n" +
                                "Sende Nachricht: Werbung: Spezielle Angebote für Ihr nächstes Auto! Auto gebucht: BMW X5\n" +
                                "Sende Nachricht: Werbung: Spezielle Angebote für Ihr nächstes Auto! Auto gebucht: BMW X5\n";

        assertEquals(expectedOutput, outContent.toString());
    }
}
