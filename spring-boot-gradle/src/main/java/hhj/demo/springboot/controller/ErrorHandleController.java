package hhj.demo.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hhj
 *
 */
@RestController
public class ErrorHandleController implements ErrorController {
	
	@RequestMapping(value="/error")
	public Object error() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("errno", 999);
		map.put("errmsg", "出错了!");
		return map;
	}

	public String getErrorPath() {
		return null;
	}

}
