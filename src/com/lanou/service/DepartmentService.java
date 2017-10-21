package com.lanou.service;

import com.lanou.domain.Department;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/20.
 */
public interface DepartmentService {

    /**
     * 查询所有
     *
     * @return 结果集
     */
    List<Department> findAll();

    /**
     * 根据查询条件进行模糊查询
     *
     * @return 结果集
     */
    Department findById(int departId);

    /**
     * 根据查询条件进行模糊查询
     *
     * @param hql    查询语句
     * @param params 查询语句中包含的参数
     * @return 结果集
     */
    List<Department> find(String hql, Map<String, Object> params);

}
