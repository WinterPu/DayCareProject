package neu.edu.csye6200.team.objects;

import neu.edu.csye6200.team.data.StudentDataManagement;
import neu.edu.csye6200.team.interfaces.DataManagement;

public class Classroom {
	
	public void arrange() {
		DataManagement<Student> dm1 = new StudentDataManagement();
		for (Student s : dm1.getDataList()) {
			
		}
		System.out.println(dm1.getDataList());
	}
}
