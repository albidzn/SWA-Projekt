package authentification;


public class Subject {
	private String id;
	private String type;

	public Subject(String id, String type) {
		this.id = id;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Subject [ID=" + id + ", Type=" + type + "]";
	}
}
