package com.hz.cmfz.service.impl;

import com.hz.cmfz.dao.MenuDAO;
import com.hz.cmfz.entity.Menu;
import com.hz.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 11022 on 2018/7/5 0005.
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDAO md;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Menu> findAll(Integer menuParentId) {
        List<Menu> menus =md.selectAll(menuParentId);
        return menus;
    }
}
