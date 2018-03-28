package com.shd.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shd.model.pojoExt.PrescriptionExt;
import com.shd.service.MedicineService;
import com.shd.service.PrescriptionService;

/**
 * 主页跳转的Controller
 * 
 * @author S5343
 * @date 2018年3月27日下午8:38:36
 */
@Controller
@RequestMapping("/main")
public class MainController extends CommonController {
	@Autowired
	private MedicineService medicineService;
	@Autowired
	private PrescriptionService prescriptionService;

	/**
	 * 首页显示
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/main")
	public String main(Model model) {
		// 中药种类
		model.addAttribute("countMedicine", medicineService.countMedicine(null));
		// 处方数量
		model.addAttribute("countPrescription", prescriptionService.countPrescription(null));
		// 证型种类
		model.addAttribute("countDisease", prescriptionService.countDiseases(null));
		// 常用药品TOP3
		model.addAttribute("topMap", prescriptionService.getTop(3, null, null));
		return "main/main";
	}

	/**
	 * 常见中医诊断证型统计
	 * 
	 * @param startTime
	 * @param endTime
	 * @return json
	 */
	@RequestMapping("/getCountDisease")
	@ResponseBody
	public Map<String, Object> getCountDisease(String startTime, String endTime) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 默认显示5条
		Map<String, Object> top = prescriptionService.getDiseaseTop(5, startTime, endTime);
		List<PrescriptionExt> countDiseaseList = new ArrayList<>();
		String[] keys = (String[]) top.get("keys");
		Integer[] tops = (Integer[]) top.get("top");
		for (int i = 0; i < keys.length; i++) {
			String text = keys[i];
			if (text == null) {
				continue;
			}
			Integer count = tops[i];
			PrescriptionExt prescriptionExt = new PrescriptionExt();
			prescriptionExt.setText(text);
			prescriptionExt.setCount(count);
			countDiseaseList.add(prescriptionExt);
		}
		PrescriptionExt tem = new PrescriptionExt();
		tem.setCount((Integer) top.get("total"));
		tem.setText("其他");
		countDiseaseList.add(tem);
		map.put("countDiseaseList", countDiseaseList);
		return map;
	}
}
