package resource;

//Kindersitz
public class ChildSeat extends Resource {

	public ChildSeat(int id, String name) {
		super(id, name);
	}

	@Override
	public String getDescription() {
		return "Child Seat: " + name;
	}

	@Override
	public double getPrice() {
		return 15.0; // Beispielpreis
	}
}
