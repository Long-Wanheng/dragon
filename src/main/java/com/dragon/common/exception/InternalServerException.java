package com.dragon.common.exception;

/**
 * @desc 内部服务异常
 * 
 * @author 龙万恒
 * @date 2019-08-03
 */
public class InternalServerException extends DragonException {

	private static final long serialVersionUID = 2659909836556958676L;

	public InternalServerException() {
		super();
	}

	public InternalServerException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public InternalServerException(String msg, Throwable cause, Object... objects) {
		super(msg, cause, objects);
	}

	public InternalServerException(String msg) {
		super(msg);
	}

	public InternalServerException(String formatMsg, Object... objects) {
		super(formatMsg, objects);
	}

}
