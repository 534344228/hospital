package com.shd.dao.mapper;

import com.shd.model.pojo.SysCfg;
import com.shd.model.pojo.SysCfgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysCfgMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_cfg
     *
     * @mbg.generated Tue Mar 27 14:38:52 CST 2018
     */
    long countByExample(SysCfgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_cfg
     *
     * @mbg.generated Tue Mar 27 14:38:52 CST 2018
     */
    int deleteByExample(SysCfgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_cfg
     *
     * @mbg.generated Tue Mar 27 14:38:52 CST 2018
     */
    int deleteByPrimaryKey(String cfgId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_cfg
     *
     * @mbg.generated Tue Mar 27 14:38:52 CST 2018
     */
    int insert(SysCfg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_cfg
     *
     * @mbg.generated Tue Mar 27 14:38:52 CST 2018
     */
    int insertSelective(SysCfg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_cfg
     *
     * @mbg.generated Tue Mar 27 14:38:52 CST 2018
     */
    List<SysCfg> selectByExample(SysCfgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_cfg
     *
     * @mbg.generated Tue Mar 27 14:38:52 CST 2018
     */
    SysCfg selectByPrimaryKey(String cfgId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_cfg
     *
     * @mbg.generated Tue Mar 27 14:38:52 CST 2018
     */
    int updateByExampleSelective(@Param("record") SysCfg record, @Param("example") SysCfgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_cfg
     *
     * @mbg.generated Tue Mar 27 14:38:52 CST 2018
     */
    int updateByExample(@Param("record") SysCfg record, @Param("example") SysCfgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_cfg
     *
     * @mbg.generated Tue Mar 27 14:38:52 CST 2018
     */
    int updateByPrimaryKeySelective(SysCfg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_cfg
     *
     * @mbg.generated Tue Mar 27 14:38:52 CST 2018
     */
    int updateByPrimaryKey(SysCfg record);
}