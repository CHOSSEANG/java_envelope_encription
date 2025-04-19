package com.chosseang;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KmsUtilsTest {

	@Test
	public void KmsEncryptDecryptTest() {
		KmsUtils kmsUtils = new KmsUtils();

		kmsUtils.init("25211055-4f8f-4bb8-aeb1-67bfa801aefd");

		String encryptResult = kmsUtils.encrypt("test");

		Assertions.assertEquals("test", kmsUtils.decrypt(encryptResult));
	}
}
