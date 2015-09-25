package hhj.demo.springboot.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hhj.demo.springboot.bean.Demo;
import hhj.demo.springboot.dao.DemoDAO;
import hhj.demo.springboot.service.DemoService;

/**
 * @author hhj
 *
 */
@Service
public class DemoServiceImpl implements DemoService {
	
	@Resource
	private DemoDAO demoDAO;

	public List<Demo> getList(Integer start, Integer length) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("length", length);
		return demoDAO.selectByLength(map);
	}

	public int add(Demo record) {
		return demoDAO.insertSelective(record);
	}

}
