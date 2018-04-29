package com.example.demo.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AccountDAO;
import com.example.demo.entities.Account;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountDAO accountDAO;
	
	@Override
	public Iterable<Account> findAll() {
		return accountDAO.findAll();
	}

	@Override
	public Account find(int id) {
		return accountDAO.findById(id).get();
	}

	@Override
	public void save(Account account) {
		System.out.println("account name :: " + account.getUsername() + "account ID :: " + account.getId());
		accountDAO.save(account);
	}

	@Override
	public void delete(Account account) {
		accountDAO.delete(account);
	}

}
