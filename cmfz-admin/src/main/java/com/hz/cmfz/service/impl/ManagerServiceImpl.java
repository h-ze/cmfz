package com.hz.cmfz.service.impl;

import com.hz.cmfz.dao.ManagerDAO;
import com.hz.cmfz.entity.Manager;
import com.hz.cmfz.service.ManagerService;
import com.hz.cmfz.utils.EncryptionUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 11022 on 2018/7/4 0004.
 */
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService{

    @Autowired
    private ManagerDAO md;
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public Manager find(String mgrName, String mgrPwd) {
        Manager manager =md.Select(mgrName);
        String salt =EncryptionUtils.getRandomSalt(6);
        System.out.println(salt+"hhh");
        String newPwd =DigestUtils.md5Hex(manager.getMgrPwd()+manager.getSalt());
        System.out.println(newPwd);
        if(mgrPwd.equals(manager.getMgrPwd()) && manager != null){
            return manager;
        }else
     return null;
    }

    @Override
    public Manager findByName(String mgrName) {
        Manager manager =md.Select(mgrName);
        if(manager != null){
            return manager;
        }else
            return null;
    }
}
