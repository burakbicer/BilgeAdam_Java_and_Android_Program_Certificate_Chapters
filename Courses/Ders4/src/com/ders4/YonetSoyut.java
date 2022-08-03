package com.ders4;

public class YonetSoyut {

	public static void main(String[] args) {
		 
		SoyutSinif ss =  new SoyutSinif() {
			
			@Override
			public Integer islem(Integer val, Integer val2) {
				
				System.out.println("Ýþlem Baþladý");
				return val+val2;
			}
		};
		
		SoyutSinif ss2 = new SoyutSinif() {
			
			@Override
			public Integer islem(Integer val, Integer val2) {
				// TODO Auto-generated method stub
				return val-val2;
			}
		};
		
		System.out.println("Sonuç:"+ss.islem(50, 50));
		System.out.println("Sonuç:"+ss2.islem(50, 50));
		System.out.println("Sonuç:"+ss.carp(50, 50));
		System.out.println("Sonuç:"+ss2.carp(50, 50));
	}

}
