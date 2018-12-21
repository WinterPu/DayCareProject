package neu.edu.csye6200;

public class Lenovo extends Computer {
	
	private String system;

	public Lenovo (String system) {
		super("Lenovo");
		this.system = system;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
	    sb.append("System = ").append(this.system).append(" ");
	    return sb.toString();
	}
	
	@Override
	public void computerSystem() {
		System.out.println("Its system is " + system);
	}
	
	@Override
	public void computerName() {
		System.out.println("It is a Lenovo.");
		computerSystem();
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}
}
