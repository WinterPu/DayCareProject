package neu.edu.csye6200.team.controller;

import com.jfoenix.controls.JFXButton;

import neu.edu.csye6200.main.*;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
//	@FXML 
//	private JFXButton searchField;
	@FXML
	private JFXButton searchButton;
	
	/**
	 * Usage: Showing teachers' info.
	 */
	@FXML
	private TableView<Teacher> tchTable;
	@FXML
	private TableColumn<Teacher, Integer> tchId;
//	@FXML
//	private TableColumn<Teacher, String> tchGender;
//	@FXML
//	private TableColumn<Teacher, Integer> tchClassNo;
//	@FXML
//	private TableColumn<Teacher, Integer> tchClassSize;
	
	/** 
	 * Usage: Teacher details Showing
	 */
//	@FXML
//	private TableView<Teacher> tchInfo;
	@FXML
	private Label firstNameLabel;
	@FXML
	private Label lastNameLabel;
//	@FXML
//	private Label genderLabel;
//	@FXML
//	private Label classNoLabel;
//	@FXML
//	private Label classSizeLabel;
//	@FXML
//	private Label contactInfoLabel;
	
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
	
	private Main main;
	
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
//		tchGender.setCellValueFactory(cellData -> cellData.getValue().getGenderProperty());
//		tchClassNo.setCellValueFactory(cellData -> cellData.getValue().getClassNoProperty());
//		tchClassSize.setCellValueFactory(cellData -> cellData.getValue().getClassSizeProperty());
		
		showTeacherDetail(null);
		
		tchTable.getSelectionModel().selectedItemProperty().addListener(
        		(observable, oldValue, newValue) -> showTeacherDetail(newValue));
	}
	
	private StringProperty strToStrProperty(String s) {
		return new SimpleStringProperty(s);
	}
	
	private ObjectProperty<Integer> intToIntProperty(int i) {
		return new SimpleIntegerProperty(i).asObject();
	}
	
	
	@FXML
	private void handlePrintButton() {
		return;
	}
	
	@FXML
	private void handleBackButton() {
		return;
	}
	
	@Override
	public void setApp(Main mainTestTeacher) {
        this.main = mainTestTeacher;

        // Add observable list data to the table
        tchTable.setItems(main.getTeacherData());
    }
	
}
