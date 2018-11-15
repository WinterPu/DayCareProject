package neu.edu.csye6200.team.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import neu.edu.csye6200.main.Main;

public class ControlPanelController extends AbstractController implements Initializable {

    @FXML
    private JFXButton btnAdministrator;

    @FXML
    private JFXButton btnStudent;

    @FXML
    private JFXButton btnTeacher;

    @FXML
    private JFXButton btnExit;
    
    private Main application;
    
    private BackgroundPanelController background_controller;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	
    @Override
    public void setApp(Main main) {
        this.application = main;
    }
    
    public void setBackground(BackgroundPanelController controller) {
    	background_controller = controller;
    }
    
    @FXML
    private void Exit(ActionEvent event) {
    	application.getStage().close();
    }

    
    @FXML
    void showStudentView(ActionEvent event) throws Exception {

    	background_controller.loadStudent();
    }
    
    @FXML
    private void showAdminView(ActionEvent event) throws Exception {
    	//application.loadAdmin();
    	background_controller.loadAdmin();
    }

    @FXML
    private void showTeacherView(ActionEvent event) throws Exception {
    	background_controller.loadTeacher();
    }
}