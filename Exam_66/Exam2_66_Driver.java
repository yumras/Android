package com.kopo;

import com.kopo.Exam2_66_AccName;

public class Exam2_66_Driver {

	public static void main(String[] args) {


		Exam2_66_AccName person1 = new Exam2_66_AccName( );
		person1.setName("이한민");
		person1.setAccNum(1820340066);
		person1.setIn(8000);
	    System.out.println(person1);

	    Exam2_66_AccName person2 = new Exam2_66_AccName( );
	    person2.name = "이한민1";
	    person2.AccNum = 7807;
	    person2.In = 3000;
	    System.out.println(person2.toString( ));

	}

}
