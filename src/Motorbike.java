
public class Motorbike extends Vehicle{

	private int engineCap;

	public Motorbike(String vehiID, int engineCap) {
		super(vehiID);
		
		this.engineCap = engineCap;
	}

	public float getEngineCap() {
		return engineCap;
	}

	public void setEngineCap(int engineCap) {
		this.engineCap = engineCap;
	}
	
	
}
