package com.company.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@XmlRootElement
@Table
public class Person implements Serializable {

	@Pattern(regexp = "[^0-9]*")
	@Size(min = 1, max = 30)
	String personName;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int personId;
	@Pattern(regexp = "[0-9[a-z[_]]]{1,}[@][a-z]{1,}[.][a-z]{1,}")
	String emailID;
	@Pattern(regexp = "[(][0-9]{3}[)][-][0-9]{3}[-][0-9]{4}")
	String contactNumber;
	@Size(min = 1, max = 15)
	@Pattern(regexp = "[^0-9]*")
	String personCity;
	@Size(min = 1, max = 10)
	@Pattern(regexp = "[^0-9]*")
	String personState;

	public Person() {
		super();
	}

	public Person(String personName, int personId, String emailID,
			String contactNumber, String personCity, String personState) {
		super();
		this.personName = personName;
		this.personId = personId;
		this.emailID = emailID;
		this.contactNumber = contactNumber;
		this.personCity = personCity;
		this.personState = personState;

	}

	public String getPersonCity() {
		return personCity;
	}

	public void setPersonCity(String personCity) {
		this.personCity = personCity;
	}

	public String getPersonState() {
		return personState;
	}

	public void setPersonState(String personState) {
		this.personState = personState;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "Person [personName=" + personName + ", personId=" + personId
				+ ", emailID=" + emailID + ", contactNumber=" + contactNumber
				+ ", personCity=" + personCity + ", personState=" + personState
				+ "]";
	}

}
