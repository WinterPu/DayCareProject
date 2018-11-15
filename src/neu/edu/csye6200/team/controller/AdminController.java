package neu.edu.csye6200.team.controller;



import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import neu.edu.csye6200.main.*;
import neu.edu.csye6200.team.data.DataStore;
import neu.edu.csye6200.team.data.StudentDataManagement;
import neu.edu.csye6200.team.objects.Classroom;
import neu.edu.csye6200.team.objects.Rules;
import neu.edu.csye6200.team.objects.Student;

public class AdminController extends AbstractController {
	
	@FXML
    private TableView<Classroom> classTable;
	@FXML
    private TableColumn<Classroom, String> classNumColumn;
    @FXML
    private TableColumn<Classroom, String> classSizeColumn;
    @FXML
    private TableColumn<Classroom, String> studentAgeColumn;
    @FXML
    private TableColumn<Classroom, String> teacherName;
    
    public AdminController() {}
    private Classroom classroom = new Classroom();
    
    @FXML
    private void initialize() {
    	classroom.arrange();
    	classNumColumn.setCellValueFactory(cell -> cell.getValue().nameProperty());
    	classSizeColumn.setCellValueFactory(cell -> cell.getValue().sizeProperty());
    	studentAgeColumn.setCellValueFactory(cell -> cell.getValue().ageRangeProperty());
    	teacherName.setCellValueFactory(cell -> cell.getValue().teacherNameProperty());
    }
    
    // Reference to the main application.
    private Main main;
    
    
    @Override
    public void setApp(Main main) {
        this.main = main;
        classTable.setItems(DataStore.getInstance().getClassroomList());
    }
    
    @FXML
    private void handleRegulationRules() throws Exception {
        main.loadRegulationRules();
    }
    
    @FXML
    private void handleAddStudent() throws Exception {
    	main.loadAddStudent(classroom);
    }
    
    @FXML
    private void handleAddTeacher() throws Exception {
    	main.loadAddTeacher();
    }
    
    @FXML
    private void handleDetail() throws Exception {
        Classroom selectedClassroom = classTable.getSelectionModel().getSelectedItem();
        if (selectedClassroom != null) {
            main.loadClassroonInfo(selectedClassroom);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(main.getStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Classroom Selected");
            alert.setContentText("Please select a classroom in the table.");

            alert.showAndWait();
        }
    }
    
    @FXML
    private void handleAfter() {
        for(Student s : DataStore.getInstance().getStudents()) {
        	s.setAge(s.getAge()+6);
        }
        new StudentDataManagement().refreshAll(DataStore.getInstance().getStudents());
        classroom.arrange();
    	classNumColumn.setCellValueFactory(cell -> cell.getValue().nameProperty());
    	classSizeColumn.setCellValueFactory(cell -> cell.getValue().sizeProperty());
    	studentAgeColumn.setCellValueFactory(cell -> cell.getValue().ageRangeProperty());
    	teacherName.setCellValueFactory(cell -> cell.getValue().teacherNameProperty());
    }
}