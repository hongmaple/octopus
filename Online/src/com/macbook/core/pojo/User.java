package com.macbook.core.pojo;

/**
 * @author maweihong
 * 用户的javabean类
 */
public class User {
	/**
	 * sno:账号
	 * name:姓名
	 * password:密码
	 * phone:联系号码
	 * identity:身份
	 * sex:性别
	 * college:学院
	 * start:分页显示开始行
	 * roes:分页显示行数
	 */
	private String sno;
	private String name;
	private String password;
	private String phone;
	private String identity;
	private String sex;
	private String college;
	private Integer start;
	private Integer rows;


	public String getSno() {
	    return sno;
	}

	public void setSno(String sno) {
	    this.sno = sno;
	}

	public String getName() {
	    return name;
	}

	public void setName(String name) {
	    this.name = name;
	}

	public String getPassword() {
	    return password;
	}

	public void setPassword(String password) {
	    this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdentity() {
	    return identity;
	}

	public void setIdentity(String identity) {
	    this.identity = identity;
	}

	public String getSex() {
	    return sex;
	}

	public void setSex(String sex) {
	    this.sex = sex;
	}

	public String getCollege() {
	    return college;
	}

	public void setCollege(String college) {
	    this.college = college;
	}


	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}
}

