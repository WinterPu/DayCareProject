package neu.edu.csye6200.team.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    	if(!(typeIsRight(fName.getText()) && typeIsRight(lName.getText()))) {
    		Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(main.getStage());
            alert.setTitle("Warning");
            alert.setHeaderText("Wrong Format");
            alert.setContentText("You can only enter letters for name");
            alert.showAndWait();
    	}else {
    		int tcId = DataStore.getInstance().getTeachers().get(DataStore.getInstance().getTeachers().size()-1).getTchId() + 1;
        	DataStore.getInstance().getTeachers().add(new Teacher(tcId, fName.getText(), lName.getText()));
        	new TeacherDataManagement().refreshAll(DataStore.getInstance().getTeachers());
            dialogStage.close();
    	}
    }
    
    public boolean typeIsRight(String s) {
    	Pattern p = Pattern.compile("[A-Za-z]{1,}");
        Matcher m = p.matcher(s);
    	return m.matches();
    }
}
