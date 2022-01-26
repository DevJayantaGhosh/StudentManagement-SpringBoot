package com.student.management.dto;

import java.util.List;

public class AccountListStatus extends Status{
	private List<AccountDto> accountDtos;

	public List<AccountDto> getAccountDtos() {
		return accountDtos;
	}

	public void setAccountDtos(List<AccountDto> accountDtos) {
		this.accountDtos = accountDtos;
	}
	
	

}
