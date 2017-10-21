package com.lanou.service.impl;

import com.lanou.dao.StaffDao;
import com.lanou.dao.impl.StaffDaoImpl;
import com.lanou.domain.Staff;
import com.lanou.service.StaffService;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/20.
 */
public class StaffServiceImpl implements StaffService{
    private StaffDao staffDao;

    public StaffServiceImpl() {
        staffDao = new StaffDaoImpl();
    }

    @Override
    public List<Staff> findAll() {
        String hql = "from Staff";
        return staffDao.findAll(hql);
    }

    public List<Staff> find(Map<String, Object> params) {
        return staffDao.find(params);
    }

    @Override
    public Staff findSingle(String hql, Map<String, Object> params) {
        return staffDao.findSingle(hql,params);
    }

    @Override
    public void save(Staff staff) {
        staffDao.save(staff);
    }


}
