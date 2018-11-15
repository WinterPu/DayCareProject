package neu.edu.csye6200.team.controller;

import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import neu.edu.csye6200.main.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import neu.edu.csye6200.team.data.DataStore;
import neu.edu.csye6200.team.data.StudentDataManagement;
import neu.edu.csye6200.team.objects.Classroom;
import neu.edu.csye6200.team.objects.Student;

/**
 * 
 * @author Qianru
 * The class contains operations in View Student Information Interface
 */
public class ViewStudentController extends AbstractController implements Initializable {
	private Main application;
	private Button btnBack;
	private Button btnCheckimmun;
	@FXML
	private TextField txtID = new TextField();
	@FXML
	private TextField txtFirstname = new TextField();
	@FXML
	private TextField txtLastname = new TextField();
	@FXML
	private TextField txtAge = new TextField();
	@FXML
	private TextField txtFather = new TextField();
	@FXML
	private TextField txtMother = new TextField();
	@FXML
	private TextField txtRegister = new TextField();
	@FXML
	private TextField txtClassroom = new TextField();
	
	public static Student student;
	public Classroom room;
	
	public void setApp(Main app) {
		this.application = app;
	}
	
	private BackgroundPanelController background_controller;
	
	
    public void setBackground(BackgroundPanelController controller) {
    	background_controller = controller;
    }
	
    public void setStudent(Student student) {
    	this.student = student;
    	System.out.println(this.student);
    }
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	       // TODO (don't really need to do anything here).		
		
		String strstudent = String.valueOf(student);
		String[] fields = strstudent.split(",");
		String id = fields[0];
		
		String firname = fields[1];
		String laname = fields[2];
		String age = fields[3];
		String father = fields[4];
		String mother = fields[5];
		String registime = fields[6];
		
		int idnum = Integer.parseInt(id);
		int agenum = Integer.parseInt(age);
		student.setStuId(idnum);
		student.setFirstName(firname);
		student.setLastName(laname);
		student.setAge(agenum);
		student.setFatherName(father);
		student.setMotherName(mother);
		//Immunization imm1 = new Immunization(idnum, immuId, String immuName, int duration, Date immuDate)
		for(Classroom cr : DataStore.getInstance().getClassroomList()) {
			for(Student st : cr.getStudents()) {
				if(idnum == st.getStuId()) {
					room = cr;
					break;
				}
			}
		}
		
		
		txtID.setText(id);
		txtFirstname.setText(firname);
		txtLastname.setText(laname);
		txtAge.setText(age);
		txtFather.setText(father);
		txtMother.setText(mother);
		txtRegister.setText(registime);
		//txtClassroom.setText(room.getName());
	}
	
	public void back(ActionEvent event) throws Exception {
	    System.out.println("Back Successfully");
	    background_controller.loadStudent();
	}
	
	@FXML
	public void checkImmuns(ActionEvent event) throws Exception {
		System.out.println("Go To Immunization Interface");
		background_controller.loadImmunizationView(student);
    }  
	
}
