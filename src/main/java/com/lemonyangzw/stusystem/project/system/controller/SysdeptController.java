package com.lemonyangzw.stusystem.project.system.controller;

import com.lemonyangzw.stusystem.framework.web.domain.AjaxResult;
import com.lemonyangzw.stusystem.project.system.domain.SysDept;
import com.lemonyangzw.stusystem.project.system.service.SysDeptService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Yang
 * @date 2020/11/11 9:28
 */
@Api("部门信息")
@RestController
@RequestMapping("/system/dept")
public class SysdeptController {
    @Autowired
    private SysDeptService sysDeptService;
    /**
     * @param dept
     * @return 获取部门下拉树列表
     */
    @GetMapping("/treeselect")
    public AjaxResult treeselect(SysDept dept) {
        List<SysDept> depts = sysDeptService.selectDeptList(dept);
        return AjaxResult.success(sysDeptService.buildDeptTreeSelect(depts));
    }
}
