package neu.edu.csye6200.team.objects;

import java.util.Date;

import neu.edu.csye6200.main.PropertiesReader;

public class Student extends Person implements Comparable<Student>{

	private int stuId;//primary key for student, automatically increased by 1, start from 100001, cannot be set manually
	private int age;//monthly age
	private Date graduateTime;
	private boolean isGrad = false;//if is true, graduateTime should be set
	public Student() {}
	//This constructor should only be used for initialization
	public Student(int stuId, String firstName, String lastName, Date registerTime, int age) {
		super();
		this.stuId = stuId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.registerTime = registerTime;
		this.age = age;
	}
	//This is the basic constructor when creating a Student Object
	public Student(String firstName, String lastName, Date registerTime, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.registerTime = registerTime;
		this.age = age;
	}
	
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getGraduateTime() {
		return graduateTime;
	}
	public void setGraduateTime(Date graduateTime) {
		this.graduateTime = graduateTime;
	}
	public boolean isGrad() {
		return isGrad;
	}
	public void setGrad(boolean isGrad) {
		this.isGrad = isGrad;
	}

	@Override
	public String toString() {
		return stuId + "," + age + "," + (graduateTime == null ? "" : PropertiesReader.getSimpleDataFormat().format(graduateTime)) + "," 
				+ isGrad + "," + firstName + "," + lastName + "," + PropertiesReader.getSimpleDataFormat().format(registerTime) + "\n";
	}

	@Override
	public int compareTo(Student stu) {
		// TODO Auto-generated method stub
		return Integer.valueOf(stuId).compareTo(stu.stuId);
	}
	
}
