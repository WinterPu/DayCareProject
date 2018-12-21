package neu.edu.csye6200;

public class Computer extends AbstractComputer implements  Comparable<Computer>, InterfaceComputerSystem{
	
	private String name;
	
	public Computer(String name) {
		this.name = name;
	}
	
	public void computerName() {
		System.out.println("It is a computer");
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
	    sb.append("Name = ").append(this.name).append(", ");
	    return sb.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Computer c) {
		return this.getName().compareTo(c.getName());
	}

	@Override
	public void computerSystem() {
		// TODO Auto-generated method stub
		System.out.println("Its computer system");
	}

}
