package resource;

public class Car extends Resource {

	public Car(int id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Car: " + getResourceName();
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 50.00;
	}
	
}