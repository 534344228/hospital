package com.shd.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.shd.model.pojo.Prescription;
import com.shd.model.pojoExt.NodeExt;
import com.shd.model.pojoExt.PrescriptionExt;

/**
 * 处方服务类
 * 
 * @author S5343
 * @date 2018年3月28日下午1:57:15
 */
public interface PrescriptionService {
	/**
	 * 查询处方列表
	 * 
	 * @param prescription
	 * @param orderBy
	 * @param endTime
	 * @param startTime
	 * @return
	 */
	List<PrescriptionExt> queryPrescriptionList(PrescriptionExt prescriptionExt);

	/**
	 * 查找单个处方对象
	 * 
	 * @param medicineId
	 * @return
	 */
	PrescriptionExt getPrescription(String prescriptionId);

	/**
	 * 保存处方信息
	 * 
	 * @param medicineblob
	 * @return
	 */
	Integer save(PrescriptionExt prescription);

	/**
	 * 删除处方
	 * 
	 * @param medicineId
	 * @return
	 */
	Integer deletePrescription(String prescriptionId);

	/**
	 * 批量删除
	 * 
	 * @param medicineId
	 * @return
	 */
	Integer batchDel(String[] prescriptionId);

	/**
	 * 读取文件
	 * 
	 * @param file
	 * @return
	 */
	Map<String, Object> readExcelFile(MultipartFile file);

	/**
	 * 
	 * @param file
	 */
	void readExcelFile(File file);

	/**
	 * 检查处方名称唯一性
	 * 
	 * @param prescription
	 * @return
	 */
	List<Prescription> checkUnique(Prescription prescription);

	/**
	 * 统计处方数量
	 * 
	 * @param medicineId
	 * @return
	 */
	Integer countPrescription(String medicineId);

	/**
	 * 统计病症数量
	 * 
	 * @param
	 * @return
	 */
	Integer countDiseases(Prescription prescription);

	/**
	 * 批量保存
	 * 
	 * @param prescriptionList
	 * @return
	 */
	Integer savePrescriptions(List<PrescriptionExt> prescriptionList);

	/**
	 * 统计常用药品top
	 * 
	 * @param json
	 * @param topLevel
	 * @return
	 */
	Map<String, Object> getTop(Integer topLevel, String startTime, String endTime);

	@SuppressWarnings("rawtypes")
	List<NodeExt> searchAll(String para);

	/**
	 * 统计常见中医证型TOP5
	 * 
	 * @return
	 */
	Map<String, Object> getDiseaseTop(int topLevel, String startTime, String endTime);

}
