package com.temelfw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fw {

	private String data = "";
	private List<String> icdizi = new ArrayList<>();

	public Fw ready(String data) {
		this.data = data;
		return this;
	}

	public List<String> splite() {

		return Arrays.asList(this.data.split(" "));

	}

	public Fw spliteGo() {

		this.icdizi = Arrays.asList(this.data.split(" "));
		return this;
	}

	public void forEach() {
		if (!icdizi.isEmpty()) {
			for (String str : icdizi) {
				System.out.println(str);
			}
		} else {
			System.out.println(this.data);
		}
	}

}
