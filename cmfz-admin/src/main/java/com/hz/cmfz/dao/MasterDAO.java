package com.hz.cmfz.dao;

import com.hz.cmfz.entity.Master;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 11022 on 2018/7/6 0006.
 */
public interface MasterDAO {
    public List<Master> selectAll(@Param("begin") int begin,@Param("showSize") int showSize,@Param("dim") String dim);

    public int countMaster();

    public Master select(String masterId);

    public int insert(Master master);

    public int update(Master master);

    public int delete(String masterId);
}
