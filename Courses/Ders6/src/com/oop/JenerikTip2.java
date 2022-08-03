package com.oop;

public class JenerikTip2<T extends Arac , K extends IMethodlar> {

	private T bilgi;
	private K islem;

	public JenerikTip2(T bilgi, K islem) {
		super();
		this.bilgi = bilgi;
		this.islem = islem;
	}

	public T getBilgi() {
		return bilgi;
	}

	public K getIslem() {
		return islem;
	}
	
	public void yap() {
		getIslem().camiAc();
	}

}
