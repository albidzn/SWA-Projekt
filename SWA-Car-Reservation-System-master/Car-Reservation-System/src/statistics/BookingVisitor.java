package statistics;


//Das Visitor Interface
public interface BookingVisitor {
 void visit(GermanBooking germanBooking);
 void visit(EnglishBooking englishBooking);
}




