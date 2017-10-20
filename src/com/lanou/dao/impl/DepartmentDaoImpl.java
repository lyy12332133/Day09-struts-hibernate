package com.lanou.dao.impl;


import com.lanou.dao.DepartmentDao;
import com.lanou.domain.Department;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by dllo on 17/10/20.
 */
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao {
    /**
     * 通过部门id查找部门
     * @param departId 部门id
     * @return 返回包含职务的部门
     */
    @Override
    public Department findById(int departId) {
        // 查询语句
        String hql = "from Department where id=:id";
        Map<String, Object> param = new HashMap<>(); //查询语句中的参数
        param.put("id", departId);
        return findSingle(hql, param); // 单向查询
    }
}
