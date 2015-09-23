package hhj.demo.springboot.service.impl;

import java.util.List;

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

	public List<Demo> getList() {
		return demoDAO.selectAll();
	}

}
