package instance;


public class CarReservationSystem {
    // Die einzige Instanz der Klasse
    private static CarReservationSystem instance;

    // Privater Konstruktor, um zu verhindern, dass Instanzen außerhalb der Klasse erstellt werden
    private CarReservationSystem() {
        // Initialisierungscode hier
    }

    // Synchronized Methode, um die Instanz sicher zu erstellen
    public static synchronized CarReservationSystem getInstance() {
        if (instance == null) {
            instance = new CarReservationSystem();
        }
        return instance;
    }

    // Beispielmethode für das Reservierungssystem
    public void makeReservation() { // operation() heißt es im allgemeinen Klassendiagramm 
        System.out.println("Reservation made!");
    }
}
