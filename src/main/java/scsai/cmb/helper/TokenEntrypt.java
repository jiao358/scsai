package scsai.cmb.helper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class TokenEntrypt {
	private static final Logger logger = Logger.getLogger(TokenEntrypt.class);
	private static String pwd = "estelasu";

	public static String encrypt(String content) {
		byte[] encryptResult = encrypt(content, pwd);
		return setEncString(encryptResult);
	}

	public static String decrypt(String password) {
		String result = "";
		try {
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] debuf = decoder.decodeBuffer(password);
			byte[] decrypt = decrypt(debuf, pwd);
			result = new String(decrypt);
			/*
			 * byte[] decryptFrom = parseHexStr2Byte(password);
			 * logger.info("now the 16ox convertto length="+decryptFrom.length);
			 * logger.info(Arrays.toString(decryptFrom));
			 * 
			 * byte[] decryptResult = decrypt(decryptFrom,pwd); result = new
			 * String (decryptResult);
			 */
		} catch (Exception e) {
			logger.error("decrypt failed -->", e);
		}
		return result;
	}

	public static String setEncString(byte[] buf) {
		BASE64Encoder base64en = new BASE64Encoder();
		return base64en.encode(buf);
	}

	public static void main(String[] args) throws IOException {
		/*
		 * String paswd= "123456"; System.out.println(encrypt(paswd)); String
		 * psd= "6E0C304C265ADB22A4EF5EF74D8C88DC";
		 * System.out.println(decrypt(psd));
		 * 
		 * byte[] buf= {110, 12, 48, 76, 38, 90, -37, 34, -92, -17, 94, -9, 77,
		 * -116, -120, -36}; byte[] cc=decrypt(buf,pwd); String vv= new
		 * String(cc); System.out.println(vv);
		 */
		String str = "123456";
		byte[] buf = encrypt(str, pwd);
		String encryptString = setEncString(buf);
		System.out.println(encryptString);
		BASE64Decoder decoder = new BASE64Decoder();

		byte[] debuf = decoder.decodeBuffer(encryptString);
		byte[] decrypt = decrypt(debuf, pwd);

		System.out.println(new String(decrypt, "utf-8"));

	}

	public static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}

	public static String parseByte2HexStr(byte buf[]) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	public static byte[] decrypt(byte[] content, String password) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			kgen.init(128, secureRandom);
			secureRandom.setSeed(password.getBytes());

			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");// 创建密码器
			cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(content);
			return result; // 加密
		} catch (Exception e) {
			logger.error("decrypt something error", e);
		}
		return null;
	}

	public static byte[] encrypt(String content, String password) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			kgen.init(128, secureRandom);
			secureRandom.setSeed(password.getBytes());

			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");// 创建密码器
			byte[] byteContent = content.getBytes("utf-8");
			cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(byteContent);
			return result; // 加密
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
