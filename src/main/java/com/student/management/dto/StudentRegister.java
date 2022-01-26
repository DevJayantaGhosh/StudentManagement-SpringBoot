package com.student.management.dto;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

public class StudentRegister implements Serializable{
	private int referenceNo;
	private String name;
	private String fatherName;
	private String motherName;
	private String domicileState;
	//private MultipartFile picture;

	private String aadhaarNo;
	private LocalDate dateOfBirth;
	private String category;
	private char pwd;
	private String permanentAddress;
	private String parentsOccupation;
	private String mobileNoSms;
	private String mobileNoFather;
	private String mobileNoMother;
	private String mobileNoStudent;
	private String emailId;
	private String localAddress;
	private String localAddressGuardian;
	private String mobileNoLocalGuardian;
	private int passingOutYear10;
	private int passingOutYear11;
	private int passingOutYear12;
	private String school10;
	private String school11;
	private String school12;
	private String schoolAddress10;
	private String schoolAddress11;
	private String schoolAddress12;
	private float gradePer10;
	private float gradePer11;
	private float gradePer12;
	private float pastNeetMarks;
	private float pastNeetAir;
	private float pastNeetAsr;
	
	private float pastNeetAttempts;
	private String pastNeetRemarks;
	private String medium;
	private char demoCard;
	private String counsellor;
	private String counsellorName;
	private LocalDate date;
	public int getReferenceNo() {
		return referenceNo;
	}
	public void setReferenceNo(int referenceNo) {
		this.referenceNo = referenceNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getDomicileState() {
		return domicileState;
	}
	public void setDomicileState(String domicileState) {
		this.domicileState = domicileState;
	}
	

	
	/*public MultipartFile getPicture() {
		return picture;
	}
	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}*/
	public String getAadhaarNo() {
		return aadhaarNo;
	}
	public void setAadhaarNo(String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public char getPwd() {
		return pwd;
	}
	public void setPwd(char pwd) {
		this.pwd = pwd;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public String getParentsOccupation() {
		return parentsOccupation;
	}
	public void setParentsOccupation(String parentsOccupation) {
		this.parentsOccupation = parentsOccupation;
	}
	public String getMobileNoSms() {
		return mobileNoSms;
	}
	public void setMobileNoSms(String mobileNoSms) {
		this.mobileNoSms = mobileNoSms;
	}
	public String getMobileNoFather() {
		return mobileNoFather;
	}
	public void setMobileNoFather(String mobileNoFather) {
		this.mobileNoFather = mobileNoFather;
	}
	public String getMobileNoMother() {
		return mobileNoMother;
	}
	public void setMobileNoMother(String mobileNoMother) {
		this.mobileNoMother = mobileNoMother;
	}
	public String getMobileNoStudent() {
		return mobileNoStudent;
	}
	public void setMobileNoStudent(String mobileNoStudent) {
		this.mobileNoStudent = mobileNoStudent;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getLocalAddress() {
		return localAddress;
	}
	public void setLocalAddress(String localAddress) {
		this.localAddress = localAddress;
	}
	public String getLocalAddressGuardian() {
		return localAddressGuardian;
	}
	public void setLocalAddressGuardian(String localAddressGuardian) {
		this.localAddressGuardian = localAddressGuardian;
	}
	public String getMobileNoLocalGuardian() {
		return mobileNoLocalGuardian;
	}
	public void setMobileNoLocalGuardian(String mobileNoLocalGuardian) {
		this.mobileNoLocalGuardian = mobileNoLocalGuardian;
	}
	public int getPassingOutYear10() {
		return passingOutYear10;
	}
	public void setPassingOutYear10(int passingOutYear10) {
		this.passingOutYear10 = passingOutYear10;
	}
	public int getPassingOutYear11() {
		return passingOutYear11;
	}
	public void setPassingOutYear11(int passingOutYear11) {
		this.passingOutYear11 = passingOutYear11;
	}
	public int getPassingOutYear12() {
		return passingOutYear12;
	}
	public void setPassingOutYear12(int passingOutYear12) {
		this.passingOutYear12 = passingOutYear12;
	}
	public String getSchool10() {
		return school10;
	}
	public void setSchool10(String school10) {
		this.school10 = school10;
	}
	public String getSchool11() {
		return school11;
	}
	public void setSchool11(String school11) {
		this.school11 = school11;
	}
	public String getSchool12() {
		return school12;
	}
	public void setSchool12(String school12) {
		this.school12 = school12;
	}
	public String getSchoolAddress10() {
		return schoolAddress10;
	}
	public void setSchoolAddress10(String schoolAddress10) {
		this.schoolAddress10 = schoolAddress10;
	}
	public String getSchoolAddress11() {
		return schoolAddress11;
	}
	public void setSchoolAddress11(String schoolAddress11) {
		this.schoolAddress11 = schoolAddress11;
	}
	public String getSchoolAddress12() {
		return schoolAddress12;
	}
	public void setSchoolAddress12(String schoolAddress12) {
		this.schoolAddress12 = schoolAddress12;
	}
	public float getGradePer10() {
		return gradePer10;
	}
	public void setGradePer10(float gradePer10) {
		this.gradePer10 = gradePer10;
	}
	public float getGradePer11() {
		return gradePer11;
	}
	public void setGradePer11(float gradePer11) {
		this.gradePer11 = gradePer11;
	}
	public float getGradePer12() {
		return gradePer12;
	}
	public void setGradePer12(float gradePer12) {
		this.gradePer12 = gradePer12;
	}
	public float getPastNeetMarks() {
		return pastNeetMarks;
	}
	public void setPastNeetMarks(float pastNeetMarks) {
		this.pastNeetMarks = pastNeetMarks;
	}
	public float getPastNeetAir() {
		return pastNeetAir;
	}
	public void setPastNeetAir(float pastNeetAir) {
		this.pastNeetAir = pastNeetAir;
	}
	public float getPastNeetAsr() {
		return pastNeetAsr;
	}
	public void setPastNeetAsr(float pastNeetAsr) {
		this.pastNeetAsr = pastNeetAsr;
	}
	public float getPastNeetAttempts() {
		return pastNeetAttempts;
	}
	public void setPastNeetAttempts(float pastNeetAttempts) {
		this.pastNeetAttempts = pastNeetAttempts;
	}
	public String getPastNeetRemarks() {
		return pastNeetRemarks;
	}
	public void setPastNeetRemarks(String pastNeetRemarks) {
		this.pastNeetRemarks = pastNeetRemarks;
	}
	public String getMedium() {
		return medium;
	}
	public void setMedium(String medium) {
		this.medium = medium;
	}
	public char getDemoCard() {
		return demoCard;
	}
	public void setDemoCard(char demoCard) {
		this.demoCard = demoCard;
	}
	public String getCounsellor() {
		return counsellor;
	}
	public void setCounsellor(String counsellor) {
		this.counsellor = counsellor;
	}
	public String getCounsellorName() {
		return counsellorName;
	}
	public void setCounsellorName(String counsellorName) {
		this.counsellorName = counsellorName;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "StudentRegister [referenceNo=" + referenceNo + ", name=" + name + ", fatherName=" + fatherName
				+ ", motherName=" + motherName + ", domicileState=" + domicileState + ", aadhaarNo=" + aadhaarNo + ", dateOfBirth=" + dateOfBirth + ", category=" + category + ", pwd="
				+ pwd + ", permanentAddress=" + permanentAddress + ", parentsOccupation=" + parentsOccupation
				+ ", mobileNoSms=" + mobileNoSms + ", mobileNoFather=" + mobileNoFather + ", mobileNoMother="
				+ mobileNoMother + ", mobileNoStudent=" + mobileNoStudent + ", emailId=" + emailId + ", localAddress="
				+ localAddress + ", localAddressGuardian=" + localAddressGuardian + ", mobileNoLocalGuardian="
				+ mobileNoLocalGuardian + ", passingOutYear10=" + passingOutYear10 + ", passingOutYear11="
				+ passingOutYear11 + ", passingOutYear12=" + passingOutYear12 + ", school10=" + school10 + ", school11="
				+ school11 + ", school12=" + school12 + ", schoolAddress10=" + schoolAddress10 + ", schoolAddress11="
				+ schoolAddress11 + ", schoolAddress12=" + schoolAddress12 + ", gradePer10=" + gradePer10
				+ ", gradePer11=" + gradePer11 + ", gradePer12=" + gradePer12 + ", pastNeetMarks=" + pastNeetMarks
				+ ", pastNeetAir=" + pastNeetAir + ", pastNeetAsr=" + pastNeetAsr + ", pastNeetAttempts="
				+ pastNeetAttempts + ", pastNeetRemarks=" + pastNeetRemarks + ", medium=" + medium + ", demoCard="
				+ demoCard + ", counsellor=" + counsellor + ", counsellorName=" + counsellorName + ", date=" + date
				+ "]";
	}
	
	
	
	
	


}
