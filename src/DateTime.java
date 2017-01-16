import java.io.Serializable;

public class DateTime implements Serializable{
	
	private String vehiID;

	private int enterMins=0;
	private int enterHours=0;
	
	private int exitMins=0;
	private int exitHours=0;
	
	private int day=0;
	private int mnth=0;
	
	
	public DateTime(String vehiID, int enterMins, int enterHours, int exitMins, int exitHours, int day, int mnth) {
		super();
		this.vehiID = vehiID;
		this.enterMins = enterMins;
		this.enterHours = enterHours;
		this.exitMins = exitMins;
		this.exitHours = exitHours;
		this.day = day;
		this.mnth = mnth;
	
	}


	public String getVehiID() {
		return vehiID;
	}


	public int getEnterMins() {
		return enterMins;
	}


	public int getEnterHours() {
		return enterHours;
	}


	public int getExitMins() {
		return exitMins;
	}


	public int getExitHours() {
		return exitHours;
	}


	public int getDay() {
		return day;
	}


	public int getMnth() {
		return mnth;
	}


	public void setVehiID(String vehiID) {
		this.vehiID = vehiID;
	}


	public void setEnterMins(int enterMins) {
		this.enterMins = enterMins;
	}


	public void setEnterHours(int enterHours) {
		this.enterHours = enterHours;
	}


	public void setExitMins(int exitMins) {
		this.exitMins = exitMins;
	}


	public void setExitHours(int exitHours) {
		this.exitHours = exitHours;
	}


	public void setDay(int day) {
		this.day = day;
	}


	public void setMnth(int mnth) {
		this.mnth = mnth;
	}
	
	
	
}
