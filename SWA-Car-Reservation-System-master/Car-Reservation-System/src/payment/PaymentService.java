package payment;


public abstract class PaymentService {
    public final void payAmount(Account sender, Account receiver, CurrencyAmount amount) {
        authenticateSender(sender);
        transferAmount(sender, receiver, amount);
        generateReceipt(sender, receiver, amount);
    }

    protected void authenticateSender(Account sender) {
        System.out.println("Authentifizierung des Auftraggebers: " + sender.getAccountHolderName());
    }

    protected abstract void transferAmount(Account sender, Account receiver, CurrencyAmount amount);

    protected void generateReceipt(Account sender, Account receiver, CurrencyAmount amount) {
        System.out.println("Zahlung von " + amount.getAmount() + " " + amount.getCurrency()
                + " von " + sender.getAccountHolderName() + " an " + receiver.getAccountHolderName() + " abgeschlossen.");
    }
}

