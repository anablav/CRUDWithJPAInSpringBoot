package com.example.demo.services;

import com.example.demo.entities.Account;

public interface AccountService {
	
	public Iterable<Account> findAll();
	
	public Account find(int id);
	
	public void save(Account account);
	
	public void delete(Account account);

}
