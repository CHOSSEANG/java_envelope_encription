package com.chosseang;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Encrypt {

	public static String encrypt(String plainText) {
		try {
			SecretKey dataKey = GenerateKey();

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, dataKey);

			byte[] encrypted = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));

			return new String(Base64.getEncoder().encode(encrypted));
		} catch (Exception e) {
			return null;
		}

	}

	public static SecretKey GenerateKey() throws NoSuchAlgorithmException {
		KeyGenerator keyGenerator = KeyGenerator.getInstance(CryptoConstants.AES_ALGORITHM);
		keyGenerator.init(CryptoConstants.AES_KEY_SIZE);

		return keyGenerator.generateKey();
	}
}

class CryptoConstants {
	// 암호화 알고리즘
	public static final String AES_GCM_ALGORITHM = "AES/GCM/NoPadding";
	public static final String AES_ALGORITHM = "AES";

	// GCM 모드 관련 상수
	public static final int GCM_TAG_LENGTH = 128; // bits
	public static final int GCM_IV_LENGTH = 12; // bytes

	// 키 크기
	public static final int AES_KEY_SIZE = 256; // bits
}
