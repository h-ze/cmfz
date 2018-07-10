package com.hz.cmfz.service;

import com.hz.cmfz.entity.Log;

import java.util.Map;

/**
 * Created by 11022 on 2018/7/9 0009.
 */
public interface LogService {
    public int LogAdd(Log log);

    public Map<String,Object> findAll(int totalSize,int pageIndex);
}
