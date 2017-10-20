package com.lanou.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 17/10/20.
 */
public class Department {
    private int id; //主键id
    private String dname; //部门名称
    private Set<Post> posts = new HashSet<>(); //职务集合

    public Department(String dname) {
        this.dname = dname;
    }

    public Department(int id, String dname) {
        this.id = id;
        this.dname = dname;
    }

    public Department(int id, String dname, Set<Post> posts) {
        this.id = id;
        this.dname = dname;
        this.posts = posts;
    }

    public Department() {
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", dname='" + dname + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}
