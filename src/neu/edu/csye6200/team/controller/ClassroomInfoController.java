package neu.edu.csye6200.team.controller;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import neu.edu.csye6200.main.Main;
import neu.edu.csye6200.team.objects.Classroom;
import neu.edu.csye6200.team.objects.Student;
import neu.edu.csye6200.team.objects.Teacher;

public class ClassroomInfoController extends AbstractController{
	private Stage dialogStage;
    private Main main;
    private Classroom classroom;
    private ObservableList<Student> students = FXCollections.observableArrayList();
    @FXML
    private TableView<Student> studentTable;
	@FXML
    private TableColumn<Student, Integer> studentId;
    @FXML
    private TableColumn<Student, String> firstName;
    @FXML
    private TableColumn<Student, String> lastName;
    @FXML
    private TableColumn<Student, Integer> age;
    @FXML
    private TableColumn<Student, String> fatherName;
    @FXML
    private TableColumn<Student, String> motherName;
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    @FXML
    public void initialize() {
    	
    	studentId.setCellValueFactory(cell -> {
    		Student cellFeature = cell.getValue();
    		return intToIntProperty(cellFeature.getStuId());
    	});
    	firstName.setCellValueFactory(cell -> {
    		Student cellFeature = cell.getValue();
    		return strToStrProperty(cellFeature.getFirstName());
    	});
    	lastName.setCellValueFactory(cell -> {
    		Student cellFeature = cell.getValue();
    		return strToStrProperty(cellFeature.getLastName());
    	});
    	age.setCellValueFactory(cell -> {
    		Student cellFeature = cell.getValue();
    		return intToIntProperty(cellFeature.getAge());
    	});
    	fatherName.setCellValueFactory(cell -> {
    		Student cellFeature = cell.getValue();
    		return strToStrProperty(cellFeature.getFatherName());
    	});
    	motherName.setCellValueFactory(cell -> {
    		Student cellFeature = cell.getValue();
    		return strToStrProperty(cellFeature.getMotherName());
    	});
    }
    
    private StringProperty strToStrProperty(String s) {
		return new SimpleStringProperty(s);
	}
    
    private ObjectProperty<Integer> intToIntProperty(int i) {
		return new SimpleIntegerProperty(i).asObject();
	}
    
    @Override
    public void setApp(Main main) {
        this.main = main;
    	studentTable.setItems(students);
    }
    
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
    
    public void setClassroom(Classroom classroom) {
    	this.classroom = classroom;
    	for(Student s : classroom.getStudents()) {
    		students.add(s);
    	}
    }
    
}
