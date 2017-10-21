package com.lanou.service;

import com.lanou.domain.Staff;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/20.
 */
public interface StaffService {

    /**
     * 查询所有
     * @return 结果集
     */
    List<Staff> findAll();

    /**
     * 根据查询条件进行模糊查询

     * @param params 查询语句中包含的参数
     * @return 结果集
     */
    List<Staff> find(Map<String, Object> params);

    /**
     *
     * @param hql 查询语句
     * @param params 查询语句中包含的参数
     * @return 一个员工
     */
    Staff findSingle(String hql, Map<String, Object> params);

    void save(Staff staff);
}
