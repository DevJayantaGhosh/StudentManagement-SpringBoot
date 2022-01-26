package com.student.management.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "table_accounts")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tranSeq")
	@SequenceGenerator(name = "tranSeq", sequenceName = "TRANSACTION_ID_SEQ", allocationSize = 1)
	@Column(name = "transaction_Id")
	private int transactionId;
	
	@Column(name = "amount")
	private int amount;
	
	@Column(name = "payment_method")
	private String paymentMethod;
	
	@Column(name = "date_time")
	private LocalDateTime dateTime;
	
	@Column(name = "remarks")
	private String remarks;
	
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="roll_no")
	private Admission admission;

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Admission getAdmission() {
		return admission;
	}

	public void setAdmission(Admission admission) {
		this.admission = admission;
	}

	@Override
	public String toString() {
		return "Account [transactionId=" + transactionId + ", amount=" + amount + ", dateTime=" + dateTime
				+ ", admission=" + admission + "]";
	}
	


	
	

}
