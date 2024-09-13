package application;

import person.*;
import resource.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PersonService personService = new PersonService();
        ResourceService resourceService = new ResourceService();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Erst Person erstellen
        while (running) {
            System.out.println("1. Person erstellen");
            System.out.println("2. Ressourcen hinzufügen");
            System.out.println("3. Ressourcen löschen");
            System.out.println("4. Alle Personen anzeigen");
            System.out.println("5. Alle Ressourcen anzeigen");
            System.out.println("6. Beenden");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Verarbeitet Zeilenumbruch

            switch (choice) {
                case 1:
                    // Erstellen der Person
                    System.out.println("Geben Sie den Personentyp ein (1: NaturalPerson, 2: LegalPerson):");
                    int personType = scanner.nextInt();
                    scanner.nextLine();  // Verarbeitet Zeilenumbruch
                    System.out.println("Geben Sie den Namen ein:");
                    String name = scanner.nextLine();
                    System.out.println("Geben Sie die Email ein:");
                    String email = scanner.nextLine();
                    System.out.println("Geben Sie die Telefonnummer ein:");
                    String phoneNumber = scanner.nextLine();
                    System.out.println("Geben Sie die Adresse ein:");
                    String address = scanner.nextLine();

                    if (personType == 1) {
                        System.out.println("Geben Sie das Geburtsdatum ein (yyyy-MM-dd):");
                        String birthDate = scanner.nextLine();
                        personService.createPerson("NaturalPerson", name, email, phoneNumber, address, birthDate);
                        System.out.println("Natürliche Person erstellt!");
                    } else if (personType == 2) {
                        System.out.println("Geben Sie den Firmennamen ein:");
                        String companyName = scanner.nextLine();
                        System.out.println("Geben Sie die Registrierungsnummer ein:");
                        String registrationNumber = scanner.nextLine();
                        System.out.println("Geben Sie die Steuernummer ein:");
                        String taxNumber = scanner.nextLine();
                        personService.createPerson("LegalPerson", name, email, phoneNumber, address, companyName, registrationNumber, taxNumber);
                        System.out.println("Juristische Person erstellt!");
                    }
                    break;

                case 2:
                    // Ressourcen hinzufügen (z.B. Auto)
                    System.out.println("Geben Sie den Ressourcentyp ein (1: Car, 2: SetTopBox, 3: ChildSeat):");
                    int resourceType = scanner.nextInt();
                    System.out.println("Geben Sie die ID ein:");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Verarbeitet Zeilenumbruch
                    System.out.println("Geben Sie den Namen der Ressource ein:");
                    String resourceName = scanner.nextLine();

                    Resource resource = null;
                    if (resourceType == 1) {
                        resource = new Car(id, resourceName);

                        // Option für ein Upgrade auf Luxusfahrzeug anbieten
                        System.out.println("Möchten Sie ein Upgrade auf ein Luxusauto? (1: Ja, 0: Nein)");
                        int upgradeChoice = scanner.nextInt();
                        if (upgradeChoice == 1) {
                            resource = new LuxuryCarDecorator(resource);
                        }
                    } else if (resourceType == 2) {
                        resource = new SetTopBox(id, resourceName);
                    } else if (resourceType == 3) {
                        resource = new ChildSeat(id, resourceName);
                    }

                    if (resource != null) {
                        resourceService.addResource(resource);
                        System.out.println("Ressource hinzugefügt!");
                    }
                    break;

                case 3:
                    // Ressourcen löschen
                    System.out.println("Geben Sie die ID der zu löschenden Ressource ein:");
                    int deleteId = scanner.nextInt();
                    resourceService.deleteResource(deleteId);
                    break;

                case 4:
                    // Alle Personen anzeigen
                    personService.displayPersons();
                    break;

                case 5:
                    // Alle Ressourcen anzeigen
                    resourceService.displayResources();
                    break;

                case 6:
                    running = false;
                    break;

                default:
                    System.out.println("Ungültige Auswahl!");
            }
        }

        scanner.close();
    }
}
