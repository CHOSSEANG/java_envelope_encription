package com.chosseang;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Encrypt {

	public static SecretKey encrypt() throws NoSuchAlgorithmException {
		KeyGenerator dataKey = GenerateKey();

		return dataKey.generateKey();
	}

	public static KeyGenerator GenerateKey() throws NoSuchAlgorithmException {
		KeyGenerator keyGenerator = KeyGenerator.getInstance(CryptoConstants.AES_ALGORITHM);
		keyGenerator.init(CryptoConstants.AES_KEY_SIZE);

		return keyGenerator;
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
