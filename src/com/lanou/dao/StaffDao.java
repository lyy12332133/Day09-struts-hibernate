package com.lanou.dao;

import com.lanou.domain.Staff;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/20.
 */
public interface StaffDao extends BaseDao<Staff>{
    List<Staff> find(Map<String, Object> params);
}
