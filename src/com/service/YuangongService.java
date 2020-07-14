package com.service;

import java.util.List;
import com.util.PageBean;
import com.model.Yuangong;

/**
 * 用户信息Service接口
 */
public interface YuangongService {
	/**
	 * 查询用户信息记录数
	 * 
	 * @param yuangong
	 * @return
	 */
	public int getCount(Yuangong yuangong);

	/**
	 * 查询所有用户信息
	 * 
	 * @return
	 */
	public List<Yuangong> queryYuangongList(Yuangong yuangong, PageBean page)
			throws Exception;

//	/*
//	 * 查询所有的用户信息，用作员工信息录
//	 */
//	public List<Yuangong> selectYuangongs();
//	
	
	
	
	
	
	/**
	 * 保存用户信息
	 * 
	 * @param yuangong
	 * @return
	 */
	public int insertYuangong(Yuangong yuangong) throws Exception;

	/**
	 * 删除用户信息
	 * 
	 * @param id
	 * @return
	 */
	public int deleteYuangong(int id) throws Exception;

	/**
	 * 更新用户信息
	 * 
	 * @param yuangong
	 * @return
	 */
	public int updateYuangong(Yuangong yuangong) throws Exception;

	/**
	 * 根据ID查询记录
	 * 
	 * @param id
	 * @return
	 */
	public Yuangong queryYuangongById(int id) throws Exception;
	
	
	
	/*
	 * 查询申请
	 */
	
	public List<Yuangong> selectshen(String state);
	
	/*
	 * 根据部门查询申请员工
	 */
	public List<Yuangong> selectshenbybid(String state,Integer bid);
	
	
	
	
	
	
	
	
	
}
