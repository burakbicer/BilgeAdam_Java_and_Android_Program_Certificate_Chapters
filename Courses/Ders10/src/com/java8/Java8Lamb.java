package com.java8;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Lamb {

	
	
	
	public static void main(String[] args) {
		 //Varsayým: Method dan seçilebilecek tipler gelir. 
		String[] dizi = {"One","Two","Three","Four"};
		
		Stream<String> st1 = Arrays.stream(dizi);
		st1.forEach(bilgi -> System.out.println(bilgi));
		
		Stream<String> st2 = Stream.of(dizi);
		st2.forEach(bilgi -> System.out.println(bilgi));
		
		
		
		int[] intdizisi = {1,2,3,4,5,6,7,8,9,10};
		IntStream intTipSt = Arrays.stream(intdizisi);
		intTipSt.forEach(bilgi -> System.out.println(bilgi));
		
		Stream<int[]> veri = Stream.of(intdizisi);
		IntStream intSt = veri.flatMapToInt(deger -> Arrays.stream(deger));
		intSt.forEach(System.out::println);
		
		
		
		
		
		
		
		
		
		
		
	}

}
