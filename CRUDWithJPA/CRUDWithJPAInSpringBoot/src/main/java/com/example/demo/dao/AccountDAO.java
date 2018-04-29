package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Account;

public interface AccountDAO extends CrudRepository<Account, Integer>{

}
