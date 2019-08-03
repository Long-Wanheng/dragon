package com.dragon.common.exception;

/**
 * @desc 用户未登录异常
 * 
 * @author 龙万恒
 * @date 2019-08-03
 */
public class UserNotLoginException extends DragonException {

	private static final long serialVersionUID = -1879503946782379204L;

	public UserNotLoginException() {
		super();
	}

	public UserNotLoginException(String msg) {
		super(msg);
	}

	public UserNotLoginException(String formatMsg, Object... objects) {
		super(formatMsg, objects);
	}

}
