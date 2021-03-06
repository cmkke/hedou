package org.hedou.guagua.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Rc4
{
	private static final String ALGORITHM = "RC4";

	public static final byte[] encrypt(byte[] src, byte[] key) throws Exception
	{
		SecretKey secretKey = new SecretKeySpec(key, ALGORITHM);
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(1, secretKey);
		return cipher.doFinal(src);
	}

	public static final byte[] decrypt(byte[] src, byte[] key) throws Exception
	{
		SecretKey secretKey = new SecretKeySpec(key, ALGORITHM);
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(2, secretKey);
		return cipher.doFinal(src);
	}
}