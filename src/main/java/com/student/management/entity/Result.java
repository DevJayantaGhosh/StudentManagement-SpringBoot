package com.student.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "table_results")
public class Result {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "serialSeq")
	@SequenceGenerator(name = "serialSeq", sequenceName = "SERIAL_NO_SEQ", allocationSize = 1)
	@Column(name="serial_no")
	private long serialNo;
	@Column(name="roll_no")
	private int rollNo;
	@Column(name="test_code")
	private String testCode;
	@Column(name="answers")
	private String answers;
	@Column(name="answers_edited")
	private String answersEdited;
	@Column(name="answer_confidence")
	private String answerConfidence;
	@Column(name="sheet_confidence")
	private String sheetConfidence;
	@Column(name="rectangle_count_1")
	private String rectangleCount1;
	@Column(name="resolution_issue")
	private char resolutionIssue;
	@Column(name="rectangle_fault")
	private char rectangleFault;
	@Column(name="flipped_image")
	private char flippedImage;
	@Column(name="side_1_bw")
	private String side1BW;
	@Column(name="medium")
	private String medium;
	@Column(name="score")
	private int score;
	@Column(name="right")
	private int right;
	@Column(name="wrong")
	private int wrong;
	@Column(name="blank")
	private int blank;
	@Column(name="rank")
	private int rank;
	@Column(name="physics")
	private int physics;
	@Column(name="physics_correct")
	private int physicsCorrect;
	@Column(name="physics_incorrect")
	private int physicsIncorrect;
	@Column(name="physics_blank")
	private int physicsBlank;
	@Column(name="physics_per")
	private float physicsPer;
	@Column(name="chemistry")
	private int chemistry;
	@Column(name="chemistry_correct")
	private int chemistryCorrect;
	@Column(name="chemistry_incorrect")
	private int chemistryIncorrect;
	@Column(name="chemistry_blank")
	private int chemistryBlank;
	@Column(name="chemistry_per")
	private float chemistryPer;
	@Column(name="botany")
	private int botany;
	@Column(name="botany_correct")
	private int botanyCorrect;
	@Column(name="botany_incorrect")
	private int botanyIncorrect;
	@Column(name="botany_blank")
	private int botanyBlank;
	@Column(name="botany_per")
	private float botanyPer;
	@Column(name="zoology")
	private int zoology;
	@Column(name="zoology_correct")
	private int zoologyCorrect;
	@Column(name="zoology_incorrect")
	private int zoologyIncorrect;
	@Column(name="zoology_blank")
	private int zoologyBlank;
	@Column(name="zoology_per")
	private float zoologyPer;
	public long getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(long serialNo) {
		this.serialNo = serialNo;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getTestCode() {
		return testCode;
	}
	public void setTestCode(String testCode) {
		this.testCode = testCode;
	}
	public String getAnswers() {
		return answers;
	}
	public void setAnswers(String answers) {
		this.answers = answers;
	}
	public String getAnswersEdited() {
		return answersEdited;
	}
	public void setAnswersEdited(String answersEdited) {
		this.answersEdited = answersEdited;
	}
	public String getAnswerConfidence() {
		return answerConfidence;
	}
	public void setAnswerConfidence(String answerConfidence) {
		this.answerConfidence = answerConfidence;
	}
	public String getSheetConfidence() {
		return sheetConfidence;
	}
	public void setSheetConfidence(String sheetConfidence) {
		this.sheetConfidence = sheetConfidence;
	}
	public String getRectangleCount1() {
		return rectangleCount1;
	}
	public void setRectangleCount1(String rectangleCount1) {
		this.rectangleCount1 = rectangleCount1;
	}
	public char getResolutionIssue() {
		return resolutionIssue;
	}
	public void setResolutionIssue(char resolutionIssue) {
		this.resolutionIssue = resolutionIssue;
	}
	public char getRectangleFault() {
		return rectangleFault;
	}
	public void setRectangleFault(char rectangleFault) {
		this.rectangleFault = rectangleFault;
	}
	public char getFlippedImage() {
		return flippedImage;
	}
	public void setFlippedImage(char flippedImage) {
		this.flippedImage = flippedImage;
	}
	public String getSide1BW() {
		return side1BW;
	}
	public void setSide1BW(String side1bw) {
		side1BW = side1bw;
	}
	public String getMedium() {
		return medium;
	}
	public void setMedium(String medium) {
		this.medium = medium;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getRight() {
		return right;
	}
	public void setRight(int right) {
		this.right = right;
	}
	public int getWrong() {
		return wrong;
	}
	public void setWrong(int wrong) {
		this.wrong = wrong;
	}
	public int getBlank() {
		return blank;
	}
	public void setBlank(int blank) {
		this.blank = blank;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getPhysics() {
		return physics;
	}
	public void setPhysics(int physics) {
		this.physics = physics;
	}
	public int getPhysicsCorrect() {
		return physicsCorrect;
	}
	public void setPhysicsCorrect(int physicsCorrect) {
		this.physicsCorrect = physicsCorrect;
	}
	public int getPhysicsIncorrect() {
		return physicsIncorrect;
	}
	public void setPhysicsIncorrect(int physicsIncorrect) {
		this.physicsIncorrect = physicsIncorrect;
	}
	public int getPhysicsBlank() {
		return physicsBlank;
	}
	public void setPhysicsBlank(int physicsBlank) {
		this.physicsBlank = physicsBlank;
	}
	public float getPhysicsPer() {
		return physicsPer;
	}
	public void setPhysicsPer(float physicsPer) {
		this.physicsPer = physicsPer;
	}
	public int getChemistry() {
		return chemistry;
	}
	public void setChemistry(int chemistry) {
		this.chemistry = chemistry;
	}
	public int getChemistryCorrect() {
		return chemistryCorrect;
	}
	public void setChemistryCorrect(int chemistryCorrect) {
		this.chemistryCorrect = chemistryCorrect;
	}
	public int getChemistryIncorrect() {
		return chemistryIncorrect;
	}
	public void setChemistryIncorrect(int chemistryIncorrect) {
		this.chemistryIncorrect = chemistryIncorrect;
	}
	public int getChemistryBlank() {
		return chemistryBlank;
	}
	public void setChemistryBlank(int chemistryBlank) {
		this.chemistryBlank = chemistryBlank;
	}
	public float getChemistryPer() {
		return chemistryPer;
	}
	public void setChemistryPer(float chemistryPer) {
		this.chemistryPer = chemistryPer;
	}
	public int getBotany() {
		return botany;
	}
	public void setBotany(int botany) {
		this.botany = botany;
	}
	public int getBotanyCorrect() {
		return botanyCorrect;
	}
	public void setBotanyCorrect(int botanyCorrect) {
		this.botanyCorrect = botanyCorrect;
	}
	public int getBotanyIncorrect() {
		return botanyIncorrect;
	}
	public void setBotanyIncorrect(int botanyIncorrect) {
		this.botanyIncorrect = botanyIncorrect;
	}
	public int getBotanyBlank() {
		return botanyBlank;
	}
	public void setBotanyBlank(int botanyBlank) {
		this.botanyBlank = botanyBlank;
	}
	public float getBotanyPer() {
		return botanyPer;
	}
	public void setBotanyPer(float botanyPer) {
		this.botanyPer = botanyPer;
	}
	public int getZoology() {
		return zoology;
	}
	public void setZoology(int zoology) {
		this.zoology = zoology;
	}
	public int getZoologyCorrect() {
		return zoologyCorrect;
	}
	public void setZoologyCorrect(int zoologyCorrect) {
		this.zoologyCorrect = zoologyCorrect;
	}
	public int getZoologyIncorrect() {
		return zoologyIncorrect;
	}
	public void setZoologyIncorrect(int zoologyIncorrect) {
		this.zoologyIncorrect = zoologyIncorrect;
	}
	public int getZoologyBlank() {
		return zoologyBlank;
	}
	public void setZoologyBlank(int zoologyBlank) {
		this.zoologyBlank = zoologyBlank;
	}
	public float getZoologyPer() {
		return zoologyPer;
	}
	public void setZoologyPer(float zoologyPer) {
		this.zoologyPer = zoologyPer;
	}
	@Override
	public String toString() {
		return "Result [serialNo=" + serialNo + ", rollNo=" + rollNo + ", testCode=" + testCode + ", answers=" + answers
				+ ", answersEdited=" + answersEdited + ", answerConfidence=" + answerConfidence + ", sheetConfidence="
				+ sheetConfidence + ", rectangleCount1=" + rectangleCount1 + ", resolutionIssue=" + resolutionIssue
				+ ", rectangleFault=" + rectangleFault + ", flippedImage=" + flippedImage + ", side1BW=" + side1BW
				+ ", medium=" + medium + ", score=" + score + ", right=" + right + ", wrong=" + wrong + ", blank="
				+ blank + ", rank=" + rank + ", physics=" + physics + ", physicsCorrect=" + physicsCorrect
				+ ", physicsIncorrect=" + physicsIncorrect + ", physicsBlank=" + physicsBlank + ", physicsPer="
				+ physicsPer + ", chemistry=" + chemistry + ", chemistryCorrect=" + chemistryCorrect
				+ ", chemistryIncorrect=" + chemistryIncorrect + ", chemistryBlank=" + chemistryBlank
				+ ", chemistryPer=" + chemistryPer + ", botany=" + botany + ", botanyCorrect=" + botanyCorrect
				+ ", botanyIncorrect=" + botanyIncorrect + ", botanyBlank=" + botanyBlank + ", botanyPer=" + botanyPer
				+ ", zoology=" + zoology + ", zoologyCorrect=" + zoologyCorrect + ", zoologyIncorrect="
				+ zoologyIncorrect + ", zoologyBlank=" + zoologyBlank + ", zoologyPer=" + zoologyPer + "]";
	}
	
	
	

}
