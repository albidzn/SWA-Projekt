package statistics;

import booking.EnglishBooking;
import booking.GermanBooking;

//Das Visitor Interface
public interface BookingVisitor {
 void visit(GermanBooking germanBooking);
 void visit(EnglishBooking englishBooking);
}




