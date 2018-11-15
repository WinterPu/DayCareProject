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


public class DataStore {
	
	private static DataStore dataStore;
	
	private List<Student> students;
	private List<Teacher> teachers;
	private ObservableList<Rules> ruleDate;
	private ObservableList<Classroom> classroomList;
	
	private DataStore() {
		students = new StudentDataManagement().getDataList();
		teachers = new TeacherDataManagement().getDataList();
		ruleDate = FXCollections.observableArrayList();
		classroomList = FXCollections.observableArrayList();
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

	public ObservableList<Classroom> getClassroomList() {
		return classroomList;
	}

	public void setClassroomList(ObservableList<Classroom> classroomList) {
		this.classroomList = classroomList;
	}
	
}
