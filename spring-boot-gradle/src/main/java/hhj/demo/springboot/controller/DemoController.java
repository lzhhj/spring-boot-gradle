package hhj.demo.springboot.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
		return demoService.getList();
	}

}
