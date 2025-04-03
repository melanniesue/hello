package RealState;

public abstract class Property {

	private String streetAddress;
	private int zip;
	private double listPrice;  
    private double appraisalPrice;
	
	public Property() { 
		streetAddress = "";
		zip = 0;
		listPrice = 0;        
        appraisalPrice = 0;
		
	}

	public Property(String streetAddress, int zip) {
		this.streetAddress = streetAddress;
		this.zip = zip;
		
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	
	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}
	
	public double getListPrice() {
		return listPrice;

	}
	
	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	
	}
	
	public double getAppraisalPrice() {
		return appraisalPrice;
	}
	
	protected void setAppraisalPrice(double appraisalPrice) {
		this.appraisalPrice = appraisalPrice;
	}
	
	
	public abstract double calculateAppraisalPrice();

}