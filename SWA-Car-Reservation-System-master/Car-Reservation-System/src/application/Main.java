package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import authentification.AuthenticationService;
import authentification.AuthenticationStrategy;
import authentification.Credential;
import authentification.EyeScanStrategy;
import authentification.FingerprintStrategy;
import authentification.Subject;
import authentification.UsernamePasswordStrategy;
import person.FactoryPerson;
import person.LegalPersonFactory;
import person.NaturalPersonFactory;
import person.PersonService;
import resource.Car;
import resource.ChildSeat;
import resource.LuxuryCarDecorator;
import resource.Resource;
import resource.ResourceService;
import resource.SetTopBox;

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
            System.out.println("6. Authentifizierung");
            System.out.println("7. Beenden");

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
                    // Authentifizierung aufrufen
                    if (authenticateUser(scanner)) {
                        System.out.println("Authentifizierung erfolgreich!");
                        // Hier könnte man dann Buchungen oder Zahlungen freischalten
                    } else {
                        System.out.println("Authentifizierung fehlgeschlagen! Zugriff verweigert.");
                    }
                    break;
                case 7:
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
        // Der gesamte Inhalt dieser Methode bleibt unverändert
        // Code von der bisherigen Implementierung kopieren
    }

    // Methode zum Hinzufügen einer Ressource mit Eingabevalidierung
    private static void addResource(Scanner scanner, ResourceService resourceService) {
        // Der gesamte Inhalt dieser Methode bleibt unverändert
        // Code von der bisherigen Implementierung kopieren
    }

    // Methode zum Löschen einer Ressource
    private static void deleteResource(Scanner scanner, ResourceService resourceService) {
        // Der gesamte Inhalt dieser Methode bleibt unverändert
        // Code von der bisherigen Implementierung kopieren
    }

    // Methode zum Anzeigen aller Personen
    private static void displayPersons(PersonService personService) {
        // Der gesamte Inhalt dieser Methode bleibt unverändert
        // Code von der bisherigen Implementierung kopieren
    }

    // Methode zum Anzeigen aller Ressourcen
    private static void displayResources(ResourceService resourceService) {
        // Der gesamte Inhalt dieser Methode bleibt unverändert
        // Code von der bisherigen Implementierung kopieren
    }

    // Neue Methode zur Durchführung der Authentifizierung
    private static boolean authenticateUser(Scanner scanner) {
        System.out.println("===== Authentifizierungsdienst =====");

        System.out.print("Geben Sie die ID des Subjekts ein: ");
        String subjectId = scanner.nextLine();
        System.out.print("Geben Sie den Subjekttyp ein (Person/System): ");
        String subjectType = scanner.nextLine();
        Subject subject = new Subject(subjectId, subjectType);

        System.out.println("\nWählen Sie eine Authentifizierungsmethode:");
        System.out.println("1. Benutzername und Passwort");
        System.out.println("2. Fingerabdruck");
        System.out.println("3. Iris-Scan");
        System.out.print("Ihre Wahl: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Verarbeite Zeilenumbruch

        AuthenticationService authService;
        Credential credential;

        switch (choice) {
            case 1:
                System.out.print("Geben Sie den Benutzernamen ein: ");
                String username = scanner.nextLine();
                System.out.print("Geben Sie das Passwort ein: ");
                String password = scanner.nextLine();
                credential = new Credential(username, password);
                authService = new AuthenticationService(new UsernamePasswordStrategy());
                break;
            case 2:
                System.out.print("Geben Sie den Fingerabdruck ein: ");
                String fingerPrint = scanner.nextLine();
                credential = new Credential(fingerPrint);
                authService = new AuthenticationService(new FingerprintStrategy());
                break;
            case 3:
                System.out.print("Geben Sie den Iris-Scan ein: ");
                String eyeScan = scanner.nextLine();
                credential = new Credential(eyeScan, true);
                authService = new AuthenticationService(new EyeScanStrategy());
                break;
            default:
                System.out.println("Ungültige Auswahl.");
                return false;
        }

        // Authentifizierung durchführen
        return authService.authenticateSubject(subject, credential);
    }

    // Validierungsmethoden bleiben gleich wie in der ursprünglichen Implementierung
}
