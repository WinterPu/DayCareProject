package neu.edu.csye6200.team.controller;


import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import neu.edu.csye6200.main.*;
import neu.edu.csye6200.team.data.DataStore;
import neu.edu.csye6200.team.data.ImmuDataManagement;
import neu.edu.csye6200.team.objects.Classroom;
import neu.edu.csye6200.team.objects.ImmunList;
import neu.edu.csye6200.team.objects.Immunization;




public class AdminController extends AbstractController implements Initializable {


  
	@FXML
    private TableView<Classroom> classTable;
	@FXML
    private TableColumn<Classroom, String> classNumColumn;
    @FXML
    private TableColumn<Classroom, String> classSizeColumn;
    @FXML
    private TableColumn<Classroom, String> studentAgeColumn;
    @FXML
    private TableColumn<Classroom, String> teacherName;
    
   
    // Reference to the main application.
    private Main main;

    
    public AdminController() {}
    private Classroom classroom = new Classroom();
    
    
    
    
    @Override
    public void setApp(Main main) {
        this.main = main;
        classTable.setItems(DataStore.getInstance().getClassroomList());
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// TODO Auto-generated method stub
		classroom.arrange();
		
		System.out.println(classNumColumn);
		System.out.println(classSizeColumn);
		
		classNumColumn.setCellValueFactory(cell-> cell.getValue().nameProperty());

    	classSizeColumn.setCellValueFactory(cell -> cell.getValue().sizeProperty());
    	studentAgeColumn.setCellValueFactory(cell -> cell.getValue().ageRangeProperty());
    	teacherName.setCellValueFactory(cell -> cell.getValue().teacherNameProperty());
//    	

	}
    
    
    @FXML
    private void handleRegulationRules() throws Exception {
        main.loadRegulationRules();
    }
    
    @FXML
    private void handleAddStudent() throws Exception {
    	main.loadAddStudent(classroom);
    }
    
    @FXML
    private void handleAddTeacher() throws Exception {
    	main.loadAddTeacher();
    }
    
    @FXML
    private void handleDetail() throws Exception {
        Classroom selectedClassroom = classTable.getSelectionModel().getSelectedItem();
        if (selectedClassroom != null) {
            main.loadClassroonInfo(selectedClassroom);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(main.getStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Classroom Selected");
            alert.setContentText("Please select a classroom in the table.");

            alert.showAndWait();
        }
    }


    
    
}