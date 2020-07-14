package com.model;

/**
 * 消息通知Model类
 */
public class Newsinfo {
	public Newsinfo() {
	}

	/**
	 * id
	 */
	private Integer id;
	/**
	 * 标题
	 */
	private String title;
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

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
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
