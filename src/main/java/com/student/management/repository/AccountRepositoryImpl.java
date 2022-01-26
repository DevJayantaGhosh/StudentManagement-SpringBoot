package com.student.management.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.student.management.entity.Account;

@Repository
public class AccountRepositoryImpl extends GenericRepositoryImpl implements AccountRepository {
	
	@Override
	public boolean isTransactionIdPresent(int transactionId) {
		return (Long)
				entityManager
				.createQuery("select count(a.transactionId) from Account a where a.transactionId = :transactionId")
				.setParameter("transactionId", transactionId)
				.getSingleResult() == 1 ?true : false;
	}
	
	@Override
	public List<Account> accountsWithRollNo(int rollNo){
		return (List<Account>)
				entityManager
				.createQuery("select a from Account a where a.admission.rollNo = :rollNo", Account.class)
				.setParameter("rollNo", rollNo)
				.getResultList();
	}
	
	@Override
	public List<Account> accountsWithDate(LocalDate fromDate,LocalDate toDate){
		return (List<Account>)
				entityManager
				.createQuery("select a from Account a where a.dateTime between to_date(:fromDate) and to_date(:toDate)",Account.class)
                .setParameter("fromDate", fromDate)
                .setParameter("toDate", toDate)
				.getResultList();
	}
	
	
	@Override
	public void deleteAccount(Account account) {
		entityManager.remove(account);
	}

}
