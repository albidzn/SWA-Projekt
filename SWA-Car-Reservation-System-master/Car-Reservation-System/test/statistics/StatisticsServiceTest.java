package statistics;

import booking.EnglishBooking;
import booking.GermanBooking;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import statistics.StatisticsService;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class StatisticsServiceTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private StatisticsService statisticsService;

    @Before
    public void setUp() {
        statisticsService = new StatisticsService();
        // Um die Konsolenausgabe aufzuzeichnen
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void tearDown() {
        // Setze die Standardausgabe wieder zurück
        System.setOut(originalOut);
    }

    @Test
    public void testVisitGermanBookingWithPayPal() {
        GermanBooking germanBooking = new GermanBooking("PayPal");
        statisticsService.visit(germanBooking);

        String expectedOutput = "Deutsche Buchungskopfzeile\n" +
                                "Deutscher Buchungstext\n" +
                                "Deutsche Buchungsfußzeile\n" +
                                "Deutsche Buchungen, die mit PayPal bezahlt wurden.\n";

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testVisitGermanBookingWithGoogleWallet() {
        GermanBooking germanBooking = new GermanBooking("GoogleWallet");
        statisticsService.visit(germanBooking);

        String expectedOutput = "Deutsche Buchungskopfzeile\n" +
                                "Deutscher Buchungstext\n" +
                                "Deutsche Buchungsfußzeile\n" +
                                "Deutsche Buchungen, die mit GoogleWallet bezahlt wurden.\n";

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testVisitEnglishBookingWithPayPal() {
        EnglishBooking englishBooking = new EnglishBooking("PayPal");
        statisticsService.visit(englishBooking);

        String expectedOutput = "English Booking Header\n" +
                                "English Booking Body\n" +
                                "English Booking Footer\n" +
                                "Englische Buchungen, die mit PayPal bezahlt wurden.\n";

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testVisitEnglishBookingWithMoneyWallet() {
        EnglishBooking englishBooking = new EnglishBooking("MoneyWallet");
        statisticsService.visit(englishBooking);

        String expectedOutput = "English Booking Header\n" +
                                "English Booking Body\n" +
                                "English Booking Footer\n" +
                                "Englische Buchungen, die mit MoneyWallet bezahlt wurden.\n";

        assertEquals(expectedOutput, outputStream.toString());
    }
}
