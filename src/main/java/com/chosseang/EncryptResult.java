package com.chosseang;

public class EncryptResult {
	private final String encryptedData;
	private final String iv;
	private final String dataKey;

	public EncryptResult(String encryptedData, String dataKey, String iv) {
		this.encryptedData = encryptedData;
		this.dataKey = dataKey;
		this.iv = iv;
	}

	public String getEncryptedData() { return encryptedData; }
	public String getDataKey() { return dataKey; }
	public String getIv() { return iv; }
}
