package com.model;

/**
 * 用户信息Model类
 */
public class Yuangong {
	public Yuangong() {
	}

	/**
	 * id
	 */
	private Integer id;
	/**
	 * 员工编号
	 */
	private String yno;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 出生日期
	 */
	private String csrq;
	/**
	 * 联系电话
	 */
	private String tel;
	/**
	 * 密码
	 */
	private String pwd;
	/**
	 * 部门
	 */
	private Integer bid;
	private Bumen bumenVO;

	/**
	 * 职位
	 */
	private String roles;

	/**
	 * 状态
	 */
	private String state;
	/**
	 * 电子档案
	 */
	private String fujian;
	/**
	 * 时间
	 */
	private String cdate;
	
	private String qtype;
	private Integer qid;
	
	

	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

	public Integer getQid() {
		return qid;
	}

	public void setQid(Integer qid) {
		this.qid = qid;
	}

	public String getCdate() {
		return cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getFujian() {
		return fujian;
	}

	public void setFujian(String fujian) {
		this.fujian = fujian;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getYno() {
		return this.yno;
	}

	public void setYno(String yno) {
		this.yno = yno;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCsrq() {
		return this.csrq;
	}

	public void setCsrq(String csrq) {
		this.csrq = csrq;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getBid() {
		return this.bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public Bumen getBumenVO() {
		return this.bumenVO;
	}

	public void setBumenVO(Bumen bumenVO) {
		this.bumenVO = bumenVO;
	}

}
