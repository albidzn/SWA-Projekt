package payment;


public class GoogleWalletPaymentService extends PaymentService {
    @Override
    protected void transferAmount(Account sender, Account receiver, CurrencyAmount amount) {
        System.out.println("Überweisung über Google Wallet: " + amount.getAmount() + " " + amount.getCurrency());
    }
}

