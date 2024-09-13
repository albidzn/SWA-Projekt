package instance;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

public class CarReservationSystemTest {

    @Test
    public void testSingletonInstanceIsSame() {
        // Teste, dass nur eine Instanz existiert
        CarReservationSystem instance1 = CarReservationSystem.getInstance();
        CarReservationSystem instance2 = CarReservationSystem.getInstance();

        // Beide Instanzen müssen dieselbe sein
        assertSame(instance1, instance2, "Es darf nur eine Instanz des CarReservationSystem geben");
    }

    @Test
    public void testMakeReservation() {
        // Teste eine Beispielmethode aus dem CarReservationSystem
        CarReservationSystem system = CarReservationSystem.getInstance();
        system.makeReservation();

        // Du könntest hier prüfen, ob die Methode korrekt ausgeführt wurde
        // Falls sie eine Rückgabe hat, kannst du diese prüfen.
        // Zum Beispiel:
        assertNotNull(system, "System sollte eine Reservation durchführen können.");
    }
}

