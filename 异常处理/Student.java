package com.yunsi.day17.exception06;

public class Student {
	public static final String AGE_ERROR="年龄设置有误！";

	public static final String  AGE_ERROR_CODE="111001";

	private String name; 
	private int age; 
	private String sex;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) throws IllegalAgeException {
		if(age<=0 || age>120){
			throw new IllegalAgeException(AGE_ERROR, Constant.AGE_ERROR_CODE);
		}
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	} 
	
	@Override
	public String toString() {
		return "学生信息如下：\n名字是："+this.getName()+",年龄是："+this.getAge()
				+",性别是："+this.getSex();
	}
	public static void main(String[] args) {
		Student stu = new Student();
		stu.setName("张三");
		try {
			stu.setAge(1000);
		} catch (IllegalAgeException e) {
			e.printStackTrace();
			//注意 ：getMessage(),  getErrorMsg() 这2个拿的都带参构造的第1个参数  ，错误消息
			// 错误码 ：带参构造的第2个参数
			System.out.println("错误原因："+e.getMessage()+"\t或者："+e.getErrorMsg()+",对应的错误码："+e.getErrorCode());
		}
		stu.setSex("人妖");

		System.out.println(stu.toString());
	}
	
}
