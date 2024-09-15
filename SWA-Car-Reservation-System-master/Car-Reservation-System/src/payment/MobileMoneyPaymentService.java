package payment;


public class MobileMoneyPaymentService extends PaymentService {
	@Override
	protected void transferAmount(Account sender, Account receiver, CurrencyAmount amount) {
		System.out.println("Überweisung über Mobile Money Wallet: " + amount.getAmount() + " " + amount.getCurrency());
	}
}
