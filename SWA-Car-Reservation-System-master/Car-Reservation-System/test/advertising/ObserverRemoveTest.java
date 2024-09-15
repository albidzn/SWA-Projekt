package advertising;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ObserverRemoveTest {
	private CarReservationSystem carReservationSystem;
    private AdvertisingSystem advertisingSystem;
    private MessagingSystem messagingSystem;

    @BeforeEach
    void setUp() {
        messagingSystem = new MessagingSystem();
        advertisingSystem = new AdvertisingSystem(messagingSystem);
        carReservationSystem = new CarReservationSystem();
        carReservationSystem.registerObserver(advertisingSystem);
    }

    @Test
    void testObserverRemoval() {
        // Entferne den Observer
        carReservationSystem.removeObserver(advertisingSystem);

        // Umleiten der Standardausgabe auf einen Output-Stream, um die Konsole zu überprüfen
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Buchung durchführen
        carReservationSystem.bookCar("VW Golf", "Max Mustermann");

        // Da der Observer entfernt wurde, sollte nur die Buchung ohne Werbenachricht erfolgen
        String expectedOutput = "Max Mustermann hat das Auto VW Golf gebucht.\n";
        
        assertEquals(expectedOutput, outContent.toString());
    }
}
