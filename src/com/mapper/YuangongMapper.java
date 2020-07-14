package com.mapper;

import com.model.Yuangong;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface YuangongMapper {
	/**
	 * 查询所有用户信息
	 * 
	 * @return
	 */
	public List<Yuangong> query(Map<String, Object> inputParam);

	/**
	 * 查询用户信息记录数
	 * 
	 * @param inputParam
	 * @return
	 */
	public int getCount(Map<String, Object> inputParam);

	/**
	 * 保存用户信息
	 * 
	 * @param yuangong
	 * @return
	 */
	public int insertYuangong(Yuangong yuangong);

	/**
	 * 删除用户信息
	 * 
	 * @param id
	 * @return
	 */
	public int deleteYuangong(int id);

	/**
	 * 更新用户信息
	 * 
	 * @param yuangong
	 * @return
	 */
	public int updateYuangong(Yuangong yuangong);

	/**
	 * 根据ID查询记录
	 * 
	 * @param id
	 * @return
	 */
	public Yuangong queryYuangongById(int id);
	
	
	/*
	 * 查询申请员工
	 */
	
	public List<Yuangong> selectshen(String state);
	
	/*
	 * 根据部门查询申请员工
	 */
	public List<Yuangong> selectshenbybid(@Param("state")String state,@Param("bid")Integer bid);
	
	
	
	
	
	
	
	
	
	
}
