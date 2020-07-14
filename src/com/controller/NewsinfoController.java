package com.controller;

import com.model.Newsinfo;
import com.service.NewsinfoService;
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
 * 消息通知Controller业务控制类
 */
@Controller
public class NewsinfoController {
	/**
	 * 注入Service
	 */
	@Autowired
	private NewsinfoService newsinfoService;

	/**
	 * 消息通知列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/newsinfo_list")
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
		Newsinfo newsinfo = new Newsinfo();
		String title = request.getParameter("title");
		newsinfo.setTitle(title);
		request.setAttribute("title", title);
		// 查询记录总数
		counts = newsinfoService.getCount(newsinfo);
		// 获取当前页记录
		List newsinfoList = newsinfoService.queryNewsinfoList(newsinfo, page);
		request.setAttribute("list", newsinfoList);
		// 将分页相关参数放到request中
		request.setAttribute("itemSize", counts);
		int page_count = counts % PageBean.PAGE_IETM == 0 ? counts
				/ PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
		request.setAttribute("pageItem", PageBean.PAGE_IETM);
		request.setAttribute("pageTotal", page_count);
		return "/admin/newsinfo/newsinfo_list.jsp";
	}

	/**
	 * 跳转到新增消息通知界面
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/newsinfo_toAdd")
	public String toAdd(HttpServletRequest request) throws Exception {
		return "/admin/newsinfo/newsinfo_add.jsp";
	}

	/**
	 * 保存新增消息通知
	 * 
	 * @param newsinfo
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/newsinfo_add")
	public String add(Newsinfo newsinfo, HttpServletRequest request)
			throws Exception {
		// 保存到数据库
		newsinfo.setFbsj(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		newsinfoService.insertNewsinfo(newsinfo);
		return "redirect:newsinfo_list.action";
	}

	/**
	 * 跳转到更新消息通知界面
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/newsinfo_toUpdate")
	public String toUpdate(HttpServletRequest request) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		// 根据ID查询出需要更新的记录
		Newsinfo newsinfo = newsinfoService.queryNewsinfoById(id);
		request.setAttribute("newsinfo", newsinfo);
		return "/admin/newsinfo/newsinfo_update.jsp";
	}

	/**
	 * 更新消息通知
	 * 
	 * @param newsinfo
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/newsinfo_update")
	public String update(Newsinfo newsinfo, HttpServletRequest request)
			throws Exception {
		// 更新数据库
		newsinfoService.updateNewsinfo(newsinfo);
		return "redirect:newsinfo_list.action";
	}

	/**
	 * 删除消息通知
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/newsinfo_delete")
	public String delete(HttpServletRequest request) throws Exception {
		// 根据id删除数据库记录
		int id = Integer.parseInt(request.getParameter("id"));
		newsinfoService.deleteNewsinfo(id);
		return "redirect:newsinfo_list.action";
	}

	/**
	 * 查看消息通知详情
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/newsinfo_toView")
	public String toView(HttpServletRequest request) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		// 根据ID查询出记录放到request中，到前台jsp界面显示
		Newsinfo newsinfo = newsinfoService.queryNewsinfoById(id);
		request.setAttribute("newsinfo", newsinfo);
		return "/admin/newsinfo/newsinfo_view.jsp";
	}
}
