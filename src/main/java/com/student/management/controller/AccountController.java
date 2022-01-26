package com.student.management.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.dto.AccountDto;
import com.student.management.dto.AccountDtoStatus;
import com.student.management.dto.AccountListStatus;
import com.student.management.dto.Status;
import com.student.management.dto.Status.StatusCode;
import com.student.management.entity.Account;
import com.student.management.exception.ServiceException;
import com.student.management.service.AccountService;

@RestController
@CrossOrigin
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping(path="/add-transaction")
	public AccountDtoStatus addTransaction(@RequestBody AccountDto accounttDto) {
		try {
			Account account = accountService.payment(accounttDto);
			AccountDto accountDto = new AccountDto();
			accountDto.setAmount(account.getAmount());
			accountDto.setDateTime(account.getDateTime());
			accountDto.setName(account.getAdmission().getStudent().getName());
			accountDto.setRollNo(account.getAdmission().getRollNo());
			accountDto.setTransactionId(account.getTransactionId());
			accountDto.setAcademicYear(account.getAdmission().getAcademicYear());
			accountDto.setFatherName(account.getAdmission().getStudent().getFatherName());
			accountDto.setAddress(account.getAdmission().getStudent().getPermanentAddress());
			accountDto.setBatch(account.getAdmission().getBatch());
			accountDto.setClasss(account.getAdmission().getClasss());
			accountDto.setRemarks(account.getRemarks());
			AccountDtoStatus accountDtoStatus = new AccountDtoStatus();
			accountDtoStatus.setAccountDto(accountDto);
			accountDtoStatus.setStatusCode(StatusCode.SUCCESS);
			accountDtoStatus.setStatusMessage("Payment Saved Successfully");	
			return accountDtoStatus;
		} catch (ServiceException e) {
			AccountDtoStatus accountDtoStatus = new AccountDtoStatus();
			accountDtoStatus.setStatusCode(StatusCode.FAILURE);
			accountDtoStatus.setStatusMessage(e.getMessage());
			return accountDtoStatus;
		}catch (Exception e) {
			AccountDtoStatus accountDtoStatus = new AccountDtoStatus();
			accountDtoStatus.setStatusCode(StatusCode.FAILURE);
			accountDtoStatus.setStatusMessage("Save failed for some reason");
			return accountDtoStatus;
		}
	}
	
	@PostMapping(path="/update-transaction")
	public AccountDtoStatus updateTransaction(@RequestBody AccountDto accounttDto) {
		try {
			Account account = accountService.updatePayment(accounttDto);
			AccountDto accountDto = new AccountDto();
			accountDto.setAmount(account.getAmount());
			accountDto.setDateTime(account.getDateTime());
			accountDto.setName(account.getAdmission().getStudent().getName());
			accountDto.setRollNo(account.getAdmission().getRollNo());
			accountDto.setTransactionId(account.getTransactionId());
			AccountDtoStatus accountDtoStatus = new AccountDtoStatus();
			accountDtoStatus.setAccountDto(accountDto);
			accountDtoStatus.setStatusCode(StatusCode.SUCCESS);
			accountDtoStatus.setStatusMessage("Payment Saved Successfully");	
			return accountDtoStatus;
		} catch (ServiceException e) {
			AccountDtoStatus accountDtoStatus = new AccountDtoStatus();
			accountDtoStatus.setStatusCode(StatusCode.FAILURE);
			accountDtoStatus.setStatusMessage(e.getMessage());
			return accountDtoStatus;
		}catch (Exception e) {
			AccountDtoStatus accountDtoStatus = new AccountDtoStatus();
			accountDtoStatus.setStatusCode(StatusCode.FAILURE);
			accountDtoStatus.setStatusMessage("Save failed for some reason");
			return accountDtoStatus;
		}
	}
	
	@GetMapping(path = "/delete-transaction")
	public Status deleteTransaction(@RequestParam("transactionId") int transactionId) {
		try {
			Status status = new Status();
			accountService.deleteAccount(transactionId);
			status.setStatusCode(StatusCode.SUCCESS);
			status.setStatusMessage("Deletion Successful");
			return status;
		} catch(ServiceException e) {
			Status status = new Status();
			status.setStatusCode(StatusCode.FAILURE);
			status.setStatusMessage(e.getMessage());
			return status;
		}
	}
	
	@GetMapping(path = "/get-transactions-with-rollNo")
	public AccountListStatus transactionsWithRollNo(@RequestParam("rollNo") int rollNo) {
		try {
			List<AccountDto> accountDtos= accountService.getTransactionsWithRollNo(rollNo);
			AccountListStatus accountlistStatus = new AccountListStatus();
			accountlistStatus.setAccountDtos(accountDtos);
			accountlistStatus.setStatusCode(StatusCode.SUCCESS);
			accountlistStatus.setStatusMessage("List Fetched Successfully");	
			return accountlistStatus;
		} catch (ServiceException e) {
			AccountListStatus accountlistStatus = new AccountListStatus();
			accountlistStatus.setStatusCode(StatusCode.FAILURE);
			accountlistStatus.setStatusMessage(e.getMessage());	
			return accountlistStatus;
		}catch (Exception e) {
			AccountListStatus accountlistStatus = new AccountListStatus();
			accountlistStatus.setStatusCode(StatusCode.FAILURE);
			accountlistStatus.setStatusMessage("list fetching failed for some reason");
			return accountlistStatus;
		}
	}
	
	@GetMapping(path = "/get-transactions-with-dates")
	public AccountListStatus transactionsWithRollNo(@RequestParam("fromDate") LocalDate fromDate,@RequestParam("toDate") LocalDate toDate) {
		try {
			List<AccountDto> accountDtos= accountService.getTransactionsWithDates(fromDate, toDate);
			AccountListStatus accountlistStatus = new AccountListStatus();
			accountlistStatus.setAccountDtos(accountDtos);
			accountlistStatus.setStatusCode(StatusCode.SUCCESS);
			accountlistStatus.setStatusMessage("List Fetched Successfully");	
			return accountlistStatus;
		} catch (ServiceException e) {
			AccountListStatus accountlistStatus = new AccountListStatus();
			accountlistStatus.setStatusCode(StatusCode.FAILURE);
			accountlistStatus.setStatusMessage(e.getMessage());	
			return accountlistStatus;
		}catch (Exception e) {
			AccountListStatus accountlistStatus = new AccountListStatus();
			accountlistStatus.setStatusCode(StatusCode.FAILURE);
			accountlistStatus.setStatusMessage("list fetching failed for some reason");
			return accountlistStatus;
		}
	}
	
	@GetMapping(path = "/get-transaction")
	public AccountDtoStatus getTransaction(@RequestParam("transactionId") int transactionId) {
		try {
			AccountDto accountDto= accountService.getTransaction(transactionId);
			AccountDtoStatus accountDtoStatus = new AccountDtoStatus();
			accountDtoStatus.setAccountDto(accountDto);
			accountDtoStatus.setStatusCode(StatusCode.SUCCESS);
			accountDtoStatus.setStatusMessage("Transaction Fetched Successfully");	
			return accountDtoStatus;
		} catch (ServiceException e) {
			AccountDtoStatus accountDtoStatus = new AccountDtoStatus();
			accountDtoStatus.setStatusCode(StatusCode.FAILURE);
			accountDtoStatus.setStatusMessage(e.getMessage());
			return accountDtoStatus;
		}catch (Exception e) {
			AccountDtoStatus accountDtoStatus = new AccountDtoStatus();
			accountDtoStatus.setStatusCode(StatusCode.FAILURE);
			accountDtoStatus.setStatusMessage(e.getMessage());
			return accountDtoStatus;
		}
	}
	
	
	

}
