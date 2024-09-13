package statistics;

// Concrete Visitor for Payments
public class PaymentTypeVisitor implements BookingVisitor {
    private String paymentType; // Zahlungsart 
    
    public PaymentTypeVisitor(String paymentType) {
        this.paymentType = paymentType;
    }
    
    @Override
    public void visit(GermanBooking germanBooking) {
        if (germanBooking.getPaymentType().equals(paymentType)) {
            System.out.println("Processing German booking paid by " + paymentType);
            // Statistiken für deutsche Buchung berechnen
        }
    }

    @Override
    public void visit(EnglishBooking englishBooking) {
        if (englishBooking.getPaymentType().equals(paymentType)) {
            System.out.println("Processing English booking paid by " + paymentType);
            // Statistiken für englische Buchung berechnen
        }
    }
}
