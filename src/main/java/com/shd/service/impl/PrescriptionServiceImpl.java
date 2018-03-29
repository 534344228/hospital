package com.shd.service.impl;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.shd.dao.extMapper.PrescriptionExtMapper;
import com.shd.dao.mapper.PatientMapper;
import com.shd.dao.mapper.PrescriptionMapper;
import com.shd.model.pojo.Patient;
import com.shd.model.pojo.PatientExample;
import com.shd.model.pojo.Prescription;
import com.shd.model.pojo.PrescriptionExample;
import com.shd.model.pojoExt.NodeExt;
import com.shd.model.pojoExt.PrescriptionExt;
import com.shd.service.PrescriptionService;
import com.shd.util.BeanUtil;
import com.shd.util.DateUtil;
import com.shd.util.XTConstant;

@Service
@Transactional
public class PrescriptionServiceImpl implements PrescriptionService {
	@Autowired
	private PrescriptionMapper prescriptionMapper;
	@Autowired
	private PatientMapper patientMapper;

	@Autowired
	private PrescriptionExtMapper prescriptionExtMapper;

	@Override
	public List<PrescriptionExt> queryPrescriptionList(PrescriptionExt prescriptionExt) {
		return prescriptionExtMapper.queryPrescriptionList(prescriptionExt);
	}

	@Override
	public PrescriptionExt getPrescription(String prescriptionId) {
		if (StringUtils.isNotBlank(prescriptionId)) {
			PrescriptionExt ext = new PrescriptionExt();
			Prescription pre = prescriptionMapper.selectByPrimaryKey(prescriptionId);
			PatientExample example = new PatientExample();
			example.createCriteria().andDelStateEqualTo("Y").andPresIdEqualTo(prescriptionId);
			List<Patient> patientList = patientMapper.selectByExample(example);
			if (patientList.size() == 1) {
				Patient patient = patientList.get(0);
				BeanUtil.newBeanToBean(ext, patient);
				BeanUtil.newBeanToBean(ext, pre);
				return ext;
			}
			return new PrescriptionExt();
		}
		return null;
	}

	@Override
	public Integer save(PrescriptionExt prescription) {

		return 0;
	}

	@Override
	public Integer deletePrescription(String prescriptionId) {
		if (StringUtils.isNotBlank(prescriptionId)) {
			PrescriptionExt prescription = new PrescriptionExt();
			prescription.setPrescriptionId(prescriptionId);
			prescription.setDelState(XTConstant.N);
			return save(prescription);
		}
		return XTConstant.ZERO;
	}

	@Override
	public Integer batchDel(String[] prescriptionId) {
		if (prescriptionId != null && prescriptionId.length != XTConstant.ZERO) {
			PrescriptionExample example = new PrescriptionExample();
			PrescriptionExample.Criteria criteria = example.createCriteria().andDelStateEqualTo(XTConstant.Y);
			criteria.andPrescriptionIdIn(Arrays.asList(prescriptionId));
			return prescriptionMapper.deleteByExample(example);
		}
		return XTConstant.ZERO;
	}

	@Override
	public Map<String, Object> readExcelFile(MultipartFile file) {

		return null;
	}

	@Override
	public void readExcelFile(File file) {

	}

	@Override
	public List<Prescription> checkUnique(Prescription prescription) {

		return null;
	}

	@Override
	public Integer countPrescription(String prescriptionId) {
		PrescriptionExample example = new PrescriptionExample();
		PrescriptionExample.Criteria criteria = example.createCriteria().andDelStateEqualTo(XTConstant.Y);
		if (StringUtils.isNotBlank(prescriptionId)) {
			criteria.andPrescriptionIdEqualTo(prescriptionId);
		}
		return (int) prescriptionMapper.countByExample(example);
	}

	@Override
	public Integer countDiseases(Prescription prescription) {
		StringBuffer buffer = new StringBuffer();
		Map<String, Integer> map = new HashMap<String, Integer>();

		PrescriptionExample prescriptionExample = new PrescriptionExample();
		PrescriptionExample.Criteria criteria = prescriptionExample.createCriteria();
		criteria.andDelStateEqualTo(XTConstant.Y);
		List<Prescription> selectByExample = prescriptionMapper.selectByExampleWithBLOBs(prescriptionExample);
		for (int i = 0; i < selectByExample.size(); i++) {
			buffer.append(i == 0 ? selectByExample.get(i).getDisease().replace("]", ",")
					: selectByExample.get(i).getDisease().replace("[", "").replace("]", ","));
		}
		if (buffer.length() > 0) {
			buffer.replace(buffer.length() - 1, buffer.length(), "");
			buffer.append("]");
		} else {

			buffer.append("[]");
		}
		JSONArray jsonArray = new JSONArray(buffer.toString());

		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject e = (JSONObject) jsonArray.get(i);
			map.put((String) e.get("text"), map.get(e.get("text")) == null ? 1 : map.get(e.get("text")) + 1);
		}
		return map.keySet().size();

	}

	@Override
	public Integer savePrescriptions(List<PrescriptionExt> prescriptionList) {

		return 0;
	}

	@Override
	public Map<String, Object> getTop(Integer topLevel, String startTime, String endTime) {
		StringBuffer buffer = new StringBuffer();
		Map<String, Integer> map = new HashMap<>();
		PrescriptionExample prescriptionExample = new PrescriptionExample();
		// 创建查询条件
		PrescriptionExample.Criteria criteria = prescriptionExample.createCriteria();
		if (StringUtils.isNotBlank(startTime) && StringUtils.isNotBlank(endTime)) {
			// 转换日期格式
			Date startDate = DateUtil.stringToDate(startTime);
			Date endDate = DateUtil.stringToDate(endTime);
			criteria.andVisitTimeBetween(startDate, endDate);
		}
		criteria.andDelStateEqualTo(XTConstant.Y);
		// 返回查询结果
		List<Prescription> selectByExample = prescriptionMapper.selectByExampleWithBLOBs(prescriptionExample);
		// 把所有药物信息转换成一列,json格式[{}]
		for (int i = 0; i < selectByExample.size(); i++) {
			buffer.append(i == 0 ? selectByExample.get(i).getMedicines().replace("]", ",")
					: selectByExample.get(i).getMedicines().replace("[", "").replace("]", ","));
		}
		if (buffer.length() > 0) {
			// 去除结尾的逗号
			buffer.replace(buffer.length() - 1, buffer.length(), "");
			buffer.append("]");
		} else {
			buffer.append("[]");
		}
		// 转换成json对象
		JSONArray jsonArray = new JSONArray(buffer.toString());
		// 统计药品个数 {炒青皮颗粒=1, 生姜颗粒=1, 浮小麦颗粒=1}
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject e = (JSONObject) jsonArray.get(i);
			map.put((String) e.get("medicineName"),
					map.get(e.get("medicineName")) == null ? 1 : map.get(e.get("medicineName")) + 1);
		}
		int toptotal = 0;
		Map<String, Object> data = getTopData(map, topLevel);
		for (int i = 0; i < ((Integer[]) data.get("top")).length; i++) {
			Integer el = ((Integer[]) data.get("top"))[i];
			if (el == null || el == 0)
				continue;
			toptotal += el;
		}
		data.put("total", jsonArray.length() - toptotal);
		return data;
	}

	@Override
	public List<NodeExt> searchAll(String para) {

		return null;
	}

	@Override
	public Map<String, Object> getDiseaseTop(int topLevel, String startTime, String endTime) {
		StringBuffer buffer = new StringBuffer();
		Map<String, Integer> map = new HashMap<String, Integer>();
		PrescriptionExample prescriptionExample = new PrescriptionExample();
		// 创建查询条件
		PrescriptionExample.Criteria criteria = prescriptionExample.createCriteria();
		if (StringUtils.isNotBlank(startTime) && StringUtils.isNotBlank(endTime)) {
			// 转换日期格式
			Date startDate = DateUtil.stringToDate(startTime);
			Date endDate = DateUtil.stringToDate(endTime);
			criteria.andVisitTimeBetween(startDate, endDate);
		}
		criteria.andDelStateEqualTo(XTConstant.Y);
		// 返回查询结果
		List<Prescription> selectByExample = prescriptionMapper.selectByExampleWithBLOBs(prescriptionExample);

		for (int i = 0; i < selectByExample.size(); i++) {
			buffer.append(i == 0 ? selectByExample.get(i).getDisease().replace("]", ",")
					: selectByExample.get(i).getDisease().replace("[", "").replace("]", ","));
		}
		if (buffer.length() > 0) {
			// 去除结尾的逗号
			buffer.replace(buffer.length() - 1, buffer.length(), "");
			buffer.append("]");
		} else {
			buffer.append("[]");
		}

		JSONArray jsonArray = new JSONArray(buffer.toString());

		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject e = (JSONObject) jsonArray.get(i);
			map.put((String) e.get("text"), map.get(e.get("text")) == null ? 1 : map.get(e.get("text")) + 1);
		}
		int toptotal = 0;
		Map<String, Object> data = getTopData(map, topLevel);
		for (int i = 0; i < ((Integer[]) data.get("top")).length; i++) {
			Integer el = ((Integer[]) data.get("top"))[i];
			if (el == null || el == 0)
				continue;
			toptotal += el;
		}
		data.put("total", jsonArray.length() - toptotal);
		return data;
	}

	// 排序方法
	private Map<String, Object> getTopData(Map<String, Integer> json, int topLevel) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		String[] keys = new String[topLevel];
		Integer[] top = new Integer[topLevel];
		Set<String> sets = json.keySet();
		Iterator<String> iterator = sets.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			int max = json.get(key);
			for (int j = 0; j < top.length; j++) {
				boolean flag = true;
				if (top[j] == null && flag) {
					top[j] = max;
					keys[j] = key;
					break;
				}
				if (top[j] < max) {
					int temp = top[j];
					String tempStr = keys[j];
					top[j] = max;
					keys[j] = key;
					max = temp;
					key = tempStr;
					flag = false;
				}
			}
		}
		hashMap.put("keys", keys);
		hashMap.put("top", top);
		return hashMap;
	}

}
