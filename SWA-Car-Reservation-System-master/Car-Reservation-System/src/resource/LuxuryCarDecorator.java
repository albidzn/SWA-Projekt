package resource;

//Upgrade zu einem Luxusfahrzeug. Beispiel aus A3 wird A8
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
        // Zufälligen Index auswählen
        int index = (int) (Math.random() * models.length);
        return models[index]; // Gibt das zufällig ausgewählte Modell zurück
    }

    
    
    @Override
    public String getDescription() {
        return "Car: " + selectedLuxuryModel + " (Luxusfahrzeug) oder ähnliches";
    }

    @Override
    public double getPrice() {
        return resource.getPrice() + 150.00; // Luxuspaket kostet 150.00
    }
}
