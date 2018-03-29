package com.shd.dao.extMapper;

import java.util.List;
import java.util.Map;

import com.shd.model.pojo.Patient;
import com.shd.model.pojo.Prescription;
import com.shd.model.pojoExt.PrescriptionExt;

public interface PrescriptionExtMapper {
	/**
	 * 多条件查询
	 * 
	 * @param paramMap
	 * @return
	 */
	List<PrescriptionExt> queryPrescriptionList(PrescriptionExt prescriptionExt);

	/**
	 * 批量插入
	 * 
	 * @param list
	 * @return
	 */
	Integer insertPrescriptions(List<Prescription> list);

	Integer insertPatients(List<Patient> list);

	/**
	 * 统计病症
	 * 
	 * @return
	 */
	Integer countDisease(Prescription prescription);

	/**
	 * 全文搜索
	 * 
	 * @param para
	 * @return
	 */
	List<Map<String, Object>> searchAll(String para);

	/**
	 * 统计病名
	 * 
	 * @return
	 */
	List<PrescriptionExt> getCountPname(Map<String, Object> map);
}
