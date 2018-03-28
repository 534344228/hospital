package com.shd.dao.mapper;

import com.shd.model.pojo.Prescription;
import com.shd.model.pojo.PrescriptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrescriptionMapper {
    long countByExample(PrescriptionExample example);

    int deleteByExample(PrescriptionExample example);

    int deleteByPrimaryKey(String prescriptionId);

    int insert(Prescription record);

    int insertSelective(Prescription record);

    List<Prescription> selectByExampleWithBLOBs(PrescriptionExample example);

    List<Prescription> selectByExample(PrescriptionExample example);

    Prescription selectByPrimaryKey(String prescriptionId);

    int updateByExampleSelective(@Param("record") Prescription record, @Param("example") PrescriptionExample example);

    int updateByExampleWithBLOBs(@Param("record") Prescription record, @Param("example") PrescriptionExample example);

    int updateByExample(@Param("record") Prescription record, @Param("example") PrescriptionExample example);

    int updateByPrimaryKeySelective(Prescription record);

    int updateByPrimaryKeyWithBLOBs(Prescription record);

    int updateByPrimaryKey(Prescription record);
}