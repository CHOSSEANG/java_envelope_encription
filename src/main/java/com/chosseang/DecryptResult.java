package com.chosseang;

public class DecryptResult {
	private final String decryptedData;
	private final String iv;
	private final String dataKey;

	public DecryptResult(String decryptedData, String iv, String dataKey) {
		this.decryptedData = decryptedData;
		this.iv = iv;
		this.dataKey = dataKey;
	}

	public String getDecryptedData() {return decryptedData;}
	public String getIv() {return iv;}
	public String getDataKey() {return dataKey;}
}
