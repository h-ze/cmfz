package com.hz.cmfz.service;

import com.hz.cmfz.entity.Master;

import java.util.Map;

/**
 * Created by 11022 on 2018/7/6 0006.
 */
public interface MasterService {

    public Map<String,Object> findAll(int pageSize, int pageIndex,String dim);

    public Master find(String masterId);

    public int add(Master master);

    public int modify(Master master);

    public int remove(String masterId);
}
