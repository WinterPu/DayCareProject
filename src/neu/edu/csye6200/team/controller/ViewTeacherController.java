package neu.edu.csye6200.team.controller;

import java.util.ArrayList;
import java.util.List;

import com.jfoenix.controls.JFXButton;

import neu.edu.csye6200.main.*;
import javafx.beans.property.ObjectProperty;
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
import neu.edu.csye6200.team.objects.Student;
import neu.edu.csye6200.team.objects.Teacher;

public class ViewTeacherController extends AbstractController {
	
	@FXML
	private JFXButton studentButton;
	@FXML
	private JFXButton teacherButton;
	@FXML
	private JFXButton admButton;
	
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
	private TableColumn<Teacher, String> tchGender;
//	@FXML
//	private TableColumn<Teacher, Integer> tchClassNo;
//	@FXML
//	private TableColumn<Teacher, Integer> tchClassSize;
	
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
	private Label genderLabel;
//	@FXML
//	private Label classNoLabel;
//	@FXML
//	private Label classSizeLabel;
	@FXML
	private Label contactInfoLabel;
	
	@FXML
	private TableView<Student> stuTable;
	@FXML
	private TableColumn<Student, String> stuClassNo;
	@FXML
	private TableColumn<Student, String> stuFirstName;
	@FXML
	private TableColumn<Student, String> stuLastName;
	@FXML
	private TableColumn<Student, String> stuAge;
	
	private Main application;
	
	public ViewTeacherController() {
		
	}
	
	private void showTeacherDetail(Teacher t) {
		if(t != null) {
			firstNameLabel.setText(t.getFirstName());
			lastNameLabel.setText(t.getLastName());
//			genderLabel.setText(t.getGender());
//			classNoLabel.setText(Integer.toString(t.getClassNo()));
//			classSizeLabel.setText(Integer.toString(t.getClassSize()));
//			contactInfoLabel.setText(t.getContactInfo());
		}
	}
	
	@FXML
	private void initialize() {
		/**
		 * Using DataManagement to get Teachers data
		 */
		tchId.setCellValueFactory(cellData -> {
			Teacher cellFeature = cellData.getValue();
			return intToIntProperty(cellFeature.getTchId());
		});
//		tchGender.setCellValueFactory(cellData -> {
//			Teacher cellFeature = cellData.getValue();
//			return strToStrProperty(cellFeature.getGender());
//		});
//		tchClassNo.setCellValueFactory(cellData -> cellData.getValue().getClassNoProperty());
//		tchClassSize.setCellValueFactory(cellData -> cellData.getValue().getClassSizeProperty());
		
		showTeacherDetail(null);
		
		tchTable.getSelectionModel().selectedItemProperty().addListener(
        		(observable, oldValue, newValue) -> showTeacherDetail(newValue));
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
	
	@FXML
	private void handlePrintButton() {
		return;
	}
	
	@FXML
	private void handleBackButton() {
		// Return to the initial Scene
		// application.loadAdm();
	}
	
	@Override
	public void setApp(Main mainTestTeacher) {
        this.application = mainTestTeacher;

        // Add observable list data to the table
        tchTable.setItems(application.getTeacherData());
    }
	
}
