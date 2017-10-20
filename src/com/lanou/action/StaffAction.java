package com.lanou.action;

import com.lanou.domain.Department;
import com.lanou.domain.Post;
import com.lanou.domain.Staff;
import com.lanou.service.DepartmentService;
import com.lanou.service.StaffService;
import com.lanou.service.impl.DepartmentServiceImpl;
import com.lanou.service.impl.StaffServiceImpl;
import com.opensymphony.xwork2.ActionSupport;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by dllo on 17/10/20.
 */
public class StaffAction extends ActionSupport {
    private String departId;
    private String postId;
    private Set<Post> posts;
    private List<Staff> staffs;
    private List<Department> departments;

    /**
     * 加载所有部门
     * @return 返回部门集合
     */
    public String findDepart(){
        DepartmentService departmentService = new DepartmentServiceImpl();
        departments = departmentService.findAll();
        // 将部门集合放入request对象中的属性集合中
        return SUCCESS;
    }

    /**
     * 通过部门id加载所有职务
     * @return 返回职务集合
     */
    public String findPost() {
        DepartmentService departmentService = new DepartmentServiceImpl();
        Department department = departmentService.findById(Integer.parseInt(departId));
        posts = department.getPosts();
        return SUCCESS;
    }

    /**
     * 模糊查询员工
     * @return 返回员工集合
     */
    public String findStaff() {
        StaffService staffService = new StaffServiceImpl();
        Map<String, Object> params = new HashMap<>();
        params.put("department_id", departId);
        params.put("post_id", postId);
        staffs = staffService.find(params);
        return SUCCESS;
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
