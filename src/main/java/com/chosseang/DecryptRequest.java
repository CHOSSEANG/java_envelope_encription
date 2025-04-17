package com.chosseang;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class DecryptRequest {
	private final String encryptedData;
	private final IvParameterSpec iv;
	private final SecretKey dataKey;

	public DecryptRequest(String encryptedData, IvParameterSpec iv, SecretKey dataKey) {
		this.encryptedData = encryptedData;
		this.iv = iv;
		this.dataKey = dataKey;
	}

	public String getEncryptedData() {return encryptedData;}
	public IvParameterSpec getIv() {return iv;}
	public SecretKey getDataKey() {return dataKey;}
}
