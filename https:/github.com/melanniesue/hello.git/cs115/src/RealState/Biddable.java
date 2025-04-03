package RealState;

import java.util.HashMap;
import java.util.Set;

public interface Biddable {
	
	HashMap<String, Double> getBids();
	
	double getBid(String street );
	
	Set<String> getBidders();
	
	double getBidCount();
	
	void newBids(String street, Double sqfootage);

/*getBids() - Takes no arguments and  returns a HashMap<String, Double> containing a list of bidder names (key) and their associated bid (value)
getBid(String) - Takes a String argument and returns the Double value for the associated String key in a HashMap<String, Double>
getBidders() - Takes no arguments and returns a Set<String> of keys from a HashMap<String, Double>
getBidCount() - Takes no arguments and returns the number of bids in the HashMap<String, Double>
newBid(String, Double) Returns void. Either updates the value for the key or adds a new key/value pair in a HashMap<String, Double>*/
}

