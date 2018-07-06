package com.hz.cmfz.dao;

import com.hz.cmfz.entity.Sideshow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 11022 on 2018/7/5 0005.
 */
public interface SideshowDAO {
    public List<Sideshow> selectAll(@Param("begin") int begin,@Param("showSize") int showSize);

    public int countSideshow();

    public Sideshow select(String id);

    public int insert(Sideshow sideshow);

    public int update(Sideshow sideshow);

    public int delete(String id);
}
