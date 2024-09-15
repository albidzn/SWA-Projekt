package person;

import java.util.Scanner;

public class PersonApp {

	public static void main(String[] args) {
		PersonService personService = new PersonService();
		Scanner scanner = new Scanner(System.in);
		boolean running = true;

		// Interaktives Menü
		while (running) {
			System.out.println("1. Person erstellen");
			System.out.println("2. Alle Personen anzeigen");
			System.out.println("3. Beenden");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Verarbeitet Zeilenumbruch

			switch (choice) {
			case 1:
				// Person erstellen
				System.out.println("Geben Sie den Personentyp ein (1: NaturalPerson, 2: LegalPerson):");
				int personType = scanner.nextInt();
				scanner.nextLine(); // Verarbeitet Zeilenumbruch

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
					System.out.println("Geben Sie Ihre Telefonnummer ein inkl. Landesvorwahl");
					phoneNumber = scanner.nextLine();
					if (isValidphoneNumber(phoneNumber)) {
						break;
					} else {
						System.out.println("Ungültige Telfonnummer.  Bitte geben Sie eine gültige Telefonnummer ein");
					}
				}
				System.out.println("Geben Sie die Telefonnummer ein:");
				phoneNumber = scanner.nextLine();
				System.out.println("Geben Sie die Adresse ein:");
				String address = scanner.nextLine();

				// Verwenden des Factory Method Patterns
				if (personType == 1) {
					System.out.println("Geben Sie das Geburtsdatum ein (yyyy-MM-dd):");
					String birthDate = scanner.nextLine();

					// Factory für natürliche Person
					FactoryPerson factory = new NaturalPersonFactory();
					personService.createPerson(factory, fname, lname, email, phoneNumber, address, birthDate);
					System.out.println("Natürliche Person erstellt!");
				} else if (personType == 2) {
					System.out.println("Geben Sie den Firmennamen ein:");
					String companyName = scanner.nextLine();
					System.out.println("Geben Sie die Registrierungsnummer ein:");
					String registrationNumber = scanner.nextLine();
					System.out.println("Geben Sie die Steuernummer ein:");
					String taxNumber = scanner.nextLine();

					// Factory für juristische Person
					FactoryPerson factory = new LegalPersonFactory();
					personService.createPerson(factory, fname, lname, email, phoneNumber, address, companyName,
							registrationNumber, taxNumber);
					System.out.println("Juristische Person erstellt!");
				}
				break;

			case 2:
				// Anzeigen aller Personen
				personService.displayPersons();
				break;

			case 3:
				running = false;
				break;

			default:
				System.out.println("Ungültige Eingabe. Bitte versuchen Sie es erneut.");
			}
		}
	}

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
