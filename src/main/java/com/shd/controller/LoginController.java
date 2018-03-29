/**
 * 
 */
package com.shd.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shd.common.md5.MD5;
import com.shd.enums.sys.LogTypeEnum;
import com.shd.model.pojo.SysCfg;
import com.shd.model.pojo.SysLog;
import com.shd.model.pojo.SysUser;
import com.shd.service.OpenValidateService;
import com.shd.service.SysLogService;
import com.shd.service.SysUserService;
import com.shd.util.XTConstant;

import nl.captcha.Captcha;
import nl.captcha.servlet.CaptchaServletUtil;

/**
 * 登录操作
 * 
 * @author S5343
 * @date 2018年3月27日下午3:52:33
 */
@Controller
@RequestMapping("/login")
public class LoginController extends CommonController {

	@Autowired
	private OpenValidateService openValidateService;
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysLogService sysLogService;

	/**
	 * 跳转至登录页面
	 * 
	 * @param model
	 * @return 登录页面
	 */
	@RequestMapping("/forwardLogin")
	public String forwardLogin(Model model) {
		String cfgCode = "open_validate";
		List<SysCfg> cfgList = openValidateService.getOpenValidate(cfgCode);
		model.addAttribute("openValidate", cfgList.get(0));
		return "login/login";
	}

	/**
	 * session过期
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/timeout")
	public String timeout(Model model) {
		return "/login/timeout";
	}

	/**
	 * 登陆
	 * 
	 * @param session
	 * @param 账号
	 * @param 密码
	 * @param 验证码
	 * @param model
	 * @return
	 */
	@RequestMapping("/accessLogin")
	public String accessLogin(HttpSession session, String userAcc, String userPwd, String verifyCode, Model model) {
		String successLoginPage = "redirect:/main/main.action";
		String errorLoginPage = "/login/login";
		// 从session中取出验证码
		String sessionValidateCode = (String) session.getAttribute("verifyCode");
		// 验证码输入不能为空，不区分大小写
		String cfgCode = "open_validate";
		List<SysCfg> cfgList = openValidateService.getOpenValidate(cfgCode);
		model.addAttribute("openValidate", cfgList.get(0));
		String stage = cfgList.get(0).getCfgValue(); // 验证码开启的状态
		if ("Y".equals(stage)) {// 开启验证码
			if (StringUtils.isNotBlank(sessionValidateCode)) {
				if (StringUtils.isBlank(verifyCode) || !sessionValidateCode.equalsIgnoreCase(verifyCode)) {
					model.addAttribute("loginErrorMessage", XTConstant.VALIDATECODE_ERROR);
					// 返回登录界面
					return errorLoginPage;
				}
			}
		}
		// 当前用户的登录信息
		SysUser currUser = sysUserService.getSysUserByUserAcc(userAcc);
		if (currUser == null) {// 表示通过手机号码登录
			currUser = sysUserService.getSysUserByUseMobile(userAcc);
		}
		if (currUser == null) {// 表示通过邮箱登录
			currUser = sysUserService.getSysUserByUserEmail(userAcc);
		}
		if (currUser == null) {// 表示用户不存在
			model.addAttribute("loginErrorMessage", "该用户不存在！");
			return errorLoginPage;
		}

		userPwd = MD5.md5crypt(userPwd.trim());// 密码加密比对
		if (!userPwd.equals(currUser.getUserPwd())) {
			model.addAttribute("loginErrorMessage", XTConstant.ACCOUNT_OR_PASSWORD_ERROR);
			return errorLoginPage;
		}
		// 把当前用户存入session
		session.setAttribute("currUser", currUser);
		model.addAttribute("userId", currUser.getUserId());
		model.addAttribute("loginSuccessMessage", XTConstant.LOGIN_SUCCESS);
		// 记录登录信息到日志表
		SysLog log = new SysLog();
		log.setLogType(LogTypeEnum.operLog.getId());
		log.setLogDetails("用户登录");
		log.setCreateUserId(currUser.getUserId());
		// 保存日志到数据库
		sysLogService.save(log);
		return successLoginPage;
	}

	/**
	 * 退出登录
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/exit")
	public String exit(HttpSession session, Model model) throws Exception {
		SysUser currUser = (SysUser) session.getAttribute(XTConstant.CURR_USER);
		// 如果session为空，直接报session过期，跳转登录页面
		if (currUser == null) {
			return "redirect:/login/timeout.action";
		}
		// 退出时清空session
		session.invalidate();
		// 查询验证码配置信息
		String cfgCode = "open_validate";
		List<SysCfg> cfgList = openValidateService.getOpenValidate(cfgCode);
		model.addAttribute("openValidate", cfgList.get(0));
		return "login/login";
	}

	/**
	 * 验证码图片
	 * 
	 * @param model
	 * @param response
	 * @param session
	 */
	@RequestMapping("/captcha")
	public void captcha(Model model, HttpServletResponse response, HttpSession session) {
		Captcha captcha = new Captcha.Builder(150, 50).addText().addBackground().addNoise().gimp().build();
		session.setAttribute("verifyCode", captcha.getAnswer());
		CaptchaServletUtil.writeImage(response, captcha.getImage());
	}

}
