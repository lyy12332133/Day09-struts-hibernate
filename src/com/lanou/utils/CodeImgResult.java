package com.lanou.utils;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import org.apache.struts2.ServletActionContext;

import java.awt.image.BufferedImage;

/**
 * Created by dllo on 17/10/20.
 */
public class CodeImgResult implements Result {
    @Override
    public void execute(ActionInvocation actionInvocation) throws Exception {
        VerifyCode code = new VerifyCode();
        BufferedImage image = code.getImage();
        ServletActionContext.getRequest().getSession().setAttribute("code", code.getText());
        VerifyCode.output(image, ServletActionContext.getResponse().getOutputStream());
    }
}
