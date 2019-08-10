package com.xjb.ql.choo;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.ql.util.express.IExpressContext;
import com.xjb.ql.choo.pojo.User;


public class ExpressObjectTest02 {
	
	public static void main(String[] args) throws Exception {
//		test1();
//		test2();
//		test3();
//		testAlias();
		testMacro();
	}
	public static void test1() throws Exception {

        String exp = "import com.xjb.ql.choo.pojo.User;" +
                "User cust = new User();" +
                "cust.setName(\"小强\");" +
                "return cust.getName();";
        ExpressRunner runner = new ExpressRunner();
        IExpressContext<String, Object> expressContext = new DefaultContext<>();
        String r = (String) runner.execute(exp, expressContext, null, false, false);
      System.out.println(r);
//       assert "小强".equals(r);
    }
	
	public static void test2() throws Exception {
        String exp = "cust.setName(\"小强\");" +
                "return cust.getName();";
        IExpressContext<String, Object> expressContext = new DefaultContext<>();
        expressContext.put("cust", new User());
        ExpressRunner runner = new ExpressRunner();
        String r = (String) runner.execute(exp, expressContext, null, false, false);
        System.out.println(r);
    }

	public static void test3() throws Exception {
        String exp = "首字母大写(\"abcd\")";
        ExpressRunner runner = new ExpressRunner();
        runner.addFunctionOfClassMethod("首字母大写", User.class.getName(), "firstToUpper", new String[]{"String"}, null);
        String r = (String) runner.execute(exp, null, null, false, false);
        System.out.println(r);
    }

	  /**
     * 使用别名
     *
     * @throws Exception if any
     */
    public static void testAlias() throws Exception {
        String exp = "cust.setName(\"小强\");" +
                "定义别名 custName cust.name;" +
                "return custName;";
        IExpressContext<String, Object> expressContext = new DefaultContext<>();
        expressContext.put("cust", new User());
        ExpressRunner runner = new ExpressRunner();
        //
        runner.addOperatorWithAlias("定义别名", "alias", null);
        //执行表达式，并将结果赋给r
        String r = (String) runner.execute(exp, expressContext, null, false, false);
        System.out.println(r);
    }

    /**
     * 使用宏
     *
     * @throws Exception if any
     */

    public static void testMacro() throws Exception {
        String exp = "cust.setName(\"小强\");" +
                "定义宏 custName {cust.name};" +
                "return custName;";
        IExpressContext<String, Object> expressContext = new DefaultContext<>();
        expressContext.put("cust", new User());
        ExpressRunner runner = new ExpressRunner();
        runner.addOperatorWithAlias("定义宏", "macro", null);
        String r = (String) runner.execute(exp, expressContext, null, false, false);
        System.out.println(r);
    }

	

}
