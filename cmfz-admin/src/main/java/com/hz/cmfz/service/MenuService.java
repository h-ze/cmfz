package com.hz.cmfz.service;

import com.hz.cmfz.entity.Menu;

import java.util.List;

/**
 * Created by 11022 on 2018/7/5 0005.
 */
public interface MenuService {
    public List<Menu> findAll(Integer menuParentId);
}
