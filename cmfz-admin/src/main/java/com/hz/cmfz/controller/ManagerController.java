package com.hz.cmfz.controller;

import com.hz.cmfz.entity.Manager;
import com.hz.cmfz.service.ManagerService;
import com.hz.cmfz.utils.CreateValidateCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.HttpCookie;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 11022 on 2018/7/4 0004.
 */
@Controller
@RequestMapping("manager")
public class ManagerController {
    @Autowired
    private ManagerService ms;

    @RequestMapping("/login")
    public String login(String managerName, String managerPwd,String checkName, String vcode, HttpSession session,HttpServletResponse response) throws UnsupportedEncodingException {
        Manager manager =null;
        System.out.println(checkName);
        String code = (String) session.getAttribute("code");
        if (vcode.isEmpty() || !vcode.equalsIgnoreCase(code)){
            return "redirect:/login.jsp";
        }else{
            manager = ms.query(managerName,managerPwd);
            if(manager != null ){
                if(checkName != null){
                    Cookie userCookie=new Cookie("checkName", URLEncoder.encode(managerName,"UTF-8"));
                    userCookie.setMaxAge(30*24*60*60);
                    userCookie.setPath("/");
                    response.addCookie(userCookie);
                }

                return "redirect:/main/main.jsp";
            }
            return "redirect:/error.jsp";
        }


    }


    @RequestMapping("/getVcode")
    public void create(HttpSession session,HttpServletResponse response) throws Exception{

        CreateValidateCode vCode = new CreateValidateCode(100,30,1,10);

        session.setAttribute("code", vCode.getCode());

        vCode.write(response.getOutputStream());
    }


    @RequestMapping("checkUserName")
    @ResponseBody
    public Map<String,String> checkUserName(String managerName){
        //创建一个map，用来封装数据
        System.out.println(managerName);
        Map<String,String> managerMap = new HashMap<String,String>();
        String flag="用户不存在";
        Manager ma =ms.queryByName(managerName);
        System.out.println(ma);
        if (ma!=null) {
            flag="用户已存在";
        }
        managerMap.put("manager",flag);
        //测试输出
        System.out.println("打印这句话说明,Ajax Asynchronous request 发送成功...");
        return managerMap;
    }

}
