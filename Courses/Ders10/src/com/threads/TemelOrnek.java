package com.threads;

public class TemelOrnek implements Runnable {

	@Override
	public void run() {
		
		Thread th1 = new Thread(new AraOrnek());
		th1.start();
		
		for (int i = 0; i < 20; i++) {
			System.out.println("Sayilar:" + i);
		}
	}

}
