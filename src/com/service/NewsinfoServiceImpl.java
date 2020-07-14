package com.service;

import java.util.List;
import com.model.Newsinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import com.util.PageBean;
import java.util.Map;
import com.mapper.NewsinfoMapper;

/**
 * 消息通知Service实现类
 */
@Service
public class NewsinfoServiceImpl implements NewsinfoService {
	/**
	 * 注入mapper
	 */
	@Autowired
	private NewsinfoMapper newsinfoMapper;

	/**
	 * 查询消息通知记录数
	 * 
	 * @param newsinfo
	 * @return
	 */
	public int getCount(Newsinfo newsinfo) {
		Map<String, Object> map = getQueryMap(newsinfo, null);
		return newsinfoMapper.getCount(map);
	}

	/**
	 * 查询所有消息通知
	 * 
	 * @return
	 */
	public List<Newsinfo> queryNewsinfoList(Newsinfo newsinfo, PageBean page)
			throws Exception {
		Map<String, Object> map = getQueryMap(newsinfo, page);
		List<Newsinfo> list = newsinfoMapper.query(map);
		return list;
	}

	/**
	 * 封装查询条件
	 * 
	 * @param newsinfo
	 * @param page
	 * @return
	 */
	private Map<String, Object> getQueryMap(Newsinfo newsinfo, PageBean page) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (newsinfo != null) {
			map.put("id", newsinfo.getId());
			map.put("title", newsinfo.getTitle());
		}
		if (page != null) {
			PageBean.setPageMap(map, page);
		}
		return map;
	}

	/**
	 * 保存消息通知
	 * 
	 * @param newsinfo
	 * @return
	 */
	public int insertNewsinfo(Newsinfo newsinfo) throws Exception {
		return newsinfoMapper.insertNewsinfo(newsinfo);
	}

	/**
	 * 删除消息通知
	 * 
	 * @param id
	 * @return
	 */
	public int deleteNewsinfo(int id) throws Exception {
		return newsinfoMapper.deleteNewsinfo(id);
	}

	/**
	 * 更新消息通知
	 * 
	 * @param newsinfo
	 * @return
	 */
	public int updateNewsinfo(Newsinfo newsinfo) throws Exception {
		return newsinfoMapper.updateNewsinfo(newsinfo);
	}

	/**
	 * 根据ID查询记录
	 * 
	 * @param id
	 * @return
	 */
	public Newsinfo queryNewsinfoById(int id) throws Exception {
		return newsinfoMapper.queryNewsinfoById(id);
	}
}
