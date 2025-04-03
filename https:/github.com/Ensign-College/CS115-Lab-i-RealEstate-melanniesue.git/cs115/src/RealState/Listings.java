package RealState;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Listings implements Listable{

    private HashMap<String, Residential> listings;

    public Listings() {
        listings = new HashMap<>();
    }

    @Override
    public HashMap<String, Residential> getListings() {
        return listings;
    }

    @Override
    public Residential getListing(String street) {
        return listings.get(street);
    }

    @Override
    public Set<String> getStreetAddresses() {
        return listings.keySet();
    }

    @Override
    public Collection<Residential> getResidences() {
        return listings.values();
    }

    @Override
    public int getListingCount() {
        return listings.size();
    }

    @Override
    public void addListing(String street, Residential res) {
        listings.put(street, res);
    }
}

