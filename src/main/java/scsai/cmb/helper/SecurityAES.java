package scsai.cmb.helper;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
public class SecurityAES {
	private final static String encoding = "UTF-8";
	public final static String pwd="estela";
	public static void main(String[] args) throws Exception {
		String encry=encryptAES("123456",pwd);
		System.out.println(encry);
		
		System.out.println(decrypt(encry, pwd));
		
	}
	public static String encryptAES(String content, String password)throws Exception  {
		byte[] encryptResult = encrypt(content, password);
		String encryptResultStr = parseByte2HexStr(encryptResult);
		encryptResultStr = ebotongEncrypto(encryptResultStr);
		return encryptResultStr;
	}
	//decrypt
	 public static String decrypt(String encryptResultStr, String password) throws Exception {
		 String decrpt = ebotongDecrypto(encryptResultStr);
		 byte[] decryptFrom = parseHexStr2Byte(decrpt);
		 byte[] decryptResult = decrypt(decryptFrom, password);
		 return new String(decryptResult);
	 }
	 public static String ebotongEncrypto(String str)throws Exception  {
		 BASE64Encoder base64encoder = new BASE64Encoder();
		 String result = str;
		 if (str != null && str.length() > 0) {
			 
			 byte[] encodeByte = str.getBytes(encoding);
			 result = base64encoder.encode(encodeByte);
		 }
		 return result.replaceAll("\r\n", "").replaceAll("\r", "").replaceAll("\n", "");
		 
	 }
	 public static String ebotongDecrypto(String str)throws Exception  {
		 BASE64Decoder base64decoder = new BASE64Decoder();
		 byte[] encodeByte = base64decoder.decodeBuffer(str);
		 return new String(encodeByte);
	 }
	 private static byte[] encrypt(String content, String password) throws Exception {
		 KeyGenerator kgen = KeyGenerator.getInstance("AES");
		//防止linux下 随机生成key;
		 SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG" );
		 secureRandom.setSeed(password.getBytes());
		 kgen.init(128, secureRandom);
		 SecretKey secretKey = kgen.generateKey();
		 byte[] enCodeFormat = secretKey.getEncoded();
		 SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
		 Cipher cipher = Cipher.getInstance("AES");
		 byte[] byteContent = content.getBytes("utf-8"); 
		 cipher.init(Cipher.ENCRYPT_MODE, key);
		 byte[] result = cipher.doFinal(byteContent);
		 return result;
	 }
	 private static byte[] decrypt(byte[] content, String password) throws Exception { 
		 
		 KeyGenerator kgen = KeyGenerator.getInstance("AES");
		 SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG" ); 
		 secureRandom.setSeed(password.getBytes()); 
		 kgen.init(128, secureRandom);
		 SecretKey secretKey = kgen.generateKey();
		 byte[] enCodeFormat = secretKey.getEncoded();
		 SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
		 Cipher cipher = Cipher.getInstance("AES");
		 cipher.init(Cipher.DECRYPT_MODE, key);
		 byte[] result = cipher.doFinal(content);
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
	 
	 public static byte[] parseHexStr2Byte(String hexStr) { 
		 if (hexStr.length() < 1)
			 return null;
		 byte[] result = new byte[hexStr.length()/2];
		 for (int i = 0;i< hexStr.length()/2; i++) { 
			 int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
			 int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16); 
			 result[i] = (byte) (high * 16 + low); 
		 }
			 
		 return result; 
			 
	 }
}
