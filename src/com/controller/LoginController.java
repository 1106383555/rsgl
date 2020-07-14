package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Tadmin;
import com.model.Yuangong;
import com.service.TadminService;
import com.service.YuangongService;
import com.util.MD5Util;

/**
 * 登录信息控制类
 */
@Controller
public class LoginController {
	/**
	 * 注入Service
	 */
	@Autowired
	private TadminService tadminService;

	@Autowired
	private YuangongService yuangongService;

	/**
	 * 用户登录
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/login")
	public String unameExist(HttpServletRequest request) throws Exception {
		String exist = "true";
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		
		//密码加密
//		String upwd = MD5Util.MD5EncodeUtf8(upwd1);
		
		
		int utype = Integer.parseInt(request.getParameter("utype"));
		if (utype == 0) { // 管理员登录
			Tadmin tadmin = new Tadmin();
			tadmin.setUname(uname);
			tadmin.setUpwd(upwd);
			List<Tadmin> list = tadminService.queryTadminList(tadmin, null);
			if (list == null || list.size() == 0) {
				exist = "false";
			} else {
				request.getSession().setAttribute("cuser", list.get(0));
				request.getSession().setAttribute("utype", utype);
			}
		}
		if (utype == 1) { // 员工登录
			Yuangong yinfo = new Yuangong();
			yinfo.setYno(uname);
			yinfo.setPwd(upwd);
			List<Yuangong> list = yuangongService.queryYuangongList(yinfo, null);
			if (list == null || list.size() == 0) {
				exist = "false";
			} else {
				request.getSession().setAttribute("cuser", list.get(0));
				yinfo = list.get(0);
				if("员工".equals(yinfo.getRoles())){
					utype = 2;
				}
				if("领导".equals(yinfo.getRoles())){
					utype = 3;
				}
				request.getSession().setAttribute("utype", utype);
			}
		}

		return exist;
		
	}

	/**
	 * 跳转到修改密码界面
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/toUpwd")
	public String toUpwd(HttpServletRequest request) throws Exception {
		return "/admin/upwd.jsp";
	}

	/**
	 * 验证原密码
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/validateOpwd")
	public String validateOpwd(HttpServletRequest request) throws Exception {
		String exist = "false";

		String opwd = request.getParameter("opwd");
		int utype = Integer.parseInt(request.getSession().getAttribute("utype")
				+ "");
		if (utype == 0) { // 管理员
			Tadmin admin = (Tadmin) request.getSession().getAttribute("cuser");
			if (admin.getUpwd().equals(opwd)) {
				return "true";
			}
		}
		if (utype == 2 || utype==3) { // 员工
			Yuangong yinfo = (Yuangong) request.getSession().getAttribute("cuser");
			if (yinfo.getPwd().equals(opwd)) {
				return "true";
			}
		}

		return exist;
	}

	/**
	 * 修改密码
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modifyPwd")
	public String modifyPwd(HttpServletRequest request) throws Exception {
		String exist = "true";
		String upwd = request.getParameter("upwd");
		int utype = Integer.parseInt(request.getSession().getAttribute("utype")
				+ "");
		if (utype == 0) { // 管理员修改密码
			Tadmin tadmin = (Tadmin) request.getSession().getAttribute("cuser");
			tadmin.setUpwd(upwd);
			tadminService.updateTadmin(tadmin);
			request.getSession().setAttribute("cuser", tadmin);
		}
		if (utype == 2 || utype==3) { // 员工修改密码
			Yuangong yinfo = (Yuangong) request.getSession().getAttribute("cuser");
			yinfo.setPwd(upwd);
			yuangongService.updateYuangong(yinfo);
			request.getSession().setAttribute("cuser", yinfo);
		}
		return exist;
	}

	/**
	 * 退出登录
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/loginOut")
	public String loginOut(HttpServletRequest request) throws Exception {
		request.getSession().setAttribute("cuser", null);
		request.getSession().setAttribute("utype", null);
		request.getSession().invalidate();
		return "/login.jsp";
	}

}
