package neu.edu.csye6200.team.objects;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

public class ImmunList {
	private SimpleStringProperty immID;
    private SimpleStringProperty immName;
    private SimpleStringProperty status;
    
	public String getImmID() {
		return immID.get();
	}
	public void setImmID(String immID) {
		this.immID = new SimpleStringProperty(immID);
	}
	public String getImmName() {
		return immName.get();
	}
	public void setImmName(String immName) {
		this.immName = new SimpleStringProperty(immName);
	}
	public String getStatus() {
		return status.get();
	}
	public void setStatus(String status) {
		this.status = new SimpleStringProperty(status);
	}

	public ObservableValue<String> idProperty(){
	    return immID;
	}
	public ObservableValue<String> nameProperty(){
		return immName;
    }
	public  ObservableValue<String> staProperty(){
	    return status;
	}
}
