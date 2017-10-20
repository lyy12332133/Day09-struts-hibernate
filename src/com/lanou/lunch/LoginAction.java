package com.lanou.lunch;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.awt.image.BufferedImage;

/**
 * Created by dllo on 17/10/20.
 */
public class LoginAction extends ActionSupport{
    private String code;


    public String login(){
        return SUCCESS;
    }

    public void validateLogin(){
        Object code1 = ServletActionContext.getRequest().getSession().getAttribute("code");
        if (!code.equalsIgnoreCase(String.valueOf(code1))){
            addFieldError("error","验证码输入有误");
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
