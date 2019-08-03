package com.dragon.common.exception;


import com.dragon.common.enums.ResultCode;

/**
 * @desc 数据已经存在异常
 * 
 * @author 龙万恒
 * @date 2019
 */
public class DataConflictException extends DragonException {

	private static final long serialVersionUID = 3721036867889297081L;

	public DataConflictException() {
		super();
	}

	public DataConflictException(Object data) {
		super.data = data;
	}

	public DataConflictException(ResultCode resultCode) {
		super(resultCode);
	}

	public DataConflictException(ResultCode resultCode, Object data) {
		super(resultCode, data);
	}

	public DataConflictException(String msg) {
		super(msg);
	}

	public DataConflictException(String formatMsg, Object... objects) {
		super(formatMsg, objects);
	}


}
