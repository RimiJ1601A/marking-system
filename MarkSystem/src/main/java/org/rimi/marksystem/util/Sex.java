package org.rimi.marksystem.util;

public enum Sex {
	MAN("男",1),WOMAN("女",2);
	
	private String sex;
	private int value;
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	private Sex(String sex,int value){
		this.sex = sex;
		this.value = value;
	}
	public static Sex getSexByValue(int value){
		if(value == 1){		
			return Sex.MAN;
		}
		else{
			return Sex.WOMAN;
		}
	}
	public static int getValueBySex(String sex){
		if(sex.equals("男")){
			return 1;
		}else{		
			return 2;
		}
	}
}
