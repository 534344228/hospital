package com.shd.dao.mapper;

import com.shd.model.pojo.SysCfg;
import com.shd.model.pojo.SysCfgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysCfgMapper {
    long countByExample(SysCfgExample example);

    int deleteByExample(SysCfgExample example);

    int deleteByPrimaryKey(String cfgId);

    int insert(SysCfg record);

    int insertSelective(SysCfg record);

    List<SysCfg> selectByExample(SysCfgExample example);

    SysCfg selectByPrimaryKey(String cfgId);

    int updateByExampleSelective(@Param("record") SysCfg record, @Param("example") SysCfgExample example);

    int updateByExample(@Param("record") SysCfg record, @Param("example") SysCfgExample example);

    int updateByPrimaryKeySelective(SysCfg record);

    int updateByPrimaryKey(SysCfg record);
}