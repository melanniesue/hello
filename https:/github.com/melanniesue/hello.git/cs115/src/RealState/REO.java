package RealState;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class REO {

    private static Listings listings;//static
 
    public static void printHeader(String header) {
        System.out.println("\n");
        for (int i = 0; i < 40; i++) {
            System.out.print("-");
        }
        System.out.println();

        for (int i = 0; i < 20 - (header.length()) / 2; i++) {
            System.out.print(" ");
        }
        System.out.println(header);

        for (int i = 0; i < 40; i++) {
            System.out.print("-");
        }
        System.out.println("\n");
    }
   
    public static void mainMenuInterface(Scanner mainMenu) {

        boolean done = false;

        while (!done){
            printHeader("Main Menu");

            System.out.println("1: Listings ");
            System.out.println("2: Bids \n");
            System.out.print("What would you like to do?(1-2): ");
            int choice = mainMenu.nextInt();
			mainMenu.nextLine();

			switch (choice) {
			case 1:
				listingMenuInterface(mainMenu);
				break;
			case 2:
				bidsMenuInterface(mainMenu);
				break;
			default:
				done = true;
				break;
			}
		}
	}

	public static void autoPopulateListings() {

		int currentSize = listings.getListings().size();
		House house1 = new House("34 Elm", 95129, 3, 2, 2200, .2);
		house1.setListPrice(house1.calculateAppraisalPrice() * 1.1);
		listings.addListing("34 Elm", house1);
		House house2 = new House("42 Hitchhikers", 95136, 4, 3, 2800, .3);
		house2.setListPrice(house2.calculateAppraisalPrice() * 1.1);
		listings.addListing("42 Hitchhikers", house2);
		Condo condo1 = new Condo("4876 Industrial", 95177, 3, 1, 1800, 3);
		condo1.setListPrice(condo1.calculateAppraisalPrice() * 1.1);
		listings.addListing("4876 Industrial", condo1);
		House house3 = new House("2654 Oak", 84062, 5, 53, 4200, .5);
		house3.setListPrice(house3.calculateAppraisalPrice() * 1.1);
		listings.addListing("2654 Oak", house3);
		Condo condo2 = new Condo("9875 Lexington", 84063, 2, 1, 1500, 1);
		condo2.setListPrice(condo2.calculateAppraisalPrice() * 1.1);
		listings.addListing("9875 Lexington", condo2);
		Condo condo3 = new Condo("3782 Market", 84066, 3, 1, 1800, 2);
		condo3.setListPrice(condo3.calculateAppraisalPrice() * 1.1);
		listings.addListing("3782 Market", condo3);
		House house4 = new House("7608 Glenwood", 84055, 6, 3, 3900, .4);
		house4.setListPrice(house4.calculateAppraisalPrice() * 1.1);
		listings.addListing("7608 Glenwood", house4);
		House house5 = new House("1220 Apple", 84057, 8, 7, 7900, 1);
		house5.setListPrice(house5.calculateAppraisalPrice() * 1.1);
		listings.addListing("1220 Apple", house5);
		int added = listings.getListingCount() - currentSize;

		System.out.println(added + " residences have been added to the listings for testing purposes.");
	}

	public static void showListings() {
		System.out.println("Current Listings for REO:");
		int count = 1;
		for (String key : listings.getStreetAddresses()) {
			System.out.println("Listing No: " + count);
			System.out.println(listings.getListing(key));
			System.out.println();
			count++;
		}
	}

	public static void listingMenuInterface(Scanner ListMenu) {

		boolean done = false;

		while (!done) {
			printHeader("Listing Menu");

			System.out.println("1: Add Listings ");
			System.out.println("2: Show Listings ");
			System.out.println("3: Auto Populate Listings (Dev tool) ");
			System.out.println("ENTER: Exit back to previous menu \n");
			System.out.print("What would you like to do?(1-3): ");

			String choice = ListMenu.nextLine();

			switch (choice) {
			case "1":
				addListingMenuInterface(ListMenu);
				break;
			case "2":
				showListings();
				break;
			case "3":
				autoPopulateListings();
				break;
			case "":
				done = true;
				break;
			default:
				break;
			}
		}
	}

	public static void ResidentialHouse(Scanner house, Residential residential) {

		System.out.print("Please enter the street address for the residence: ");
		residential.setStreetAddress(house.nextLine());

		System.out.print("Please enter the zip code for the residence: ");
		residential.setZip(Integer.parseInt(house.nextLine()));

		System.out.print("Please enter the number of bedrooms: ");
		residential.setBedCount(Integer.parseInt(house.nextLine()));

		System.out.print("Please enter the number of bathrooms: ");
		residential.setBathCount(Integer.parseInt(house.nextLine()));

		System.out.print("Please enter the square footage of the residence: ");
		residential.setSqFootage(Double.parseDouble(house.nextLine()));

		if (residential instanceof Condo) {
			System.out.print("Please enter the floor level of the condo: ");
			((Condo) residential).setFloorLvl(Integer.parseInt(house.nextLine()));
		} else {
			System.out.print("Please enter the size of the yard in acres: ");
			((House) residential).setYardAcres(Double.parseDouble(house.nextLine()));
		}
		DecimalFormat dFormat = new DecimalFormat("####,###,###.00");
		System.out.println(
				"\nAppraisal Price for this property is: $" + dFormat.format(residential.calculateAppraisalPrice()));

		System.out.print("Please enter the List Price for the property: $");
		residential.setListPrice(Double.parseDouble(house.nextLine()));

		System.out.println("\nYou have created a new listing");
		System.out.println(residential);
	}

	public static void ResidentialCondo(Scanner condo, Residential residential) {

		System.out.print("Please enter the street address for the residence: ");
		residential.setStreetAddress(condo.nextLine());

		System.out.print("Please enter the zip code for the residence: ");
		residential.setZip(Integer.parseInt(condo.nextLine()));

		System.out.print("Please enter the number of bedrooms: ");
		residential.setBedCount(Integer.parseInt(condo.nextLine()));

		System.out.print("Please enter the number of bathrooms: ");
		residential.setBathCount(Integer.parseInt(condo.nextLine()));

		System.out.print("Please enter the square footage of the residence: ");
		residential.setSqFootage(Double.parseDouble(condo.nextLine()));

		if (residential instanceof Condo) {
			System.out.print("Please enter the floor level of the condo: ");
			((Condo) residential).setFloorLvl(Integer.parseInt(condo.nextLine()));
		} else {
			System.out.print("Please enter the size of the yard in acres: ");
			((House) residential).setYardAcres(Double.parseDouble(condo.nextLine()));
		}
		DecimalFormat dFormat = new DecimalFormat("####,###,###.00");
		System.out.println(
				"\nAppraisal Price for this property is: $" + dFormat.format(residential.calculateAppraisalPrice()));

		System.out.print("Please enter the List Price for the property: $");
		residential.setListPrice(Double.parseDouble(condo.nextLine()));

		System.out.println("\nYou have created a new listing");
		System.out.println(residential);
	}

	public static void addListingMenuInterface(Scanner addList) {
		printHeader("Add Listing Menu");

		System.out.println("1: Add House ");
		System.out.println("2: Add Condo ");
		System.out.println("ENTER: Exit back to previous menu \n");
		System.out.print("What would you like to do?(1-2): ");

		String choice = addList.nextLine();

		switch (choice) {
		case "1":
			House house = new House("", 0, 0, 0, 0);
			ResidentialHouse(addList, house);
			listings.addListing(house.getStreetAddress(), house);
			break;
		case "2":
			Condo condo = new Condo("", 0, 0, 0, 0);
			ResidentialCondo(addList, condo);
			listings.addListing(condo.getStreetAddress(), condo);
			break;
		case "":
			listingMenuInterface(addList);
			break;
		default:
			break;
		}
	}

	public static void bidsMenuInterface(Scanner bidMenu) {
		
		boolean done = false;
		while(!done) {
			printHeader("Bids Menu");
			System.out.println("1: Add New Bid ");
			System.out.println("2: Show Existing Bids ");
			System.out.println("3: Auto Populate Bids (Dev tool) ");
			System.out.println("ENTER: Exit back to previous menu \n");
			System.out.print("What would you like to do?(1-3): ");

			String choice = bidMenu.nextLine();
			
			switch (choice) {
			case "1":
				addBiddingMenuInterface(bidMenu);
				break;
			case "2":
				showBidding(bidMenu);
				break;
			case "3":
				autoPopulateBidding(bidMenu);
				break;
			case "":{
				done = true;
				mainMenuInterface(bidMenu);
				break;
			}
			default:
				break;
			}
		}
	}
	
	private static void printCurrentListing(int i) {
		for (String key : listings.getStreetAddresses()) {
			System.out.print(i++);
			System.out.printf(" %s",listings.getListing(key).getStreetAddress());
			System.out.printf("(%.0f)",listings.getListing(key).getBidCount());
			System.out.println("");
		}
	}
	
	private static void showBidding(Scanner bidMenu) {
		System.out.println("Current Listings for REO:");
		printCurrentListing(1);
		String input = "";
		System.out.println("ENTER: Exit back to previous menu\n");
		System.out.print("For which property would you like to see the current bids?:");
		while(true) {
			input = bidMenu.nextLine();
			switch(input){
				case "":
					bidsMenuInterface(bidMenu);
					break;
			
				default:{
					int id = Integer.valueOf(input);
					int i = 1;
					String address = "";
					
					for (String key : listings.getStreetAddresses()) {
						if(i == id) {
							address = key;
							break;
						}
						i++;
					}
					Residential res = listings.getListing(address);		
					System.out.print(res.toString());
					System.out.println("");
					
					System.out.println("\n Current bids for the listing");
					HashMap<String,Double> bidMap = res.getBids();
					
			        String s="----------------------------\n" +
			                	"Bidder			  Bid\n" +          
			                	"-----------------------------\n" ;
			        System.out.println(s);
			        for(String name : bidMap.keySet()) {
			        	
			        	System.out.printf("%s		$%.2f\n",name,bidMap.get(name));
			        }
			        
					System.out.println("ENTER: Exit back to previous menu\n");
					System.out.print("For which property would you like to see the current bids?:");
				}
			}				
		}		
	}

	private static void addBiddingMenuInterface(Scanner bidMenu) {
		System.out.println("Current Listings for REO:");
		System.out.println("No.	Property (bids)");
		System.out.println("---------------------------");
		printCurrentListing(1);
		String input = "";
		System.out.println("ENTER: Exit back to previous menu\n");
		System.out.print("For which property would you like to add a bid?:");
		while(true) {
			input = bidMenu.nextLine();
			switch(input){
				
			case "":
				bidsMenuInterface(bidMenu);
				break;
			
			default:{
				int id = Integer.valueOf(input);
				int i = 1;
				String address = "";
				
				for (String key : listings.getStreetAddresses()) {
					if(i == id) {
						address = key;
						break;
					}
					i++;
				}
				Residential res = listings.getListing(address);		
				System.out.print(res.toString());
				System.out.print("Please Enter the name of the bidder:");
				String name = bidMenu.nextLine();
				System.out.print("Please enter the new bid: $");
				String bidValue = bidMenu.nextLine();
				res.newBids(name, Double.valueOf(bidValue));
				
				System.out.printf("\nNew bid for property: %s added.\n\n", address);
				printCurrentListing(1);
				System.out.println("ENTER: Exit back to previous menu\n");
				System.out.println("For which property would you like to add a bid?:");
			}
		}
			
	   }
	}

	private static void autoPopulateBidding(Scanner bidMenu) {
		
		String[] autoBidders= {"Patric Stewart","Walter Koenig","William Shatner","Leonard Nimoy","DeForect Kelley","James Doohan","George Takei","Majel Barrett","Nichelle Nichol","Jonathan Frank"
                ,"Marina Sirtis","Brent Spiner","Gates McFadden","Michael Dorn","LeVar Burton","Wil Wheaton","Colm Meaney","Michelle Forbes"};

		Random r = new Random();
		
		for(String address : listings.getStreetAddresses()) {
			Residential res = listings.getListing(address);
			int noOfBids = r.nextInt((autoBidders.length-1) +1);
				for( int i =0 ; i<noOfBids ; i++) {
					int index = r.nextInt((autoBidders.length-1)+1);
					int maxBid = (int) (res.calculateAppraisalPrice()*1.1);
					int minBid = (int)(res.calculateAppraisalPrice() * .9);
					int bidAmount = (int) (Math.random() * ((maxBid - minBid) + 1)) + minBid;
					res.newBids(autoBidders[index], Double.valueOf(bidAmount));
				}
			System.out.printf("%d new bids have been added to listing %s\n", noOfBids, address);
		}
		
	}
	
	public static void main(String[] args) {
		listings = new Listings();
		Scanner sIn = new Scanner(System.in);
		mainMenuInterface(sIn);
		sIn.close();
	}
}
