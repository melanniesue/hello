package RealState;

import java.util.HashMap;
import java.util.Set;

public abstract class Residential extends Property implements Biddable {
	
	private int bedCount;
	private int bathCount;
	private double sqFootage;
	private HashMap<String, Double> bids;
	
	Residential() {
		super();
		this.bedCount = 0;
		this.bathCount = 0;
		this.sqFootage = 0;
		this.bids = new HashMap<>();
		
	}

	public Residential(String streetAddress,int zip, int bedCount, int bathCount, double sqFootage) {
		super( streetAddress, zip);
		this.bedCount = bedCount;
		this.bathCount = bathCount;
		this.sqFootage = sqFootage;
		this.bids = new HashMap<>();
	}
	
	public int getBedCount() {
		return bedCount;
	}

	public void setBedCount(int bedCount) {
		this.bedCount = bedCount;
	}

	public int getBathCount() {
		return bathCount;
	}

	public void setBathCount(int bathCount) {
		this.bathCount = bathCount;
	}

	public double getSqFootage() {
		return sqFootage;
	}

	public void setSqFootage(double sqFootage) {
		this.sqFootage = sqFootage;
	}
	
	public abstract double calculateAppraisalPrice();

	    
	@Override
	public HashMap<String, Double> getBids() {
		return bids;
	}

	@Override
	public double getBid(String name ) {
		return bids.get(name);
	}

	@Override
	public Set<String> getBidders() {
		return bids.keySet();
	}

	@Override
	public double getBidCount() {
		return bids.size();
	}

	@Override
	public void newBids(String name, Double bidValue) {
		bids.put(name, bidValue);
	}
	

}
