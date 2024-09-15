package application;

import person.*;
import resource.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PersonService personService = new PersonService();
        ResourceService resourceService = new ResourceService();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Hauptschleife der Anwendung
        while (running) {
            System.out.println("\n--- Car Reservation System ---");
            System.out.println("1. Person erstellen");
            System.out.println("2. Ressourcen hinzufügen");
            System.out.println("3. Ressourcen löschen");
            System.out.println("4. Alle Personen anzeigen");
            System.out.println("5. Alle Ressourcen anzeigen");
            System.out.println("6. Beenden");

            int choice = 0;

            // Eingabevalidierung für die Auswahl
            try {
                choice = scanner.nextInt();
                scanner.nextLine();  // Verarbeitet Zeilenumbruch
            } catch (InputMismatchException e) {
                System.out.println("Ungültige Eingabe! Bitte eine Zahl eingeben.");
                scanner.nextLine(); // Scanner-Fehlerpuffer löschen
                continue;  // Schleife erneut starten
            }

            switch (choice) {
                case 1:
                    createPerson(scanner, personService);
                    break;
                case 2:
                    addResource(scanner, resourceService);
                    break;
                case 3:
                    deleteResource(scanner, resourceService);
                    break;
                case 4:
                    displayPersons(personService);
                    break;
                case 5:
                    displayResources(resourceService);
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Ungültige Auswahl! Bitte versuchen Sie es erneut.");
            }
        }

        scanner.close();
        System.out.println("Programm beendet.");
    }

    // Methode zum Erstellen einer Person mit Validierungen
    private static void createPerson(Scanner scanner, PersonService personService) {
        System.out.println("Geben Sie den Personentyp ein (1: NaturalPerson, 2: LegalPerson):");
        int personType = 0;

        // Validierung der Eingabe für den Personentyp
        while (true) {
            try {
                personType = scanner.nextInt();
                scanner.nextLine();  // Verarbeitet Zeilenumbruch
                if (personType == 1 || personType == 2) {
                    break;
                } else {
                    System.out.println("Ungültige Auswahl! Bitte geben Sie 1 oder 2 ein.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ungültige Eingabe! Bitte eine Zahl eingeben.");
                scanner.nextLine(); // Scanner-Fehlerpuffer löschen
            }
        }

        // Name validieren
        String fname = "";
        String lname = "";
        while (true) {
            System.out.println("Geben Sie Ihren Vornamen ein:");
            fname = scanner.nextLine();
            if (isValidName(fname)) {
                break;
            } else {
                System.out.println("Ungültiger Vorname. Bitte keine Zahlen oder Sonderzeichen verwenden.");
            }
        }

        while (true) {
            System.out.println("Geben Sie Ihren Nachnamen ein:");
            lname = scanner.nextLine();
            if (isValidName(lname)) {
                break;
            } else {
                System.out.println("Ungültiger Nachname. Bitte keine Zahlen oder Sonderzeichen verwenden.");
            }
        }

        // Email validieren
        String email = "";
        while (true) {
            System.out.println("Geben Sie die Email ein:");
            email = scanner.nextLine();
            if (isValidEmail(email)) {
                break;
            } else {
                System.out.println("Ungültige Email-Adresse. Bitte geben Sie eine gültige Email ein.");
            }
        }

        // Telefonnummer validieren
        String phoneNumber = "";
        while (true) {
            System.out.println("Geben Sie Ihre Telefonnummer ein inkl. Landesvorwahl:");
            phoneNumber = scanner.nextLine();
            if (isValidphoneNumber(phoneNumber)) {
                break;
            } else {
                System.out.println("Ungültige Telefonnummer. Bitte geben Sie eine gültige Telefonnummer ein.");
            }
        }

        System.out.println("Geben Sie die Adresse ein:");
        String address = scanner.nextLine();

        if (personType == 1) {
            // Natürliche Person erstellen
            System.out.println("Geben Sie das Geburtsdatum ein (yyyy-MM-dd):");
            String birthDate = scanner.nextLine();
            FactoryPerson factory = new NaturalPersonFactory();
            personService.createPerson(factory, fname, lname, email, phoneNumber, address, birthDate);
            System.out.println("Natürliche Person erstellt!");
        } else if (personType == 2) {
            // Juristische Person erstellen
            System.out.println("Geben Sie den Firmennamen ein:");
            String companyName = scanner.nextLine();
            System.out.println("Geben Sie die Registrierungsnummer ein:");
            String registrationNumber = scanner.nextLine();
            System.out.println("Geben Sie die Steuernummer ein:");
            String taxNumber = scanner.nextLine();
            FactoryPerson factory = new LegalPersonFactory();
            personService.createPerson(factory, fname, lname, email, phoneNumber, address, companyName, registrationNumber, taxNumber);
            System.out.println("Juristische Person erstellt!");
        }
    }

    // Methode zum Hinzufügen einer Ressource mit Eingabevalidierung
    private static void addResource(Scanner scanner, ResourceService resourceService) {
        int resourceType = 0;
        int id = 0;

        // Validierung für den Ressourcentyp
        while (true) {
            try {
                System.out.println("Geben Sie den Ressourcentyp ein (1: Car, 2: SetTopBox, 3: ChildSeat):");
                resourceType = scanner.nextInt();
                scanner.nextLine();  // Verarbeitet Zeilenumbruch
                if (resourceType >= 1 && resourceType <= 3) {
                    break;
                } else {
                    System.out.println("Ungültiger Ressourcentyp. Bitte eine Zahl zwischen 1 und 3 eingeben.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl ein.");
                scanner.nextLine();  // Scanner-Fehlerpuffer löschen
            }
        }

        // Validierung für die ID
        while (true) {
            try {
                System.out.println("Geben Sie die ID ein:");
                id = scanner.nextInt();
                scanner.nextLine();  // Verarbeitet Zeilenumbruch
                break;
            } catch (InputMismatchException e) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine gültige Zahl für die ID ein.");
                scanner.nextLine();  // Scanner-Fehlerpuffer löschen
            }
        }

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
        } else {
            System.out.println("Ungültige Ressourcenauswahl.");
        }
    }

    // Methode zum Löschen einer Ressource
    private static void deleteResource(Scanner scanner, ResourceService resourceService) {
        int deleteId = 0;
        while (true) {
            try {
                System.out.println("Geben Sie die ID der zu löschenden Ressource ein:");
                deleteId = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl ein.");
                scanner.nextLine();  // Fehlerpuffer löschen
            }
        }
        resourceService.deleteResource(deleteId);
        System.out.println("Ressource gelöscht.");
    }

    // Methode zum Anzeigen aller Personen
    private static void displayPersons(PersonService personService) {
        System.out.println("\n--- Personenliste ---");
        personService.displayPersons();
    }

    // Methode zum Anzeigen aller Ressourcen
    private static void displayResources(ResourceService resourceService) {
        System.out.println("\n--- Ressourcenliste ---");
        resourceService.displayResources();
    }

    // Validierungsmethoden

    private static boolean isValidphoneNumber(String phoneNumber) {
        return phoneNumber.matches("[0-9+]+") && phoneNumber.length() >= 10; // Mindestlänge 10 Ziffern
    }

    // Methode zur Validierung von Namen (keine Zahlen oder Sonderzeichen)
    private static boolean isValidName(String name) {
        return name.matches("[a-zA-ZäöüßÄÖÜ]+");
    }

    // Methode zur Validierung der E-Mail-Adresse (muss ein @ enthalten)
    private static boolean isValidEmail(String email) {
        return email.contains("@");
    }
}
