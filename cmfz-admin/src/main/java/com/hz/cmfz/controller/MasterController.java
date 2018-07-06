package com.hz.cmfz.controller;

import com.hz.cmfz.entity.Master;
import com.hz.cmfz.service.MasterService;
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
 * Created by 11022 on 2018/7/6 0006.
 */
@Controller
@RequestMapping("Master")
public class MasterController {

    @Autowired
    private MasterService masterService;


    //@RequestParam("rows")int totalSize, @RequestParam("page")int pageIndex
    @RequestMapping("/query")
    @ResponseBody
    public Map<String,Object> queryMaster(@RequestParam("rows") int totalSize,@RequestParam("page") int pageIndex,String masterName){
        return masterService.findAll(totalSize,pageIndex,masterName);

    }

    @RequestMapping("/add")
    @ResponseBody
    public String insertMaster(String masterId, String masterName, String masterPhoto, String masterSummary, MultipartFile myFile, HttpSession session) throws IOException {
        String realPath1 =session.getServletContext().getRealPath("").replace("cmfz-admin","upload");

        String uuidName = UUID.randomUUID().toString().replace("-","");
        masterId = uuidName;
        String oldName = myFile.getOriginalFilename();
        String suffix = oldName.substring(oldName.lastIndexOf("."));
        System.out.println(suffix);
        myFile.transferTo(new File(realPath1+"/"+oldName));


        Master master = new Master(masterId,masterName,masterPhoto,masterSummary);
        int a = masterService.add(master);
        if(a > 0){
            return "success";
        }
        return "false";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String deleteMaster(String masterId){
        int i =masterService.remove(masterId);
        if(i > 0){
            return "success";
        }
        return "false";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String updateMaster(String masterId,String masterName,String masterPhoto,String masterSummary){
        Master master =masterService.find(masterId);
        master.setMasterId(master.getMasterId());
        master.setMasterName(master.getMasterName());
        master.setMasterPhoto(master.getMasterPhoto());
        master.setMasterSummary(masterSummary);
        int a = masterService.modify(master);
        if(a > 0){
            return "success";
        }
        return "false";
    }
}
