
public class Property {

	private String propertyName;
	private String location;
	private double rentalAmount;
	private String owner;
	private int x, y, width, depth;
	private Plot plot;
	
	public Property() {
		this.propertyName = propertyName;
		this.location = location;
		this.rentalAmount = rentalAmount;
		this.owner = owner;
	}
	
	public Property(Property p) {
		propertyName = p.propertyName;
		location = p.location;
		rentalAmount = p.rentalAmount;
		owner = p.owner;
	}
	
	public Property(String propName, String city, double rentAmount, String own ) {
		
		propertyName = propName;
		location = city;
		rentalAmount = rentAmount;
		owner = own;
		
	}
	public Property(String propName, String city, double rent, String own, int x, int y, int width, int depth ) {
	
		propertyName = propName;
		location = city;
		rentalAmount = rent;
		owner = own;
		plot = new Plot(x,y, width, depth);

	}
	
	public void setPropertyName(String propName) {
		propertyName = propName;
	}
	
	public void setLocation(String city) {
		location = city;
	}
	public void setRentalAmount(double rentAmount) {
		rentalAmount = rentAmount;
	}
	public void setOwner(String own) {
		owner = own;
	}
	
	public void setPlot() {
		plot = new Plot(x,y, width, depth);
	}
	public Plot getPlot() {
		return plot;
	}


	public String getPropertyName() {
		return propertyName;
	}
	public String getLocation() {
		return location;
	}
	public double getRentalAmount() {
		return rentalAmount;
	}
	
	public String getOwner() {
		return owner;
	}

	
	public String toString() {
		
		return "Property Name: " + getPropertyName() + "\n" +
				"Located in " + getLocation() + "\n" + 
				"Belonging to: " + getOwner() + "\n" +
				"Mortgage Amount: " + getRentalAmount();
	}


}
