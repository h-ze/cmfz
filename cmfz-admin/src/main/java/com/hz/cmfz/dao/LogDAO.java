package com.hz.cmfz.dao;

import com.hz.cmfz.entity.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 11022 on 2018/7/9 0009.
 */
public interface LogDAO {
    public int insert(Log log);

    public int countLog();

    public List<Log> selectAll(@Param("begin") int begin, @Param("showSize") int showSize);
}
