package statistics;

import booking.EnglishBooking;
import booking.GermanBooking;

public interface BookingVisitor {
    void visit(GermanBooking germanBooking);
    void visit(EnglishBooking englishBooking);
}
