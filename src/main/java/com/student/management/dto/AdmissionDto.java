package com.student.management.dto;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.student.management.entity.Admission;
import com.student.management.entity.Student;

public class AdmissionDto{

	private int referenceNo;
	private String academicYear;
	private String batch;
	private String classs;
	private char idCard;
	private String name;
	private char bag;
	private char module;
	private float scholarship;
	private int installments;
	private float amountPaid;
	private int rollNo;
	private LocalDate date;
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getReferenceNo() {
		return referenceNo;
	}
	public void setReferenceNo(int referenceNo) {
		this.referenceNo = referenceNo;
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
	
	
	
}
