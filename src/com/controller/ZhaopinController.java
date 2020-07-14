package com.controller;

import com.model.Zhaopin;
import com.service.ZhaopinService;
import com.util.PageBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 招聘信息Controller业务控制类
 */
@Controller
public class ZhaopinController {
	/**
	 * 注入Service
	 */
	@Autowired
	private ZhaopinService zhaopinService;

	/**
	 * 招聘信息列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/zhaopin_list")
	public String list(HttpServletRequest request) throws Exception {
		/**
		 * 获取分页参数
		 */
		int offset = 0; // 记录偏移量
		int counts = 0; // 总记录数
		try {
			offset = Integer.parseInt(request.getParameter("pager.offset"));
		} catch (Exception e) {
		}
		PageBean page = new PageBean(offset);
		Zhaopin zhaopin = new Zhaopin();
		String name = request.getParameter("name");
		zhaopin.setName(name);
		request.setAttribute("name", name);
		// 查询记录总数
		counts = zhaopinService.getCount(zhaopin);
		// 获取当前页记录
		List zhaopinList = zhaopinService.queryZhaopinList(zhaopin, page);
		request.setAttribute("list", zhaopinList);
		// 将分页相关参数放到request中
		request.setAttribute("itemSize", counts);
		int page_count = counts % PageBean.PAGE_IETM == 0 ? counts
				/ PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
		request.setAttribute("pageItem", PageBean.PAGE_IETM);
		request.setAttribute("pageTotal", page_count);
		return "/admin/zhaopin/zhaopin_list.jsp";
	}

	/**
	 * 跳转到新增招聘信息界面
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/zhaopin_toAdd")
	public String toAdd(HttpServletRequest request) throws Exception {
		return "/admin/zhaopin/zhaopin_add.jsp";
	}

	/**
	 * 保存新增招聘信息
	 * 
	 * @param zhaopin
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/zhaopin_add")
	public String add(Zhaopin zhaopin, HttpServletRequest request)
			throws Exception {
		// 保存到数据库
		zhaopin.setFbsj(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		zhaopinService.insertZhaopin(zhaopin);
		return "redirect:zhaopin_list.action";
	}

	/**
	 * 跳转到更新招聘信息界面
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/zhaopin_toUpdate")
	public String toUpdate(HttpServletRequest request) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		// 根据ID查询出需要更新的记录
		Zhaopin zhaopin = zhaopinService.queryZhaopinById(id);
		request.setAttribute("zhaopin", zhaopin);
		return "/admin/zhaopin/zhaopin_update.jsp";
	}

	/**
	 * 更新招聘信息
	 * 
	 * @param zhaopin
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/zhaopin_update")
	public String update(Zhaopin zhaopin, HttpServletRequest request)
			throws Exception {
		// 更新数据库
		zhaopinService.updateZhaopin(zhaopin);
		return "redirect:zhaopin_list.action";
	}

	/**
	 * 删除招聘信息
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/zhaopin_delete")
	public String delete(HttpServletRequest request) throws Exception {
		// 根据id删除数据库记录
		int id = Integer.parseInt(request.getParameter("id"));
		zhaopinService.deleteZhaopin(id);
		return "redirect:zhaopin_list.action";
	}

	/**
	 * 查看招聘信息详情
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/zhaopin_toView")
	public String toView(HttpServletRequest request) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		// 根据ID查询出记录放到request中，到前台jsp界面显示
		Zhaopin zhaopin = zhaopinService.queryZhaopinById(id);
		request.setAttribute("zhaopin", zhaopin);
		return "/admin/zhaopin/zhaopin_view.jsp";
	}
}
