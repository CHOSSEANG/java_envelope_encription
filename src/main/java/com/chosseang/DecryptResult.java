package com.chosseang;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class DecryptResult {
	private final String decryptedData;
	private final IvParameterSpec iv;
	private final SecretKey dataKey;

	public DecryptResult(String decryptedData, IvParameterSpec iv, SecretKey dataKey) {
		this.decryptedData = decryptedData;
		this.iv = iv;
		this.dataKey = dataKey;
	}

	public String getDecryptedData() {return decryptedData;}
	public IvParameterSpec getIv() {return iv;}
	public SecretKey getDataKey() {return dataKey;}
}
