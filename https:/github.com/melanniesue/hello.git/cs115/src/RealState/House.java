package RealState;

import java.text.DecimalFormat;

public class House extends Residential{

    private double yardAcres;

    public House(String streetAddress,int zip, int bedCount, int bathCount, double sqFootage) {
        super();
        yardAcres = 0.0;

    }

    public House(String streetAddress, int zip, int bedcount, int bathcount, double sqFoot, double yardAcres) {
        super(streetAddress, zip, bedcount, bathcount, sqFoot);
        this.yardAcres = yardAcres;
    }

    public double getYardAcres() {
        return yardAcres;
    }

    public void setYardAcres(double yardAcres) {
        this.yardAcres = yardAcres;
    }

    @Override
    public double calculateAppraisalPrice() {
        double costs=(97*getSqFootage())+(10000*getBedCount())+(12000*getBathCount())+(yardAcres*460000);
        setAppraisalPrice(costs);
        return costs;
    }

    @Override
    public String toString() {
        String string;
        DecimalFormat dFormat = new DecimalFormat("####,###,###.00");

        string = "-------------------------------------------------------------------------------------------------------\n" +
                "Residence Type: House           Address: "+getStreetAddress()+"           Zip Code: "+getZip()+"\n" +
                "-------------------------------------------------------------------------------------------------------\n" +
                "Sq Footage: "+getSqFootage()+"\n" +
                "Bedrooms: "+getBedCount()+"\n" +
                "Bathrooms: "+getBathCount()+"\n" +
                "Yard Size (Acres): "+getYardAcres()+"\n" +
                "------------------------------------------\n" +
                "Appraisal Price: $"+dFormat.format(getAppraisalPrice())+"\n" +
                "List Price: $"+dFormat.format(getListPrice())+"\n" +
                "------------------------------------------\n";
        return string;
    }
}

