package com.student.management.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "table_admission")
public class Admission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rollSeq")
	@SequenceGenerator(name = "rollSeq", sequenceName = "ROLL_NO_SEQ", allocationSize = 1)
	@Column(name = "roll_no")
	private int rollNo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="reference_no")
	private Student student;
	
	@Column(name = "academic_year")
	private String academicYear;
	
	@Column(name = "batch")
	private String batch;
	
	@Column(name = "class")
	private String classs;
	
	@Column(name = "id_card")
	private char idCard;
	
	@Column(name = "bag")
	private char bag;
	
	@Column(name = "module")
	private char module;
	
	@Column(name = "scholarship")
	private float scholarship;
	
	@Column(name = "installments")
	private int installments;
	
	@Column(name = "amount_paid")
	private float amountPaid;
	
	@Column(name = "admission_date")
	private LocalDate date;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="admission") // maybe CascadeType.REMOVE is enough for you
	private List<Account> memberships = new ArrayList<>();

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}


	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getClasss() {
		return classs;
	}

	public void setClasss(String classs) {
		this.classs = classs;
	}

	public char getIdCard() {
		return idCard;
	}

	public void setIdCard(char idCard) {
		this.idCard = idCard;
	}

	public char getBag() {
		return bag;
	}

	public void setBag(char bag) {
		this.bag = bag;
	}

	public char getModule() {
		return module;
	}

	public void setModule(char module) {
		this.module = module;
	}

	public float getScholarship() {
		return scholarship;
	}

	public void setScholarship(float scholarship) {
		this.scholarship = scholarship;
	}

	public int getInstallments() {
		return installments;
	}

	public void setInstallments(int installments) {
		this.installments = installments;
	}

	public float getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(float amountPaid) {
		this.amountPaid = amountPaid;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Admission [rollNo=" + rollNo + ", academicYear=" + academicYear + ", batch=" + batch + ", classs="
				+ classs + ", idCard=" + idCard + ", bag=" + bag + ", module=" + module + ", scholarship=" + scholarship
				+ ", installments=" + installments + ", amountPaid=" + amountPaid + ", date=" + date + "]";
	}

	
	

}
