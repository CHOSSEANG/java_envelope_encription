package com.chosseang;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import org.apache.commons.codec.binary.Base64;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.AWSKMSClientBuilder;
import com.amazonaws.services.kms.model.DecryptRequest;
import com.amazonaws.services.kms.model.EncryptRequest;
import com.amazonaws.services.kms.model.EncryptionAlgorithmSpec;

public class KmsUtils {

	public static String key;

	private static final Regions REGIONS = Regions.AP_NORTHEAST_2;
	private static final EncryptionAlgorithmSpec ALGORITHM = EncryptionAlgorithmSpec.SYMMETRIC_DEFAULT;

	AWSKMS kmsClient = AWSKMSClientBuilder.standard()
		//.withCredentials(new AWSStaticCredentialsProvider(awsCreds))
		.withRegion(Regions.AP_NORTHEAST_2)
		.build();

	public String encrypt(String text) {
		AWSKMS kmsClient = AWSKMSClientBuilder.standard()
			.withRegion(REGIONS)
			.withCredentials(DefaultAWSCredentialsProviderChain.getInstance())
			.build();

		EncryptRequest request = new EncryptRequest();
		request.withKeyId(key);
		request.withPlaintext(ByteBuffer.wrap(text.getBytes(StandardCharsets.UTF_8)));
		request.withEncryptionAlgorithm(ALGORITHM);

		byte[] encryptBytes = kmsClient.encrypt(request).getCiphertextBlob().array();
		return Base64.encodeBase64String(encryptBytes);
	}

	public String decrypt(String encryptText) {
		AWSKMS kmsClient = AWSKMSClientBuilder.standard()
			.withRegion(REGIONS)
			.withCredentials(DefaultAWSCredentialsProviderChain.getInstance())
			.build();

		DecryptRequest request = new DecryptRequest();
		request.withKeyId(key);
		request.withCiphertextBlob(ByteBuffer.wrap(Base64.decodeBase64(encryptText)));
		request.withEncryptionAlgorithm(ALGORITHM);

		byte[] textBytes = kmsClient.decrypt(request).getPlaintext().array();
		return new String(textBytes);
	}
}
