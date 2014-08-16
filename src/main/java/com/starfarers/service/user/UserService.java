package com.starfarers.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.starfarers.dao.UserDao;
import com.starfarers.domain.user.User;

@Service
public class UserService implements UserDetailsService {

	private static final String DEFAULT_PASSWORD = "password";

	@Autowired
	private transient UserDao userDao;

	@Autowired
	private transient SecurityService securityService;

	public User create() {
		return new User(getDefaultPassword());
	}

	public User create(User user) {
		user.setPassword(getDefaultPassword());
		return save(user);
	}

	private String getDefaultPassword() {
		return securityService.encode(DEFAULT_PASSWORD);
	}

	public boolean hasDefaultPassword(User user) {
		return securityService.matches(user.getPassword(), DEFAULT_PASSWORD);
	}

	public User find(Integer id) {
		return userDao.find(id);
	}

	public User find(String username) {
		return userDao.find(username);
	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	public User save(User user) {
		return userDao.save(user);
	}

	public void remove(String username) {
		User user = userDao.find(username);
		userDao.remove(user);
	}

	public User resetPassword(String username) {
		User user = userDao.find(username);
		user.setPassword(getDefaultPassword());
		return userDao.save(user);
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = find(username);
		if (user == null) {
			throw new UsernameNotFoundException("Username not found.");
		}
		return user;
	}

}