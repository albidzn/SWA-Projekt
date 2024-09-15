package resource;

import java.util.Scanner;
import java.util.List;
import resource.*;

public class ResourceApp {

    private static ResourceService resourceService = new ResourceService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("1. Daten eingeben");
            System.out.println("2. Daten löschen");
            System.out.println("3. Daten ausgeben");
            System.out.println("4. Programm beenden");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addResource();
                    break;
                case 2:
                    deleteResource();
                    break;
                case 3:
                    displayResources();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Ungültige Auswahl, bitte versuchen Sie es erneut.");
            }
        }

        System.out.println("Programm beendet.");
        scanner.close();
    }

    // Methode zum Hinzufügen einer Ressource
    private static void addResource() {
        System.out.println("Welche Ressource möchten Sie hinzufügen?");
        System.out.println("1. Auto");
        System.out.println("2. Kindersitz");
        System.out.println("3. SetTopBox");

        int choice = scanner.nextInt();
        System.out.println("Geben Sie die ID ein:");
        int id = scanner.nextInt();
        System.out.println("Geben Sie den Namen der Ressource ein:");
        String name = scanner.next();

        Resource resource = null;

        switch (choice) {
            case 1:
                resource = new Car(id, name);
                break;
            case 2:
                resource = new ChildSeat(id, name);
                break;
            case 3:
                resource = new SetTopBox(id, name);
                break;
            default:
                System.out.println("Ungültige Ressourcenauswahl.");
                return;
        }

        // Frage den Benutzer, ob Dekoratoren hinzugefügt werden sollen
        resource = addDecorators(resource);
        resourceService.addResource(resource);
        System.out.println("Ressource hinzugefügt: " + resource.getDescription());
    }

    // Methode zum Hinzufügen von Dekoratoren
    private static Resource addDecorators(Resource resource) {
        boolean addingDecorators = true;

        while (addingDecorators) {
            System.out.println("Möchten Sie einen Dekorator hinzufügen?");
            System.out.println("1. Navi");
            System.out.println("2. Luxus");
            System.out.println("3. WiFi-Hotspot");
            System.out.println("4. Fahrradträger");
            System.out.println("5. Anhängerkupplung");
            System.out.println("6. Keinen Dekorator hinzufügen (Beenden)");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    resource = new NaviDecorator(resource);
                    break;
                case 2:
                    resource = new LuxuryCarDecorator(resource);
                    break;
                case 3:
                    resource = new WifiHotSpotDecorator(resource);
                    break;
                case 4:
                    resource = new BicycleRackDecorator(resource);
                    break;
                case 5:
                    resource = new TrailerHitchDecorator(resource);
                    break;
                case 6:
                    addingDecorators = false;
                    break;
                default:
                    System.out.println("Ungültige Auswahl.");
            }
        }

        return resource;
    }

    // Methode zum Löschen einer Ressource
    private static void deleteResource() {
        System.out.println("Geben Sie die ID der Ressource ein, die Sie löschen möchten:");
        int id = scanner.nextInt();
        resourceService.deleteResource(id);
    }

    // Methode zur Ausgabe aller Ressourcen
    private static void displayResources() {
        List<Resource> resources = resourceService.getResources();
        if (resources.isEmpty()) {
            System.out.println("Es gibt keine Ressourcen.");
        } else {
            for (Resource resource : resources) {
                System.out.println(resource.getDescription() + " kostet: " + resource.getPrice());
            }
        }
    }
}
