package com.chosseang;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class EncryptResult {
	private final String encryptedData;
	private final IvParameterSpec iv;
	private final SecretKey dataKey;

	public EncryptResult(String encryptedData, SecretKey dataKey, IvParameterSpec iv) {
		this.encryptedData = encryptedData;
		this.dataKey = dataKey;
		this.iv = iv;
	}

	public String getEncryptedData() { return encryptedData; }
	public SecretKey getDataKey() { return dataKey; }
	public IvParameterSpec getIv() { return iv; }
}
