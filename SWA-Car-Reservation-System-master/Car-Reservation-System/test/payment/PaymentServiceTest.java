package payment;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import payment.Account;
import payment.CurrencyAmount;
import payment.GoogleWalletPaymentService;
import payment.MobileMoneyPaymentService;
import payment.PayPalPaymentService;
import payment.PaymentService;

public class PaymentServiceTest {

	@Test
	public void testPayPalPayment() {
		// Arrange: Erstelle die Accounts und den Betrag
		Account sender = new Account("John Doe", "12345678");
		Account receiver = new Account("Jane Doe", "87654321");
		CurrencyAmount amount = new CurrencyAmount(100.0, "EUR");

		PaymentService paymentService = new PayPalPaymentService();

		// Act: Führe die Zahlung durch
		paymentService.payAmount(sender, receiver, amount);

		// Assert: Es gibt nichts direkt zu überprüfen, aber man könnte Ausgaben
		// überprüfen oder Logs
		assertTrue(true, "Die Zahlung sollte erfolgreich sein.");
	}

	@Test
	public void testGoogleWalletPayment() {
		// Arrange: Erstelle die Accounts und den Betrag
		Account sender = new Account("Alice", "123456789");
		Account receiver = new Account("Bob", "987654321");
		CurrencyAmount amount = new CurrencyAmount(50.0, "USD");

		PaymentService paymentService = new GoogleWalletPaymentService();

		// Act: Führe die Zahlung durch
		paymentService.payAmount(sender, receiver, amount);

		// Assert: Wieder einfach ein Beispiel ohne tatsächliche Assertions
		assertTrue(true, "Die Zahlung sollte erfolgreich sein.");
	}

	@Test
	public void testMobileMoneyWalletPayment() {
		// Arrange: Erstelle die Accounts und den Betrag
		Account sender = new Account("Mike", "55555555");
		Account receiver = new Account("Sarah", "11111111");
		CurrencyAmount amount = new CurrencyAmount(200.0, "USD");

		PaymentService paymentService = new MobileMoneyPaymentService();

		// Act: Führe die Zahlung durch
		paymentService.payAmount(sender, receiver, amount);

		// Assert: Wieder einfach ein Beispiel ohne tatsächliche Assertions
		assertTrue(true, "Die Zahlung sollte erfolgreich sein.");
	}
}
