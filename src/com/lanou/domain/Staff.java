package com.lanou.domain;

/**
 * Created by dllo on 17/10/20.
 */
public class Staff {
    private int id; //主键id
    private String sname; //员工姓名
    private Post post; // 所属职务
    private Department department; // 所属部门

    public Staff(int id, String sname, Post post, Department department) {
        this.id = id;
        this.sname = sname;
        this.post = post;
        this.department = department;
    }

    public Staff(int id, String sname) {
        this.id = id;
        this.sname = sname;
    }

    public Staff(String sname) {
        this.sname = sname;
    }

    public Staff() {
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", sname='" + sname + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
