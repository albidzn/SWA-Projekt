package payment;


public abstract class PaymentService {
    // Template Method: Struktur des Zahlungsprozesses
    public final void payAmount(Account sender, Account receiver, CurrencyAmount amount) {
        authenticateSender(sender);
        transferAmount(sender, receiver, amount);
        generateReceipt(sender, receiver, amount);
    }

    // Authentifizierung des Auftraggebers (für alle Zahlungsarten gleich)
    protected void authenticateSender(Account sender) {
        System.out.println("Authentifizierung des Auftraggebers: " + sender.getAccountHolderName());
    }

    // Betrag überweisen (muss von jeder spezifischen Zahlungsmethode implementiert werden)
    protected abstract void transferAmount(Account sender, Account receiver, CurrencyAmount amount);

    // Zahlungsbestätigung erstellen (für alle Zahlungsarten gleich)
    protected void generateReceipt(Account sender, Account receiver, CurrencyAmount amount) {
        System.out.println("Zahlung von " + amount.getAmount() + " " + amount.getCurrency()
                + " von " + sender.getAccountHolderName() + " an " + receiver.getAccountHolderName() + " abgeschlossen.");
    }
}

