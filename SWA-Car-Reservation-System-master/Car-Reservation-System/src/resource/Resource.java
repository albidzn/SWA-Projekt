package resource;

//Grundlage aller Ressourcen
public abstract class Resource {
	protected int id;
	protected String name;

	public Resource(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getResourceID() {
		return id;
	}

	public String getResourceName() {
		return name;
	}

	// Grundlegende Methoden
	public abstract String getDescription();

	public abstract double getPrice();
}
