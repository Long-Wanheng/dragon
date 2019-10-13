package com.dragon.common.exception;

import com.dragon.common.enums.ExceptionEnum;
import com.dragon.common.enums.ResultCode;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-03 21:49
 * @Description: ${Description}
 */
@Data
public class DragonException extends RuntimeException{

    protected String code;

    protected String message;

    protected ResultCode resultCode;

    protected Object data;

    public DragonException() {
        ExceptionEnum exceptionEnum = ExceptionEnum.getByClazz(this.getClass());
        if (exceptionEnum != null) {
            resultCode = exceptionEnum.getResultCode();
            code = exceptionEnum.getResultCode().code().toString();
            message = exceptionEnum.getResultCode().message();
        }
    }

    public DragonException(String message) {
        this();
        this.message = message;
    }

    public DragonException(String format, Object... objects) {
        this();
        format = StringUtils.replace(format, "{}", "%s");
        this.message = String.format(format, objects);
    }

    public DragonException(String msg, Throwable cause, Object... objects) {
        this();
        String format = StringUtils.replace(msg, "{}", "%s");
        this.message= String.format(format, objects);
    }

    public DragonException(ResultCode resultCode, Object data) {
        this(resultCode);
        this.data = data;
    }

    public DragonException(ResultCode resultCode) {
        this.resultCode = resultCode;
        this.code = resultCode.code().toString();
        this.message = resultCode.message();
    }

}
