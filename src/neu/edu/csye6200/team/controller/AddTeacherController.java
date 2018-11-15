package neu.edu.csye6200.team.controller;

import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
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
    	int tcId = DataStore.getInstance().getTeachers().get(DataStore.getInstance().getTeachers().size()-1).getTchId() + 1;
    	DataStore.getInstance().getTeachers().add(new Teacher(tcId, fName.getText(), lName.getText()));
    	new TeacherDataManagement().refreshAll(DataStore.getInstance().getTeachers());
        dialogStage.close();
    }
}
