package resource;

//Basisklasse für andere Ausstttungsmerkmale
//dient dazu andere Eigenschaften hinzuzufügen ohne Ressource zu verändern.

public abstract class ResourceDecorator extends Resource {
	protected Resource resource;

	public ResourceDecorator(Resource resource) {
		super(resource.getResourceID(), resource.getResourceName());
		this.resource = resource;
	}

	@Override
	public String getDescription() {
		return resource.getDescription();
	}

	@Override
	public double getPrice() {
		return resource.getPrice();
	}
}
