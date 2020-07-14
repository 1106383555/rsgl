package com.mapper;

import com.model.Zhaopin;
import java.util.List;
import java.util.Map;

public interface ZhaopinMapper {
	/**
	 * 查询所有招聘信息
	 * 
	 * @return
	 */
	public List<Zhaopin> query(Map<String, Object> inputParam);

	/**
	 * 查询招聘信息记录数
	 * 
	 * @param inputParam
	 * @return
	 */
	public int getCount(Map<String, Object> inputParam);

	/**
	 * 保存招聘信息
	 * 
	 * @param zhaopin
	 * @return
	 */
	public int insertZhaopin(Zhaopin zhaopin);

	/**
	 * 删除招聘信息
	 * 
	 * @param id
	 * @return
	 */
	public int deleteZhaopin(int id);

	/**
	 * 更新招聘信息
	 * 
	 * @param zhaopin
	 * @return
	 */
	public int updateZhaopin(Zhaopin zhaopin);

	/**
	 * 根据ID查询记录
	 * 
	 * @param id
	 * @return
	 */
	public Zhaopin queryZhaopinById(int id);
}
