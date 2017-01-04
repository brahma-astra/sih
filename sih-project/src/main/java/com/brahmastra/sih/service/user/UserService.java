package com.brahmastra.sih.service.user;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import com.brahmastra.sih.core.service.CoreService;
import com.brahmastra.sih.persistence.user.domain.User;

public interface UserService extends CoreService<User> {
	User update(User detachedInstance, Boolean isUpdatePassword)
			throws NoSuchAlgorithmException, UnsupportedEncodingException;

	User updateWithoutPassword(User user);

	User updatePassword(User user) throws NoSuchAlgorithmException,
			UnsupportedEncodingException;

	User login(String username, String password)
			throws NoSuchAlgorithmException, UnsupportedEncodingException;

	void doLogout();
}
