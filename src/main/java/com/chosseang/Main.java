package com.chosseang;

public class Main {
	public static void main(String[] args) {

		System.out.println("Hello world!");

		EncryptResult encryptedData = Encrypt.encrypt("test");

		System.out.println("암호화");
		System.out.println(encryptedData.getDataKey());
		System.out.println(encryptedData.getIv());
		System.out.println(encryptedData.getEncryptedData());

		DecryptResult data = Encrypt.decrypt(
			new DecryptRequestParam(encryptedData.getEncryptedData(), encryptedData.getIv(), encryptedData.getDataKey()));
		System.out.println("복호화");
		System.out.println(data.getDataKey());
		System.out.println(data.getIv());
		System.out.println(data.getDecryptedData());
	}
}
