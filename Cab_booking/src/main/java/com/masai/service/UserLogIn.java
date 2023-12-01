package com.masai.service;

import com.masai.dto.CustomerDTO;

public interface UserLogIn {
	
	public String logIntoAccount(CustomerDTO userDto);
	
	public String logOutFromAccount(String key);
}
