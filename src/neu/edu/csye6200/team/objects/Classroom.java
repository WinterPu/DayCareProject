package neu.edu.csye6200.team.objects;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import neu.edu.csye6200.team.data.DataStore;
import neu.edu.csye6200.team.data.StudentDataManagement;
import neu.edu.csye6200.team.interfaces.DataManagement;

public class Classroom {
	
	private StringProperty name;
	private StringProperty size;
	private StringProperty ageRange;
	private StringProperty teacherName;
	private List<Student> students;
	private Teacher teacher;
	private boolean classIsExcept;
	private boolean teacherIsExcept;
	private String exceptRange;
	
	public Classroom() {}
	
	public Classroom(String name, String ageRange, String size, List<Student> students, Teacher teacher) {
		this.name = new SimpleStringProperty(name);
		this.size = new SimpleStringProperty(size);
		this.ageRange = new SimpleStringProperty(ageRange);
		this.teacherName = new SimpleStringProperty(teacher.getLastName());
		this.students = students;
		this.teacher = teacher;
	}
	
	public void arrange() {
		int count = 0;
		classIsExcept = false;
		teacherIsExcept = false;
		DataStore.getInstance().getRuleDate().clear();
        DataStore.getInstance().getRuleDate().add(new Rules("6","12","4","4:1","3"));
        DataStore.getInstance().getRuleDate().add(new Rules("13","24","5","5:1","3"));
        DataStore.getInstance().getRuleDate().add(new Rules("25","35","6","6:1","3"));
        DataStore.getInstance().getRuleDate().add(new Rules("36","47","8","8:1","3"));
        DataStore.getInstance().getRuleDate().add(new Rules("48","59","12","12:1","2"));
        DataStore.getInstance().getRuleDate().add(new Rules("60","on up","15","15:1","2"));
		
        
        DataStore.getInstance().getClassroomList().clear();
        DataStore.getInstance().getClassrooms().clear();
        
		for(Rules r : DataStore.getInstance().getRuleDate()) {
			List<Student> selectedStudents = new ArrayList<>();
			try {
				int i = Integer.parseInt(r.getMaxAge());
			}catch(NumberFormatException e) {
				r.setMaxAge("100000");
			}
			for(Student s : DataStore.getInstance().getStudents()) {
				if(s.getAge() > Integer.parseInt(r.getMinAge()) && s.getAge() <= Integer.parseInt(r.getMaxAge())) {
					selectedStudents.add(s);
				}
			}
			if(selectedStudents.size() == 0) {
				
			}else {
				
		
			if(selectedStudents.size() <= Integer.parseInt(r.getGroupSize())) {
//				DataStore.getInstance().getClassrooms().put(r.getMinAge(), 
//						new Classroom("Class "+(++count),r.getAgeRange(), r.getGroupSize(),selectedStudents, DataStore.getInstance().getTeachers().get(count-1)));
				if(count < DataStore.getInstance().getTeachers().size()) {
					DataStore.getInstance().getClassroomList().add(
							new Classroom("Class "+(++count),r.getAgeRange(), r.getGroupSize(),selectedStudents, DataStore.getInstance().getTeachers().get(count-1)));
				}else {
					teacherIsExcept = true;
				}
				
			}else {
				int classroomCount = (int)Math.ceil((double)selectedStudents.size() / Integer.parseInt(r.getGroupSize()));
				if(classroomCount <= Integer.parseInt(r.getMaxGroup())) {
					for(int i = 0 ; i < classroomCount ; i++ ) {
						List<Student> dividedStudents = new ArrayList<>();
						for(int j = 0 ; j < Integer.parseInt(r.getGroupSize()) ; j++) {
							if((i*4+j) < selectedStudents.size()) {
								dividedStudents.add(selectedStudents.get(i*4+j));
							}
						}
//						DataStore.getInstance().getClassrooms().put(r.getMinAge()+(i+1), 
//								new Classroom("Class "+(++count),r.getAgeRange(), r.getGroupSize(),dividedStudents, DataStore.getInstance().getTeachers().get(count-1)));
						if(count < DataStore.getInstance().getTeachers().size()) {
							DataStore.getInstance().getClassroomList().add(
									new Classroom("Class "+(++count),r.getAgeRange(), r.getGroupSize(),dividedStudents, DataStore.getInstance().getTeachers().get(count-1)));
						}else {
							teacherIsExcept = true;
						}
					}
				}else {
					for(int i = 0 ; i < Integer.parseInt(r.getMaxGroup()) ; i++ ) {
						List<Student> dividedStudents = new ArrayList<>();
						for(int j = 0 ; j < Integer.parseInt(r.getGroupSize()) ; j++) {
							if((i*4+j) < selectedStudents.size()) {
								dividedStudents.add(selectedStudents.get(i*4+j));
							}
						}
//						DataStore.getInstance().getClassrooms().put(r.getMinAge()+(i+1), 
//								new Classroom("Class "+(++count),r.getAgeRange(), r.getGroupSize(),dividedStudents, DataStore.getInstance().getTeachers().get(count-1)));
						if(count < DataStore.getInstance().getTeachers().size()) {
							DataStore.getInstance().getClassroomList().add(
									new Classroom("Class "+(++count),r.getAgeRange(), r.getGroupSize(),dividedStudents, DataStore.getInstance().getTeachers().get(count-1)));
						}else {
							teacherIsExcept = true;
						}
					}
					classIsExcept = true;
					exceptRange = r.getAgeRange();
				}	
			}
			}
		}
		//System.out.println(DataStore.getInstance().getStudents());
		for(Classroom c : DataStore.getInstance().getClassrooms().values()) {
			System.out.println(c);
		}
	}

	@Override
	public String toString() {
		return "Classroom [name=" + name.get() + ", range=" + ageRange.get() +", size=" + size.get() + ", students=" + students + ", teacher=" + teacher + "]";
	}
	
	public String getSize() {
		return size.get();
	}

	public List<Student> getStudents() {
		return students;
	}
	
	public String getAgeRange() {
		return ageRange.get();
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public String getName() {
        return name.get();
    }
	
	public StringProperty nameProperty() {
		return name;
	}
	
	public StringProperty sizeProperty() {
		return size;
	}
	
	public StringProperty ageRangeProperty() {
		return ageRange;
	}
	
	public StringProperty teacherNameProperty() {
		return teacherName;
	}

	public boolean classIsExcept() {
		return classIsExcept;
	}
	
	public boolean teacherIsExcept() {
		return teacherIsExcept;
	}
	
	public String getExceptRange() {
		return exceptRange;
	}
}
