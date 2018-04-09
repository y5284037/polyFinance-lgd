package com.ptteng.polyFinance.lgd.payutil.fuiou.mpay.encrypt;

import java.util.Map;

public class RSAUtilsFUIOU {
	/**
	 * 
	* @Title: getKeyInfo
	* @Description: (生成公私钥字符串方法)
	* @param     设定文件
	* @return void    返回类型
	* @throws
	 */
	public static void getKeyInfo() {
		try {

			Map<String, Object> keyMap = RSAUtils.genKeyPair();
			String publicKey = RSAUtils.getPublicKey(keyMap);
			String privateKey = RSAUtils.getPrivateKey(keyMap);
			System.err.println("公钥: \n\r" + publicKey);
			System.err.println("私钥： \n\r" + privateKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	* @Title: encryptByPrivateKey
	* @Description: (私钥加密)
	* @param @param encodedData（待加密明文）
	* @param @param privateKey（私钥字符串）
	* @param @return    设定文件
	* @return String    返回类型）(加密后的密文)
	* @throws
	 */
	public static String encryptByPrivateKey(String encodedData, String privateKey) {
		byte[] data = encodedData.getBytes();
		String posStr = "";
		try {
			posStr = Base64Utils.encode(RSAUtils.encryptByPrivateKey(data, privateKey));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return posStr;

	}

	/**
	 * 
	* @Title: decryptByPublicKey
	* @Description: (公钥解密)
	* @param @param decodeData（加密密文）
	* @param @param publicKey(公钥字符串)
	* @param @return    设定文件
	* @return String    返回类型（明文）
	* @throws
	 */
	public static String decryptByPublicKey(String decodeData, String publicKey) {
		byte[] decodedData = null;
		try {
			decodedData = RSAUtils.decryptByPublicKey(Base64Utils.decode(decodeData), publicKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new String(decodedData);

	}

	static void testdecryp() throws Exception {

		String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIR1Oi/5UedqnBvNU6JWFBTc7vgrSJNcLRwx+Rpj3XYWym6tZrSUUa0GKPO/0K/5hwLE9Q74LmhJp6ZazbaB9u9sHf/gwlWqcvZYN+yrjNhKEic3rBZslLThX7TYz8EkteSGsN3DY2NRaoa0CNh870kxVUL0iQkoRuWx1n1pHiSZAgMBAAECgYAFvW7AFXXPKXeKXON67XABV3Gjn3yNpjjuN9wroJhAPcyX7zu8J5FChjnQFkfc2FtZa1+TPn4EVuzE8LppZkhlF5dK/dVX8FTx4q7yZ9tdG+fttQkNf3AfOGdIGNjul5gZIE2m/ID4yLgSdmx7HBGdE4mGphgKih0Yh9NWq1BpgQJBANLG9GKFkz8IVcgHlo3pANKmTPgyUQim8MzAeX5FjZPsDDbyeO/reAeE+GHJh+iucY+yZanJCD4JubnuAYxarjUCQQCg4Iwc2uMUcOrfcA7VAdyUiI1cbrnO3r5DoVmhHhU7F6lm7g1gF4hXhVv6XXa/0PbljE/8Q+mlCyz3jzMmZrlVAkEAwKXPoGzuFGKN5PHqjXI1qlMNbpyuq/XJiZsycFMp/9VzpJUiLEdPwa+rRdVpPyaR7QDlIrX3rpw9AM+k4p/PMQJAd9atKLV44Ho4y9aahdvMJ60MuGUW7l4IlzJzJMzW/dzjaPQ9bG47Nw71dCv5UGvl7xq1XnJscnA/v+2hKaLtvQJAamQQEX5Uj31AAgL+oeGBGtDnMBBGagkqExKIAi7jGJIxzeaW/q2VzTaegBxYn8RK11HcNe7MXHZocNqw3JJ+pg==";
		String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCEdTov+VHnapwbzVOiVhQU3O74K0iTXC0cMfkaY912FspurWa0lFGtBijzv9Cv+YcCxPUO+C5oSaemWs22gfbvbB3/4MJVqnL2WDfsq4zYShInN6wWbJS04V+02M/BJLXkhrDdw2NjUWqGtAjYfO9JMVVC9IkJKEblsdZ9aR4kmQIDAQAB";
		System.err.println("私钥加密——公钥解密");

		String source = "333333这是一行测试RSA数字签名的无意义文字";
		System.out.println("原文字：\r\n" + source);
		String posStr = encryptByPrivateKey(source, privateKey);

		System.out.println("加密后：\r\n" + posStr);
		String target = decryptByPublicKey(posStr, publicKey);
		System.out.println("解密后: \r\n" + target);
		System.err.println(source.equals(target));

	}

	public static void main(String[] args) throws Exception {
		//	getKeyInfo();
			testdecryp();
		}
}
