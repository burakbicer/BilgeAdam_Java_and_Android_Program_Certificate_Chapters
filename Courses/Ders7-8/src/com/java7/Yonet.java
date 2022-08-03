package com.java7;

public class Yonet {

	public static void main(String[] args) {

		Yonet.Islem toplama = new Yonet.Islem() {

			@Override
			public int islemYap(int a, int b) {
				// TODO Auto-generated method stub
				return a + b;
			}
		};

		Yonet.Islem cikarma = new Yonet.Islem() {

			@Override
			public int islemYap(int a, int b) {
				// TODO Auto-generated method stub
				return a - b;
			}
		};
		
		
		System.out.println("Toplama:" + new Yonet().islemiGerceklestir(10, 30, toplama));
		System.out.println("Çýkarma:" + new Yonet().islemiGerceklestir(10, 30, cikarma));

	}

	public int islemiGerceklestir(int a, int b, Yonet.Islem is) {
		return is.islemYap(a, b);
	}

	abstract static class Islem {

		public abstract int islemYap(int a, int b);

	}

}
