package com.lemonyangzw.stusystem.common.exception;

/**
 * @author Yang
 * @date 2020/9/29 15:50
 */
public class UserException extends BaseException {
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args) {
        super("user", code, args, null);
    }
}