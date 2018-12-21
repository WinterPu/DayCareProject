package neu.edu.csye6200;

public class MacBookPro extends Computer {
	
	private String system;
	
	public MacBookPro(String system) {
		super("MacBookPro");
		this.system = system;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
	    sb.append("System = ").append(this.system).append(" ");
	    return sb.toString();
	}
	
	@Override
	public void computerName() {
		System.out.println("It is a MacBookPro.");
		computerSystem();
	}

	@Override
	public void computerSystem() {
		System.out.println("Its system is " + system);
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}


}
