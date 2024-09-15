package resource;

//Ausstattung: NAvi mit neumodernem CarPLay etc
public class NaviDecorator extends ResourceDecorator {

	public NaviDecorator(Resource resource) {
		super(resource);
	}

	@Override
	public String getDescription() {
		return resource.getDescription() + " mit Navigationsgerät inkl. AppleCarPlay und AndroidCar";
	}

	@Override
	public double getPrice() {
		return resource.getPrice() + 5.0;
	}
}