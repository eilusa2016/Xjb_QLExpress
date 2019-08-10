package com.xjb.ql.choo.spring;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.ql.util.express.ExpressRunner;
import com.ql.util.express.IExpressContext;

@Service
public class SpringBeanRunner implements ApplicationContextAware {

	private ApplicationContext applicationContext;
	private ExpressRunner runner;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		runner = new ExpressRunner();
	}

	public Object executeExpress(String text, Map<String, Object> context) {
		IExpressContext<String, Object> expressContext = new SpringBeanContext(context, this.applicationContext);
		try {
			return runner.execute(text, expressContext, null, true, false);
		} catch (Exception e) {
			e.printStackTrace();
			//logger.error("qlExpress运行出错！", e);
		}
		return null;

	}

}
