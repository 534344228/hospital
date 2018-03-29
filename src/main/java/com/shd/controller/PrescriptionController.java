package com.shd.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shd.common.page.PageHelper;
import com.shd.model.pojoExt.PrescriptionExt;
import com.shd.service.PrescriptionService;
import com.shd.util.XTConstant;

@Controller
@RequestMapping("/prescription")
public class PrescriptionController extends CommonController {
	@Autowired
	private PrescriptionService prescriptionService;

	@RequestMapping("/list")
	public String list() {
		return "prescription/list_main";
	}

	/**
	 * 查询处方列表(可按条件查询)
	 * 
	 * @param prescription
	 * @param currentPage
	 * @param model
	 * @return
	 */
	@RequestMapping("/prescriptionList")
	public String prescriptionList(PrescriptionExt prescriptionExt, Integer currentPage, Model model) {
		int pageSize = getPageSize();
		PageHelper.startPage(currentPage, pageSize);
		List<PrescriptionExt> prescriptionList = prescriptionService.queryPrescriptionList(prescriptionExt);
		model.addAttribute("prescriptionList", prescriptionList);
		model.addAttribute("pageSize", pageSize);
		return "prescription/list_prescriptionList";
	}

	/**
	 * 删除处方
	 * 
	 * @author
	 * @param request
	 * @param prescriptionId
	 *            处方Id
	 * @return
	 */
	@RequestMapping("/deletePrescription")
	@ResponseBody
	public String deletePrescription(String prescriptionId) {
		Integer result = prescriptionService.deletePrescription(prescriptionId);
		if (result != XTConstant.ZERO) {// 删除成功
			return XTConstant.Y;
		} else {// 删除失败
			return XTConstant.N;
		}
	}

	/**
	 * 批量删除处方
	 * 
	 * @param medicineId
	 * @param model
	 * @return
	 */
	@RequestMapping("/batchDel")
	@ResponseBody
	public String batchDel(String[] prescriptionId) {
		Integer result = prescriptionService.batchDel(prescriptionId);
		if (result != XTConstant.ZERO) {
			return XTConstant.DELETE_SUCCESSED;
		}
		return XTConstant.DELETE_FAIL;
	}

	/**
	 * 编辑
	 * 
	 * @param model
	 * @param prescriptionId
	 * @return
	 */
	@RequestMapping("/editPrescription")
	public String editPrescription(Model model, String prescriptionId, boolean pageFlag) {
		if (StringUtils.isNotBlank(prescriptionId)) {
			PrescriptionExt prescription = prescriptionService.getPrescription(prescriptionId);
			model.addAttribute("prescription", prescription);
		}
		model.addAttribute("pageFlag", pageFlag);
		return "prescription/editPrescription";
	}
}
