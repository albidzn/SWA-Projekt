package resource;

public class SetTopBox extends Resource {

	public SetTopBox(int id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "SetTopBox: " + getResourceName();
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return + 39.99;
	}
	
}