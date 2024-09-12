package payment;

import java.util.Scanner;

public class PaymentApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;

		while (!exit) {
			// Textbasiertes Menü
			System.out.println("\n===== Zahlungsmenü =====");
			System.out.println("1. Zahlung mit PayPal");
			System.out.println("2. Zahlung mit Google Wallet");
			System.out.println("3. Zahlung mit Mobile Money Wallet");
			System.out.println("4. Beenden");
			System.out.print("Wählen Sie eine Option: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // Verarbeite Zeilenumbruch

			PaymentType paymentType;

			switch (choice) {
			case 1:
				paymentType = PaymentType.PAYPAL;
				break;
			case 2:
				paymentType = PaymentType.GOOGLE_WALLET;
				break;
			case 3:
				paymentType = PaymentType.MOBILE_MONEY_WALLET;
				break;
			case 4:
				exit = true;
				System.out.println("Programm wird beendet.");
				continue;
			default:
				System.out.println("Ungültige Auswahl. Bitte versuchen Sie es erneut.");
				continue;
			}

			// Verarbeite die Zahlung basierend auf der gewählten Zahlungsmethode
			handlePayment(scanner, paymentType);
		}

		scanner.close();
	}

	// Methode zur Verarbeitung der Zahlung
	private static void handlePayment(Scanner scanner, PaymentType paymentType) {
		System.out.print("Geben Sie den Namen des Senders ein: ");
		String senderName = scanner.nextLine();
		System.out.print("Geben Sie die Kontonummer des Senders ein: ");
		String senderAccountNumber = scanner.nextLine();
		Account sender = new Account(senderName, senderAccountNumber);

		System.out.print("Geben Sie den Namen des Empfängers ein: ");
		String receiverName = scanner.nextLine();
		System.out.print("Geben Sie die Kontonummer des Empfängers ein: ");
		String receiverAccountNumber = scanner.nextLine();
		Account receiver = new Account(receiverName, receiverAccountNumber);

		System.out.print("Geben Sie den Betrag ein: ");
		double amount = scanner.nextDouble();
		scanner.nextLine(); // Verarbeite Zeilenumbruch

		System.out.print("Geben Sie die Währung ein (z.B. EUR, USD): ");
		String currency = scanner.nextLine();
		CurrencyAmount currencyAmount = new CurrencyAmount(amount, currency);

		// Wähle den PaymentService basierend auf dem PaymentType
		PaymentService paymentService = getPaymentService(paymentType);

		// Zahlung durchführen
		paymentService.payAmount(sender, receiver, currencyAmount);
	}

	// Liefert den PaymentService basierend auf dem PaymentType
	private static PaymentService getPaymentService(PaymentType paymentType) {
		switch (paymentType) {
		case PAYPAL:
			return new PayPalPaymentService();
		case GOOGLE_WALLET:
			return new GoogleWalletPaymentService();
		case MOBILE_MONEY_WALLET:
			return new MobileMoneyPaymentService(); // Annahme: Diese Klasse musst du noch implementieren
		default:
			throw new IllegalArgumentException("Ungültige Zahlungsmethode");
		}
	}
}
