package neu.edu.csye6200.team.objects;

import java.util.Date;

import neu.edu.csye6200.team.util.PropertiesReader;

public class Teacher extends Person implements Comparable<Teacher> {

	private int tchId;//automatically increased by 1, start at 1001
	private boolean isIdle = true;//mark whether the teacher is ready for classes or not, true means can be arranged. If all teachers are not idle
	private int stateLevel;//the level this teacher is available to teach. 1 means 6-12month, etc.
	
	public Teacher() {};
	public Teacher(int tchId, String firstName, String lastName, int stateLevel) {
		super();
		this.tchId = tchId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.stateLevel = stateLevel;
		
	}
	public int getTchId() {
		return tchId;
	}
	public boolean isIdle() {
		return isIdle;
	}
	public void setIdle(boolean isIdle) {
		this.isIdle = isIdle;
	}
	public int getStateLevel() {
		return stateLevel;
	}
	public void setStateLevel(int stateLevel) {
		this.stateLevel = stateLevel;
	}
	
	public void setTchId(int tchId) {
		this.tchId = tchId;
	}
	@Override
	public String toString() {
		return tchId + "," + isIdle + "," + stateLevel + "," + firstName + "," + lastName + "," + 
				PropertiesReader.getSimpleDataFormat().format(registerTime) + "\n";
	}
	@Override
	public int compareTo(Teacher tch) {
		// TODO Auto-generated method stub
		return Integer.valueOf(tchId).compareTo(tch.tchId);
	}

}
