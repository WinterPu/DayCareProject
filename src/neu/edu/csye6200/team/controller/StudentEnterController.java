package neu.edu.csye6200.team.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
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
public class StudentEnterController implements Initializable {

	private Main application;
	StudentDataManagement sdm;
	List<Student> stuList;
	public Student student;
	@FXML
	private TextField txtID = new TextField();
	
	
	public void setApp(Main app) {
		this.application = app;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		sdm = new StudentDataManagement();
		stuList = sdm.getDataList();
		
	}
	
	public void clear(ActionEvent event) {
		txtID.setText(null);
		
	}
	
	public void submit(ActionEvent event) throws Exception {
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
		application.goViewStudent(student);
	}
}
