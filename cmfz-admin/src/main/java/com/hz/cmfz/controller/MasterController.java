package com.hz.cmfz.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.handler.inter.IExcelDataHandler;
import com.alibaba.fastjson.JSON;
import com.hz.cmfz.entity.Master;
import com.hz.cmfz.service.MasterService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Date;
import java.util.List;
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
        System.out.println(oldName);
        masterPhoto = oldName;
        //String suffix = oldName.substring(oldName.lastIndexOf("."));
        //System.out.println(suffix);
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
        master.setMasterName(masterName);
        master.setMasterPhoto(master.getMasterPhoto());
        master.setMasterSummary(masterSummary);
        int a = masterService.modify(master);
        if(a > 0){
            return "success";
        }
        return "false";
    }
    @RequestMapping(value = "/import",method= RequestMethod.POST)
    @ResponseBody
    public String importExcel(@RequestParam("file") MultipartFile file, HttpSession session) throws Exception {
        ImportParams params = new ImportParams();
        params.setTitleRows(0);
        params.setHeadRows(1);

        params.setNeedVerfiy(true);
        List<Master> masterList = null;
        masterList = ExcelImportUtil.importExcel(file.getInputStream(),Master.class,params);

        System.out.println(JSON.toJSONString(masterList)+"1111");
        String realPath1 =session.getServletContext().getRealPath("").replace("cmfz-admin","upload");
        for (Master master:masterList) {
            /*String photoUrl=master.getMasterPhoto();
            File file1 = new File(photoUrl);
            File file2 = new File(realPath1+"/"+photoUrl);
            FileInputStream fin = new FileInputStream(file1);
            DataInputStream ds = new DataInputStream(fin);
            OutputStream os = new FileOutputStream(file2);

            byte[] cache=new byte[64];
            for(;true;){
                int n=ds.read(cache);
                if(n==-1){
                    break;
                }
                os.write(cache,0,n);
            }
            ds.close();
            os.close();*/
            int a =masterService.add(master);
            if( a <= 0 ){
                return "false";
            }
            System.out.println(master+"2222");
        }
        return "success";
    }

    @RequestMapping("/download")
    public void download(HttpServletResponse response) throws IOException {
        List<Master> masters = masterService.downloadAll();
        Workbook workbook =ExcelExportUtil.exportExcel(new ExportParams("",""),Master.class,masters);
        ServletOutputStream out = response.getOutputStream();

        String fileName =new String("上师信息.xls".getBytes(),"iso-8859-1");
        response.setContentType("application/vnd.ms-excel");

        response.setHeader("content-disposition","attachment;fileName="+fileName);
        workbook.write(out);
        out.close();
    }
}
