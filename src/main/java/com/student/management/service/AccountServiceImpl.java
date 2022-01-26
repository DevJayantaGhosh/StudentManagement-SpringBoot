package com.student.management.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.student.management.dto.AccountDto;
import com.student.management.entity.Account;
import com.student.management.entity.Admission;
import com.student.management.exception.ServiceException;
import com.student.management.repository.AccountRepository;
import com.student.management.repository.AdmissionRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AdmissionRepository admissionRepository;

	@Override
	@Transactional
	public Account payment(AccountDto accountDto) {
		try {
			if (admissionRepository.isRollNoPresent(accountDto.getRollNo())) {
				Account account = new Account();
				account.setAmount(accountDto.getAmount());
				Admission admission = admissionRepository.fetchById(Admission.class, accountDto.getRollNo());
				admission.setAmountPaid(admission.getAmountPaid() + accountDto.getAmount());
				Admission updatedAdmission = admissionRepository.save(admission);
				account.setAdmission(updatedAdmission);
				account.setDateTime(LocalDateTime.now());
				account.setPaymentMethod(accountDto.getPaymentMethod());
				Account updatedAccount = accountRepository.save(account);
				return updatedAccount;

			} else {
				throw new ServiceException("Invalid Roll Number");
			}
		} catch (ServiceException e) {
			throw new ServiceException("Invalid Roll Number");
		} catch (EmptyResultDataAccessException e) {
			throw new ServiceException("Student roll number is invalid ");
		}
	}

	@Override
	@Transactional
	public Account updatePayment(AccountDto accountDto) {
		try {
			if (accountRepository.isTransactionIdPresent(accountDto.getTransactionId())) {
				Account account = accountRepository.fetchById(Account.class, accountDto.getTransactionId());
				Admission admission = admissionRepository.fetchById(Admission.class, accountDto.getRollNo());
				admission.setAmountPaid(admission.getAmountPaid() - account.getAmount() + accountDto.getAmount());
				Admission updatedAdmission = admissionRepository.save(admission);
				account.setAdmission(updatedAdmission);
				account.setAmount(accountDto.getAmount());
				Account updatedAccount = accountRepository.save(account);
				return updatedAccount;

			} else {
				throw new ServiceException("Invalid Roll Number");
			}
		} catch (ServiceException e) {
			throw new ServiceException("Invalid Roll Number");
		} catch (EmptyResultDataAccessException e) {
			throw new ServiceException("Student roll number is invalid ");
		}
	}

	@Override
	@Transactional
	public void deleteAccount(int transactionId) {
		try {
			if (accountRepository.isTransactionIdPresent(transactionId)) {
				accountRepository.deleteAccount(accountRepository.fetchById(Account.class, transactionId));
			} else {
				throw new ServiceException("Invalid Transaction Id/Number");
			}
		} catch (ServiceException e) {
			throw new ServiceException("Invalid Transaction Id/Number");
		}
	}

	@Override
	public List<AccountDto> getTransactionsWithRollNo(int rollNo) {
		try {
			if (admissionRepository.isRollNoPresent(rollNo)) {
				List<Account> accounts = accountRepository.accountsWithRollNo(rollNo);
				List<AccountDto> accountDtos = new ArrayList<AccountDto>();
				for (Account account : accounts) {
					AccountDto accountDto = new AccountDto();
					accountDto.setAmount(account.getAmount());
					accountDto.setDateTime(account.getDateTime());
					accountDto.setName(account.getAdmission().getStudent().getName());
					accountDto.setRollNo(account.getAdmission().getRollNo());
					accountDto.setTransactionId(account.getTransactionId());
					accountDtos.add(accountDto);
				}

				return accountDtos;

			} else {
				throw new ServiceException("Invalid Roll Number");
			}
		} catch (ServiceException e) {
			throw new ServiceException("Invalid Roll Number");
		} catch (EmptyResultDataAccessException e) {
			throw new ServiceException("Student roll number is invalid ");
		}
	}

	@Override
	public AccountDto getTransaction(int transactionId) {
		try {
			if (accountRepository.isTransactionIdPresent(transactionId)) {
				Account account = accountRepository.fetchById(Account.class, transactionId);
				AccountDto accountDto = new AccountDto();
				accountDto.setAmount(account.getAmount());
				accountDto.setDateTime(account.getDateTime());
				accountDto.setName(account.getAdmission().getStudent().getName());
				accountDto.setRollNo(account.getAdmission().getRollNo());
				accountDto.setTransactionId(account.getTransactionId());
				return accountDto;

			} else {
				throw new ServiceException("Invalid Roll Number");
			}
		} catch (ServiceException e) {
			throw new ServiceException("Invalid Roll Number");
		} catch (EmptyResultDataAccessException e) {
			throw new ServiceException("Student roll number is invalid ");
		}
	}

	@Override
	public List<AccountDto> getTransactionsWithDates(LocalDate fromDate, LocalDate toDate) {
		try {
			List<Account> accounts = accountRepository.accountsWithDate(fromDate, toDate);
			List<AccountDto> accountDtos = new ArrayList<AccountDto>();
			for (Account account : accounts) {
				AccountDto accountDto = new AccountDto();
				accountDto.setAmount(account.getAmount());
				accountDto.setDateTime(account.getDateTime());
				accountDto.setName(account.getAdmission().getStudent().getName());
				accountDto.setRollNo(account.getAdmission().getRollNo());
				accountDto.setTransactionId(account.getTransactionId());
				accountDtos.add(accountDto);
			}
			return accountDtos;
		} catch (ServiceException e) {
			throw new ServiceException("Some error occured while fetching data");
		}
	}

}
