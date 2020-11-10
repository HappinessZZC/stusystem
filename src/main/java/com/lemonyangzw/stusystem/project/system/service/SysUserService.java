package com.lemonyangzw.stusystem.project.system.service;

import com.lemonyangzw.stusystem.project.system.domain.SysUser;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import java.util.List;

/**
 * @author Yang
 * @date 2020/9/10 14:20
 */

public interface SysUserService {
    SysUser selectUserByUserName(String username);

    List<SysUser> getUserAll();
}
