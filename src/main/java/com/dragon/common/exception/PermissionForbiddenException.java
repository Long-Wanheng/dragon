package com.dragon.common.exception;


import com.dragon.common.enums.ResultCode;

/**
 * @desc 权限不足异常
 * 
 * @author 龙万恒
 * @date 2019-08-03
 */
public class PermissionForbiddenException extends DragonException {

	private static final long serialVersionUID = 3721036867889297081L;

	public PermissionForbiddenException() {
		super();
	}

	public PermissionForbiddenException(Object data) {
		super.data = data;
	}

	public PermissionForbiddenException(ResultCode resultCode) {
		super(resultCode);
	}

	public PermissionForbiddenException(ResultCode resultCode, Object data) {
		super(resultCode, data);
	}

	public PermissionForbiddenException(String msg) {
		super(msg);
	}

	public PermissionForbiddenException(String formatMsg, Object... objects) {
		super(formatMsg, objects);
	}

}
