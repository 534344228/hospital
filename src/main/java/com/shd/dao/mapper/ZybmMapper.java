package com.shd.dao.mapper;

import com.shd.model.pojo.Zybm;
import com.shd.model.pojo.ZybmExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZybmMapper {
    long countByExample(ZybmExample example);

    int deleteByExample(ZybmExample example);

    int deleteByPrimaryKey(String zybmId);

    int insert(Zybm record);

    int insertSelective(Zybm record);

    List<Zybm> selectByExample(ZybmExample example);

    Zybm selectByPrimaryKey(String zybmId);

    int updateByExampleSelective(@Param("record") Zybm record, @Param("example") ZybmExample example);

    int updateByExample(@Param("record") Zybm record, @Param("example") ZybmExample example);

    int updateByPrimaryKeySelective(Zybm record);

    int updateByPrimaryKey(Zybm record);
}