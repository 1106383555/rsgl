package com.service;

import java.util.List;
import com.util.PageBean;
import com.model.Bumen;

/**
 * 部门信息Service接口
 */
public interface BumenService {
	/**
	 * 查询部门信息记录数
	 * 
	 * @param bumen
	 * @return
	 */
	public int getCount(Bumen bumen);

	/**
	 * 查询所有部门信息
	 * 
	 * @return
	 */
	public List<Bumen> queryBumenList(Bumen bumen, PageBean page)
			throws Exception;

	/**
	 * 保存部门信息
	 * 
	 * @param bumen
	 * @return
	 */
	public int insertBumen(Bumen bumen) throws Exception;

	/**
	 * 删除部门信息
	 * 
	 * @param id
	 * @return
	 */
	public int deleteBumen(int id) throws Exception;

	/**
	 * 更新部门信息
	 * 
	 * @param bumen
	 * @return
	 */
	public int updateBumen(Bumen bumen) throws Exception;

	/**
	 * 根据ID查询记录
	 * 
	 * @param id
	 * @return
	 */
	public Bumen queryBumenById(int id) throws Exception;
}
