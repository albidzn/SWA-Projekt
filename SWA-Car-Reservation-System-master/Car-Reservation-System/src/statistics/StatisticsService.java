package statistics;

import booking.EnglishBooking;
import booking.GermanBooking;

public class StatisticsService implements BookingVisitor {

    @Override
    public void visit(GermanBooking germanBooking) {
        String header = germanBooking.createHead();
        String body = germanBooking.createBody();
        String footer = germanBooking.createFooter();
        
        System.out.println(header);
        System.out.println(body);
        System.out.println(footer);

        if ("PayPal".equals(germanBooking.getPaymentMethod())) {
            getGermanBookingsPaidByPayPal();
        } else if ("GoogleWallet".equals(germanBooking.getPaymentMethod())) {
            getGermanBookingsPaidByGoogleWallet();
        } else if ("MoneyWallet".equals(germanBooking.getPaymentMethod())) {
            getGermanBookingsPaidByMoneyWallet();
        }
    }

    @Override
    public void visit(EnglishBooking englishBooking) {
        String header = englishBooking.createHead();
        String body = englishBooking.createBody();
        String footer = englishBooking.createFooter();

        System.out.println(header);
        System.out.println(body);
        System.out.println(footer);

        if ("PayPal".equals(englishBooking.getPaymentMethod())) {
            getEnglishBookingsPaidByPayPal();
        } else if ("GoogleWallet".equals(englishBooking.getPaymentMethod())) {
            getEnglishBookingsPaidByGoogleWallet();
        } else if ("MoneyWallet".equals(englishBooking.getPaymentMethod())) {
            getEnglishBookingsPaidByMoneyWallet();
        }
    }

    // Methoden für deutsche Buchungen
    public void getGermanBookingsPaidByPayPal() {
        System.out.println("Deutsche Buchungen, die mit PayPal bezahlt wurden.");
    }

    public void getGermanBookingsPaidByGoogleWallet() {
        System.out.println("Deutsche Buchungen, die mit GoogleWallet bezahlt wurden.");
    }

    public void getGermanBookingsPaidByMoneyWallet() {
        System.out.println("Deutsche Buchungen, die mit MoneyWallet bezahlt wurden.");
    }

    // Methoden für englische Buchungen
    public void getEnglishBookingsPaidByPayPal() {
        System.out.println("Englische Buchungen, die mit PayPal bezahlt wurden.");
    }

    public void getEnglishBookingsPaidByGoogleWallet() {
        System.out.println("Englische Buchungen, die mit GoogleWallet bezahlt wurden.");
    }

    public void getEnglishBookingsPaidByMoneyWallet() {
        System.out.println("Englische Buchungen, die mit MoneyWallet bezahlt wurden.");
    }
}
