package com.hz.cmfz.controller;

import com.hz.cmfz.entity.Sideshow;
import com.hz.cmfz.service.SideshowService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 11022 on 2018/7/5 0005.
 */
@Controller
@RequestMapping("Sideshow")
public class SideshowController {

    @Autowired
    private SideshowService sideshowService;

    @RequestMapping("query")
    @ResponseBody
    public Map<String,Object> querySideshow(@RequestParam("rows")int totalSize, @RequestParam("page")int pageIndex){

        return sideshowService.findAll(totalSize,pageIndex);
    }

    @RequestMapping("/update")
    @ResponseBody
    public String updateSideshow(String id,String picName,String description,String picStatus,Date picDate){
        Sideshow sideshow = sideshowService.find(id);
        sideshow.setId(sideshow.getId());
        sideshow.setPicName(sideshow.getPicName());
        sideshow.setDescription(description);
        sideshow.setPicStatus(picStatus);
        sideshow.setPicDate(new Date());
        int a =sideshowService.modify(sideshow);
        if(a> 0){
            return "success";
        }
        return "false";

    }

    @RequestMapping("/add")
    @ResponseBody
    public String addSideshow(String id, String picName, String description, String picStatus, Date picDate, MultipartFile myFile, HttpSession session) throws IOException {

        String realPath1 =session.getServletContext().getRealPath("").replace("cmfz-admin","upload");

        String uuidName = UUID.randomUUID().toString().replace("-","");
        id = uuidName;
        System.out.println(id);
        String oldName = myFile.getOriginalFilename();
        picName = oldName;
        picDate = new Date();
        System.out.println(picDate);
        String suffix = oldName.substring(oldName.lastIndexOf("."));
        System.out.println(suffix);
        myFile.transferTo(new File(realPath1+"/"+oldName));

        Sideshow sideshow =new Sideshow(id,picName,description,picStatus,picDate);
        int a=sideshowService.add(sideshow);
        if(a>0){
            return "success";
        }
        return "false";
    }


}
