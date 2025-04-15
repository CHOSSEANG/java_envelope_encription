package com.chosseang;

public class Main {
	public static void main(String[] args)  {

		System.out.println("Hello world!");

		EncryptResult dataKey = Encrypt.encrypt("test");

		System.out.println(dataKey.getDataKey());
		System.out.println(dataKey.getIv());
		System.out.println(dataKey.getEncryptedData());

	}
}
