package payment;


public class PayPalPaymentService extends PaymentService {
    @Override
    protected void transferAmount(Account sender, Account receiver, CurrencyAmount amount) {
        System.out.println("Überweisung über PayPal: " + amount.getAmount() + " " + amount.getCurrency());
    }
}

