package com.ders4;

public class AltSinif extends SoyutSinif {

	@Override
	public Integer islem(Integer val, Integer val2) {
		return val + val2;
	}

	public static void main(String[] args) {

		AltSinif alt = new AltSinif();
		System.out.println("�arp:" + alt.carp(50, 50));
		System.out.println("��lem:" + alt.islem(50, 50));

	}

}
