package com.chosseang;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class Main {
	public static void main(String[] args) throws
		NoSuchAlgorithmException,
		NoSuchPaddingException,
		IllegalBlockSizeException,
		BadPaddingException,
		InvalidKeyException {

		System.out.println("Hello world!");

		String dataKey = Encrypt.encrypt("test");

		System.out.println(dataKey);
	}
}
