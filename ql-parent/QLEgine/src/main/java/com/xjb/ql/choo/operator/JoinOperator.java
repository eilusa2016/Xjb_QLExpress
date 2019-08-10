package com.xjb.ql.choo.operator;

import java.util.ArrayList;
import java.util.List;

import com.ql.util.express.Operator;

public class JoinOperator extends Operator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Object executeInner(Object[] objects) throws Exception {
		 List<Object> result = new ArrayList<Object>();
	        for (Object object : objects) {
	            if (object instanceof java.util.List) {
	                result.addAll(((List) object));
	            } else {
	                result.add(object);
	            }
	        }

	        return result;
	}

}
