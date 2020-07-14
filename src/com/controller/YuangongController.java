package com.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Bumen;
import com.model.Yuangong;
import com.service.BumenService;
import com.service.YuangongService;
import com.util.MD5Util;
import com.util.PageBean;

/**
 * 用户信息Controller业务控制类
 */
@Controller
public class YuangongController {
	/**
	 * 注入Service
	 */
	@Autowired
	private YuangongService yuangongService;
	@Autowired
	private BumenService bumenService;

	/**
	 * 用户信息列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/yuangong_list")
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
		Yuangong yuangong = new Yuangong();
		int utype = Integer.parseInt(request.getSession().getAttribute("utype")+"");
		
		PageBean page = new PageBean(offset);
	
		String yno = request.getParameter("yno");
		yuangong.setYno(yno);
		request.setAttribute("yno", yno);
		String name = request.getParameter("name");
		yuangong.setName(name);
		request.setAttribute("name", name);
		String pwd = request.getParameter("pwd");
		yuangong.setPwd(pwd);
		request.setAttribute("pwd", pwd);
		
		
		if(utype==2){//员工  看见自己和部门领导
			Yuangong yinfo = (Yuangong) request.getSession().getAttribute("cuser");
			yuangong.setQtype("员工");
			yuangong.setQid(yinfo.getId());
			yuangong.setBid(yinfo.getBid());
		}
	    if(utype==3){//领导 查看本部门人员
	    	Yuangong yinfo = (Yuangong) request.getSession().getAttribute("cuser");
	    	yuangong.setBid(yinfo.getBid());
		}
	    if(utype==0){
	    	String bid = request.getParameter("bid");
			yuangong.setBid(Integer.parseInt(bid == null || "".equals(bid) ? "0"
					: bid));
			request.setAttribute("bid", bid);
			
	    }
	    
	    
		yuangong.setState("在职");
		// 查询记录总数
		counts = yuangongService.getCount(yuangong);
		// 获取当前页记录
		List yuangongList = yuangongService.queryYuangongList(yuangong, page);
		request.setAttribute("list", yuangongList);
		Bumen bumenQuery = new Bumen();
		List<Bumen> bumenList = bumenService.queryBumenList(bumenQuery, null);
		request.setAttribute("bumenList", bumenList);
		// 将分页相关参数放到request中
		request.setAttribute("itemSize", counts);
		int page_count = counts % PageBean.PAGE_IETM == 0 ? counts
				/ PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
		request.setAttribute("pageItem", PageBean.PAGE_IETM);
		request.setAttribute("pageTotal", page_count);
		return "/admin/yuangong/yuangong_list.jsp";
	}

	
	//员工信息录
	@RequestMapping(value = "/yuangongLists")
	public String YuangongList(HttpServletRequest request) throws Exception{
		/**
		 * 获取分页参数
		 */
		int offset = 0; // 记录偏移量
		int counts = 0; // 总记录数
		try {
			offset = Integer.parseInt(request.getParameter("pager.offset"));
		} catch (Exception e) {
		}
		Yuangong yuangong = new Yuangong();
		int utype =0;
		
		PageBean page = new PageBean(offset);
	
		String yno = request.getParameter("yno");
		yuangong.setYno(yno);
		request.setAttribute("yno", yno);
		String name = request.getParameter("name");
		yuangong.setName(name);
		request.setAttribute("name", name);
		String pwd = request.getParameter("pwd");
		yuangong.setPwd(pwd);
		request.setAttribute("pwd", pwd);
		
		
//		if(utype==2){//员工  看见自己和部门领导
//			Yuangong yinfo = (Yuangong) request.getSession().getAttribute("cuser");
//			yuangong.setQtype("员工");
//			yuangong.setQid(yinfo.getId());
//			yuangong.setBid(yinfo.getBid());
//		}
//	    if(utype==3){//领导 查看本部门人员
//	    	Yuangong yinfo = (Yuangong) request.getSession().getAttribute("cuser");
//	    	yuangong.setBid(yinfo.getBid());
//		}
//	    if(utype==0){
	    	String bid = request.getParameter("bid");
			yuangong.setBid(Integer.parseInt(bid == null || "".equals(bid) ? "0"
					: bid));
			request.setAttribute("bid", bid);
			
//	    }
	    
	    
		yuangong.setState("在职");
		// 查询记录总数
		counts = yuangongService.getCount(yuangong);
		// 获取当前页记录
		List yuangongList = yuangongService.queryYuangongList(yuangong, page);
		request.setAttribute("list", yuangongList);
		Bumen bumenQuery = new Bumen();
		List<Bumen> bumenList = bumenService.queryBumenList(bumenQuery, null);
		request.setAttribute("bumenList", bumenList);
		// 将分页相关参数放到request中
		request.setAttribute("itemSize", counts);
		int page_count = counts % PageBean.PAGE_IETM == 0 ? counts
				/ PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
		request.setAttribute("pageItem", PageBean.PAGE_IETM);
		request.setAttribute("pageTotal", page_count);
		return "/admin/yuangong/emplist.jsp";
	}
	
	
	//员工个人信息界面
	@RequestMapping(value = "/myinfo")
	public String myinfo(HttpServletRequest request) throws Exception {
		Yuangong yinfo = (Yuangong) request.getSession().getAttribute("cuser");
		Integer idInteger=yinfo.getId();
		Yuangong yuangong=yuangongService.queryYuangongById(idInteger);
		List<Yuangong> list=new ArrayList<Yuangong>();
		list.add(yuangong);
		request.setAttribute("list",list);
		return "/admin/yuangong/myinfo.jsp";
	}
	
	
	/**
	 * 离职信息列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/yuangong_lzlist")
	public String lzlist(HttpServletRequest request) throws Exception {
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
		Yuangong yuangong = new Yuangong();
		String yno = request.getParameter("yno");
		yuangong.setYno(yno);
		request.setAttribute("yno", yno);
		String name = request.getParameter("name");
		yuangong.setName(name);
		request.setAttribute("name", name);
		String pwd = request.getParameter("pwd");
		yuangong.setPwd(pwd);
		request.setAttribute("pwd", pwd);
		String bid = request.getParameter("bid");
		yuangong.setBid(Integer.parseInt(bid == null || "".equals(bid) ? "0"
				: bid));
		request.setAttribute("bid", bid);
		yuangong.setState("离职");
		// 查询记录总数
		counts = yuangongService.getCount(yuangong);
		// 获取当前页记录
		List yuangongList = yuangongService.queryYuangongList(yuangong, page);
		request.setAttribute("list", yuangongList);
		Bumen bumenQuery = new Bumen();
		List<Bumen> bumenList = bumenService.queryBumenList(bumenQuery, null);
		request.setAttribute("bumenList", bumenList);
		// 将分页相关参数放到request中
		request.setAttribute("itemSize", counts);
		int page_count = counts % PageBean.PAGE_IETM == 0 ? counts
				/ PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
		request.setAttribute("pageItem", PageBean.PAGE_IETM);
		request.setAttribute("pageTotal", page_count);
		return "/admin/yuangong/yuangong_lzlist.jsp";
	}

	/**
	 * 退休员工信息列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/yuangong_txlist")
	public String txlist(HttpServletRequest request) throws Exception {
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
		Yuangong yuangong = new Yuangong();
		String yno = request.getParameter("yno");
		yuangong.setYno(yno);
		request.setAttribute("yno", yno);
		String name = request.getParameter("name");
		yuangong.setName(name);
		request.setAttribute("name", name);
		String pwd = request.getParameter("pwd");
		yuangong.setPwd(pwd);
		request.setAttribute("pwd", pwd);
		String bid = request.getParameter("bid");
		yuangong.setBid(Integer.parseInt(bid == null || "".equals(bid) ? "0"
				: bid));
		request.setAttribute("bid", bid);
		yuangong.setState("退休");
		// 查询记录总数
		counts = yuangongService.getCount(yuangong);
		// 获取当前页记录
		List yuangongList = yuangongService.queryYuangongList(yuangong, page);
		request.setAttribute("list", yuangongList);
		Bumen bumenQuery = new Bumen();
		List<Bumen> bumenList = bumenService.queryBumenList(bumenQuery, null);
		request.setAttribute("bumenList", bumenList);
		// 将分页相关参数放到request中
		request.setAttribute("itemSize", counts);
		int page_count = counts % PageBean.PAGE_IETM == 0 ? counts
				/ PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
		request.setAttribute("pageItem", PageBean.PAGE_IETM);
		request.setAttribute("pageTotal", page_count);
		return "/admin/yuangong/yuangong_txlist.jsp";
	}

	/**
	 * 跳转到新增用户信息界面
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/yuangong_toAdd")
	public String toAdd(HttpServletRequest request) throws Exception {
		Bumen bumen = new Bumen();
		int utype = Integer.parseInt(request.getSession().getAttribute("utype")+"");
		if(utype==3){
			Yuangong yinfo = (Yuangong) request.getSession().getAttribute("cuser");
			bumen.setId(yinfo.getBid());
		}
		
		
		List<Bumen> bumenList = bumenService.queryBumenList(bumen, null);
		request.setAttribute("bumenList", bumenList);
		return "/admin/yuangong/yuangong_add.jsp";
	}

	/**
	 * 保存新增用户信息
	 * 
	 * @param yuangong
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/yuangong_add")
	public String add(Yuangong yuangong, HttpServletRequest request)
			throws Exception {
		// 保存到数据库
		yuangong.setState("在职");
		
		//把用户名密码存到session中，用来发送邮件
		HttpSession session=request.getSession();
		session.setAttribute("yno", yuangong.getYno());
		session.setAttribute("pwd", yuangong.getPwd());
		
		//密码加密
//		String MD5password=MD5Util.MD5EncodeUtf8(yuangong.getPwd());
//		yuangong.setPwd(MD5password);
		
		
		yuangongService.insertYuangong(yuangong);
//		return "redirect:yuangong_list.action";
		return "/admin/yuangong/mail.jsp";
	}

	/**
	 * 成功发送邮箱
	 * @throws Exception 
	 */
	@RequestMapping(value="/fasong")
	public String fasongmail(HttpServletRequest req) throws Exception {
		HttpSession session1=req.getSession();
        req.setCharacterEncoding("utf-8");
        String mail = req.getParameter("mail");
        String yno = (String) session1.getAttribute("yno");
        String pwd = (String) session1.getAttribute("pwd");
      //设置必要的集合信息，可以使用map或其他形式
        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.163.com");// smtp服务器地址
        Session session = Session.getInstance(props);
        session.setDebug(true);
        //设置发送信息
        Message msg = new MimeMessage(session);
        msg.setSubject("您的账户密码已激活，请查看");
        msg.setText("您的账号为"+yno+","+"密码为"+pwd+",请登录管理系统http://localhost:8080/rsgl/");
        msg.setFrom(new InternetAddress("13731769025@163.com"));//发件人邮箱(我的163邮箱)
        msg.setRecipient(Message.RecipientType.TO,
                new InternetAddress(mail)); //收件人邮箱(我的QQ邮箱)
        msg.saveChanges();
        Transport transport = session.getTransport();
        transport.connect("13731769025@163.com", "JISIXBADCPZJHXDW");//发件人邮箱,授权码(可以在邮箱设置中获取到授权码的信息)

        transport.sendMessage(msg, msg.getAllRecipients());

        System.out.println("邮件发送成功...");
        transport.close();
//        System.out.println(mail);
//        System.out.println(yno);
//        System.out.println(pwd);
		return "redirect:yuangong_list.action";
	}
	
	
	
	
	/**
	 * 离职
	 * 
	 * @param yuangong
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/yuangong_lizhi")
	public String lizhi(HttpServletRequest request) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		// 根据ID查询出需要更新的记录
		Yuangong yuangong = yuangongService.queryYuangongById(id);
		// 保存到数据库
		yuangong.setState("离职");
		yuangongService.updateYuangong(yuangong);
		return "redirect:yuangong_list.action";
	}

	/**
	 * 退休
	 * 
	 * @param yuangong
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/yuangong_tuixiu")
	public String tuixiu(HttpServletRequest request) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		// 根据ID查询出需要更新的记录
		Yuangong yuangong = yuangongService.queryYuangongById(id);
		// 保存到数据库
		yuangong.setState("退休");
		yuangongService.updateYuangong(yuangong);
		return "redirect:yuangong_list.action";
	}
	
	//退休申请
	@RequestMapping(value = "/tuixius")
	public String tuixius(HttpServletRequest request) throws Exception{
		Yuangong yinfo = (Yuangong) request.getSession().getAttribute("cuser");
		yinfo.setState("退休申请");
		yuangongService.updateYuangong(yinfo);
		return "redirect:myinfo.action";
	}
	
	//部门经理帮助退休申请
	@RequestMapping(value = "/btuixius")
	public String btuixius(HttpServletRequest request) throws Exception{
		int id = Integer.parseInt(request.getParameter("id"));
		// 根据ID查询出需要更新的记录
		Yuangong yuangong = yuangongService.queryYuangongById(id);
		// 保存到数据库
		yuangong.setState("退休申请");
		yuangongService.updateYuangong(yuangong);
		return "redirect:yuangong_list.action";
	}
	//离职申请
	@RequestMapping(value = "/lizhis")
	public String lizhis(HttpServletRequest request) throws Exception{
		Yuangong yinfo = (Yuangong) request.getSession().getAttribute("cuser");
		System.out.println(yinfo.getState());
		yinfo.setState("离职申请");
		System.out.println(yinfo.getState());
		yuangongService.updateYuangong(yinfo);
		return "redirect:myinfo.action";
	}
	
	//部门经理帮助离职申请
	@RequestMapping(value = "/blizhis")
	public String blizhis(HttpServletRequest request) throws Exception{
		int id = Integer.parseInt(request.getParameter("id"));
		// 根据ID查询出需要更新的记录
		Yuangong yuangong = yuangongService.queryYuangongById(id);
		// 保存到数据库
		yuangong.setState("离职申请");
		yuangongService.updateYuangong(yuangong);
		return "redirect:yuangong_list.action";
	}
	
	//取消申请
	@RequestMapping(value = "/quxiaos")
	public String quxiaos(HttpServletRequest request) throws Exception{
		Yuangong yinfo = (Yuangong) request.getSession().getAttribute("cuser");
		System.out.println(yinfo.getState());
		yinfo.setState("在职");
		System.out.println(yinfo.getState());
		yuangongService.updateYuangong(yinfo);
		return "redirect:myinfo.action";
	}
	

	/**
	 * 跳转到更新用户信息界面
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/yuangong_toUpdate")
	public String toUpdate(HttpServletRequest request) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		// 根据ID查询出需要更新的记录
		Yuangong yuangong = yuangongService.queryYuangongById(id);
		request.setAttribute("yuangong", yuangong);
		Bumen bumen = new Bumen();
		List<Bumen> bumenList = bumenService.queryBumenList(bumen, null);
		request.setAttribute("bumenList", bumenList);
		return "/admin/yuangong/yuangong_update.jsp";
	}

	/**
	 * 更新用户信息
	 * 
	 * @param yuangong
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/yuangong_update")
	public String update(Yuangong yuangong, HttpServletRequest request)
			throws Exception {
		// 更新数据库
		yuangongService.updateYuangong(yuangong);
		return "redirect:yuangong_list.action";
	}

	/**
	 * 更新电子档案
	 * 
	 * @param yuangong
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/yuangong_updateInfo")
	public String updateInfo(HttpServletRequest request)
			throws Exception {
		// 更新数据库
		int id = Integer.parseInt(request.getParameter("id"));
		String fujian = request.getParameter("fujian");
		// 根据ID查询出需要更新的记录
		Yuangong yuangong = yuangongService.queryYuangongById(id);
		yuangong.setFujian(fujian);
		yuangongService.updateYuangong(yuangong);
		request.getSession().setAttribute("cuser", yuangong);
		return "redirect:admin/yuangong/yuangong_info.jsp";
	}

	/**
	 * 删除用户信息
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/yuangong_delete")
	public String delete(HttpServletRequest request) throws Exception {
		// 根据id删除数据库记录
		int id = Integer.parseInt(request.getParameter("id"));
		yuangongService.deleteYuangong(id);
		return "redirect:yuangong_list.action";
	}

	/**
	 * 查看用户信息详情
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/yuangong_toView")
	public String toView(HttpServletRequest request) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		// 根据ID查询出记录放到request中，到前台jsp界面显示
		Yuangong yuangong = new Yuangong();
		yuangong.setId(id);
		List<Yuangong> list = yuangongService.queryYuangongList(yuangong, null);
		yuangong = list.get(0);
		request.setAttribute("yuangong", yuangong);
		return "/admin/yuangong/yuangong_view.jsp";
	}

	/**
	 * 判断员工编号是否存在
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/yuangong_ynoExist")
	public String ynoExist(HttpServletRequest request) throws Exception {
		String exist = "true";
		String yno = request.getParameter("yno");
		Yuangong yuangong = new Yuangong();
		yuangong.setYno(yno);
		List list = yuangongService.queryYuangongList(yuangong, null);
		if (list != null && list.size() > 0) {
			exist = "false"; // 验证插件需要返回false 返回false时验证提示已存在
		}
		return exist;
	}
	
	//查询退休申请的员工
	@RequestMapping(value = "/selecttuishen")
	public String selecttuishen(HttpServletRequest request) throws Exception{
		List<Yuangong> yuangongs=yuangongService.selectshen("退休申请");
		request.setAttribute("yuangongs", yuangongs);
		return "/admin/yuangong/tuixiushen.jsp";
	}
	
	//根据部门查询退休申请的员工
	@RequestMapping(value = "/selecttuishenbybid")
	public String selecttuishenbybid(HttpServletRequest request) throws Exception{
		Yuangong yinfo = (Yuangong) request.getSession().getAttribute("cuser");
		
		System.out.println(yinfo);
		
		Integer bid=yinfo.getBid();
		
		System.out.println(bid);
		
		List<Yuangong> yuangongs=yuangongService.selectshenbybid("退休申请", bid);
		
		System.out.println(yuangongs);
		
		request.setAttribute("yuangongs", yuangongs);
		return "/admin/yuangong/tuixiushen.jsp";
	}
	
	
	//查询离职申请的员工
	@RequestMapping(value = "/selectlishen")
	public String selectlishen(HttpServletRequest request) throws Exception{
		List<Yuangong> yuangongs=yuangongService.selectshen("离职申请");
		request.setAttribute("yuangongs", yuangongs);
		return "/admin/yuangong/lizhishen.jsp";
	}
	
	//根据部门查询离职申请的员工
	@RequestMapping(value = "/selectlishenbybid")
	public String selectlishenbybid(HttpServletRequest request) throws Exception{
		Yuangong yinfo = (Yuangong) request.getSession().getAttribute("cuser");
		Integer bid=yinfo.getBid();
		List<Yuangong> yuangongs=yuangongService.selectshenbybid("离职申请", bid);
		request.setAttribute("yuangongs", yuangongs);
		return "/admin/yuangong/tuixiushen.jsp";
	}
	
	//驳回退休申请
	@RequestMapping(value = "/bohuit")
	public String bohuit(HttpServletRequest request) throws Exception{
		//查询该用户的id
		int id = Integer.parseInt(request.getParameter("id"));
		// 根据ID查询出需要更新的记录
		Yuangong yuangong = yuangongService.queryYuangongById(id);
		// 保存到数据库
		yuangong.setState("在职");
		yuangongService.updateYuangong(yuangong);
		return "redirect:selecttuishen.action";
	}
	
	//驳回退休申请
	@RequestMapping(value = "/bohuil")
	public String bohuil(HttpServletRequest request) throws Exception{
		//查询该用户的id
		int id = Integer.parseInt(request.getParameter("id"));
		// 根据ID查询出需要更新的记录
		Yuangong yuangong = yuangongService.queryYuangongById(id);
		// 保存到数据库
		yuangong.setState("在职");
		yuangongService.updateYuangong(yuangong);
		return "redirect:selectlishen.action";
	}
	
	 
}
