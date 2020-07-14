package com.mapper;

import com.model.Bumen;
import java.util.List;
import java.util.Map;

public interface BumenMapper {
	/**
	 * 查询所有部门信息
	 * 
	 * @return
	 */
	public List<Bumen> query(Map<String, Object> inputParam);

	/**
	 * 查询部门信息记录数
	 * 
	 * @param inputParam
	 * @return
	 */
	public int getCount(Map<String, Object> inputParam);

	/**
	 * 保存部门信息
	 * 
	 * @param bumen
	 * @return
	 */
	public int insertBumen(Bumen bumen);

	/**
	 * 删除部门信息
	 * 
	 * @param id
	 * @return
	 */
	public int deleteBumen(int id);

	/**
	 * 更新部门信息
	 * 
	 * @param bumen
	 * @return
	 */
	public int updateBumen(Bumen bumen);

	/**
	 * 根据ID查询记录
	 * 
	 * @param id
	 * @return
	 */
	public Bumen queryBumenById(int id);
}
