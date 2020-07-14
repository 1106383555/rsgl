package com.model;

/**
 * 部门信息Model类
 */
public class Bumen {
	public Bumen() {
	}

	/**
	 * id
	 */
	private Integer id;
	/**
	 * 部门名称
	 */
	private String name;

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
}
