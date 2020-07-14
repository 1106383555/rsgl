package com.mapper;

import com.model.Newsinfo;
import java.util.List;
import java.util.Map;

public interface NewsinfoMapper {
	/**
	 * 查询所有消息通知
	 * 
	 * @return
	 */
	public List<Newsinfo> query(Map<String, Object> inputParam);

	/**
	 * 查询消息通知记录数
	 * 
	 * @param inputParam
	 * @return
	 */
	public int getCount(Map<String, Object> inputParam);

	/**
	 * 保存消息通知
	 * 
	 * @param newsinfo
	 * @return
	 */
	public int insertNewsinfo(Newsinfo newsinfo);

	/**
	 * 删除消息通知
	 * 
	 * @param id
	 * @return
	 */
	public int deleteNewsinfo(int id);

	/**
	 * 更新消息通知
	 * 
	 * @param newsinfo
	 * @return
	 */
	public int updateNewsinfo(Newsinfo newsinfo);

	/**
	 * 根据ID查询记录
	 * 
	 * @param id
	 * @return
	 */
	public Newsinfo queryNewsinfoById(int id);
}
