
public class Van extends Vehicle{

	public int cargoVol;

	
	public Van(String vehiID, int cargoVol) {
		super(vehiID);
		
		this.cargoVol = cargoVol;
	}


	public int getCargoVol() {
		return cargoVol;
	}

	public void setCargoVol(int cargoVol) {
		this.cargoVol = cargoVol;
	}
	
	
}
