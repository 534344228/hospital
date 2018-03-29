package com.shd.service.impl;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.shd.dao.mapper.MedicineMapper;
import com.shd.model.pojo.Medicine;
import com.shd.model.pojo.MedicineExample;
import com.shd.model.pojoExt.MedicineUserExt;
import com.shd.service.MedicineService;
import com.shd.util.XTConstant;

@Service
@Transactional
public class MedicineServiceImpl implements MedicineService {
	@Autowired
	private MedicineMapper medicineMapper;

	@Override
	public List<Medicine> queryMedicineList(Medicine medicine, String orderBy) {

		return null;
	}

	@Override
	public Medicine getMedicine(String medicineId) {

		return null;
	}

	@Override
	public Medicine getMedicineByMedicineName(String medicineName) {

		return null;
	}

	@Override
	public Medicine getMedicineByClassify(String classify) {

		return null;
	}

	@Override
	public Integer save(Medicine medicine) {

		return null;
	}

	@Override
	public Integer saveMedicines(List<Medicine> medicineList) {

		return null;
	}

	@Override
	public Integer deleteMedicine(String medicineId) {

		return null;
	}

	@Override
	public Integer batchDel(String[] medicineId) {

		return null;
	}

	@Override
	public Map<String, Object> readMedicineExcelFile(MultipartFile file) {

		return null;
	}

	@Override
	public void readMedicineExcelFile(File file) {

	}

	@Override
	public List<MedicineUserExt> queryMedicineExtList(MedicineUserExt medicineExt) {

		return null;
	}

	@Override
	public List<Medicine> queryMedicineExtListSearch(MedicineUserExt medicineExt) {

		return null;
	}

	@Override
	public Integer countMedicine(String medicineId) {
		MedicineExample example = new MedicineExample();
		MedicineExample.Criteria criteria = example.createCriteria().andDelStateEqualTo(XTConstant.Y);
		if (StringUtils.isNotBlank(medicineId)) {
			criteria.andMedicineIdEqualTo(medicineId);
		}
		return (int) medicineMapper.countByExample(example);
	}

	@Override
	public List<Map<String, Object>> getWests(String q, int page) {

		return null;
	}

	@Override
	public List<Map<String, Object>> getChinese(String q, int page) {

		return null;
	}

	@Override
	public List<Map<String, Object>> getZybm(String q, int page) {

		return null;
	}

}
