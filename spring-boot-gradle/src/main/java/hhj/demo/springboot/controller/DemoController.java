package hhj.demo.springboot.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hhj.demo.springboot.bean.Demo;
import hhj.demo.springboot.service.DemoService;

/**
 * @author hhj
 *
 */
@RestController
public class DemoController {
	
	@Resource
	private DemoService demoService;
	
	@RequestMapping(value="/demo/list", method=RequestMethod.GET)
	public Object getList() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("time", System.currentTimeMillis());
		map.put("data", demoService.getList(0, 50));
		
		return map;
	}
	
	@RequestMapping(value="/demo/add", method=RequestMethod.POST)
	public Object add(@RequestBody Demo bean) {
		
		bean.setAddtime(new Date());
		int result = demoService.add(bean);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("time", System.currentTimeMillis());
		map.put("result", result);
		
		return map;
	}

}
