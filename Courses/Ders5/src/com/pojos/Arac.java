package com.pojos;

/**
 * Ana �retim s�n�f�
 * 
 * 
 * @author selcuk
 *
 */
public class Arac implements IAracFonksiyonlari, IAracAlarm {

	private RENK renk = RENK.BEYAZ;
	private Integer maxHiz = 0;
	private YAKITTIPI yakitTipi;
	private Integer guc = 0;
	private Double tekerCapi = 0d;
	private Boolean acilirTavan = false;
	private KASATIPI kasaTipi;

	public Arac() {

	}

	public Arac(RENK renk, Integer maxHiz, YAKITTIPI yakitTipi, Integer guc, Double tekerCapi, Boolean acilirTavan,
			KASATIPI kasaTipi) {
		super();
		this.renk = renk;
		this.maxHiz = maxHiz;
		this.yakitTipi = yakitTipi;
		this.guc = guc;
		this.tekerCapi = tekerCapi;
		this.acilirTavan = acilirTavan;
		this.kasaTipi = kasaTipi;
	}

	public RENK getRenk() {
		return renk;
	}

	public void setRenk(RENK renk) {
		this.renk = renk;
	}

	public Integer getMaxHiz() {
		return maxHiz;
	}

	public void setMaxHiz(Integer maxHiz) {
		this.maxHiz = maxHiz;
	}

	public YAKITTIPI getYakitTipi() {
		return yakitTipi;
	}

	public void setYakitTipi(YAKITTIPI yakitTipi) {
		this.yakitTipi = yakitTipi;
	}

	public Integer getGuc() {
		return guc;
	}

	public void setGuc(Integer guc) {
		this.guc = guc;
	}

	public Double getTekerCapi() {
		return tekerCapi;
	}

	public void setTekerCapi(Double tekerCapi) {
		this.tekerCapi = tekerCapi;
	}

	public Boolean getAcilirTavan() {
		return acilirTavan;
	}

	public void setAcilirTavan(Boolean acilirTavan) {
		this.acilirTavan = acilirTavan;
	}

	public KASATIPI getKasaTipi() {
		return kasaTipi;
	}

	public void setKasaTipi(KASATIPI kasaTipi) {
		this.kasaTipi = kasaTipi;
	}

	@Override
	public void motoruCalistir() {
		System.out.println("Motor �al��t�");

	}

	@Override
	public void farlariYak() {
		System.out.println("Farlar A��ld�");
	}

	@Override
	public void silecekleriCalistir() {
		System.out.println("Silecekler �al���yor");
	}

	@Override
	public void camiAc() {
		System.out.println("Cam A��ld�");
	}

	@Override
	public void kapilariKitle() {
		System.out.println("Kap�lar kitlendi");
	}

	@Override
	public void klimayiAc() {
		System.out.println("Klima A��ld�");
	}

	@Override
	public void klimayiKapat() {
		System.out.println("Klima Kapat�ld�");

	}

	@Override
	public void alarmAc() {
		System.out.println("Alarm A��ld�");

	}

	@Override
	public void alarmKapat() {
		System.out.println("Alarm Kapat�ld�");

	}

	@Override
	public void poliseHaberVer() {
		System.out.println("Polise Bildirildi");

	}

	@Override
	public void konumBildirimiYap() {
		aracKonumuBildir();

	}

	@Override
	public void motoruKitle() {
		System.out.println("Motor Kilitlendi !");
	}

	/**
	 * Bu alan �retilmi� olan arac�n markas�n�
	 * verir.
	 * <pre>
	 * <a href="https://www.bmw.com/">Bkz. Bmw.com</a>
	 * </pre>
	 */
	public void aracMarkasi() {
		System.out.println("�retim Tesisi Prototipi");
	}

}
