package RealState;

import java.text.DecimalFormat;

public class Condo extends Residential {

    private int floorLvl;

    public Condo(String name, int zipcode, int bedcount, int bathcount, double sqFoot){
        super();
        floorLvl = 0;
    }

    public Condo(String streetAddress, int zip, int bedcount, int bathcount, double sqFoot, int floorLvl) {
        super( streetAddress, zip, bedcount, bathcount, sqFoot);
        this.floorLvl = floorLvl;
    }

    public int getFloorLvl() {
        return floorLvl;
    }

    public void setFloorLvl(int floorLvl) {
        this.floorLvl = floorLvl;
    }

    @Override
    public double calculateAppraisalPrice() {
        double costs =(88*getSqFootage())+(8000*getBedCount())+(10000*getBathCount());
        if(floorLvl>1)
        {
            costs +=((floorLvl-1)*5000);
        }
        setAppraisalPrice(costs);
        return costs;
    }

    @Override
    public String toString() {
        String string;
        DecimalFormat dFormat = new DecimalFormat("####,###,###.00");

        string = "-------------------------------------------------------------------------------------------------------\n" +
                "Residence Type: Condo           Address: "+getStreetAddress()+"           Zip Code: "+getZip()+"\n" +
                "-------------------------------------------------------------------------------------------------------\n" +
                "Sq Footage: "+getSqFootage()+"\n" +
                "Bedrooms: "+getBedCount()+"\n" +
                "Bathrooms: "+getBathCount()+"\n" +
                "Floor: "+getFloorLvl()+"\n" +
                "------------------------------------------\n" +
                "Appraisal Price: $"+dFormat.format(getAppraisalPrice())+"\n" +
                "List Price: $"+dFormat.format(getListPrice())+"\n" +
                "------------------------------------------\n";
        return string;
    }
}
