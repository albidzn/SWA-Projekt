package resource;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//Testen für Github Commit
public class ResourceServiceTest {

    private ResourceService resourceService;

    @BeforeEach
    public void setUp() {
        // ResourceService initialisieren
        resourceService = new ResourceService();

        // Ressourcen hinzufügen
        Resource car = new Car(1, "BMW 3er");
        Resource setTopBox = new SetTopBox(2, "Apple TV");
        resourceService.addResource(car);
        resourceService.addResource(setTopBox);
        
        // Detaillierte Ausgabe
        System.out.println("Ressource hinzugefügt: " + car.getDescription() + " mit ID: " + car.getResourceID());
        System.out.println("Ressource hinzugefügt: " + setTopBox.getDescription() + " mit ID: " + setTopBox.getResourceID());
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
}
