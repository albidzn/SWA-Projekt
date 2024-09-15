package advertising;

public class AdvertisingSystem implements Observer{
	
	private MessagingSystem messagingSystem;
	
	public AdvertisingSystem(MessagingSystem messagingSystem) {
        this.messagingSystem = messagingSystem;
    }
	
    @Override
    public void update(String message) {
        // Hier wird auf das Buchungsereignis reagiert
        sendAdMessage(message);
    }
    
    // Methode, die das Messaging-System nutzt, um Werbung zu verschicken
    private void sendAdMessage(String bookingDetails) {
        String adMessage = "Werbung: Buchen Sie Ihr nächstes Auto bei uns! Sonderangebot für " + bookingDetails;
        messagingSystem.sendMessage(adMessage);
    }
}
