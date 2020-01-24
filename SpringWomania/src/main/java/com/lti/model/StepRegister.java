package com.lti.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component("stepRegister")
@Table(name = "Step_Register")
@SequenceGenerator(name="seq1",sequenceName="seq_stepId",allocationSize=1,initialValue=1)
public class StepRegister implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq1")
	@Column(name = "Id")
	private int id;
	@Column(name = "Name")
	private String name;
	@Column(name = "Username")
	private String userName;
	@Column(name = "DOB")
	private String DOB;
	@Column(name = "Password")
	private String password;
	@Column(name = "CPassword")
	private String cPassword;
	@Column(name = "Contact")
	private long contact;

	
	public StepRegister() {
		super();

	}

	public StepRegister(int id, String name, String userName, String dOB, String password, String cPassword,long contact) {
		super();
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.DOB = dOB;
		this.password = password;
		this.cPassword = cPassword;
		this.contact = contact;
	}
/*	public StepRegister(String name, String userName, String dOB, String password, String cPassword,long contact) {
		super();
		this.name = name;
		this.userName = userName;
		this.DOB = dOB;
		this.password = password;
		this.cPassword = cPassword;
		this.contact = contact;
	}*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getcPassword() {
		return cPassword;
	}

	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "StepRegister [id=" + id + ", name=" + name + ", userName=" + userName + ", DOB=" + DOB + ", password="
				+ password + ", cPassword=" + cPassword + ", contact=" + contact + "]";
	}

}
