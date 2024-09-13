package statistics;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import booking.Booking;
import booking.EnglishBooking;
import booking.GermanBooking;

public class StatisticsServiceTest {

    private List<Booking> bookings;
    private StatisticsService statisticsService;

    @BeforeEach
    public void setUp() {
        // Beispielbuchungen einrichten
        bookings = new ArrayList<>();
        bookings.add(new GermanBooking("PayPal"));
        bookings.add(new EnglishBooking("GoogleWallet"));
        bookings.add(new GermanBooking("MoneyWallet"));
        bookings.add(new EnglishBooking("MoneyWallet"));

        statisticsService = new StatisticsService(bookings);
    }

    @Test
    public void testGetGermanBookingsPaidByPayPal() {
        // Teste das Abrufen von Buchungen in deutscher Sprache, die mit PayPal bezahlt wurden
        statisticsService.getGermanBookingsPaidBy("PayPal");
        // Hier würdest du die Ausgabe oder das Verhalten der Methode prüfen
        assertTrue(bookings.get(0).getPaymentType().equals("PayPal"));
    }

    @Test
    public void testGetEnglishBookingsPaidByGoogleWallet() {
        // Teste das Abrufen von englischen Buchungen, die mit Google Wallet bezahlt wurden
        statisticsService.getEnglishBookingsPaidBy("GoogleWallet");
        assertTrue(bookings.get(1).getPaymentType().equals("GoogleWallet"));
    }

    @Test
    public void testGetGermanBookingsPaidByMoneyWallet() {
        // Teste das Abrufen von deutschen Buchungen, die mit MoneyWallet bezahlt wurden
        statisticsService.getGermanBookingsPaidBy("MoneyWallet");
        assertTrue(bookings.get(2).getPaymentType().equals("MoneyWallet"));
    }

    @Test
    public void testGetEnglishBookingsPaidByMoneyWallet() {
        // Teste das Abrufen von englischen Buchungen, die mit MoneyWallet bezahlt wurden
        statisticsService.getEnglishBookingsPaidBy("MoneyWallet");
        assertTrue(bookings.get(3).getPaymentType().equals("MoneyWallet"));
    }
}
