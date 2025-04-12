package com.chosseang;

import java.security.NoSuchAlgorithmException;

import javax.crypto.SecretKey;

public class Main {
	public static void main(String[] args) throws NoSuchAlgorithmException {

		System.out.println("Hello world!");

		SecretKey dataKey = Encrypt.encrypt();

		System.out.println(dataKey);
	}
}
