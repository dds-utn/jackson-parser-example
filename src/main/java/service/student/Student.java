package service.student;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
	
	private String firstname;
	private String lastname;
	private Address address;
	private int age;
	@JsonProperty("id_card")
	private long idCard;
	@JsonProperty("passed_subjects")
	private List<PassedSubject> passedSubjects;

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getIdCard() {
		return idCard;
	}
	public void setIdCard(long idCard) {
		this.idCard = idCard;
	}
	public List<PassedSubject> getPassedSubjects() {
		return passedSubjects;
	}
	public void setPassedSubjects(List<PassedSubject> approvedSubjects) {
		this.passedSubjects = approvedSubjects;
	}	
	
}
