package com.kopo;

import java.util.Scanner;

public class Exam1_66 {

	public static void main(String[] args) {
			
		Scanner scan = new Scanner(System.in);
		int total, max, min;
		double avg;
		int Array1[][];
		Array1 = new int[3][2];
				
		//배열에 값 저장하기
		for(int i=0;i<3;i++) {
			System.out.print("판매원의 번호를 입력하세요: ");
			Array1[i][0] = scan.nextInt();
			System.out.print("판매원 "+(i+1)+"의 매출액을 입력하세요: ");
			Array1[i][1] = scan.nextInt();	
		}
		
		System.out.println("판매원들의 매출액");
		System.out.println("------------------------");
		
		for(int i=0;i<3;i++) {
			System.out.println("판매원 "+Array1[i][0]+"\t\t"+Array1[i][1]);
		}
		System.out.println();
		
		total = 0;
		for(int i=0;i<3;i++) {
			total += Array1[i][1];
		}
		System.out.println("총 매출액: "+ total);
		
		avg = total/3;
		System.out.println("평균 매출액: "+ avg);
		
		max = 0;
		for(int i=0;i<Array1.length;i++) {
			if(Array1[i][1]>max) {
				max = Array1[i][1];   
			}
		}
		int empNumM = 0;
		for(int i=0;i<Array1.length;i++) {
			if(Array1[i][1]==max) {
				empNumM = i+1;   
			}
		}
		System.out.println("최대 매출액: "+max+" (사원 번호 "+empNumM+" )");
		
		min = 1000000000;
		for(int i=0;i<Array1.length;i++) {
			if(Array1[i][1]<min) {
				min = Array1[i][1];   
			}
		}
		int empNumm = 0;
		for(int i=0;i<Array1.length;i++) {
			if(Array1[i][1]==min) {
				empNumm = i+1;   
			}
		}
		System.out.println("최소 매출액: "+min+" (사원 번호 "+empNumm+" )");
		
		
		
	}

}
