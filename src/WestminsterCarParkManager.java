import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.Scanner;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.sun.javafx.css.CssError.StylesheetParsingError;

import javafx.scene.control.CheckBox;

public class WestminsterCarParkManager implements CarParkManager,Serializable {
	
	public static final int parkSize = 20;
	public static final int recordsSize = 20;
	
	static Vehicle [] carParkArray = new Vehicle[parkSize];
	static DateTime [] savedVehicles = new DateTime[recordsSize];

	public static int parkBlocks = 0;
	public static int counter = 0;
	
	public static String fileName = "records.txt";
	
 	public static void main(String[] args) {
 		
 		//this is the secondary array to store time data about parked vehicles
 		if (counter == 0) {
	 		savedVehicles[0] = new DateTime("", 0, 0, 0, 0, 0, 0);
	 		savedVehicles[1] = new DateTime("", 0, 0, 0, 0, 0, 0);
	 		savedVehicles[2] = new DateTime("", 0, 0, 0, 0, 0, 0);
	 		savedVehicles[3] = new DateTime("", 0, 0, 0, 0, 0, 0);
	 		savedVehicles[4] = new DateTime("", 0, 0, 0, 0, 0, 0);
	 		savedVehicles[5] = new DateTime("", 0, 0, 0, 0, 0, 0);
	 		savedVehicles[6] = new DateTime("", 0, 0, 0, 0, 0, 0);
	 		savedVehicles[7] = new DateTime("", 0, 0, 0, 0, 0, 0);
	 		savedVehicles[8] = new DateTime("", 0, 0, 0, 0, 0, 0);
	 		savedVehicles[9] = new DateTime("", 0, 0, 0, 0, 0, 0);
	 		savedVehicles[10] = new DateTime("", 0, 0, 0, 0, 0, 0);
	 		savedVehicles[11] = new DateTime("", 0, 0, 0, 0, 0, 0);
	 		savedVehicles[12] = new DateTime("", 0, 0, 0, 0, 0, 0);
	 		savedVehicles[13] = new DateTime("", 0, 0, 0, 0, 0, 0);
	 		savedVehicles[14] = new DateTime("", 0, 0, 0, 0, 0, 0);
	 		savedVehicles[15] = new DateTime("", 0, 0, 0, 0, 0, 0);
	 		savedVehicles[16] = new DateTime("", 0, 0, 0, 0, 0, 0);
	 		savedVehicles[17] = new DateTime("", 0, 0, 0, 0, 0, 0);
	 		savedVehicles[18] = new DateTime("", 0, 0, 0, 0, 0, 0);
	 		savedVehicles[19] = new DateTime("", 0, 0, 0, 0, 0, 0);
 		}
 		
 		counter++;
		
		// TODO Auto-generated method stub
		
		System.out.println("_________________________________");
		System.out.println("_________________________________");

		// the menu for the usage
		System.out.println("-----------------Menu----------------");
		System.out.println("A - Add Vehicle to park ");
		System.out.println("X - Delete Vehicle from park ");
		System.out.println("P - Print list of vehicles parked");
		System.out.println("S - Display Statistics ");
		System.out.println("F - Find cars that enter into the park in a date ");
		System.out.println("C - Charge for vehicles parked");
	
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.print("Give Your input: ");
		
		Scanner sc = new Scanner(System.in);
		String inp = sc.nextLine();
		
		
		
		// various input options and the methods they call
		switch (inp) {

		case "a":
			System.out.println("ADDING NEW VEHICLE: ");
			checkParkBlocks();
			break;
		case "A":
			System.out.println("ADDING NEW VEHICLE: ");
			checkParkBlocks();
			break;
			
			
			
		case "X":
			System.out.println("DELETING VEHICLE: ");
			deleteVehicle(savedVehicles);
			break;
		case "x":
			System.out.println("DELETING VEHICLE: ");
			deleteVehicle(savedVehicles);
			break;
			
			
			
		case "p":
			System.out.println("LIST OF VEHICLES CURRENTLY PARKED");
			vehicleList();
			break;
		case "P":
			System.out.println("LIST OF VEHICLES CURRENTLY PARKED");
			vehicleList();
			break;
		
			
		case "s":
			System.out.println("DISPLAY STATS");
			printStats();
			break;
		case "S":
			System.out.println("DISPLAY STATS");
			printStats();
			break;
			
		
		case "f":
			System.out.println("FIND VEHCILES BY DATE");
			try {
				searchByDate();
			} catch (ClassNotFoundException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "F":
			System.out.println("FIND VEHCILES BY DATE");
			try {
				searchByDate();
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		
		case "c":
			System.out.println("CHARGE FOR PARKED VEHICLES");
			charge();
			break;
		case "C":
			System.out.println("CHARGE FOR PARKED VEHICLES");
			charge();
			break;
			
		//this case is used for invalid inputs
		default:
			System.out.println("ERROR");
			main(args);
		}
		
	}
 	

	
	public static void addVehicle() {
		
		System.out.println("NO. OF PARKING SLOTS AVAILABLE = "+(carParkArray.length-parkBlocks));
		
		System.out.println("-----------------Select type of Vehicle----------------");
		System.out.println("C - CAR ");
		System.out.println("V - VAN ");
		System.out.println("B - MOTORBIKE");
		System.out.println("M - RETURN TO MAIN MENU");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.print("Give Your input: ");
		
		Scanner sc = new Scanner(System.in);
		String inp = sc.nextLine();
		
		switch (inp) {
			case "c":
				System.out.println("ADDING NEW CAR: ");
				addCar();
				break;
			case "C":
				System.out.println("ADDING NEW CAR: ");
				addCar();
				break;
				
			case "v":
				System.out.println("ADDING NEW VAN: ");
				addVan();
				break;
			case "V":
				System.out.println("ADDING NEW VAN: ");
				addVan();
				break;
				
			case "b":
				System.out.println("ADDING NEW MOTORBIKE: ");
				addBike();
				break;
			case "B":
				System.out.println("ADDING NEW MOTORBIKE: ");
				addBike();
				break;
				
			case "m":
				main(null);
				break;
			case "M":
				main(null);
				break;	
				
			default:
				System.out.println("Error try again...");
				main(null);
		}	
	}

	public static void deleteVehicle(DateTime[] tempList) {
		System.out.println("Enter ID plate of vehicle to delete: ");
		Scanner sc = new Scanner(System.in);
		String ID = sc.nextLine();
	
		int vehiExist = 0;
		for (int i = 0; i<=carParkArray.length-1; i++) {
			
				if (carParkArray[i] instanceof Car) {
					
					String tempID = ((Car)carParkArray[i]).getVehiID();
					
					if (tempID.equals(ID)) {
						carParkArray[i] = null;
						System.out.println("Vehicle with ID "+ID+" has been deleted");
						System.out.println("Vehicle Type deleted is CAR");
						parkBlocks = parkBlocks-1;
						vehiExist++;
						break;
					}
					continue;
					
				} else if (carParkArray[i] instanceof Van) {
					
					String tempID = ((Van)carParkArray[i]).getVehiID();
					
					if (tempID.equals(ID)) {
						carParkArray[i] = null;
						System.out.println("Vehicle with ID "+ID+" has been deleted");
						System.out.println("Vehicle Type deleted is VAN");
						parkBlocks = parkBlocks-2;
						vehiExist++;
						break;
					}
					continue;
					
				} else if (carParkArray[i] instanceof Motorbike) {
					
					String tempID = ((Motorbike)carParkArray[i]).getVehiID();
					
					if (tempID.equals(ID)) {
						carParkArray[i] = null;
						System.out.println("Vehicle with ID "+ID+" has been deleted");
						System.out.println("Vehicle Type deleted is BIKE");
						parkBlocks = parkBlocks-1;
						vehiExist++;
						break;
					}
					continue;
				
				}
		}
		
		if (vehiExist == 0) {
			System.out.println("NO SUCH VEHICLE PARKED");
		}
		main(null);
	}


	public static void vehicleList() {
		int vanNextBlock = -1;
		
		for (int i = carParkArray.length - 1; i>=0; i--) {
			String tempId;
			if (carParkArray[i] instanceof Car) {
				tempId = ((Car)carParkArray[i]).getVehiID();
				System.out.println("BLOCK " + (i + 1) + ") Car details: Car ID> " + tempId
						+ " / Car color> " + ((Car) carParkArray[i]).getColor() + " / Entered time> " + getEntryTimeHours(tempId) + "H " + getEntryTimeMins(tempId) +"M");
			} else if (carParkArray[i] instanceof Van) {
				tempId = ((Van)carParkArray[i]).getVehiID();
				System.out.println("BLOCK " + (i + 1) + ") Van details: Van ID> " + tempId
						+ " / Van cargo vol> " + ((Van) carParkArray[i]).getCargoVol() + " / Entered time> " + getEntryTimeHours(tempId) + "H " + getEntryTimeMins(tempId) +"M");
				vanNextBlock = i + 1;
			} else if (carParkArray[i] instanceof Motorbike) {
				tempId = ((Motorbike)carParkArray[i]).getVehiID();
				System.out.println(
						"BLOCK " + (i + 1) + ") Bike details: Bike ID> " + tempId
								+ " / Bike engine capacity> " + ((Motorbike) carParkArray[i]).getEngineCap() + " / Entered time> " + getEntryTimeHours(tempId) + "H " + getEntryTimeMins(tempId) +"M");
			} else {
				if (i == vanNextBlock) {
					System.out.println("BLOCK " + (i + 1) + ") Also occupied by VAN");
				} else {
					System.out.println("BLOCK " + (i + 1) + ") Empty Block");
				}
			}
		}
		main(null);
	}

	public static void printStats() {
		int tempParkBlocks = parkBlocks;
		
		double noOfCars = 0.0;
		double noOfVans = 0.0;
		double noOfBikes = 0.0;
	
		
		for (int i = 0; i <= carParkArray.length-1; i++) {
			if (carParkArray[i] instanceof Car) {
				noOfCars++;
			}
			
			if (carParkArray[i] instanceof Van) {
				noOfVans++;
				tempParkBlocks=tempParkBlocks-1;
			}
			
			if (carParkArray[i] instanceof Motorbike) {
				noOfBikes++;
			}
		}
		
		if (parkBlocks == 0) {
			System.out.println("CANNOT GET STATS, NO VEHICLES IN PARKING");
			main(null);
		}
		
		System.out.println("Percentage of Cars "+((noOfCars/tempParkBlocks)*100.0)+"%");
		System.out.println("Percentage of Vans "+((noOfVans/tempParkBlocks)*100.0)+"%");
		System.out.println("Percentage of Bikes "+((noOfBikes/tempParkBlocks)*100.0)+"%");
		
		main(null);
		
	}

	public static void searchByDate() throws ClassNotFoundException, IOException {
		
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		DateTime[] loadArray = (DateTime[]) ois.readObject();
		
		DateTime[] records = new DateTime[20];
		
		System.out.println("SEARCHING RECORDS BY DATE...");
		System.out.print("Enter Day to search : ");
		Scanner s1 = new Scanner(System.in);
		int day = s1.nextInt();
		
		System.out.print("Enter Month to search : ");
		Scanner s2 = new Scanner(System.in);
		int month = s2.nextInt();
		
		for (int n=0; n <= 19; n++) {
			records[n] = new DateTime(loadArray[n].getVehiID(), loadArray[n].getEnterMins(), loadArray[n].getEnterHours(), loadArray[n].getExitMins(), loadArray[n].getExitHours(), loadArray[n].getDay(), loadArray[n].getMnth());
		}
		
		int num = 0;
		
		for (DateTime val : records) {
			if (val.getDay()==day && val.getMnth()==month) {
				System.out.println("Vehicle with ID: "+val.getVehiID()+" Entered at "+val.getEnterHours()+":"+val.getEnterMins()+" And left at "+val.getExitHours()+":"+val.getExitMins());
				num++;
			}
		}
		
		if (num==0) {
			System.out.println("NO VEHICLES PARKED ON THAT DATE");
		}
		
		main(null);
		
	}

	public static void charge() {
		int perFrstHours = 3;
		int followingHours = 1;
		
		for (DateTime val: savedVehicles) {
			int timeDiff = val.getExitHours()-val.getEnterHours();
			int hoursAfterFirst3 = timeDiff-3;
			
			if (timeDiff<=3) {
				System.out.println("Vehicle with ID: "+val.getVehiID()+" Parking charge is: $"+(timeDiff*perFrstHours));
			
			} else if (timeDiff>3 && timeDiff<24) {
				System.out.println("Vehicle with ID: "+val.getVehiID()+" Parking charge is: $"+((perFrstHours*3)+hoursAfterFirst3));
				
			} else if (val.getExitHours()==23) {
				System.out.println("Vehicle with ID: "+val.getVehiID()+" Parking charge is: $24");
			}
		
		}
		
	}

	
	public static void addCar() {
		
		try {
			System.out.print("Enter Car ID : ");
			Scanner s1 = new Scanner(System.in);
			String ID = s1.nextLine();
		
			System.out.print("Enter No. of Doors : ");
			Scanner s2 = new Scanner(System.in);
			int doors = s2.nextInt();
			
			System.out.print("Enter Car color : ");
			Scanner s3 = new Scanner(System.in);
			String color = s3.nextLine();
			
	
			System.out.print("Enter Car arrival Minute : ");
			Scanner s4 = new Scanner(System.in);
			int enterMins = s4.nextInt();
			
			System.out.print("Enter Car arrival Hour : ");
			Scanner s5 = new Scanner(System.in);
			int enterHours = s5.nextInt();
			
			timeValidate(enterHours, enterMins);
			
			System.out.print("Enter Car Exit Minute : ");
			Scanner s6 = new Scanner(System.in);
			int exitMins = s6.nextInt();
			
			System.out.print("Enter Car Exit Hour : ");
			Scanner s7 = new Scanner(System.in);
			int exitHours = s7.nextInt();
			
			timeValidate(exitHours, exitMins);
			
			System.out.print("Enter Car arrival Day : ");
			Scanner s8 = new Scanner(System.in);
			int dayt = s8.nextInt();
			
			System.out.print("Enter Car arrival Month : ");
			Scanner s9 = new Scanner(System.in);
			int mntht = s9.nextInt();
			
			dateValidate(dayt, mntht);
			
			savedVehicles[parkBlocks] = new DateTime(ID, enterMins, enterHours, exitMins, exitHours, dayt, mntht);
			
			carParkArray[parkBlocks] = new Car(ID, doors, color);
			parkBlocks++;
			System.out.println("Remaining no. of slots for parking = "+(carParkArray.length-parkBlocks));
			
			try {
				saveRecords(savedVehicles);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			checkParkBlocks();
		
		} catch (Exception e) {
			System.out.println("INPUT ERROR RETRY...");
			addVehicle();
		}
		
	}
	
	public static void addVan() {
		
		try {
			System.out.print("Enter Van ID : ");
			Scanner s1 = new Scanner(System.in);
			String ID = s1.nextLine();
			
			System.out.print("Enter Cargo volume : ");
			Scanner s2 = new Scanner(System.in);
			int cargo = s2.nextInt();
			
			System.out.print("Enter Van arrival Minute : ");
			Scanner s4 = new Scanner(System.in);
			int enterMins = s4.nextInt();
			
			System.out.print("Enter Van arrival Hour : ");
			Scanner s5 = new Scanner(System.in);
			int enterHours = s5.nextInt();
			
			timeValidate(enterHours, enterMins);
			
			System.out.print("Enter Van Exit Minute : ");
			Scanner s6 = new Scanner(System.in);
			int exitMins = s5.nextInt();
			
			System.out.print("Enter Van Exit Hour : ");
			Scanner s7 = new Scanner(System.in);
			int exitHours = s7.nextInt();
			
			timeValidate(exitHours, enterMins);
			
			System.out.print("Enter Van arrival Day : ");
			Scanner s8 = new Scanner(System.in);
			int day = s8.nextInt();
			
			System.out.print("Enter Van arrival Month : ");
			Scanner s9 = new Scanner(System.in);
			int mnth = s9.nextInt();
			
			savedVehicles[parkBlocks] = new DateTime(ID, enterMins, enterHours, exitMins, exitHours, day, mnth);
			
			carParkArray[parkBlocks] = new Van(ID, cargo);
			parkBlocks = parkBlocks+2;
			System.out.println("Remaining no. of slots for parking = "+(carParkArray.length-parkBlocks));
			
			try {
				saveRecords(savedVehicles);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			checkParkBlocks();
		
		} catch (Exception e) {
			System.out.println("INPUT ERROR RETRY...");
			addVehicle();
		}
		
	}
	
	public static void addBike() {
		
		try {
			System.out.print("Enter Bike ID : ");
			Scanner s1 = new Scanner(System.in);
			String ID = s1.nextLine();
			
			System.out.print("Enter Engine capacity : ");
			Scanner s2 = new Scanner(System.in);
			int capacity = s2.nextInt();
			
			System.out.print("Enter Bike arrival Minute : ");
			Scanner s4 = new Scanner(System.in);
			int enterMins = s4.nextInt();
			
			System.out.print("Enter Bike arrival Hour : ");
			Scanner s5 = new Scanner(System.in);
			int enterHours = s5.nextInt();
			
			timeValidate(enterHours, enterMins);
			
			System.out.print("Enter Bike Exit Minute : ");
			Scanner s6 = new Scanner(System.in);
			int exitMins = s6.nextInt();
			
			System.out.print("Enter Bike Exit Hour : ");
			Scanner s7 = new Scanner(System.in);
			int exitHours = s7.nextInt();
			
			timeValidate(exitHours, exitMins);
			
			System.out.print("Enter Bike arrival Day : ");
			Scanner s8 = new Scanner(System.in);
			int day = s8.nextInt();
			
			System.out.print("Enter Bike arrival Month : ");
			Scanner s9 = new Scanner(System.in);
			int mnth = s9.nextInt();
			
			savedVehicles[parkBlocks] = new DateTime(ID, enterMins, enterHours, exitMins, exitHours, day, mnth);
			
			carParkArray[parkBlocks] = new Motorbike(ID, capacity);
			parkBlocks++;
			System.out.println("Remaining no. of slots for parking = "+(carParkArray.length-parkBlocks));
			
			try {
				saveRecords(savedVehicles);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			checkParkBlocks();
		
		} catch (Exception e) {
			System.out.println("INPUT ERROR RETRY...");
			addVehicle();
		}
		
	}
	
	
	public static void checkParkBlocks() {
		if (parkBlocks>=carParkArray.length) {
			System.out.println("PARKING IS FULL, REMOVE A VEHICLE");
			main(null);
		}
		addVehicle();
	}
	
	
	public static void saveRecords(DateTime[] saveArray) throws IOException{
		
		try {
			// creates a new file with object ObjectOutputStream
			FileOutputStream out = new FileOutputStream(fileName);
			ObjectOutputStream oout = new ObjectOutputStream(out);

			// writes the array into the file
			oout.writeObject(saveArray);

			// closes the stream
			oout.flush();
			oout.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static int getEntryTimeHours (String id) {
		for (DateTime val : savedVehicles) {
			if (val.getVehiID().equals(id)) {
				return val.getEnterHours();
			}
		}
		return counter;
	}
	
	public static int getEntryTimeMins (String id) {
		for (DateTime val : savedVehicles) {
			if (val.getVehiID().equals(id)) {
				return val.getEnterMins();
			}
		}
		return counter;
	}
	
	
	public static void timeValidate (int hr, int min) {
		if (hr<0 || hr>23 || min<0 || min>59) {
			System.out.println("ERROR: Time invalid enter again");
			addVehicle();
		} else {
			System.out.println("TIME VALID...");
		}	
	}
	
	
	
	public static void dateValidate(int day, int mnth) {
		if (day<=31 && mnth<=12 && day>0 && mnth>0) {
			if (mnth == 2) {
				if (day<=29) {
					System.out.println("DATE VALID...");
				} else {
					System.out.println("ERROR: Day invalid for February, retry...");
					addVehicle();
				}
			}
			
			if (mnth == 1 || mnth == 3 || mnth == 5 || mnth == 7 || mnth == 8 || mnth == 10 || mnth == 12) {
				if (day<=31) {
					System.out.println("DATE VALID...");
				} else {
					System.out.println("ERROR: Day invalid for 31 day month, retry...");
					addVehicle();
				}
			}
			
			if (mnth == 4 || mnth == 6 || mnth == 9 || mnth == 11) {
				if (day<=30) {
					System.out.println("DATE VALID...");
				} else {
					System.out.println("ERROR: Day invalid for 30 day month, retry...");
					addVehicle();
				}
			}
		} else {
			System.out.println("ERROR: DATE ENTRY VIOLATION, retry...");
			addVehicle();
		}
	}
 	
}
