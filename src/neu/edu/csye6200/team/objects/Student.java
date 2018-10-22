package neu.edu.csye6200.team.objects;

import java.util.Date;
import java.util.List;

public class Student extends Person implements Comparable<Student>{

	private int stuId;//primary key for student, automatically increased by 1, start from 100001, cannot be set manually
	private int age;//monthly age
	private Date registerDate;
	private String fatherName;
	private String motherName;
	private List<Immunization> immunizations;
	public Student() {}
	//This constructor should only be used for initialization
	public Student(int stuId, String firstName, String lastName, int age) {
		super();
		this.stuId = stuId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	//This is the basic constructor when creating a Student Object
	public Student(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
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
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public List<Immunization> getImmunizations() {
		return immunizations;
	}
	public void setImmunizations(List<Immunization> immunizations) {
		this.immunizations = immunizations;
	}
	@Override
	public String toString() {
		return stuId + "," + registerDate + "," + firstName + "," + lastName + "," + age + "," + fatherName + "," + motherName + "\n";
	}

	@Override
	public int compareTo(Student stu) {
		// TODO Auto-generated method stub
		return Integer.valueOf(stuId).compareTo(stu.stuId);
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
}
