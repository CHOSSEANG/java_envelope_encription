package com.chosseang;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EncryptDecryptTest {

	@Test
	public void encryptDecryptTest(){

		String input = "test";

		EncryptResult encryptResult = Encrypt.encrypt(input);

		DecryptRequestParam decryptRequst = new DecryptRequestParam(encryptResult.getEncryptedData(),encryptResult.getIv(),encryptResult.getDataKey());

		DecryptResult decryptResult = Encrypt.decrypt(decryptRequst);

		Assertions.assertEquals(input,decryptResult.getDecryptedData());
	}
}
