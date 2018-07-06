package com.hz.cmfz.service.impl;

import com.hz.cmfz.dao.MasterDAO;
import com.hz.cmfz.entity.Master;
import com.hz.cmfz.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 11022 on 2018/7/6 0006.
 */
@Service
@Transactional
public class MasterServiceImpl implements MasterService{

    @Autowired
    private MasterDAO masterDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Map<String, Object> findAll(int pageSize, int pageIndex,String dim) {
        List<Master> masters = masterDAO.selectAll((pageIndex-1)*pageSize,pageSize,dim);
        int i = masterDAO.countMaster();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total",i);
        map.put("rows",masters);
        return map;
    }

    @Override
    public Master find(String masterId) {
        return masterDAO.select(masterId);
    }

    @Override
    public int add(Master master) {
        return masterDAO.insert(master);
    }

    @Override
    public int modify(Master master) {
        return masterDAO.update(master);
    }

    @Override
    public int remove(String masterId) {
        return 0;
    }
}
