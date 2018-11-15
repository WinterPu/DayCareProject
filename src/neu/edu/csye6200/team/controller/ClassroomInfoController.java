package neu.edu.csye6200.team.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import neu.edu.csye6200.main.Main;
import neu.edu.csye6200.team.objects.Classroom;

public class ClassroomInfoController extends AbstractController{
	private Stage dialogStage;
    private Main main;
    
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
    
    public void setClassroom(Classroom classroom) {
    	
    }
    
}
