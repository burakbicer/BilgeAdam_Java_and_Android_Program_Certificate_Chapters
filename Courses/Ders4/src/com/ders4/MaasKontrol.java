package com.ders4;

import com.ders4.hatalar.HesapKapali;
import com.ders4.hatalar.OzelHata;

public class MaasKontrol {

	private double maas;// Hesapdaki para
	private boolean hesapdurumu=true;
	public void cekimYap(double miktar) throws OzelHata, HesapKapali {

		if(!hesapdurumu)
			throw new HesapKapali(false);
			
			
		if (maas >= miktar) {
			maas -= miktar;
		} else {
			double ihtiyac = miktar - maas;
			throw new OzelHata(ihtiyac);	
		}
	}

	public double getMaas() {
		return maas;
	}

	public void setMaas(double maas) throws HesapKapali {
		if(!hesapdurumu) throw new HesapKapali(false);
		this.maas = maas;
	}

}
