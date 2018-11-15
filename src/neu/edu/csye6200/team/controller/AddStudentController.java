package neu.edu.csye6200.team.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import neu.edu.csye6200.main.Main;
import neu.edu.csye6200.team.data.DataStore;
import neu.edu.csye6200.team.data.StudentDataManagement;
import neu.edu.csye6200.team.objects.Classroom;
import neu.edu.csye6200.team.objects.Student;
import neu.edu.csye6200.team.objects.Teacher;

public class AddStudentController extends AbstractController{
	private Stage dialogStage;
    private Main main;
    private Classroom classroom;
    
    @FXML
    private JFXTextField fName;
    @FXML
    private JFXTextField lName;
    @FXML
    private JFXTextField fatherName;
    @FXML
    private JFXTextField motherName;
    @FXML
    private JFXTextField age;
    
    @FXML
    public void initialize() {
    	
    }
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    @Override
    public void setApp(Main main) {
        this.main = main;
    }
    
    public void setClassroom(Classroom classroom) {
    	this.classroom = classroom;
    }
    
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
    
    @FXML
    private void handleSave() throws Exception {
    	if(fName.getText().isEmpty()||lName.getText().isEmpty()||age.getText().isEmpty()||fatherName.getText().isEmpty()||motherName.getText().isEmpty()) {
    		Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(main.getStage());
            alert.setTitle("Warning");
            alert.setHeaderText("The Information is Incomplete");
            alert.setContentText("Please fill in the blank");
            alert.showAndWait();
    	}else if(!isInt(age.getText())){
    		Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(main.getStage());
            alert.setTitle("Warning");
            alert.setHeaderText("Wrong Format");
            alert.setContentText("please enter a valid age");
            alert.showAndWait();
    	}else {
    		int studentId = DataStore.getInstance().getStudents().get(DataStore.getInstance().getStudents().size()-1).getStuId() + 1;
        	DataStore.getInstance().getStudents().add(
        			new Student(studentId, fName.getText(),lName.getText(),
        					Integer.parseInt(age.getText()), new Date(), fatherName.getText(), motherName.getText()));
        	classroom.arrange();
        	if(classroom.teacherIsExcept()) {
        		DataStore.getInstance().getStudents().remove(DataStore.getInstance().getStudents().size()-1);
    			Alert alert = new Alert(AlertType.WARNING);
                alert.initOwner(main.getStage());
                alert.setTitle("Warning");
                alert.setHeaderText("No Teacher Is Available");
                alert.setContentText("Need to employee more teachers");
                alert.showAndWait();
        	}
        	if(classroom.classIsExcept()) {
        			DataStore.getInstance().getStudents().remove(DataStore.getInstance().getStudents().size()-1);
        			Alert alert = new Alert(AlertType.WARNING);
                    alert.initOwner(main.getStage());
                    alert.setTitle("Warning");
                    alert.setHeaderText("The Clss Is Full");
                    alert.setContentText("Can not add student whoes age is between "+classroom.getExceptRange()+" any more");
                    alert.showAndWait();
        	}
        	//dialogStage.close();
        	new StudentDataManagement().refreshAll(DataStore.getInstance().getStudents());
    	}
    }
    
    public boolean isInt(String s) {
    	try{
            Integer.parseInt(s);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}
