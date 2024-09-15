package resource;

//Fahrradträger für das Heck
public class BicycleRackDecorator extends ResourceDecorator {

	public BicycleRackDecorator(Resource resource) {
		super(resource);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return super.getDescription() + " mit Fahrradträger (max. zwei Fahrräder)";
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return super.getPrice() + 89.99;
	}
}
