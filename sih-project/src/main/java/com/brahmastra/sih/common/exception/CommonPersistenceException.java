package com.brahmastra.sih.common.exception;

import org.hibernate.HibernateException;

/**
 * @author viper
 */
public class CommonPersistenceException extends HibernateException {

	private static final long serialVersionUID = -7311418088412161513L;

	/**
	 * Constructor
	 * 
	 * @author viper
	 * @param e
	 */
	public CommonPersistenceException(Throwable e) {
		super(e);
	}

	/**
	 * Constructor
	 * 
	 * @author viper
	 * @param msg
	 * @param e
	 */
	public CommonPersistenceException(String msg, Throwable e) {
		super(msg, e);
	}

	/**
	 * Constructor
	 * 
	 * @author viper
	 * @param s
	 */
	public CommonPersistenceException(String s) {
		super(s);
	}

}
