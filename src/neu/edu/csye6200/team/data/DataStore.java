package neu.edu.csye6200.team.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import neu.edu.csye6200.team.objects.Classroom;
import neu.edu.csye6200.team.objects.Rules;
import neu.edu.csye6200.team.objects.Student;
import neu.edu.csye6200.team.objects.Teacher;
import neu.edu.csye6200.team.util.GenerateData;


public class DataStore {
	
	private static DataStore dataStore;
	
	private List<Student> students;
	private List<Teacher> teachers;
	private Map<String,Classroom> classrooms;
	private ObservableList<Rules> ruleDate;
	private ObservableList<Classroom> classroomList;
	
	private DataStore() {
		students = new StudentDataManagement().getDataList();
		classrooms = new HashMap<>();
		ruleDate = FXCollections.observableArrayList();
		classroomList = FXCollections.observableArrayList();
		generateTeachers();
	}
	
	private void generateTeachers() {
		teachers = new ArrayList<>();
		try { 
			GenerateData reader = new GenerateData("static/teacher.csv");
			String[] teacherRow;
			while((teacherRow = reader.getNextRow()) != null) {
				teachers.add(new Teacher(Integer.parseInt(teacherRow[0]),teacherRow[1],teacherRow[2]));
			}
		}catch(Exception e) {}
	}
	
	public static DataStore getInstance() {
		if(dataStore == null)
            dataStore = new DataStore();
        return dataStore;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public ObservableList<Rules> getRuleDate() {
		return ruleDate;
	}

	public void setRuleDate(ObservableList<Rules> ruleDate) {
		this.ruleDate = ruleDate;
	}

	public Map<String, Classroom> getClassrooms() {
		return classrooms;
	}

	public void setClassrooms(Map<String, Classroom> classrooms) {
		this.classrooms = classrooms;
	}

	public ObservableList<Classroom> getClassroomList() {
		return classroomList;
	}

	public void setClassroomList(ObservableList<Classroom> classroomList) {
		this.classroomList = classroomList;
	}
	
}
