package com.lanou.action;

import com.lanou.domain.Department;
import com.lanou.domain.Post;
import com.lanou.domain.Staff;
import com.lanou.service.DepartmentService;
import com.lanou.service.StaffService;
import com.lanou.service.impl.DepartmentServiceImpl;
import com.lanou.service.impl.StaffServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;


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
    private String sname;
    private String code;
    private Set<Post> posts;
    private List<Staff> staffs;
    private List<Department> departments;

    /**
     * 加载所有部门
     */
    public String findDepart() {
        DepartmentService departmentService = new DepartmentServiceImpl();
        departments = departmentService.findAll();
        // 将部门集合放入request对象中的属性集合中
        return SUCCESS;
    }

    /**
     * 通过部门id加载所有职务
     */
    public String findPost() {
        DepartmentService departmentService = new DepartmentServiceImpl();
        Department department = departmentService.findById(Integer.parseInt(departId));
        posts = department.getPosts();
        return SUCCESS;
    }

    /**
     * 模糊查询员工
     */
    public String findStaff() {
        StaffService staffService = new StaffServiceImpl();
        Map<String, Object> params = new HashMap<>();
        params.put("department_id", departId);
        params.put("post_id", postId);
        if (sname.trim().length() > 0) {
            params.put("sname", sname);
        }
        staffs = staffService.find(params);
        return SUCCESS;
    }

    /**
     * 加载所有员工
     */
    public String findStaffs() {
        StaffService staffService = new StaffServiceImpl();
        staffs = staffService.findAll();
        return SUCCESS;
    }

    /**
     * 添加员工
     */
    public String addStaff() {
        DepartmentService departmentService = new DepartmentServiceImpl();
        Department department = departmentService.findById(Integer.parseInt(departId));
        Set<Post> posts = department.getPosts();
        Staff staff = new Staff();
        staff.setSname(sname);
        staff.setDepartment(department);
        for (Post post : posts) {
            int pid = post.getId();
            if (postId.equals(String.valueOf(pid))) {
                staff.setPost(post);
            }
        }
        StaffService staffService = new StaffServiceImpl();
        staffService.save(staff);
        return SUCCESS;
    }

    /**
     * 添加员工表单校验
     */
    public void validateAddStaff() {
        if (sname.trim().length() == 0) {
            addFieldError("error", "用户名不能为空");
        }
        if (departId.equals("-1")) {
            addFieldError("error", "请选择部门");
        }
        if (postId.equals("-1")) {
            addFieldError("error", "请选择职务");
        }
        Object code1 = ServletActionContext.getRequest().getSession().getAttribute("code");
        if (!code.equalsIgnoreCase(String.valueOf(code1))) {
            addFieldError("error", "验证码输入有误");
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
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
