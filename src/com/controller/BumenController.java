package com.controller;

import com.model.Bumen;
import com.service.BumenService;
import com.util.PageBean;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 部门信息Controller业务控制类
 */
@Controller
public class BumenController {
	/**
	 * 注入Service
	 */
	@Autowired
	private BumenService bumenService;

	/**
	 * 部门信息列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/bumen_list")
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
		Bumen bumen = new Bumen();
		String name = request.getParameter("name");
		bumen.setName(name);
		request.setAttribute("name", name);
		// 查询记录总数
		counts = bumenService.getCount(bumen);
		// 获取当前页记录
		List bumenList = bumenService.queryBumenList(bumen, page);
		request.setAttribute("list", bumenList);
		// 将分页相关参数放到request中
		request.setAttribute("itemSize", counts);
		int page_count = counts % PageBean.PAGE_IETM == 0 ? counts
				/ PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
		request.setAttribute("pageItem", PageBean.PAGE_IETM);
		request.setAttribute("pageTotal", page_count);
		return "/admin/bumen/bumen_list.jsp";
	}

	/**
	 * 跳转到新增部门信息界面
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/bumen_toAdd")
	public String toAdd(HttpServletRequest request) throws Exception {
		return "/admin/bumen/bumen_add.jsp";
	}

	/**
	 * 保存新增部门信息
	 * 
	 * @param bumen
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/bumen_add")
	public String add(Bumen bumen, HttpServletRequest request) throws Exception {
		// 保存到数据库
		bumenService.insertBumen(bumen);
		return "redirect:bumen_list.action";
	}

	/**
	 * 跳转到更新部门信息界面
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/bumen_toUpdate")
	public String toUpdate(HttpServletRequest request) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		// 根据ID查询出需要更新的记录
		Bumen bumen = bumenService.queryBumenById(id);
		request.setAttribute("bumen", bumen);
		return "/admin/bumen/bumen_update.jsp";
	}

	/**
	 * 更新部门信息
	 * 
	 * @param bumen
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/bumen_update")
	public String update(Bumen bumen, HttpServletRequest request)
			throws Exception {
		// 更新数据库
		bumenService.updateBumen(bumen);
		return "redirect:bumen_list.action";
	}

	/**
	 * 删除部门信息
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/bumen_delete")
	public String delete(HttpServletRequest request) throws Exception {
		// 根据id删除数据库记录
		int id = Integer.parseInt(request.getParameter("id"));
		bumenService.deleteBumen(id);
		return "redirect:bumen_list.action";
	}

	/**
	 * 查看部门信息详情
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/bumen_toView")
	public String toView(HttpServletRequest request) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		// 根据ID查询出记录放到request中，到前台jsp界面显示
		Bumen bumen = bumenService.queryBumenById(id);
		request.setAttribute("bumen", bumen);
		return "/admin/bumen/bumen_view.jsp";
	}
}
