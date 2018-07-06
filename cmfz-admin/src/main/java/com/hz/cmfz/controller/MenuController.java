package com.hz.cmfz.controller;

import com.hz.cmfz.entity.Menu;
import com.hz.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 11022 on 2018/7/5 0005.
 */
@Controller
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private MenuService ms;

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Menu> findAll(Integer menuParentId){
        List<Menu> menus = ms.findAll(menuParentId);
        return  menus;
    }
}
