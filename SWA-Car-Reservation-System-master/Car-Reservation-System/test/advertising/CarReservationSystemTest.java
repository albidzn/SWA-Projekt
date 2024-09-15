package advertising;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarReservationSystemTest {
	private CarReservationSystem carReservationSystem;
    private AdvertisingSystem advertisingSystem;
    private MessagingSystem messagingSystem;

    @BeforeEach
    void setUp() {
        // Erstelle ein MessagingSystem
        messagingSystem = new MessagingSystem();

        // Erstelle ein AdvertisingSystem, das das MessagingSystem verwendet
        advertisingSystem = new AdvertisingSystem(messagingSystem);

        // Erstelle das CarReservationSystem
        carReservationSystem = new CarReservationSystem();

        // Registriere das AdvertisingSystem als Observer
        carReservationSystem.registerObserver(advertisingSystem);
    }

    @Test
    void testObserverNotificationOnBooking() {
        // Umleiten der Standardausgabe auf einen Output-Stream, um die Konsole zu überprüfen
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Buchung durchführen
        carReservationSystem.bookCar("VW Golf", "Max Mustermann");

        // Überprüfen, ob die richtige Nachricht an die Konsole ausgegeben wurde
        String expectedOutput = "Max Mustermann hat das Auto VW Golf gebucht.\n" +
                                "Sende Nachricht: Werbung: Spezielle Angebote für Ihr nächstes Auto! Auto gebucht: VW Golf\n";
        
        assertEquals(expectedOutput, outContent.toString());
    }
}
