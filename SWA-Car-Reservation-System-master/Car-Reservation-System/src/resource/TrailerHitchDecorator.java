package resource;

public class TrailerHitchDecorator extends ResourceDecorator{
    public TrailerHitchDecorator(Resource resource) {
    	super(resource);
    }

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return super.getDescription() + " mit Anhängerkupplung";
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return super.getPrice() + 59.99;
	}
    
    
}