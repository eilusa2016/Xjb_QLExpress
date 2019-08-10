package com.xjb.ql.choo.spring;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class TestService {
	@Resource
	private SpringBeanRunner runner;

	public void test(){
	    Map<String, Object> context = new HashMap<String, Object>();
	    context.put("orderId",100012L); 
	    Object result = runner.executeExpress("", context);
	    System.out.println(result);
	}

}
