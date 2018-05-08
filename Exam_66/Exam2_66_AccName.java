package com.kopo;

public class Exam2_66_AccName extends Exam2_66_Driver{
	
	public Exam2_66_AccName() {
		super();
	}
	public Exam2_66_AccName(String name, int accNum, int in) {
		super();
		this.name = name;
		AccNum = accNum;
		In = in;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccNum() {
		return AccNum;
	}
	public void setAccNum(int accNum) {
		AccNum = accNum;
	}
	public int getIn() {
		return In;
	}
	public void setIn(int in) {
		In = in;
	}


	public String name;
	public int AccNum;
	public int In;
	public String toString( )    {
		String str = "";
		str += "예금주 이름: " + name + "\n";
		str += "계좌번호: " + AccNum + "\n";
		str += "입금금액: " + In + "\n";
		return str;
	    }
	public int result( )   {
		int total;
		int Res;
		total = 10000;
		
		Res = total + In;
		
		return Res;
    } 
	
	
}
