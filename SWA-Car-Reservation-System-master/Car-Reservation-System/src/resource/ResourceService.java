package resource;

import java.util.ArrayList;
import java.util.List;

public class ResourceService {
    private List<Resource> resources;

    public ResourceService() {
        resources = new ArrayList<>();
    }

    // Methode zum Hinzufügen einer Ressource
    public void addResource(Resource resource) {
        resources.add(resource);
    }

    // Methode, um die Liste aller Ressourcen zurückzugeben
    public List<Resource> getResources() {
        return resources;
    }

    // Use Case: getSelectedResource
    public Resource getSelectedResource(int id) {
        for (Resource resource : resources) {
            // Ausgabe um zusätzliche Informationen erweitern
            System.out.println("Überprüfe Ressource: " + resource.getDescription() + " mit ID: " + resource.getResourceID());
            if (resource.getResourceID() == id) {
                return resource;
            }
        }
        return null; // Falls keine Ressource mit der ID gefunden wird
    }



    // Methode zur Ausgabe aller Ressourcen
    public void displayResources() {
        for (Resource resource : resources) {
            System.out.println(resource.getDescription() + " kostet: " + resource.getPrice());
        }
    }
}
