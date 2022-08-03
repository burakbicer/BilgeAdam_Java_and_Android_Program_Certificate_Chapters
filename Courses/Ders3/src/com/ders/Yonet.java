package com.ders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Yonet {

	private void islem() {

		String[] stringornek = { "Bilgi", "Güçtür", "!" };
		Integer[] integerornek = { 1, 2, 3, 4, 5, 6 };
		double[] doubleornek = new double[5];
		doubleornek[0] = 1;
		doubleornek[1] = 2;
		doubleornek[2] = 3;
		doubleornek[3] = 4;
		doubleornek[4] = 5;

		double[] doubleornek2 = { 7.5, 1.2, 1.5, 3.5 };
		double enbuyuk = doubleornek2[0];
		for (int i = 1; i < doubleornek2.length; i++) {
			if (doubleornek2[i] > enbuyuk)
				enbuyuk = doubleornek2[i];
		}
		System.out.println("En büyük:" + enbuyuk);

	}

	private static int[] tersinecevir(int[] val) {

		int[] sonuc = new int[val.length];
		for (int i = 0, j = sonuc.length - 1; i < val.length; i++, j--) {
			sonuc[j] = val[i];
		}
		return sonuc;
	}

	private void yazdir(int[] array) {
		for (int deger : array) {
			System.out.print(deger);
		}
	}

	private void islem2() {

		Date date = new Date();
		System.out.println("Zaman:" + date);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		System.out.println("Tarih:" + sdf.format(date));

		System.out.println("Tarih:" + sdf2.format(date));

		String ornek = String.format("Þu anki zaman: %tc ", date);
		System.out.println(ornek);

		System.out.printf("%1$s %2$tB %2$td, %2$tY ", "Zaman:", date);

	}

	private void islem3() {

		GregorianCalendar gre = new GregorianCalendar(new Locale("tr", "TR"));
		System.out.println("Zaman:");
		System.out.println("Ay:" + gre.get(Calendar.MONTH));
		System.out.println("Yýl:" + gre.get(Calendar.YEAR));

		System.out.println("Saat:" + gre.get(Calendar.HOUR));
		System.out.println("Dakika:" + gre.get(Calendar.MINUTE));
		System.out.println("Saniye:" + gre.get(Calendar.SECOND));

	}

	private void islem4() {

		String bilgi = "Sayýsal deðer -2018- bulunan alan.";
		String iz = "(.*)(\\d+)(.*)";
		Pattern ptr = Pattern.compile(iz);
		Matcher m = ptr.matcher(bilgi);
		if (m.find()) {
			System.out.println("Bilgi bulundu:" + m.group(0));
		} else {
			System.out.println("Bilgi bulunamadý");
		}

	}

	private void islem5() {

		int[] sayilar = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
		for (int i : sayilar) {

			if (i > 4 && i < 8) {
				continue;
			}

			if (i > 9) {
				break;
			}

			System.out.println("Sayý:" + i);
		}
	}

	private void islem6() {

		System.out.println("Giriþ");
		bir: {

			System.out.println("bir");
			if (false)
				break bir;
			iki: {

				System.out.println("iki");
				if (true)
					break iki;

				uc: {

					System.out.println("Üç");

				}

			}
		}

		dehle: for (int i = 0; i < 5; i++) {
			borderin: for (int j = 0; j < 5; j++) {
				borderinto: for (int k = 0; k < 5; k++) {
					int sonuc = i * j * k;
					if (sonuc > 50)
						break dehle;
				}

			}
		}

	}

	private void dosyaOku() throws IOException {

		FileInputStream fi = new FileInputStream("C:/BilgeadamOrnek/ornekklasor/input.txt");
		FileOutputStream fo = new FileOutputStream("C:/BilgeadamOrnek/ornekklasor/output.txt");

		int c;
		while ((c = fi.read()) != -1) {
			fo.write(c);
		}

		fi.close();
		fo.close();

	}

	private void dosyaKopyala() throws IOException {
		FileReader in = null;
		FileWriter out = null;
		in = new FileReader("C:/BilgeadamOrnek/ornekklasor/input.txt");
		out = new FileWriter("C:/BilgeadamOrnek/ornekklasor/output.txt");
		int c;
		while ((c = in.read()) != -1) {
			out.write(c);
		}
		in.close();
		out.close();
	}

	private void klawyegirisi() throws IOException {

		InputStreamReader giris = null;

		giris = new InputStreamReader(System.in);
		char c;
		do {
			c = (char) giris.read();
			System.out.println("Girilen Bilgi:" + c);
		} while (c != 'e');
		giris.close();
	}

	private void dizinOlustur() {

		String dizinismi = "C:/BilgeadamOrnek/deneme/A/B/C";
		File d = new File(dizinismi);
		d.mkdirs();
	}

	// uzunsoy@yandex.com

	private void dizinListele() {
		File file = null;
		String[] paths;
		file = new File("C:/BilgeadamOrnek/");
		paths = file.list();
		for (String path : paths) {
			System.out.println("Path:" + path);
		}
	}

	private void dosyaTasi() {

		File dosya1 = new File("C:\\BilgeadamOrnek\\Folder1\\infile.txt");
		File dosya2 = new File("C:\\BilgeadamOrnek\\Folder2\\" + dosya1.getName());
		dosya1.renameTo(dosya2);

	}

	private void delete() {
		File dosya1 = new File("C:\\BilgeadamOrnek\\Folder2\\infile.txt");
		dosya1.delete();

	}

	public static void main(String[] args) throws IOException {

		atla: {
			if (true)
				break atla;
			new Yonet().islem();
			int[] dizim = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
			int[] sonuc = tersinecevir(dizim);

			System.out.println("Asýl dizi:");
			new Yonet().yazdir(dizim);
			System.out.println("");
			System.out.println("Tersine dizi:");
			new Yonet().yazdir(sonuc);
		}
		// new Yonet().islem2();
		// new Yonet().islem3();
		// new Yonet().islem4();
		// new Yonet().islem5();
		// new Yonet().islem6();
		// new Yonet().dosyaOku();
		// new Yonet().dosyaKopyala();
		// new Yonet().klawyegirisi();
		// new Yonet().dizinOlustur();
		// new Yonet().dizinListele();
		// new Yonet().dosyaTasi();
		new Yonet().delete();
	}

}
