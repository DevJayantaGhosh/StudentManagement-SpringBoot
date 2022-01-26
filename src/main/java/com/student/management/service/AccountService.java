package com.student.management.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import com.student.management.dto.AccountDto;
import com.student.management.entity.Account;

public interface AccountService {

	Account payment(AccountDto accountDto);

	Account updatePayment(AccountDto accountDto);

	void deleteAccount(int transactionId);

	List<AccountDto> getTransactionsWithRollNo(int rollNo);

	AccountDto getTransaction(int transactionId);

	List<AccountDto> getTransactionsWithDates(LocalDate fromDate, LocalDate toDate);

}