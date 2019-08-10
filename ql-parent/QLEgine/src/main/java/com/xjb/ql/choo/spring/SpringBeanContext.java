package com.xjb.ql.choo.spring;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;

import com.ql.util.express.IExpressContext;

public class SpringBeanContext extends HashMap<String, Object> implements IExpressContext<String, Object> {

	private static final long serialVersionUID = 1L;

	private ApplicationContext applicationContext;

	public SpringBeanContext(Map<String, Object> aProperties, ApplicationContext applicationContext) {
		super(aProperties);
		this.applicationContext = applicationContext;
	}

	/**
	 * 根据key从容器里面获取对象
	 *
	 * @param key
	 * @return
	 */
	public Object get(Object key) {
		Object object = super.get(key);
		try {
			if (object == null 
					&& this.applicationContext != null
					&& this.applicationContext.containsBean((String) key)) {
				object = this.applicationContext.getBean((String) key);
			}
		} catch (Exception e) {
			throw new RuntimeException("表达式容器获取对象失败", e);
		}
		return object;
	}

	/**
	 * 把key-value放到容器里面去
	 *
	 * @param key
	 * @param value
	 */
	public Object put(String key, Object value) {
		return super.put(key, value);
	}
}
