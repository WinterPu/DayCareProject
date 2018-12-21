package neu.edu.csye6200;
import java.util.ArrayList;
import java.util.List;

public class ComputerShop {
	public void display() {
		MacBookPro m = new MacBookPro("MACOS");
		Lenovo l = new Lenovo("Windows");
		
		List<Computer> computerList = new ArrayList<>();
		computerList.add(m);
		computerList.add(l);
		System.out.println(computerList.size() + " computers in the shop.");
		
		for(Computer c : computerList) {
			c.computerName();
		}
		
		System.out.println("----Before sorting----");
		
		for(Computer c : computerList) {
			System.out.println(c);
		}
		
		computerList.sort(null);
		

		System.out.println("----After sorting by computer name----");
		
		for(Computer c : computerList) {
			System.out.println(c);
		}
	}

}
