package com.lemonyangzw.stusystem.common.exception;

/**
 * @author Yang
 * @date 2020/9/29 15:50
 */
public class UserPasswordNotMatchException extends UserException
{
    private static final long serialVersionUID = 1L;

    public UserPasswordNotMatchException()
    {
        super("用户名/密码", null);
    }
}
