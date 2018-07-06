package com.hz.cmfz.service.impl;

import com.hz.cmfz.dao.SideshowDAO;
import com.hz.cmfz.entity.Sideshow;
import com.hz.cmfz.service.SideshowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 11022 on 2018/7/5 0005.
 */
@Service
@Transactional
public class SideshowServiceImpl implements SideshowService {

    @Autowired
    private SideshowDAO sideshowDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Map<String,Object> findAll(int totalSize, int pageIndex) {
        int i=sideshowDAO.countSideshow();
        List<Sideshow> sideshows =sideshowDAO.selectAll((pageIndex - 1) * totalSize, totalSize);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("total",i);
        map.put("rows",sideshows);
        return map;
    }


    @Override
    public Sideshow find(String id) {
        return sideshowDAO.select(id);
    }

    @Override
    public int remove(String id) {
        return sideshowDAO.delete(id);
    }

    @Override
    public int modify(Sideshow sideshow) {
        return sideshowDAO.update(sideshow);
    }

    @Override
    public int add(Sideshow sideshow) {
        return sideshowDAO.insert(sideshow);
    }
}
