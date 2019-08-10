package com.xjb.ql.choo;


import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.xjb.ql.choo.operator.JoinOperator;

@RunWith(BlockJUnit4ClassRunner.class)
public class ExpressFunction03 {

	@Test
	public  void  testA() {
		System.out.println(1111);
	}
	
	/**
	 * 自定义函数测试
	 * @throws Exception if any
	 */
	@Test
	public void defineFunctionTest() throws Exception {
	    final String express = "function add(int a,int b){\n" +
	            "  return a+b;\n" +
	            "};\n" +
	            "\n" +
	            "function sub(int a,int b){\n" +
	            "  return a - b;\n" +
	            "};\n" +
	            "\n" +
	            "a=10;\n" +
	            "return add(a,4) + sub(a,9);";
	    ExpressRunner runner = new ExpressRunner();
	    DefaultContext<String, Object> context = new DefaultContext<>();
	    Object r = runner.execute(express, context, null, true, false);
	    Assert.assertEquals(15, r);
	}
	/**
	 * 替换关键字
	 * @throws Exception
	 */
	@Test
	public void replaceKeywordTest() throws Exception {
	    ExpressRunner runner = new ExpressRunner();
	    runner.addOperatorWithAlias("如果", "if", null);
	    runner.addOperatorWithAlias("则", "then", null);
	    runner.addOperatorWithAlias("否则", "else", null);
	    DefaultContext<String, Object> context = new DefaultContext<>();
	    final String express = "如果(1>2){ return 10;} 否则 {return 5;}";
	    Object r = runner.execute(express, context, null, true, false);
	    System.out.println(r);
	    Assert.assertEquals(5, r);
	}
	
	/**
	 * 自定义 操作符
	 * @throws Exception
	 */
	@Test
	public void addOperatorTest() throws Exception {
	    ExpressRunner runner = new ExpressRunner();
	    DefaultContext<String, Object> context = new DefaultContext<>();
	    runner.addOperator("join", new JoinOperator());
	    Object r = runner.execute("1 join 2 join 3", context, null, false, false);
	    System.out.println(r);
	    Assert.assertEquals(Arrays.asList(1,2,3), r);
	}
	
	@Test
	public void replaceOperatorTest() throws Exception {
	    ExpressRunner runner = new ExpressRunner();
	    DefaultContext<String, Object> context = new DefaultContext<>();
	    runner.replaceOperator("+", new JoinOperator());
	    Object r = runner.execute("1 + 2 + 3", context, null, false, false);
	    Assert.assertEquals(Arrays.asList(1,2,3), r);
	}
	@Test
	public void addFunctionTest() throws Exception {
	    ExpressRunner runner = new ExpressRunner();
	    DefaultContext<String, Object> context = new DefaultContext<>();
	    runner.addFunction("join",new JoinOperator());
	    Object r = runner.execute("join(1, 2, 3)", context, null, false, false);
	    Assert.assertEquals(Arrays.asList(1,2,3), r);
	}


}
