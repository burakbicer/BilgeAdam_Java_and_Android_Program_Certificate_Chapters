package com.threads;

public class AraOrnek implements Runnable {

	@Override
	public void run() {

		for (int i = 500; i < 600; i++) {

			System.out.println("Bilgi:" + i);

		}

	}

}
