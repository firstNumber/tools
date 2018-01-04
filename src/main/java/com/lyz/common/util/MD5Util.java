package com.lyz.common.util;

import java.security.MessageDigest;

public class MD5Util {

	/**
     * 转换字节数组为16进制字串
     * @param b 字节数组
     * @return 16进制字串
     */
	private static String byteArrayToHexString(byte b[]) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++)
			resultSb.append(byteToHexString(b[i]));

		return resultSb.toString();
	}

	   /**
     * 转换byte到16进制
     * @param b 要转换的byte
     * @return 16进制格式
     */
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n += 256;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}
	
    /**
     * MD5编码
     * @param origin 原始字符串
     * @return 经过MD5加密之后的结果
     */
	public static String encode(String origin){
		return encode(origin, "");
	}

    /**
     * MD5编码
     * @param origin 原始字符串
     * @param charsetname	编码方式
     * @return 经过MD5加密之后的结果
     */
	public static String encode(String origin, String charsetname) {
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			if (charsetname == null || "".equals(charsetname))
				resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
			else
				resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
		} catch (Exception exception) {
		}
		return resultString;
	}

	private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f" };

	
	public static void main(String[] args) {
		System.out.println(encode("000000"));
	}
	
	/**
	 * 初始化密码
	* @return
	* @Author: wangxingfei
	* @Date: 2016年5月21日
	 */
	public static String initPwd(){
		return encode(encode("123456"));
	}
	
}
