package com.shd.dao.mapper;

import com.shd.model.pojo.West;
import com.shd.model.pojo.WestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WestMapper {
    long countByExample(WestExample example);

    int deleteByExample(WestExample example);

    int deleteByPrimaryKey(String westId);

    int insert(West record);

    int insertSelective(West record);

    List<West> selectByExample(WestExample example);

    West selectByPrimaryKey(String westId);

    int updateByExampleSelective(@Param("record") West record, @Param("example") WestExample example);

    int updateByExample(@Param("record") West record, @Param("example") WestExample example);

    int updateByPrimaryKeySelective(West record);

    int updateByPrimaryKey(West record);
}