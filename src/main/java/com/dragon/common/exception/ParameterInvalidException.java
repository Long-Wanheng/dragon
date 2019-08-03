package com.dragon.common.exception;

import com.dragon.common.enums.ResultCode;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-03 21:52
 */
public class ParameterInvalidException extends DragonException {

        private static final long serialVersionUID = 3721036867889297081L;

        public ParameterInvalidException() {
            super();
        }

        public ParameterInvalidException(Object data) {
            super();
            super.data = data;
        }

        public ParameterInvalidException(ResultCode resultCode) {
            super(resultCode);
        }

        public ParameterInvalidException(ResultCode resultCode, Object data) {
            super(resultCode, data);
        }

        public ParameterInvalidException(String msg) {
            super(msg);
        }

        public ParameterInvalidException(String formatMsg, Object... objects) {
            super(formatMsg, objects);
        }

}
