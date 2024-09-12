package authentification;

import java.util.Scanner;

public class AuthenticationApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
                return;
        }

        // Authentifizierung durchführen
        boolean isAuthenticated = authService.authenticateSubject(subject, credential);

        if (isAuthenticated) {
            System.out.println("Authentifizierung erfolgreich!");
        } else {
            System.out.println("Authentifizierung fehlgeschlagen.");
        }

        scanner.close();
    }
}
