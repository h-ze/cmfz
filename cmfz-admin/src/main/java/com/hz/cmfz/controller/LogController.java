package com.hz.cmfz.controller;

import com.hz.cmfz.service.LogService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by 11022 on 2018/7/10 0010.
 */
@Controller
@RequestMapping("Log")
public class LogController {
    @Autowired
    private LogService logService;

    @RequestMapping("/query")
    @ResponseBody
    public Map<String,Object> queryLog(@RequestParam("rows")int totalSize, @RequestParam("page")int pageIndex){

        return logService.findAll(totalSize,pageIndex);
    }


}
