package com.chosseang;

public class DecryptRequest {
	private final String encryptedData;
	private final String iv;
	private final String dataKey;

	public DecryptRequest(String encryptedData, String iv, String dataKey) {
		this.encryptedData = encryptedData;
		this.iv = iv;
		this.dataKey = dataKey;
	}

	public String getEncryptedData() {return encryptedData;}
	public String getIv() {return iv;}
	public String getDataKey() {return dataKey;}
}
