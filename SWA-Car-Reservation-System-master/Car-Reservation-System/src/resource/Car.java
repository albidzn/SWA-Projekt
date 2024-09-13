package resource;

import java.util.Random;

public class Car extends Resource {

	private String selectedModel;

	// Standardkonstruktor mit zufälliger Auswahl
	public Car(int id, String name) {
		super(id, name);
		this.selectedModel = selectRandomModel(new String[] { "Audi A3", "BMW 1er", "VW Golf 8" });
	}

	// Neuer Konstruktor für Tests, um ein spezifisches Modell zu wählen
	public Car(int id, String name, String model) {
		super(id, name);
		this.selectedModel = model; // Setzt das explizit angegebene Modell
	}

	private String selectRandomModel(String[] models) {
		Random random = new Random();
		int index = random.nextInt(models.length);
		return models[index];
	}

	@Override
	public String getDescription() {
		return "Car: " + selectedModel; // Ausgabe des ausgewählten Modells
	}

	@Override
	public double getPrice() {
		return 50.00; // Möglicher Basispreis
	}
}
