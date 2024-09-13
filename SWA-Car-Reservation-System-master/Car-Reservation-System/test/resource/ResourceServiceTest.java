package resource;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//Testen für Github Commit und Push Ariansch 
public class ResourceServiceTest {

	private ResourceService resourceService;

	@BeforeEach
	public void setUp() {
		// ResourceService initialisieren
		resourceService = new ResourceService();

		// Ressourcen hinzufügen (BMW 3er explizit festlegen)
		Resource car = new Car(1, "BMW 1er", "BMW 3er"); // Setze explizit BMW 3er
		Resource setTopBox = new SetTopBox(2, "Apple TV");
		resourceService.addResource(car);
		resourceService.addResource(setTopBox);

		// Detaillierte Ausgabe
		System.out.println("Ressource hinzugefügt: " + car.getDescription() + " mit ID: " + car.getResourceID());
		System.out.println(
				"Ressource hinzugefügt: " + setTopBox.getDescription() + " mit ID: " + setTopBox.getResourceID());
		System.out.println("Anzahl der Ressourcen nach Hinzufügen: " + resourceService.getResources().size());
	}

	@Test
	public void testGetSelectedResource() {
		// Testen, ob eine Ressource mit der ID 1 korrekt zurückgegeben wird
		Resource selectedResource = resourceService.getSelectedResource(1);
		assertEquals("Car: BMW 3er", selectedResource.getDescription());
	}

	@Test
	public void testGetSelectedResourceNotFound() {
		// Testen, ob null zurückgegeben wird, wenn keine Ressource gefunden wird
		Resource selectedResource = resourceService.getSelectedResource(99);
		assertNull(selectedResource);
	}

	@Test
	public void isResourceAdded() {
		// Neue Ressource hinzufügen
		Resource resource = new Car(3, "Mercedes C-Klasse");
		resourceService.addResource(resource);

		// Überprüfen, ob die Ressource hinzugefügt wurde
		assertTrue(resourceService.getResources().contains(resource));
	}

	// Test für LuxuryCarDecorator
	@Test
	public void testLuxuryCarDecorator() {
		// Basisauto erstellen
		Resource car = new Car(4, "Audi A3");

		// Luxusupgrade anwenden
		Resource luxuryCar = new LuxuryCarDecorator(car, "Audi A8");

		// Überprüfen, ob die Beschreibung und der Preis korrekt angepasst wurden
		assertEquals("Car: Audi A8 (Luxusfahrzeug) oder ähnliches", luxuryCar.getDescription());
		assertEquals(200.00, luxuryCar.getPrice()); // Basispreis 50 + 150 für das Luxuspaket
	}
}
