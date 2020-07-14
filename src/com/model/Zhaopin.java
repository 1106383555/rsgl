package com.model;

/**
 * 招聘信息Model类
 */
public class Zhaopin {
	public Zhaopin() {
	}

	/**
	 * id
	 */
	private Integer id;
	/**
	 * 职位
	 */
	private String name;
	/**
	 * 内容
	 */
	private String contents;
	/**
	 * 发布时间
	 */
	private String fbsj;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getFbsj() {
		return this.fbsj;
	}

	public void setFbsj(String fbsj) {
		this.fbsj = fbsj;
	}
}
