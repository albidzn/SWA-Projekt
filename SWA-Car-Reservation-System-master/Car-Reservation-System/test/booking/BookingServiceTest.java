package booking;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookingServiceTest {
    private BookingService bookingService;

    @BeforeEach
    public void setUp() {
        bookingService = new BookingService();
    }

    @Test
    public void testCreateGermanBooking() {
        // Erstelle ein Fahrzeug
        Fahrzeug fahrzeug = new Fahrzeug.Builder()
                .setKategorie("Kompaktklasse")
                .setModell("VW Golf")
                .setAutomatik(true)
                .setKlimaanlage(true)
                .setNavigationssystem(true)
                .build();

        // PreisDetails erstellen
        PriceDetails priceDetails = new PriceDetails.Builder()
                .setMietpreis(200.0)
                .setSteuern(20.0)
                .setGebuehren(15.0)
                .setAnzahlung(50.0)
                .build();

        // VersicherungsDetails erstellen
        InsuranceDetails insuranceDetails = new InsuranceDetails.Builder()
                .setVollkasko(true)
                .setSelbstbeteiligung(500.0)
                .setHaftpflicht(true)
                .setDiebstahlschutz(true)
                .build();

        // Erstelle eine deutsche Buchung
        Booking germanBooking = new GermanBooking();
        String bookingDetails = bookingService.createBooking(germanBooking, fahrzeug, priceDetails, insuranceDetails);

        // Überprüfe, ob der Buchungsstring die erwarteten Inhalte enthält
        assertTrue(bookingDetails.contains("Buchungskopf (Deutsch): Ihre Reservierungsdetails"));
        assertTrue(bookingDetails.contains("Fahrzeug: Kompaktklasse - VW Golf"));
        assertTrue(bookingDetails.contains("Preis: 235.0 Euro"));
        assertTrue(bookingDetails.contains("Buchungsfußzeile (Deutsch): Vielen Dank für Ihre Buchung."));
    }

    @Test
    public void testCreateEnglishBooking() {
        // Erstelle ein Fahrzeug
        Fahrzeug fahrzeug = new Fahrzeug.Builder()
                .setKategorie("Mittelklasse")
                .setModell("BMW 3er")
                .setAutomatik(true)
                .setKlimaanlage(true)
                .setNavigationssystem(true)
                .build();

        // PreisDetails erstellen
        PriceDetails priceDetails = new PriceDetails.Builder()
                .setMietpreis(300.0)
                .setSteuern(30.0)
                .setGebuehren(20.0)
                .setAnzahlung(100.0)
                .build();

        // VersicherungsDetails erstellen
        InsuranceDetails insuranceDetails = new InsuranceDetails.Builder()
                .setVollkasko(true)
                .setSelbstbeteiligung(1000.0)
                .setHaftpflicht(true)
                .setDiebstahlschutz(true)
                .build();

        // Erstelle eine englische Buchung
        Booking englishBooking = new EnglishBooking();
        String bookingDetails = bookingService.createBooking(englishBooking, fahrzeug, priceDetails, insuranceDetails);

        // Überprüfe, ob der Buchungsstring die erwarteten Inhalte enthält
        assertTrue(bookingDetails.contains("Booking Head (English): Your reservation details"));
        assertTrue(bookingDetails.contains("Fahrzeug: Mittelklasse - BMW 3er"));
        assertTrue(bookingDetails.contains("Preis: 350.0 Euro"));
        assertTrue(bookingDetails.contains("Booking Footer (English): Thank you for your reservation."));
    }
}
