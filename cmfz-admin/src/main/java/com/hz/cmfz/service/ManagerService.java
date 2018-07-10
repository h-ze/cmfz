package com.hz.cmfz.service;

import com.hz.cmfz.entity.Manager;

/**
 * Created by 11022 on 2018/7/4 0004.
 */
public interface ManagerService {
    public Manager find(String mgrName, String mgrPwd);

    public Manager findByName(String mgrName);
}
