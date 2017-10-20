package com.lanou.dao.impl;

import com.lanou.dao.StaffDao;
import com.lanou.domain.Staff;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/20.
 */
public class StaffDaoImpl extends BaseDaoImpl<Staff> implements StaffDao {
    /**
     * 模糊查询员工表
     * @param params 查询语句的参数列表
     * @return 返回员工集合
     */

    public List<Staff> find(Map<String, Object> params) {
        String hql1 = "from Staff where 1=1";
        StringBuffer stringBuffer = new StringBuffer(hql1);
        Object departId = params.get("department_id");
        Object postId = params.get("post_id");
        if (!departId.equals("-1")) {
            stringBuffer.append(" and department_id like :department_id");

        }else {
            params.remove("department_id");
        }
        if (!postId.equals("-1")) {
            stringBuffer.append(" and post_id like :post_id");
        }else {
            params.remove("post_id");
        }
        return super.find(stringBuffer.toString(), params);
    }
}
