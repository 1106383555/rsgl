package com.service;

import java.util.List;
import com.util.PageBean;
import com.model.Zhaopin;

/**
 * 招聘信息Service接口
 */
public interface ZhaopinService {
	/**
	 * 查询招聘信息记录数
	 * 
	 * @param zhaopin
	 * @return
	 */
	public int getCount(Zhaopin zhaopin);

	/**
	 * 查询所有招聘信息
	 * 
	 * @return
	 */
	public List<Zhaopin> queryZhaopinList(Zhaopin zhaopin, PageBean page)
			throws Exception;

	/**
	 * 保存招聘信息
	 * 
	 * @param zhaopin
	 * @return
	 */
	public int insertZhaopin(Zhaopin zhaopin) throws Exception;

	/**
	 * 删除招聘信息
	 * 
	 * @param id
	 * @return
	 */
	public int deleteZhaopin(int id) throws Exception;

	/**
	 * 更新招聘信息
	 * 
	 * @param zhaopin
	 * @return
	 */
	public int updateZhaopin(Zhaopin zhaopin) throws Exception;

	/**
	 * 根据ID查询记录
	 * 
	 * @param id
	 * @return
	 */
	public Zhaopin queryZhaopinById(int id) throws Exception;
}
