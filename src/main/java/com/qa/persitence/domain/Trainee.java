package com.qa.persitence.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Trainee {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private String name;
	private long id;
	@JoinColumn(name = "trainee_id")
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Subject> subject;
	
	public Trainee(String name, List<Subject> subject) {
		super();
		this.name = name;
		this.subject = subject;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Subject> getSubject() {
		return subject;
	}

	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	}
	
	
	


}
