package application;

import java.util.Scanner;

import person.Person;
import person.PersonFactory;
import person.PersonService;
import resource.AdditionalDriver;
import resource.Car;
import resource.ChildSeat;
import resource.Navi;
import resource.Resource;
import resource.ResourceService;
import resource.SetTopBox;
import resource.TrailerHitch;

public class Main {
    private static PersonService personService = new PersonService();
    private static ResourceService resourceService = new ResourceService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            printMainMenu();
            int mainChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (mainChoice) {
                case 1: // Personenverwaltung
                    handlePersonMenu();
                    break;
                case 2: // Ressourcenverwaltung
                    handleResourceMenu();
                    break;
                case 3: // Beenden
                    exit = true;
                    System.out.println("Programm wird beendet.");
                    break;
                default:
                    System.out.println("Ungültige Auswahl.");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("Wählen Sie eine Option: ");
        System.out.println("1. Personenverwaltung");
        System.out.println("2. Ressourcenverwaltung");
        System.out.println("3. Beenden");
        System.out.print("Ihre Auswahl: ");
    }

    // Methoden zur Personenverwaltung
    private static void handlePersonMenu() {
        System.out.println("Wählen Sie eine Option:");
        System.out.println("1. Person hinzufügen");
        System.out.println("2. Person löschen");
        System.out.println("3. Alle Personen anzeigen");
        System.out.println("4. Zurück zum Hauptmenü");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                System.out.println("Geben Sie den Personentyp ein (natural/legal): ");
                String type = scanner.nextLine();

                System.out.println("Geben Sie den Namen ein: ");
                String name = scanner.nextLine();

                System.out.println("Geben Sie die Adresse ein: ");
                String address = scanner.nextLine();

                String extraInfo1 = "", extraInfo2 = "";
                if ("natural".equalsIgnoreCase(type)) {
                    System.out.println("Geben Sie das Geburtsdatum ein: ");
                    extraInfo1 = scanner.nextLine();

                    System.out.println("Geben Sie die Führerscheinnummer ein: ");
                    extraInfo2 = scanner.nextLine();
                } else if ("legal".equalsIgnoreCase(type)) {
                    System.out.println("Geben Sie die Handelsregisternummer ein: ");
                    extraInfo1 = scanner.nextLine();
                    System.out.println("Geben Sie die Steuernummer ein: ");
                    extraInfo2 = scanner.nextLine();
                }

                Person person = PersonFactory.createPerson(type, name, address, extraInfo1, extraInfo2);
                if (person != null) {
                    personService.addPerson(person);
                    System.out.println("Person hinzugefügt: " + person.getName());
                } else {
                    System.out.println("Ungültiger Personentyp!");
                }
                break;
            case 2:
                System.out.println("Geben Sie den Namen der zu löschenden Person ein: ");
                String nameToDelete = scanner.nextLine();
                personService.deletePerson(nameToDelete);
                System.out.println("Person gelöscht (falls vorhanden).");
                break;
            case 3:
                System.out.println("Aktuelle Personen:");
                personService.displayPersons();
                break;
            case 4:
                return; // Zurück zum Hauptmenü
            default:
                System.out.println("Ungültige Auswahl.");
        }
    }

    // Methoden zur Ressourcenverwaltung
    private static void handleResourceMenu() {
        System.out.println("Wählen Sie eine Option:");
        System.out.println("1. Ressource hinzufügen");
        System.out.println("2. Ressource löschen");
        System.out.println("3. Alle Ressourcen anzeigen");
        System.out.println("4. Zurück zum Hauptmenü");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                System.out.println("Geben Sie die Ressource ein (car, childseat, settopbox): ");
                String resourceType = scanner.nextLine();

                Resource resource;
                switch (resourceType.toLowerCase()) {
                    case "car":
                        resource = new Car();
                        break;
                    case "childseat":
                        resource = new ChildSeat(new Car());
                        break;
                    case "settopbox":
                        resource = new SetTopBox(new Car());
                        break;
                    default:
                        System.out.println("Ungültiger Ressourcentyp!");
                        return;
                }

                System.out.println("Möchten Sie zusätzliche Optionen hinzufügen (navi, trailerhitch, additionaldriver)? (y/n)");
                String addOptions = scanner.nextLine();

                if (addOptions.equalsIgnoreCase("y")) {
                    System.out.println("Geben Sie die gewünschten Optionen ein (navi, trailerhitch, additionaldriver): ");
                    String option = scanner.nextLine();
                    switch (option.toLowerCase()) {
                        case "navi":
                            resource = new Navi(resource);
                            break;
                        case "trailerhitch":
                            resource = new TrailerHitch(resource);
                            break;
                        case "additionaldriver":
                            System.out.println("Geben Sie das Alter des zusätzlichen Fahrers ein: ");
                            int age = scanner.nextInt();
                            scanner.nextLine(); // consume newline
                            resource = new AdditionalDriver(resource, age);
                            break;
                        default:
                            System.out.println("Ungültige Option!");
                            return;
                    }
                }

                resourceService.addResource(resource);
                System.out.println("Ressource hinzugefügt: " + resource.getDescription());
                break;
            case 2:
                System.out.println("Geben Sie die ID der Ressource ein, die Sie löschen möchten: ");
                String resourceID = scanner.nextLine();
                Resource resourceToDelete = resourceService.getSelectedResource(resourceID);
                if (resourceToDelete != null) {
                    resourceService.removeResource(resourceToDelete);
                    System.out.println("Ressource gelöscht: " + resourceToDelete.getDescription());
                } else {
                    System.out.println("Ressource mit dieser ID nicht gefunden.");
                }
                break;
            case 3:
                System.out.println("Aktuelle Ressourcen:");
                for (Resource res : resourceService.getResources()) {
                    System.out.println(res.getDescription() + " kostet: " + res.getCost());
                }
                break;
            case 4:
                return; // Zurück zum Hauptmenü
            default:
                System.out.println("Ungültige Auswahl.");
        }
    }
}
