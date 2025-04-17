package com.chosseang;

public class Main {
	public static void main(String[] args)  {

		System.out.println("Hello world!");

		EncryptResult encryptedData = Encrypt.encrypt("test");

		System.out.println("암호화");
		System.out.println(encryptedData.getDataKey());
		System.out.println(encryptedData.getIv());
		System.out.println(encryptedData.getEncryptedData());

		String data = Encrypt.decrypt(new DecryptRequest(encryptedData.getEncryptedData(), encryptedData.getIv(),encryptedData.getDataKey()));
		System.out.println("복호화");
		System.out.println(data);
	}
}
