package com.service;

import java.util.List;
import com.model.Zhaopin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import com.util.PageBean;
import java.util.Map;
import com.mapper.ZhaopinMapper;

/**
 * 招聘信息Service实现类
 */
@Service
public class ZhaopinServiceImpl implements ZhaopinService {
	/**
	 * 注入mapper
	 */
	@Autowired
	private ZhaopinMapper zhaopinMapper;

	/**
	 * 查询招聘信息记录数
	 * 
	 * @param zhaopin
	 * @return
	 */
	public int getCount(Zhaopin zhaopin) {
		Map<String, Object> map = getQueryMap(zhaopin, null);
		return zhaopinMapper.getCount(map);
	}

	/**
	 * 查询所有招聘信息
	 * 
	 * @return
	 */
	public List<Zhaopin> queryZhaopinList(Zhaopin zhaopin, PageBean page)
			throws Exception {
		Map<String, Object> map = getQueryMap(zhaopin, page);
		List<Zhaopin> list = zhaopinMapper.query(map);
		return list;
	}

	/**
	 * 封装查询条件
	 * 
	 * @param zhaopin
	 * @param page
	 * @return
	 */
	private Map<String, Object> getQueryMap(Zhaopin zhaopin, PageBean page) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (zhaopin != null) {
			map.put("id", zhaopin.getId());
			map.put("name", zhaopin.getName());
		}
		if (page != null) {
			PageBean.setPageMap(map, page);
		}
		return map;
	}

	/**
	 * 保存招聘信息
	 * 
	 * @param zhaopin
	 * @return
	 */
	public int insertZhaopin(Zhaopin zhaopin) throws Exception {
		return zhaopinMapper.insertZhaopin(zhaopin);
	}

	/**
	 * 删除招聘信息
	 * 
	 * @param id
	 * @return
	 */
	public int deleteZhaopin(int id) throws Exception {
		return zhaopinMapper.deleteZhaopin(id);
	}

	/**
	 * 更新招聘信息
	 * 
	 * @param zhaopin
	 * @return
	 */
	public int updateZhaopin(Zhaopin zhaopin) throws Exception {
		return zhaopinMapper.updateZhaopin(zhaopin);
	}

	/**
	 * 根据ID查询记录
	 * 
	 * @param id
	 * @return
	 */
	public Zhaopin queryZhaopinById(int id) throws Exception {
		return zhaopinMapper.queryZhaopinById(id);
	}
}
