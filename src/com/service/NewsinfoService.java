package com.service;

import java.util.List;
import com.util.PageBean;
import com.model.Newsinfo;

/**
 * 消息通知Service接口
 */
public interface NewsinfoService {
	/**
	 * 查询消息通知记录数
	 * 
	 * @param newsinfo
	 * @return
	 */
	public int getCount(Newsinfo newsinfo);

	/**
	 * 查询所有消息通知
	 * 
	 * @return
	 */
	public List<Newsinfo> queryNewsinfoList(Newsinfo newsinfo, PageBean page)
			throws Exception;

	/**
	 * 保存消息通知
	 * 
	 * @param newsinfo
	 * @return
	 */
	public int insertNewsinfo(Newsinfo newsinfo) throws Exception;

	/**
	 * 删除消息通知
	 * 
	 * @param id
	 * @return
	 */
	public int deleteNewsinfo(int id) throws Exception;

	/**
	 * 更新消息通知
	 * 
	 * @param newsinfo
	 * @return
	 */
	public int updateNewsinfo(Newsinfo newsinfo) throws Exception;

	/**
	 * 根据ID查询记录
	 * 
	 * @param id
	 * @return
	 */
	public Newsinfo queryNewsinfoById(int id) throws Exception;
}
