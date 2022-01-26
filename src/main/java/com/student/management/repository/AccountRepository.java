package com.student.management.repository;

import java.time.LocalDate;
import java.util.List;

import com.student.management.entity.Account;

public interface AccountRepository extends GenericRepository{

	boolean isTransactionIdPresent(int transactionId);

	List<Account> accountsWithRollNo(int rollNo);

	List<Account> accountsWithDate(LocalDate fromDate, LocalDate toDate);

	void deleteAccount(Account account);

}