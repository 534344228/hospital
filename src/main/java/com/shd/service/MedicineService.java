package com.shd.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.shd.model.pojo.Medicine;
import com.shd.model.pojoExt.MedicineUserExt;

/**
 * 药品管理服务
 * 
 * @author S5343
 * @date 2018年3月28日上午10:33:14
 */
public interface MedicineService {
	/**
	 * 查询药品列表
	 * 
	 * @param medicine
	 * @param orderBy
	 * @return
	 */
	List<Medicine> queryMedicineList(Medicine medicine, String orderBy);

	/**
	 * 查找单个药品对象
	 * 
	 * @param medicineId
	 * @return
	 */
	Medicine getMedicine(String medicineId);

	/**
	 * 根据药品名称查询药品
	 * 
	 * @param medicineName
	 * @return
	 */
	Medicine getMedicineByMedicineName(String medicineName);

	/**
	 * 根据药品分类查询药品
	 * 
	 * @param classify
	 * @return
	 */
	Medicine getMedicineByClassify(String classify);

	/**
	 * 保存药品信息
	 * 
	 * @param medicineblob
	 * @return
	 */
	Integer save(Medicine medicine);

	/**
	 * 批量保存
	 * 
	 * @param list
	 * @return
	 */
	Integer saveMedicines(List<Medicine> medicineList);

	/**
	 * 删除药品
	 * 
	 * @param medicineId
	 * @return
	 */
	Integer deleteMedicine(String medicineId);

	/**
	 * 批量删除
	 * 
	 * @param medicineId
	 * @return
	 */
	Integer batchDel(String[] medicineId);

	/**
	 * 读取文件
	 * 
	 * @param file
	 * @return
	 */
	Map<String, Object> readMedicineExcelFile(MultipartFile file);

	/**
	 * 测试用
	 * 
	 * @param file
	 */
	void readMedicineExcelFile(File file);

	/**
	 * 多条件查询药品
	 * 
	 * @param medicineExt
	 * @return
	 */
	List<MedicineUserExt> queryMedicineExtList(MedicineUserExt medicineExt);

	/**
	 * 保存处方时查询药品信息
	 * 
	 * @param medicineExt
	 * @return
	 */
	List<Medicine> queryMedicineExtListSearch(MedicineUserExt medicineExt);

	/**
	 * 统计药品数量
	 * 
	 * @param medicineId
	 * @return
	 */
	Integer countMedicine(String medicineId);

	/**
	 * 保存处方时查询西医诊断
	 * 
	 * @param q
	 * @param page
	 * @return
	 */
	List<Map<String, Object>> getWests(String q, int page);

	/**
	 * 保存处方时查询中医诊断证型
	 * 
	 * @param q
	 * @param page
	 * @return
	 */
	List<Map<String, Object>> getChinese(String q, int page);

	/**
	 * 保存处方时查询中医诊断病名
	 * 
	 * @param q
	 * @param page
	 * @return
	 */
	List<Map<String, Object>> getZybm(String q, int page);
}
