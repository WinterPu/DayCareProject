package neu.edu.csye6200.team.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import neu.edu.csye6200.team.interfaces.DataManagement;
import neu.edu.csye6200.team.objects.Student;
import neu.edu.csye6200.team.util.FileIO;

public class StudentDataManagement implements DataManagement<Student> {

	/**
	 * General search
	 */
	@Override
	public List<Student> getDataList() {
		// TODO Auto-generated method stub
		return FileIO.readFileOfMap(Student.class, "student");
	}
	//Not in use yet
	@Override
	public List<Student> getDataList(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getDataList(int key) {
		// TODO Auto-generated method stub
		List<Student> stus = new ArrayList<>();
		getDataList().forEach(stu -> {if(stu.getStuId() == key) stus.add(stu);});
		return stus;
	}
	/**
	 * Search for students that ages are between minimum value and maximum value. Notice, I use >= and <=
	 */
	@Override
	public List<Student> getDataList(int min, int max) {
		// TODO Auto-generated method stub
		List<Student> stus = new ArrayList<>();
		getDataList().forEach(stu -> {if(stu.getAge() >= min && stu.getAge() <= max) stus.add(stu);});
		return stus;
	}

	@Override
	public List<Student> getDataList(String min, String max) {
		// TODO Auto-generated method stub
		List<Student> stus = new ArrayList<>();
		getDataList().forEach(stu -> {if(stu.firstName.compareTo(min) >= 0 && stu.firstName.compareTo(max) <= 0) stus.add(stu);});
		return stus;
	}
	
	@Override
	public void registerOneObject(Student stu) {
		// TODO Auto-generated method stub
		List<Student> stus = new ArrayList<>();
		int maxId = 0;
		List<Student> allStus = getDataList();
		for(Student s : allStus) {if(s.getStuId() > maxId) maxId = s.getStuId();}
		stu.setStuId(maxId+1);
		stus.add(stu);
		FileIO.writeFileAppended(stus, "student");
	}

	@Override
	public void deleteOneObject(Student stu) {
		// TODO Auto-generated method stub
		List<Student> stus = new ArrayList<>();
		getDataList().forEach(s -> {if(s.getStuId() != stu.getStuId()) stus.add(s);});
		refreshAll(stus);
	}

	@Override
	public void updateOneObject(Student stu) {
		// TODO Auto-generated method stub
		List<Student> stus = new ArrayList<>();
		getDataList().forEach(s -> {
			if(s.getStuId() != stu.getStuId()) stus.add(s);
			else stus.add(stu);
			});
		refreshAll(stus);
	}
	
	@Override
	public void refreshAll(List<Student> list) {
		// TODO Auto-generated method stub
		FileIO.writeFile(list, Student.class, "student");
	}
	
	/**
	 * This method generate the basic data only if there is no data.
	 */
//	private static void initialize() {
		// TODO Auto-generated method stub
//		if(FileIO.isFileEmpty("student")) {
//			List<Student> stus = new ArrayList<>();
//			stus.add(new Student(100001, "Jimmy", "Tompson", new Date(System.currentTimeMillis()-4*300*24*60*60*1000), 53));
//			stus.add(new Student(100002, "Sally", "George", new Date(System.currentTimeMillis()-3*271*24*60*60*1000), 39));
//			stus.add(new Student(100003, "Lizzy", "Edwen", new Date(System.currentTimeMillis()-3*268*23*60*60*1000), 36));
//			stus.add(new Student(100004, "Markie", "James", new Date(System.currentTimeMillis()-3*243*24*60*60*1000), 35));
//			stus.add(new Student(100005, "Johnny", "Dep", new Date(System.currentTimeMillis()-3*344*24*60*60*1000), 44));
//			stus.add(new Student(100006, "Bobby", "Higgins", new Date(System.currentTimeMillis()-2*430*23*60*60*1000), 42));
//			stus.add(new Student(100007, "Billy", "Hill", new Date(System.currentTimeMillis()-2*365*24*60*60*1000), 36));
//			stus.add(new Student(100008, "Evie", "Jane", new Date(System.currentTimeMillis()-2*230*24*60*60*1000), 28));
//			stus.add(new Student(100009, "Becky", "Smith", new Date(System.currentTimeMillis()-2*230*24*59*59*1000), 27));
//			stus.add(new Student(100010, "Jessie", "Christin", new Date(System.currentTimeMillis()-2*169*24*60*60*1000), 23));
//			stus.add(new Student(100011, "Jackie", "Chan", new Date(System.currentTimeMillis()-233*24*60*60*1000), 18));
//			stus.add(new Student(100012, "Laurie", "Florance", new Date(System.currentTimeMillis()-300*24*60*60*1000), 22));
//			stus.add(new Student(100013, "Cathey", "Methew", new Date(System.currentTimeMillis()-209*24*60*60*1000), 17));
//			stus.add(new Student(100014, "Millie", "Tompson", new Date(System.currentTimeMillis()-191*24*60*60*1000), 63));
//			stus.add(new Student(100015, "Ruthie", "Jesus", new Date(System.currentTimeMillis()-120*24*60*60*1000), 16));
//			stus.add(new Student(100016, "Stanley", "Mart", new Date(System.currentTimeMillis()-120*24*59*59*1000), 15));
//			stus.add(new Student(100017, "Mary", "Mandery", new Date(System.currentTimeMillis()-24*60*60*1000), 12));
//			stus.add(new Student(100018, "Annie", "Johns", new Date(System.currentTimeMillis()-22*24*58*60*1000), 13));
//			stus.add(new Student(100019, "Karlly", "Karren", new Date(System.currentTimeMillis()-24*60*60*1000), 11));
//			FileIO.writeFile(stus, Student.class, "student");
//		}
//	}


}
