package com.pojos;
/**
 * J2SE7 de gövdesiz method imzalarýna izin verilirken
 * J2SE8 de default method prefix (Ön Ek) i ile gövdeli method da yazýlabilir.
 * 
 * @author selcuk
 *
 */
public interface IAracFonksiyonlari {

	public void motoruCalistir();

	public void farlariYak();

	public void silecekleriCalistir();

	public void camiAc();

	public void kapilariKitle();
	
	public void klimayiAc();
	
	public void klimayiKapat();

	default public void lastikleriKontrolEt() {
		
	};
	
	default public void aracKonumuBildir() {
		 System.out.println("Aracýn konumu:X:45.54.64.64 Y:35.56.34.12");		
	}
	
	
}
