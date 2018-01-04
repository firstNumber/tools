package com.lyz.common.util;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

/**
 * 生成摘要工具类
 */
public class DigestUtil {
    public static final String GBK="GBK";
    public static final String UTF8="UTF-8";

    /**
     * MD5
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] encryptMD5(byte[] data) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(data);
        return md5.digest();
    }

    /**
     * base64
     * @param md5
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(byte[] md5) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(md5);
    }

    /**
     * 摘要生成
     * @param data 请求数据
     * @param sign 签名秘钥(key或者parternID)
     * @param charset 编码格式
     * @return 摘要
     * @throws Exception
     */
    public static String digest(String data,String sign,String charset) throws Exception {
			String t = encryptBASE64(encryptMD5((data + sign).getBytes(charset)));
		// BASE64编码之后默认有一个回车换行符，这个符号在windows上 与 linux不同
		// 中通后台是按照 Windows 换行符校验的，如果调用者是linux 系统要做个转换
		if (System.getProperty("line.separator").equals("\n")) {
			String t2 = t.replaceAll("\\n", "\r\n");
			return t2;
		} else {
			return t;
		}
    }

    /**
     * 调用测试
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
//        System.out.println(digest("{\"partnerCode\":\"130520142013234\",\"type\":\"\",\"tradeId\":\"2701843\",\"mailNo\":\"1000000000016\",\"sender\":{\"id\":\"130520142010\",\"name\":\"李琳\",\"company\":\"新南电子商务有限公司\",\"mobile\":\"13912345678\",\"phone\":\"021-87654321\",\"prov\":\"上海市\",\"city\":\"上海市\",\"county\":\"青浦区\",\"address\":\"华新镇华志路123号\",\"zipcode\":\"610012\"},\"receiver\":{\"id\":\"130520142097\",\"name\":\"杨逸嘉\",\"company\":\"逸嘉实业有限公司\",\"mobile\":\"13687654321\",\"phone\":\"010-22226789\",\"prov\":\"四川省\",\"city\":\"成都市\",\"county\":\"武侯区\",\"address\":\"育德路497号\",\"zipcode\":\"610012\"},\"items\":[{\"id\":\"1234567\",\"name\":\"迷你风扇\",\"category\":\"电子产品\",\"material\":\"金属\",\"size\":\"12,11,23\",\"weight\":753,\"unitprice\":\"79\",\"quantity\":\"1\",\"remark\":\"黑色大号\"},{\"name\":\"USB3.0集线器\",\"quantity\":\"1\",\"remark\":\"\"}],\"starttime\":\"2013-05-20 12:00:00\",\"endtime\":\"2013-05-20 15:00:00\",\"weight\":753,\"size\":\"12,23,11\",\"quantity\":2,\"price\":12650,\"freight\":1000,\"premium\":50,\"packCharges\":100,\"otherCharges\":0,\"orderSum\":0,\"collectMoneytype\":\"CNY\",\"collectSum\":1200,\"remark\":\"请勿摔货\"}","1D841C9ACCE719C4A7ACDA0F247AB6D7",UTF8));
        System.out.println(digest("{\"partnerCode\":\"130520142013234\",\"type\":\"\",\"tradeId\":\"2701843\",\"mailNo\":\"1000000000016\",\"sender\":{\"id\":\"130520142010\",\"name\":\"李琳\",\"company\":\"新南电子商务有限公司\",\"mobile\":\"13912345678\",\"phone\":\"021-87654321\",\"area\":\"上海市\",\"city\":\"上海市\",\"county\":\"青浦区\",\"address\":\"华新镇华志路123号\",\"zipcode\":\"610012\"},\"receiver\":{\"id\":\"130520142097\",\"name\":\"杨逸嘉\",\"company\":\"逸嘉实业有限公司\",\"mobile\":\"13687654321\",\"phone\":\"010-22226789\",\"area\":\"四川省\",\"city\":\"成都市\",\"county\":\"武侯区\",\"address\":\"育德路497号\",\"zipcode\":\"610012\"},\"items\":[{\"id\":\"1234567\",\"name\":\"迷你风扇\",\"category\":\"电子产品\",\"material\":\"金属\",\"size\":\"12,11,23\",\"weight\":\"0.752\",\"unitprice\":\"79\",\"quantity\":\"1\",\"remark\":\"黑色大号\"},{\"name\":\"USB3.0集线器\",\"quantity\":\"1\",\"remark\":\"\"}],\"starttime\":\"2013-05-20 12:00:00\",\"endtime\":\"2013-05-20 15:00:00\",\"weight\":753,\"size\":\"12,23,11\",\"quantity\":2,\"price\":12650,\"freight\":1000,\"premium\":50,\"packCharges\":100,\"otherCharges\":0,\"orderSum\":0,\"collectMoneytype\":\"CNY\",\"collectSum\":1200,\"remark\":\"请勿摔货\"}","1D841C9ACCE719C4A7ACDA0F247AB6D7",UTF8));
        System.out.println(digest("{\"partnerCode\":\"130520142013234\",\"type\":\"\",\"tradeId\":\"2701843\",\"mailNo\":\"1000000000016\",\"sender\":{\"id\":\"130520142010\",\"name\":\"李琳\",\"company\":\"新南电子商务有限公司\",\"mobile\":\"13912345678\",\"phone\":\"021-87654321\",\"prov\":\"上海市\",\"city\":\"上海市\",\"county\":\"青浦区\",\"address\":\"华新镇华志路123号\",\"zipcode\":\"610012\"},\"receiver\":{\"id\":\"130520142097\",\"name\":\"\",\"company\":\"逸嘉实业有限公司\",\"mobile\":\"\",\"phone\":\"\",\"prov\":\"\",\"city\":\"\",\"county\":\"武侯区\",\"address\":\"育德路497号\",\"zipcode\":\"610012\"},\"items\":[{\"id\":\"1234567\",\"name\":\"迷你风扇\",\"category\":\"电子产品\",\"material\":\"金属\",\"size\":\"12,11,23\",\"weight\":753,\"unitprice\":\"79\",\"quantity\":\"1\",\"remark\":\"黑色大号\"},{\"name\":\"USB3.0集线器\",\"quantity\":\"1\",\"remark\":\"\"}],\"starttime\":\"2013-05-20 12:00:00\",\"endtime\":\"2013-05-20 15:00:00\",\"weight\":753,\"size\":\"12,23,11\",\"quantity\":2,\"price\":12650,\"freight\":1000,\"premium\":50,\"packCharges\":100,\"otherCharges\":0,\"orderSum\":0,\"collectMoneytype\":\"CNY\",\"collectSum\":1200,\"remark\":\"请勿摔货\"}"
        		,"1D841C9ACCE719C4A7ACDA0F247AB6D7",UTF8));
//        System.out.println(digest("[\"1000000000016\"]","1D841C9ACCE719C4A7ACDA0F247AB6D7",UTF8));
    }
}
		 