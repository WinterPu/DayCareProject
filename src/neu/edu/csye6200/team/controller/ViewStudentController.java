package neu.edu.csye6200.team.controller;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import neu.edu.csye6200.team.data.StudentDataManagement;
import neu.edu.csye6200.team.objects.Student;

public class ViewStudentController implements Initializable {
	private Button btnBack;
	private Button btnCheckimmun;
	private TextField txtID = new TextField();
	private TextField txtFirstname = new TextField();
	private TextField txtLastname = new TextField();
	private TextField txtAge = new TextField();
	private TextField txtFather = new TextField();
	private TextField txtMother = new TextField();
	private TextField txtRegister = new TextField();
	
	StudentDataManagement sdm;
	List<Student> stuList;
	Student student;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	       // TODO (don't really need to do anything here).

		sdm = new StudentDataManagement();
		stuList = sdm.getDataList();
		student = stuList.get(0);
		viewData();
	}
	
	public void back(ActionEvent event) {
	    System.out.println("Back Successfully");

	}
	
	public void checkImmuns(ActionEvent event) {
		System.out.println("Go To Immunization Interface");
	}
	
	public void viewData(){
		String id = String.valueOf(student.getStuId());
		String firname = student.getFirstName();
		String laname = student.getLastName();
		String age = String.valueOf(student.getAge());
		String registime = String.valueOf(student.getRegisterTime());
		String father = student.getFatherName();
		String mother = student.getMotherName();
		
		txtID.setText(id);
		txtFirstname.setText(firname);
		txtLastname.setText(laname);
		txtAge.setText(age);
		txtFather.setText(father);
		txtMother.setText(mother);
		txtRegister.setText(registime);
	}
}
