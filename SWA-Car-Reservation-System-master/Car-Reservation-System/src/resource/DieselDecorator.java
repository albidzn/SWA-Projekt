package resource;

public class DieselDecorator extends ResourceDecorator {
	public DieselDecorator(Resource resource) {
		super(resource);
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return super.getDescription() + " mit Dieselkraftstoff";
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return super.getPrice() + 0.00;
	}
	
	
}
