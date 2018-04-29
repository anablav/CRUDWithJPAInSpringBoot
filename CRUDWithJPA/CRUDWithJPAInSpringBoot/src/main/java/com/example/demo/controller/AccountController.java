package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.Account;
import com.example.demo.services.AccountService;

@Controller
@RequestMapping("account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(ModelMap modelMap)
	{
		modelMap.put("accounts", accountService.findAll());
		return "account/index";
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String add(ModelMap modelMap)
	{
		modelMap.put("account", new Account());
		return "account/add";
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(@ModelAttribute("account") Account account, 
			ModelMap modelMap)
	{
		accountService.save(account);
		return "redirect:/account";
	}
	
	@RequestMapping(value="delete/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable("id") int id) 
	{
		accountService.delete(accountService.find(id));
		return "redirect:/account";
	}
	
	@RequestMapping(value="edit/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable("id") int id, ModelMap modelMap)
	{
		modelMap.put("account", accountService.find(id));
		return "account/edit";
	}
	
	@RequestMapping(value="edit", method=RequestMethod.POST)
	public String edit(@ModelAttribute("account") Account account, 
			ModelMap modelMap)
	{
		accountService.save(account);
		return "redirect:/account";
	}

}
