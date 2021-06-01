package org.hibernate.jakarta.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity(name = "Person")
@Table(name = "PERSON")
public class Person implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_ID_SEQ")
	@SequenceGenerator(name = "PERSON_ID_SEQ", sequenceName = "PERSON_ID_SEQ", allocationSize = 1)
	@Column(name = "ID")
	protected Long id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "BODY_WEIGHT")
	private Float bodyWeight;

	public Person() {
	}

	public Person(String firstName, String lastName, Float bodyWeight) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.bodyWeight = bodyWeight;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Float getBodyWeight() {
		return bodyWeight;
	}

	public void setBodyWeight(Float bodyWeight) {
		this.bodyWeight = bodyWeight;
	}

}
