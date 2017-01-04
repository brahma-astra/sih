package com.brahmastra.sih.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.xerces.impl.dv.util.Base64;

import com.brahmastra.sih.common.exception.message.ExceptionMessage;

public final class PasswordUtil {
	private static PasswordUtil instance;

	private PasswordUtil() {
	}

	public synchronized String encrypt(String plaintext)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA"); // step 2
		} catch (NoSuchAlgorithmException e) {
			// throw new SystemUnavailableException(e.getMessage());
			throw new NoSuchAlgorithmException(
					ExceptionMessage.MSG_SHA_NOT_SUPPORTED);
		}
		try {
			md.update(plaintext.getBytes("UTF-8")); // step 3
		} catch (UnsupportedEncodingException e) {
			// throw new SystemUnavailableException(e.getMessage());
			throw new UnsupportedEncodingException(
					ExceptionMessage.MSG_UTF8_NOT_SUPPORTED);
		}

		byte raw[] = md.digest(); // step 4
		// String hash = (new BASE64Encoder()).encode(raw); //step 5
		String hash = Base64.encode(raw); // step 5
		return hash; // step 6
	}

	public static synchronized PasswordUtil getInstance() // step 1
	{
		if (instance == null) {
			instance = new PasswordUtil();
		}
		return instance;
	}
}
