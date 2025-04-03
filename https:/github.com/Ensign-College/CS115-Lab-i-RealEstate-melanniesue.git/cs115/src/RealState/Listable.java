package RealState;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public interface Listable {
	
    HashMap<String, Residential> getListings();
    
    Residential getListing(String street);
    
    Set<String> getStreetAddresses();
    
    Collection<Residential> getResidences();
    
    int getListingCount();
    
    void addListing(String street, Residential res);
}
/*getListings() - Takes no arguments and  returns a HashMap<String, Residential> containing a list of street addresses (key) and their associated residences (value)
getListing(String) - Takes a String argument and returns the Residential value for the associated String key in a HashMap<String, Residential>
getStreetAddresses() - Takes no arguments and returns a Set<String> of keys from a HashMap<String, Residential>
getResidences() - Takes no arguments and returns a Collection<Residential> of values from a HashMap<String, Residential>
getListingCount() - Takes no arguments and returns the number of listings in the HashMap<String, Residential>
addListing(String, Residential) Returns void. Adds a new key/value pair in a HashMap<String, Residential>*/