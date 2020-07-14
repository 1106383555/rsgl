package com.service;

import java.util.List;
import com.model.Bumen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import com.util.PageBean;
import java.util.Map;
import com.mapper.BumenMapper;

/**
 * 部门信息Service实现类
 */
@Service
public class BumenServiceImpl implements BumenService {
	/**
	 * 注入mapper
	 */
	@Autowired
	private BumenMapper bumenMapper;

	/**
	 * 查询部门信息记录数
	 * 
	 * @param bumen
	 * @return
	 */
	public int getCount(Bumen bumen) {
		Map<String, Object> map = getQueryMap(bumen, null);
		return bumenMapper.getCount(map);
	}

	/**
	 * 查询所有部门信息
	 * 
	 * @return
	 */
	public List<Bumen> queryBumenList(Bumen bumen, PageBean page)
			throws Exception {
		Map<String, Object> map = getQueryMap(bumen, page);
		List<Bumen> list = bumenMapper.query(map);
		return list;
	}

	/**
	 * 封装查询条件
	 * 
	 * @param bumen
	 * @param page
	 * @return
	 */
	private Map<String, Object> getQueryMap(Bumen bumen, PageBean page) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (bumen != null) {
			map.put("id", bumen.getId());
			map.put("name", bumen.getName());
		}
		if (page != null) {
			PageBean.setPageMap(map, page);
		}
		return map;
	}

	/**
	 * 保存部门信息
	 * 
	 * @param bumen
	 * @return
	 */
	public int insertBumen(Bumen bumen) throws Exception {
		return bumenMapper.insertBumen(bumen);
	}

	/**
	 * 删除部门信息
	 * 
	 * @param id
	 * @return
	 */
	public int deleteBumen(int id) throws Exception {
		return bumenMapper.deleteBumen(id);
	}

	/**
	 * 更新部门信息
	 * 
	 * @param bumen
	 * @return
	 */
	public int updateBumen(Bumen bumen) throws Exception {
		return bumenMapper.updateBumen(bumen);
	}

	/**
	 * 根据ID查询记录
	 * 
	 * @param id
	 * @return
	 */
	public Bumen queryBumenById(int id) throws Exception {
		return bumenMapper.queryBumenById(id);
	}
}
