package com.hz.cmfz.service;

import com.hz.cmfz.entity.Sideshow;

import java.util.List;
import java.util.Map;

/**
 * Created by 11022 on 2018/7/5 0005.
 */
public interface SideshowService {
    public Map<String,Object> findAll(int totalSize, int pageIndex);

    public Sideshow find(String id);

    public int remove(String id);

    public int modify(Sideshow sideshow);

    public int add(Sideshow sideshow);
}
