package resource;

////Ausstattung: Kraftstoff
public class BenzinDecorator extends ResourceDecorator {

	public BenzinDecorator(Resource resource) {
		super(resource);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return super.getDescription() + " mit Benzinkraftstoff.";
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return super.getPrice() + 0.00;
	}

}
