package com.chosseang;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class Encrypt {

	public static EncryptResult encrypt(String plainText) {
		try {
			SecretKey dataKey = GenerateKey();

			// IV 생성
			byte[] iv = new byte[16]; // AES 블록 크기는 16바이트
			new SecureRandom().nextBytes(iv);
			IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, dataKey,ivParameterSpec);

			byte[] encrypted = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));

			// 결과 인코딩
			String encryptedBase64 = Base64.getEncoder().encodeToString(encrypted);

			return new EncryptResult(encryptedBase64, dataKey, ivParameterSpec);
		} catch (Exception e) {
			return null;
		}
	}

	public static DecryptResult decrypt(DecryptRequestParam decryptRequestParam){
		try{
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

			SecretKey dataKey = decryptRequestParam.getDataKey();
			IvParameterSpec iv = decryptRequestParam.getIv();
			String encryptedData = decryptRequestParam.getEncryptedData();

			cipher.init(Cipher.DECRYPT_MODE, dataKey,iv);
			byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
			String decryptedBase64 = new String(decrypted, StandardCharsets.UTF_8);
			return new DecryptResult(decryptedBase64, iv,dataKey);
		} catch(Exception e){
			return null;
		}
	}

	public static SecretKey GenerateKey() throws NoSuchAlgorithmException {
		KeyGenerator keyGenerator = KeyGenerator.getInstance(CryptoConstants.AES_ALGORITHM);
		keyGenerator.init(CryptoConstants.AES_KEY_SIZE);

		return keyGenerator.generateKey();
	}

	public static String encryptKey(String masterKey) {


		return "";
	}

	public static SecretKey decryptKey() {


		return null;
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
