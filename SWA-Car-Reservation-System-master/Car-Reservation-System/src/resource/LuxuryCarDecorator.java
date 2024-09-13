package resource;

import java.util.Random;

public class LuxuryCarDecorator extends ResourceDecorator {

	private String selectedLuxuryModel;

	public LuxuryCarDecorator(Resource resource) {
		super(resource);
		this.selectedLuxuryModel = selectRandomModel(new String[] { "Mercedes S-Klasse", "BMW 7er", "Audi A8" });
	}

	public LuxuryCarDecorator(Resource resource, String luxuryModel) {
		super(resource);
		this.selectedLuxuryModel = luxuryModel;
	}

	private String selectRandomModel(String[] models) {
		Random random = new Random();
		int index = random.nextInt(models.length);
		return models[index];
	}

	@Override
	public String getDescription() {
		return "Car: " + selectedLuxuryModel + " (Luxusfahrzeug) oder ähnliches";
	}

	@Override
	public double getPrice() {
		return super.getPrice() + 150.00;
	}

}
