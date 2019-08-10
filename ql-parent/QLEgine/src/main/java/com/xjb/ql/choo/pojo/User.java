package com.xjb.ql.choo.pojo;

import org.apache.commons.lang.StringUtils;

public class User {
	/**
     * 标识
     */
    private long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 年龄
     */
    private int age;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	/**
     * 首字母大写
     * @param value 字符串
     * @return 转换后的信息
     */
    public static String firstToUpper(String value){
        if(StringUtils.isBlank(value))
            return "";
        value = StringUtils.trim(value);
        String f = StringUtils.substring(value,0,1);
        String s = "";
        if(value.length() > 1){
            s = StringUtils.substring(value,1);
        }
        return f.toUpperCase() + s;
    }
}
