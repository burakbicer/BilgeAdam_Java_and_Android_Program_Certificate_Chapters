package com.threads;

import java.util.List;

public class DiziDuzenleyicisi implements Runnable {

	public List<String> dizi;
	private Long zaman;
	public DiziDuzenleyicisi(List<String> dizi, Long zaman) {

		this.dizi = dizi;
		this.zaman = zaman;
	}

	@Override
	public void run() {
		 zaman = System.currentTimeMillis();
				 
		 for(int i=0; i< dizi.size(); i++) {
			 dizi.set(i, dizi.get(i)+" Ýþlendi");
			 try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 /*
		 for(String str : dizi) {
			 System.out.println("Dizi:"+str);
			 
		 }*/
		 Long timeStamp1 = System.currentTimeMillis();
		 //System.out.println("Bitiþ Saati:"+timeStamp1);		
		 System.out.println("Toplam süre:"+(timeStamp1-zaman));	
		 
	}

}
