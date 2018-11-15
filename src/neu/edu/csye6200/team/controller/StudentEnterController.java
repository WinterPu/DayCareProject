package neu.edu.csye6200.team.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import neu.edu.csye6200.main.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import neu.edu.csye6200.team.data.StudentDataManagement;
import neu.edu.csye6200.team.objects.Student;


/**
 * @author Qianru
 * The class contains operations in Student Entrance Interface
 */
public class StudentEnterController extends AbstractController implements Initializable {

	private Main application;
	StudentDataManagement sdm;
	List<Student> stuList;
	public Student student;
	@FXML
	private TextField txtID = new TextField();
	
	private BackgroundPanelController background_controller;
	
	public void setApp(Main app) {
		this.application = app;
	}
	
    public void setBackground(BackgroundPanelController controller) {
    	background_controller = controller;
    }
    
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		sdm = new StudentDataManagement();
		stuList = sdm.getDataList();
		System.out.println(stuList+"      in StuEnter initial");
	}
	
	public void clear(ActionEvent event) {
		txtID.setText("");
	}
	
	public void update(ActionEvent event)  throws Exception{
		String textid = txtID.getText();
		for(Student st : stuList) {
			String strst = String.valueOf(st);
			String[] fields = strst.split(",");
			String id = fields[0];
			if(textid.equals(id)) {
				System.out.println("find student");
				student = st;
				break;
			}
		}
		if(student == null) {
			System.out.println("fail to continue");
			Alert error = new Alert(Alert.AlertType.ERROR,"                  No Student Found");
			error.setTitle("Feedback");
			error.setHeaderText("   Search Result: ");
			Button err = new Button();
			error.show();
			err.setOnAction((ActionEvent e)->{
			error.showAndWait();
			});
			return;
		}
		background_controller.loadStudentUpdatePanel(student);
	}
	
	public void submit(ActionEvent event) throws Exception {
		String textid = txtID.getText();
		System.out.println(stuList+"      in submit");
		for(Student st : stuList) {
			String strst = String.valueOf(st);
			String[] fields = strst.split(",");
			String id = fields[0];
			if(textid.equals(id)) {
				System.out.println("find student");
				student = st;
				break;
			}
		}
		
		if(student == null) {
			System.out.println("fail to continue");
			Alert error = new Alert(Alert.AlertType.ERROR,"                  No Student Found");
			error.setTitle("Feedback");
			error.setHeaderText("   Search Result: ");
			Button err = new Button();
			error.show();
			err.setOnAction((ActionEvent e)->{
			error.showAndWait();
			});
			return;
		}
		background_controller.loadStudentInfoView(student);
	}
}
