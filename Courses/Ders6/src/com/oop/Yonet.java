package com.oop;

public class Yonet {

	public static void main(String[] args) {
		 
		
		Bmw bmw = new Bmw();
		bmw.setModel("320");
		bmw.setRenk("Kýrmýzý");
		
		IMethodlar bmw_islem = bmw;
		
		JenerikTip2<Arac, IMethodlar> jt = 
				new JenerikTip2<Arac, IMethodlar>(bmw, bmw_islem);
		
		jt.yap();
		jt.getIslem().camiAc();
		
		
		
		
		
	}

}
