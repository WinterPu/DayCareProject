package neu.edu.csye6200.team.controller;

import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import neu.edu.csye6200.main.Main;
import neu.edu.csye6200.team.data.DataStore;
import neu.edu.csye6200.team.data.TeacherDataManagement;
import neu.edu.csye6200.team.objects.Teacher;

public class AddTeacherController extends AbstractController{
	private Stage dialogStage;
    private Main main;
    
    @FXML
    private JFXTextField fName;
    @FXML
    private JFXTextField lName;
    
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    @Override
    public void setApp(Main main) {
        this.main = main;
    }
    
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
    
    @FXML
    private void handleSave() {
    	if(fName.getText().isEmpty()||lName.getText().isEmpty()) {
    		Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(main.getStage());
            alert.setTitle("Warning");
            alert.setHeaderText("The Information is Incomplete");
            alert.setContentText("Please fill in the blank");
            alert.showAndWait();
    	}else {
    		int tcId = DataStore.getInstance().getTeachers().get(DataStore.getInstance().getTeachers().size()-1).getTchId() + 1;
        	DataStore.getInstance().getTeachers().add(new Teacher(tcId, fName.getText(), lName.getText()));
        	new TeacherDataManagement().refreshAll(DataStore.getInstance().getTeachers());
            dialogStage.close();
    	}
    }
}
