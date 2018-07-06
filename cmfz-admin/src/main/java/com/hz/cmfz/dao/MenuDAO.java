package com.hz.cmfz.dao;

import com.hz.cmfz.entity.Menu;

import java.util.List;

/**
 * Created by 11022 on 2018/7/5 0005.
 */
public interface MenuDAO {
    public List<Menu> selectAll(Integer menuParentId);


}
