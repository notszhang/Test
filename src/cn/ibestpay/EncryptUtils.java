package cn.ibestpay;

import java.math.BigInteger;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

/**
 * 编码工具类
 * 实现aes加密、解密
 */
public class EncryptUtils {

	/**
	 * 密钥
	 */
	//private static String KEY = PropertiesUtil.getConfigValue("aesKey", "abcdefgabcdefg12");
	private static String KEY = "abcdefgabcdefg12";

	/**
	 * 算法
	 */
	private static String ALGORITHMSTR = "AES/ECB/PKCS5Padding";

	public static void main(String[] args) throws Exception {
		String content = "{\"userId\":\"123\",\"name\":\"123\",\"deptName\":\"总经办\",\"userType\":\"0\",\"aesKey\":\"abcdefgabcdefg12\"}";
		System.out.println("加密前：" + content);

		System.out.println("加密密钥和解密密钥：" + KEY);

		String encrypt = aesEncrypt(content, KEY);
		System.out.println("加密后：" + encrypt);

		String dec = "F8S53bK50dCB/QLTOFSBEoaXp4q6hIx7v+KWrBEo0G6Vv2+4e+CLd1uyimMs4dVi/M6TXCRHgaqVcL43i0i+2OCnjc/zZ6YJHMnkLkRm80KvanNM4miFAB7L3JaYvUZD2ZxoqFajE1l5ygasRx8c3nD63m/vW4PqwD3xVRD1pB/uIQqPhig6vw1YlBCBPXpx";
//		dec = java.net.URLDecoder.decode(dec, "UTF-8");
		System.out.println(dec);

		String decrypt = aesDecrypt(dec, KEY);
		System.out.println("解密后：" + decrypt);
	}

	/**
	 * aes解密
	 * @param encrypt	内容
	 * @return
	 * @throws Exception
	 */
	public static String aesDecrypt(String encrypt) throws Exception {
		return aesDecrypt(encrypt, KEY);
	}

	/**
	 * aes加密
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public static String aesEncrypt(String content) throws Exception {
		return aesEncrypt(content, KEY);
	}

	/**
	 * 将byte[]转为各种进制的字符串
	 * @param bytes byte[]
	 * @param radix 可以转换进制的范围，从Character.MIN_RADIX到Character.MAX_RADIX，超出范围后变为10进制
	 * @return 转换后的字符串
	 */
	public static String binary(byte[] bytes, int radix){
		return new BigInteger(1, bytes).toString(radix);// 这里的1代表正数
	}

	/**
	 * base 64 encode
	 * @param bytes 待编码的byte[]
	 * @return 编码后的base 64 code
	 */
	public static String base64Encode(byte[] bytes){
		return Base64.encodeBase64String(bytes);
	}

	/**
	 * base 64 decode
	 * @param base64Code 待解码的base 64 code
	 * @return 解码后的byte[]
	 * @throws Exception
	 */
	public static byte[] base64Decode(String base64Code) throws Exception{

		return StringUtils.isEmpty(base64Code) ? null : Base64.decodeBase64(base64Code);
	}


	/**
	 * AES加密
	 * @param content 待加密的内容
	 * @param encryptKey 加密密钥
	 * @return 加密后的byte[]
	 * @throws Exception
	 */
	public static byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey.getBytes(), "AES"));

        return cipher.doFinal(content.getBytes("UTF-8"));
    }


	/**
	 * AES加密为base 64 code
	 * @param content 待加密的内容
	 * @param encryptKey 加密密钥
	 * @return 加密后的base 64 code
	 * @throws Exception
	 */
	public static String aesEncrypt(String content, String encryptKey) throws Exception {
		return base64Encode(aesEncryptToBytes(content, encryptKey));
	}

	/**
	 * AES解密
	 * @param encryptBytes 待解密的byte[]
	 * @param decryptKey 解密密钥
	 * @return 解密后的String
	 * @throws Exception
	 */
	 public static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) throws Exception {
	        KeyGenerator kgen = KeyGenerator.getInstance("AES");
	        kgen.init(128);

	        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
	        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptKey.getBytes(), "AES"));
	        byte[] decryptBytes = cipher.doFinal(encryptBytes);

	        return new String(decryptBytes, "UTF-8");
	    }


	/**
	 * 将base 64 code AES解密
	 * @param encryptStr 待解密的base 64 code
	 * @param decryptKey 解密密钥
	 * @return 解密后的string
	 * @throws Exception
	 */
	public static String aesDecrypt(String encryptStr, String decryptKey) throws Exception {
		return StringUtils.isEmpty(encryptStr) ? null : aesDecryptByBytes(base64Decode(encryptStr), decryptKey);
	}

}
