package com.service;

import java.util.List;
import com.model.Yuangong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import com.util.PageBean;
import java.util.Map;
import com.mapper.YuangongMapper;

/**
 * 用户信息Service实现类
 */
@Service
public class YuangongServiceImpl implements YuangongService {
	/**
	 * 注入mapper
	 */
	@Autowired
	private YuangongMapper yuangongMapper;

	/**
	 * 查询用户信息记录数
	 * 
	 * @param yuangong
	 * @return
	 */
	public int getCount(Yuangong yuangong) {
		Map<String, Object> map = getQueryMap(yuangong, null);
		return yuangongMapper.getCount(map);
	}

	/**
	 * 查询所有用户信息
	 * 
	 * @return
	 */
	public List<Yuangong> queryYuangongList(Yuangong yuangong, PageBean page)
			throws Exception {
		Map<String, Object> map = getQueryMap(yuangong, page);
		List<Yuangong> list = yuangongMapper.query(map);
		return list;
	}

	/**
	 * 封装查询条件
	 * 
	 * @param yuangong
	 * @param page
	 * @return
	 */
	private Map<String, Object> getQueryMap(Yuangong yuangong, PageBean page) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (yuangong != null) {
			map.put("id", yuangong.getId());
			map.put("yno", yuangong.getYno());
			map.put("name", yuangong.getName());
			map.put("pwd", yuangong.getPwd());
			map.put("bid", yuangong.getBid());
			map.put("state", yuangong.getState());
			
			map.put("qid", yuangong.getQid());
			map.put("qtype", yuangong.getQtype());
		}
		if (page != null) {
			PageBean.setPageMap(map, page);
		}
		return map;
	}

	/**
	 * 保存用户信息
	 * 
	 * @param yuangong
	 * @return
	 */
	public int insertYuangong(Yuangong yuangong) throws Exception {
		return yuangongMapper.insertYuangong(yuangong);
	}

	/**
	 * 删除用户信息
	 * 
	 * @param id
	 * @return
	 */
	public int deleteYuangong(int id) throws Exception {
		return yuangongMapper.deleteYuangong(id);
	}

	/**
	 * 更新用户信息
	 * 
	 * @param yuangong
	 * @return
	 */
	public int updateYuangong(Yuangong yuangong) throws Exception {
		return yuangongMapper.updateYuangong(yuangong);
	}

	/**
	 * 根据ID查询记录
	 * 
	 * @param id
	 * @return
	 */
	public Yuangong queryYuangongById(int id) throws Exception {
		return yuangongMapper.queryYuangongById(id);
	}

	//查询有申请的员工
	@Override
	public List<Yuangong> selectshen(String state) {
		return yuangongMapper.selectshen(state);
	}

	//根据部门查询申请员工
	@Override
	public List<Yuangong> selectshenbybid(String state, Integer bid) {
		return yuangongMapper.selectshenbybid(state, bid);
	}

}
