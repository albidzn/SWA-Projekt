package resource;


//Ausstattung: ZUsätzlicher Fahrer buchen
public class AdditionalDriverDecorator extends ResourceDecorator {
	private String driverName;
	private int driverAge;
	private static final int MINIMUM_DRIVER_AGE = 18;

	public AdditionalDriverDecorator(Resource resource, String driverName, int driverAge) {
		super(resource);
		this.driverAge = driverAge;
	}

	@Override
	public String getDescription() {
		if (driverAge >= MINIMUM_DRIVER_AGE) {
			return resource.getDescription() + " mit zusätzlichem Fahrer: " + driverName + " (Alter: " + driverAge + ".)";
		} else {
			return resource.getDescription() + " Ihr zusätzlicher Fahrer: " + driverName + " ist zu jung (Alter: " + driverAge + ".)";
		}
	}

	@Override
	public double getPrice() {
		if (driverAge >= MINIMUM_DRIVER_AGE) {
			return resource.getPrice() + 10.00;
		} else {
			return resource.getPrice(); // nicht zugelassen, daher keine kosten
		}
	}

	public String getDriverName() {
		return driverName;
	}

	public int getDriverAge() {
		return driverAge;
	}

	
}