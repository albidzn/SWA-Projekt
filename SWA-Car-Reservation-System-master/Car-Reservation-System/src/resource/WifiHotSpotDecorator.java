package resource;
//Ausstattung: WLAN im Auto
public class WifiHotSpotDecorator extends ResourceDecorator {
	public WifiHotSpotDecorator(Resource resource) {
		super(resource);
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return super.getDescription() + " mit Wifi Hotspot (20GB)";
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return super.getPrice() + 24.99;
	}
	
	
	

}
