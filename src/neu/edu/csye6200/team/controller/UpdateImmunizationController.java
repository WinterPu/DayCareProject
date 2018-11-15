package neu.edu.csye6200.team.controller;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import neu.edu.csye6200.main.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import neu.edu.csye6200.team.data.ImmuDataManagement;
import neu.edu.csye6200.team.objects.Immunization;
import neu.edu.csye6200.team.objects.Student;

public class UpdateImmunizationController extends AbstractController implements Initializable{

	private Main application;
	public static Student student;
	@FXML
	private Label lbStuid = new Label();
	@FXML
	private ComboBox cbImmname = new ComboBox();
	@FXML
	private TextField txtID = new TextField();
	@FXML
	private TextField txtName = new TextField();
	@FXML
	private TextField txtDuration = new TextField();
	
	ImmuDataManagement idm;
	ArrayList<Immunization> immList;
	int applyNumber = 0;
	
	public void setApp(Main app) {
		this.application = app;
		System.out.println(application+"    in setApp");
	}
	
	private BackgroundPanelController background_controller;
	
    public void setBackground(BackgroundPanelController controller) {
    	background_controller = controller;
    }
    
    public void setStudent(Student student) {
    	this.student = student;
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		idm = new ImmuDataManagement();
		immList = (ArrayList)idm.getDataList(student.getStuId());
		List<String> data = new ArrayList<String>();
		for(Immunization imm : immList) {
			String imname = imm.getImmuName();
			data.add(imname);
		}
		ObservableList<String> options = FXCollections.observableArrayList(data);
		cbImmname.setItems(options);
		
		lbStuid.setText("Student ID: "+String.valueOf(student.getStuId()));
	}
	
	public void back(ActionEvent event) throws Exception {
		background_controller.loadStudent();
	}
	
	public void update(ActionEvent event) throws Exception {
		String imname = (String)cbImmname.getValue();
		Immunization immun = null;
		for(Immunization imm : immList) {
			String name = imm.getImmuName();
			if(name.equals(imname)) {
				immun = imm;
				break;
			}
		}
		if(immun == null) {
			Alert error = new Alert(Alert.AlertType.ERROR,"      Please select an Immunization record to Update");
			error.setTitle("Feedback");
			error.setHeaderText("   Check Result: ");
			Button err = new Button();
			error.show();
			err.setOnAction((ActionEvent e)->{
			error.showAndWait();
			});
			return;
		}
		String tid = String.valueOf(immun.getImmuId());
		String tname = immun.getImmuName();
		String tduration = String.valueOf(immun.getDuration());
		
		txtID.setText(tid);
		txtID.setEditable(false);
		txtName.setText(tname);
		txtName.setEditable(false);
		txtDuration.setText(tduration);
		txtDuration.setEditable(true);
		applyNumber = 1;
	}
	
	public void addImmun(ActionEvent event) throws Exception {
		txtID.setText("");
		txtID.setEditable(true);
		txtName.setText("");
		txtName.setEditable(true);
		txtDuration.setText("");
		txtDuration.setEditable(true);
		applyNumber = 2;
	}
	
	public void apply(ActionEvent event) throws Exception {
		String idstr = txtID.getText();
		String name = txtName.getText();
		String durationstr = txtDuration.getText();
		
		if(applyNumber == 1) {
			int id = Integer.parseInt(idstr);
			int duration;
			try {
  			    duration = Integer.parseInt(durationstr);
			} catch(NumberFormatException ex) {
				txtDuration.setText("");
				Alert error = new Alert(Alert.AlertType.ERROR,"                  Wrong Input Type of Duration");
				error.setTitle("Feedback");
				error.setHeaderText("   Check Result: ");
				Button err = new Button();
				error.show();
				err.setOnAction((ActionEvent e)->{
				error.showAndWait();
				});
				return;
			  }
			int stuid = student.getStuId();
			Date now = new Date();
		    Immunization im=null;
		    for(Immunization im1:immList) {
		    	if(im1.getImmuId() == id) {
		    		im = im1;
		    	}
		    }
		    im.setStuId(stuid);
		    im.setImmuId(id);
		    im.setImmuName(name);
		    im.setDuration(duration);
		    im.setImmuDate(now);
		    idm.updateOneObject(im);
		    
		    txtID.setText("");
			txtID.setEditable(false);
			txtName.setText("");
			txtName.setEditable(false);
			txtDuration.setText("");
			txtDuration.setEditable(false);
		}
		else if(applyNumber == 2) {
			int id;
			try {
  			    id = Integer.parseInt(idstr);
			} catch(NumberFormatException ex) {
				txtID.setText("");
				Alert error = new Alert(Alert.AlertType.ERROR,"                  Wrong Input Type of Immun ID");
				error.setTitle("Feedback");
				error.setHeaderText("   Check Result: ");
				Button err = new Button();
				error.show();
				err.setOnAction((ActionEvent e)->{
				error.showAndWait();
				});
				return;
			  }
			if(name.equals("")||name == null) {
				Alert error = new Alert(Alert.AlertType.ERROR,"                  Name can not be empty");
				error.setTitle("Feedback");
				error.setHeaderText("   Check Result: ");
				Button err = new Button();
				error.show();
				err.setOnAction((ActionEvent e)->{
				error.showAndWait();
				});
				return;
			}
			int duration;
			try {
  			    duration = Integer.parseInt(durationstr);
			} catch(NumberFormatException ex) {
				txtDuration.setText("");
				Alert error = new Alert(Alert.AlertType.ERROR,"                  Wrong Input Type of Duration");
				error.setTitle("Feedback");
				error.setHeaderText("   Check Result: ");
				Button err = new Button();
				error.show();
				err.setOnAction((ActionEvent e)->{
				error.showAndWait();
				});
				return;
			  }
			
			for(Immunization imm : immList) {
				int mid = imm.getImmuId();
				if(mid == id) {
					txtID.setText("");
					Alert error = new Alert(Alert.AlertType.ERROR,"                  This Immunization Has Already Exist");
					error.setTitle("Feedback");
					error.setHeaderText("   Check Result: ");
					Button err = new Button();
					error.show();
					err.setOnAction((ActionEvent e)->{
					error.showAndWait();
					});
					return;
				}
			}
			
			int stuid = student.getStuId();
			Date now = new Date();
			Immunization im = new Immunization();
		    im.setStuId(stuid);
		    im.setImmuId(id);
		    im.setImmuName(name);
		    im.setDuration(duration);
		    im.setImmuDate(now);
		    idm.registerOneObject(im);
		    
		    txtID.setText("");
			txtID.setEditable(false);
			txtName.setText("");
			txtName.setEditable(false);
			txtDuration.setText("");
			txtDuration.setEditable(false);
		}
		else {
			Alert warning = new Alert(Alert.AlertType.WARNING,"Warning: Please select operation first");
			warning.setTitle("Warning");
			warning.setHeaderText("   Warning: ");
			Button war = new Button();
			warning.show();
			war.setOnAction((ActionEvent e)->{
			warning.showAndWait();
			});
			return;
		}
	
	}
	
}
