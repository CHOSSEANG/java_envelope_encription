package com.chosseang;

public class Main {
	public static void main(String[] args)  {

		System.out.println("Hello world!");

		String dataKey = Encrypt.encrypt("test");

		System.out.println(dataKey);
	}
}
