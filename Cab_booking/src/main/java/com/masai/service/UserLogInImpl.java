package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import com.masai.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masai.entity.CurrentUserSession;
import com.masai.entity.Customer;

import com.masai.exception.AdminExceptions;
import com.masai.exception.InvalidPasswordException;
import com.masai.exception.NotFoundException;
import com.masai.exception.UserAlreadyExistWithuserId;
import com.masai.repository.AdminDao;
import com.masai.repository.CustomerDao;
import com.masai.repository.DriverDao;
import com.masai.repository.SessionDao;

import net.bytebuddy.utility.RandomString;

@Service
public class UserLogInImpl implements UserLogIn {
	@Autowired
	private AdminDao adminDao;

	@Autowired
	private DriverDao driverDao;

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private SessionDao sessionDao;

	@Override
	public String logIntoAccount(CustomerDTO userDto) {
		Optional<Customer> optCustomer = customerDao.findById(userDto.getUserId());
//		Optional<Driver> opt_driver = driverDao.findById(userDto.getUserId());
//		Optional<Admin> opt_admin = adminDao.findById(userDto.getUserId());

		String userId = optCustomer.get().getUserId();

		Optional<CurrentUserSession> currentUserOptional = sessionDao.findById(userId);

		if (!optCustomer.isPresent()) {
			throw new AdminExceptions("user not found");
		}
		if (currentUserOptional.isPresent()) {
			throw new UserAlreadyExistWithuserId("User already logged in with this number");
		}
		if (optCustomer.get().getPassword().equals(userDto.getPassword())) {
			String key = RandomString.make(6);
			CurrentUserSession currentUserSession = new CurrentUserSession(optCustomer.get().getUserId(), key,
					LocalDateTime.now());
			sessionDao.save(currentUserSession);

			return currentUserSession.toString();
		} else {
			throw new InvalidPasswordException("Please Enter Valid Password");
		}

	}

	@Override
	public String logOutFromAccount(String key) {
		Optional<CurrentUserSession> currentUserOptional = sessionDao.findByUuid(key);

		if (!currentUserOptional.isPresent()) {
			throw new NotFoundException("User is not logged in with this number");
		}

		CurrentUserSession currentUserSession = currentUserOptional.get();
		sessionDao.delete(currentUserSession);

		return "Logged Out...";
	}

}
