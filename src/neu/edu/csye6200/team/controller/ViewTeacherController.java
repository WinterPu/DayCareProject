package neu.edu.csye6200.team.controller;

import java.util.ArrayList;
import java.util.List;

import com.jfoenix.controls.JFXButton;

import neu.edu.csye6200.main.*;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import neu.edu.csye6200.team.data.DataStore;
import neu.edu.csye6200.team.objects.Classroom;
import neu.edu.csye6200.team.objects.Student;
import neu.edu.csye6200.team.objects.Teacher;

public class ViewTeacherController extends AbstractController {
	
	/**
	 * Usage: Searching
	 */
	@FXML
	private TextField searchField = new TextField();
//	@FXML
//	private JFXButton searchButton;
	
	/**
	 * Usage: Showing teachers' info.
	 */
	@FXML
	private TableView<Teacher> tchTable;
	@FXML
	private TableColumn<Teacher, Integer> tchId;
	@FXML
	private TableColumn<Teacher, String> tchClassNo;
	@FXML
	private TableColumn<Teacher, String> tchClassSize;
	
	/** 
	 * Usage: Teacher details Showing
	 */
	@FXML
	private TableView<Teacher> tchInfo;
	@FXML
	private Label firstNameLabel;
	@FXML
	private Label lastNameLabel;
	@FXML
	private Label classNoLabel;
	@FXML
	private Label classSizeLabel;
	
	@FXML
	private TableView<Student> stuTable;
	@FXML
	private TableColumn<Student, String> stuClassNo;
	@FXML
	private TableColumn<Student, String> stuFirstName;
	@FXML
	private TableColumn<Student, String> stuLastName;
	@FXML
	private TableColumn<Student, Integer> stuAge;
	
	private Main application;
	private Classroom clazRoom = new Classroom();
	ObservableList<Classroom> cList = DataStore.getInstance().getClassroomList();

	public ViewTeacherController() {
		
	}
	
	private void showTeacherDetail(Teacher t) {
		if(t != null) {
			firstNameLabel.setText(t.getFirstName());
			lastNameLabel.setText(t.getLastName());
			for(Classroom cc : cList) {
				if(cc.getTeacher() == t) {
					classNoLabel.setText(cc.getName());
					classSizeLabel.setText(cc.getSize());
					break;
				}
			}
			if(classNoLabel == null) classNoLabel.setText("");
			if(classNoLabel == null) classSizeLabel.setText("");
			
			Classroom cr = findclassroom(t);
			ObservableList<Student> sList = null;
			if(cr != null) sList = FXCollections.observableArrayList(cr.getStudents());
			stuTable.setItems(sList);
			
			stuClassNo.setCellValueFactory(cellData -> {
				return strToStrProperty(cr.getName());
			});
			
			stuFirstName.setCellValueFactory(cellData -> {
				Student cellFeature = cellData.getValue();
				return strToStrProperty(cellFeature.getFirstName());
			});
			
			stuLastName.setCellValueFactory(cellData -> {
				Student cellFeature = cellData.getValue();
				return strToStrProperty(cellFeature.getLastName());
			});
		
			stuAge.setCellValueFactory(cellData -> {
				Student cellFeature = cellData.getValue();
				return intToIntProperty(cellFeature.getAge());
			});
			
			
		}
	}
	
	
	private void updateStudentList(Student s) {
		
	}
	
	private Classroom findclassroom(Teacher t) {
		if(t == null) return null;
		
		for(Classroom c : cList) {
			if(c.getTeacher() == t) return c;
		}
		
		return null;
	}
	
	@FXML
	private void initialize() {
		clazRoom.arrange();
		/**
		 * Using DataManagement to get Teachers data
		 */
		tchId.setCellValueFactory(cellData -> {
			Teacher cellFeature = cellData.getValue();
			return intToIntProperty(cellFeature.getTchId());
		});
		tchClassNo.setCellValueFactory(cellData -> {
			Teacher cellFeature = cellData.getValue();
			for(Classroom cc : cList) {
				if(cc.getTeacher() == cellFeature) return strToStrProperty(cc.getName());
			}
			return strToStrProperty("");
		});
		tchClassSize.setCellValueFactory(cellData -> {
			Teacher cellFeature = cellData.getValue();
			for(Classroom cc : cList) {
				if(cc.getTeacher() == cellFeature) return strToStrProperty(cc.getSize());
			}
			return strToStrProperty("");
		});
		
		showTeacherDetail(null);
		
		tchTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showTeacherDetail(newValue));
		
		/**
		 * Using DataManagement to get Students data
		 */
		
		stuTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> updateStudentList(newValue));
	}
	
	// Helper for setCellValueFactory function
	private StringProperty strToStrProperty(String s) {
		return new SimpleStringProperty(s);
	}
	
	// Helper for setCellValueFactory function
	private ObjectProperty<Integer> intToIntProperty(int i) {
		return new SimpleIntegerProperty(i).asObject();
	}
	
	public void clear(ActionEvent event) {
		searchField.setText(null);
		
	}
	
	
	public void searchId(ActionEvent event) throws Exception {
		String fieldTchId = searchField.getText();
		
		// Handle blank field search
		if(fieldTchId == null || fieldTchId.trim().isEmpty()) {
			tchTable.setItems(application.getTeacherData());
			return;
		}
		
		try {
			List<Teacher> list = application.getTeacherData();
			List<Teacher> target = new ArrayList<>();
			
			for(Teacher t : list) {
				if(t.getTchId() == Integer.parseInt(fieldTchId)) {
					target.add(t);
				}
			}
			
			if(target.isEmpty()) tchTable.setItems(null);
			else tchTable.setItems(FXCollections.observableArrayList(target));
		} catch(NumberFormatException e) {
			System.out.println("fail to continue");
			Alert error = new Alert(Alert.AlertType.ERROR,"                  Illegal Input.");
			error.setTitle("Feedback");
			error.setHeaderText("   Search Result: ");
			Button err = new Button();
			error.show();
			err.setOnAction((ActionEvent ee)->{
			error.showAndWait();
			});
			return;
		}	
	}
	
	
	public void studentButton(ActionEvent event) throws Exception {
		// TODO
		// load ViewStudent.fxml
	}
	
	public void teacherButton(ActionEvent event) throws Exception {
		return;
	}
	
	public void admButton(ActionEvent event) throws Exception {
		application.loadAdmin();
	}
	
	@FXML
	private void handlePrintButton() {
		return;
	}
	
	@FXML
	private void handleBackButton() throws Exception {
		// Return to the initial Scene
		application.loadAdmin();
	}
	
	@Override
	public void setApp(Main mainTestTeacher) {
        this.application = mainTestTeacher;
        // Add observable list data to the table
        tchTable.setItems(application.getTeacherData());
        stuTable.setItems(FXCollections.observableArrayList(DataStore.getInstance().getStudents()));
    }
	
}
