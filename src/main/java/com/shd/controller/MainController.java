package com.shd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主页跳转的Controller
 * 
 * @author S5343
 * @date 2018年3月27日下午8:38:36
 */
@Controller
@RequestMapping("/main")
public class MainController extends CommonController {
	/**
	 * 首页显示
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/main")
	public String main(Model model) {
		return "main/main";
	}
}
