package neu.edu.csye6200.team.objects;

import java.util.Date;

import neu.edu.csye6200.team.util.PropertiesReader;

/**
 * Immunization Object Class. This class only contains the basic information of Immunization
 * @author Huai Huang
 *
 */
public class Immunization {

	private int stuId;//foreign key
	private int immuId;
	private String immuName;
	private int duration;
	private Date immuDate;//This field should be set only if one student get vaccinated
	public Immunization() {}
	public Immunization(int immuId, String immuName, int duration) {
		super();
		this.immuId = immuId;
		this.immuName = immuName;
		this.duration = duration;
	}
	//This constructor is only used for initializing
	public Immunization(int stuId, int immuId, String immuName, int duration, Date immuDate) {
		super();
		this.immuId = immuId;
		this.stuId = stuId;
		this.immuName = immuName;
		this.duration = duration;
		this.immuDate = immuDate;
	}
	public int getImmuId() {
		return immuId;
	}
	public void setImmuId(int immuId) {
		this.immuId = immuId;
	}
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public Date getImmuDate() {
		return immuDate;
	}
	public void setImmuDate(Date immuDate) {
		this.immuDate = immuDate;
	}
	public String getImmuName() {
		return immuName;
	}
	public void setImmuName(String immuName) {
		this.immuName = immuName;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return stuId + "," + immuId + "," + immuName + "," + duration + "," + PropertiesReader.getSimpleDataFormat().format(immuDate) + "\n";
	}
	
}
