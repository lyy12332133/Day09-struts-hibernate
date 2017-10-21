package com.lanou.dao;

import com.lanou.domain.Staff;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/20.
 */
public interface StaffDao extends BaseDao<Staff> {
    /**
     * 模糊查询员工表
     *
     * @param params 查询语句的参数列表
     * @return 返回员工集合
     */
    List<Staff> find(Map<String, Object> params);
}
