package com.lemonyangzw.stusystem.project.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lemonyangzw.stusystem.project.system.domain.SysDept;

import java.util.List;

public interface SysDeptMapper extends BaseMapper<SysDept> {
    /**
     * 查询部门管理数据
     *
     * @param dept 部门信息
     * @return 部门信息集合
     */
    List<SysDept> selectDeptList(SysDept dept);
}