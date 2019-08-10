package com.xjb.ql.choo;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;

public class ExpressTest01 {
	
	/**
	 * 执行一段文本
	 * @param expressString 程序文本
	 * @param context 执行上下文，可以扩展为包含ApplicationContext
	 * @param errorList 输出的错误信息List
	 * @param isCache 是否使用Cache中的指令集,建议为true
	 * @param isTrace 是否输出详细的执行指令信息，建议为false
	 * @param aLog 输出的log
	 * Object execute(String expressString, IExpressContext<String,Object> context,List<String> errorList, boolean isCache, boolean isTrace, Log aLog);
	 * @return
	 * @throws Exception
	 */
	

	
	public static void main(String[] args) throws Exception {
		ExpressRunner runner = new ExpressRunner();
		DefaultContext<String, Object> context = new DefaultContext<String, Object>();
		context.put("a",1);
		context.put("b",2);
		context.put("c",3);
		String express = "a+b*c";
		Object r = runner.execute(express, context, null, true, false);
		
		System.out.println(r);
	}

}
