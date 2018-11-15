package neu.edu.csye6200.team.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import neu.edu.csye6200.main.Main;
import neu.edu.csye6200.team.objects.Student;

public class BackgroundPanelController extends AbstractController implements Initializable{

    @FXML
    private JFXDrawer drawer;

    @FXML
    private JFXHamburger hamburger;
    
    @FXML
    private AnchorPane mainPanel;
    
    private Main application;
    private ControlPanelController controller;
    private AbstractController main_panel_controller;
    private String current_panel;
    
    private boolean flag_first =true;
    @Override
    public void setApp(Main main) {
        this.application = main;

        controller.setApp(application);
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
    	try {
    		
    		// Load Control Panel
	    	FXMLLoader loader = new FXMLLoader();
	    	FileInputStream fxmlStream = new FileInputStream("static/FXML/ControlPanel.fxml"); 
			VBox vbox;
			
			
			// Set Hamburger
			vbox = (VBox)loader.load(fxmlStream);
			controller = loader.getController();
			controller.setBackground(this);
	    	drawer.setSidePane(vbox);
	    	
			HamburgerBackArrowBasicTransition burger_task = new HamburgerBackArrowBasicTransition(hamburger);
			burger_task.setRate(-1);
			hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED,(e)->{
					burger_task.setRate(burger_task.getRate()*-1);
					burger_task.play();

					if(drawer.isOpened())
						drawer.close();
					else
						drawer.open();
					
					
					
					// Load the Main Panel
					try {
						if(flag_first) {
							main_panel_controller = loadPane("static/FXML/Admin.fxml",mainPanel,main_panel_controller,application);
							flag_first = false;
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				});
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    }
	
	
	public void loadAdmin() throws Exception {
		AnchorPane pane = new AnchorPane();
		AdminController controller = null ;
		controller = loadPane("static/FXML/Admin.fxml",pane,controller,application);
	}
	
	
	public void loadTeacher() throws Exception{
		AnchorPane pane = new AnchorPane();
		ViewTeacherController controller = null;
		controller = loadPane("static/FXML/ViewTeacher.fxml",pane,controller,application);
	}
	
	
	
	
	public void loadStudent() throws Exception{
		AnchorPane pane = new AnchorPane();
		StudentEnterController controller = null;
		
		controller = loadPane("static/FXML/ViewStudentEntrance.fxml",pane,controller,application);
		controller.setBackground(this);
	}
	
	public void loadStudentUpdatePanel(Student student)throws Exception {
		AnchorPane pane = new AnchorPane();
		UpdateImmunizationController controller = null;
		UpdateImmunizationController.student =  student;
		controller = loadPane("static/FXML/UpdateImmunizations.fxml",pane,controller,application);
		controller.setBackground(this);
		
	}
	
	public void loadStudentInfoView(Student student)throws Exception  {
		AnchorPane pane = new AnchorPane();
		ViewStudentController controller = null;
		ViewStudentController.student = student;
		controller = loadPane("static/FXML/ViewStudentInformation.fxml",pane,controller,application);
		controller.setBackground(this);
		
	}
	
	
	public void loadImmunizationView(Student student)throws Exception  {
		AnchorPane pane = new AnchorPane();
		ImmunizationCheckController controller = null;
		
		ImmunizationCheckController.student = student;
		//controller.setStudent(student);
		controller = loadPane("static/FXML/ImmunizationStatus.fxml",pane,controller,application);
		controller.setBackground(this);
		
	}
	
	
	
	public <TP extends Pane ,TC extends AbstractController> TC loadPane(String path, TP pane, TC controller, Main application) throws Exception {
		FXMLLoader loader = new FXMLLoader();  
		FileInputStream fxmlStream = new FileInputStream(path);

		pane = (TP)loader.load(fxmlStream);

		mainPanel.getChildren().setAll(pane);
	 
		controller = loader.getController();

		controller.setApp(application);
		return controller;
	}

	
	
	
	
	
	
	

}
