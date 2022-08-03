package com.temelfw;

import java.util.List;
import java.util.stream.Collectors;

public class Yonet {

	public static void main(String[] args) {
		
		new Fw()
		.ready("Merhaba Dünya")
		.spliteGo()
		.forEach();		
		
	    List<String>  veri = new Fw()
	    		.ready("Merhaba Dünya")
	    		.splite().stream()
	    		.filter(data -> data.contains("D"))
	    		.collect(Collectors.toList());		

	    veri.forEach(System.out::println);
		
	    
	    
	    
	    
		
	}

}
