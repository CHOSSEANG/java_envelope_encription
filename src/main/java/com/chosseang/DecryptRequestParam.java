package com.chosseang;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class DecryptRequestParam {
	private final String encryptedData;
	private final IvParameterSpec iv;
	private final SecretKey dataKey;

	public DecryptRequestParam(String encryptedData, IvParameterSpec iv, SecretKey dataKey) {
		this.encryptedData = encryptedData;
		this.iv = iv;
		this.dataKey = dataKey;
	}

	public String getEncryptedData() {return encryptedData;}
	public IvParameterSpec getIv() {return iv;}
	public SecretKey getDataKey() {return dataKey;}
}
