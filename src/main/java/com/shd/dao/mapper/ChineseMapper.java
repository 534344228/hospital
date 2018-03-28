package com.shd.dao.mapper;

import com.shd.model.pojo.Chinese;
import com.shd.model.pojo.ChineseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChineseMapper {
    long countByExample(ChineseExample example);

    int deleteByExample(ChineseExample example);

    int deleteByPrimaryKey(String chineseId);

    int insert(Chinese record);

    int insertSelective(Chinese record);

    List<Chinese> selectByExample(ChineseExample example);

    Chinese selectByPrimaryKey(String chineseId);

    int updateByExampleSelective(@Param("record") Chinese record, @Param("example") ChineseExample example);

    int updateByExample(@Param("record") Chinese record, @Param("example") ChineseExample example);

    int updateByPrimaryKeySelective(Chinese record);

    int updateByPrimaryKey(Chinese record);
}