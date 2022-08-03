package com.ders5;

import com.pojos.Arac;
import com.pojos.DSG;
import com.pojos.IAracAlarm;
import com.pojos.KASATIPI;
import com.pojos.RENK;
import com.pojos.YAKITTIPI;
import com.pojos.arac.Audi;
import com.pojos.arac.BMW;
import com.pojos.arac.Mercedes;

public class Yonet {

	public static void main(String[] args) {

		Arac arac = new Arac();

		// *********************

		BMW bmw = new BMW();

		Mercedes mercedes = new Mercedes();

		Audi audi = new Audi();

		// *********************

		Arac bmw1 = new BMW();

		Arac mercedes1 = new Mercedes();

		Arac audi1 = new Audi();

		// *********************
		atla: if (true) {

			if (true) {
				break atla;
			}

			bmw.setAcilirTavan(true);
			bmw.setDsgType(DSG.SEKIZ);
			bmw.setGuc(180);
			bmw.setKoltukIsitma(true);
			bmw.setMaxHiz(260);
			bmw.setRenk(RENK.KIRMIZI);
			bmw.setTekerCapi(17.0);
			bmw.setYakitTipi(YAKITTIPI.BENZIN);

			mercedes.setAcilirTavan(false);
			mercedes.setAktifFar(true);
			mercedes.setF1Vites(true);
			mercedes.setGuc(240);
			mercedes.setKasaTipi(KASATIPI.HB);
			mercedes.setMaxHiz(280);
			mercedes.setRenk(RENK.SIYAH);
			mercedes.setStartStop(true);
			mercedes.setTekerCapi(17.0);
			mercedes.setYakitTipi(YAKITTIPI.DIZEL);

			audi.setAcilirTavan(true);
			audi.setCc(true);
			audi.setGuc(180);
			audi.setKasaTipi(KASATIPI.SEDAN);
			audi.setMaxHiz(280);
			audi.setQuadro(true);
			audi.setRenk(RENK.KIRMIZI);
			audi.setTekerCapi(17.0);
			audi.setYakitTipi(YAKITTIPI.DIZEL);

			System.out.println("*****************************");
			bmw.motoruCalistir();
			mercedes.motoruCalistir();
			audi.motoruCalistir();

			System.out.println("*****************************");
			bmw.camiAc();
			mercedes.camiAc();
			audi.camiAc();

			System.out.println("*****************************");
			bmw.farlariYak();
			mercedes.farlariYak();
			audi.farlariYak();

			System.out.println("*****************************");

			IAracAlarm bmw2 = bmw;
			bmw2.alarmAc();

			IAracAlarm mercedes2 = mercedes;
			mercedes2.motoruKitle();

			IAracAlarm audi2 = audi;
			audi2.konumBildirimiYap();
		}

		System.out.println("Bmw1 :");
		
		//bmw1.aracKonumuBildir();
		//bmw1.alarmAc();
		bmw1.camiAc();
		
		//mercedes1.alarmAc();
		//mercedes1.farlariYak();
	}

}
