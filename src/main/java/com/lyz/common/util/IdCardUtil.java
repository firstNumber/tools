package com.lyz.common.util;

import java.util.Calendar;

/**
 * 身份证号工具类
 **********************************
* @Description: TODO
* @author: wangxingfei
* @createdAt: 2016年4月1日下午2:35:13
**********************************
 */
public class IdCardUtil {
	private static int ID_LENGTH = 17;

	
    /**
     * 正则校验格式
    * @param idNum
    * @return
    * @Author: wangxingfei
    * @Date: 2016年4月1日
     */
    private static boolean verifyFormat(String idNum) {
        String curYear = "" + Calendar.getInstance().get(Calendar.YEAR);
        int y3 = Integer.valueOf(curYear.substring(2, 3));
        int y4 = Integer.valueOf(curYear.substring(3, 4));
        // 43 0103 1973 0 9 30 051 9
        return idNum.matches("^(1[1-5]|2[1-3]|3[1-7]|4[1-6]|5[0-4]|6[1-5]|71|8[1-2])\\d{4}(19\\d{2}|20([0-" + (y3 - 1) + "][0-9]|" + y3 + "[0-" + y4
                + "]))(((0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])))\\d{3}([0-9]|x|X)$");
    }
	
    /**
     * 按规则校验最后一位 是否正确
    * @param idCard
    * @return
    * @Author: wangxingfei
    * @Date: 2016年4月1日
     */
    private static boolean verifyLastCode(String idNum) {
        // 系数列表
        int[] ratioArr = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        // 校验码列表
        char[] checkCodeList = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
        // 获取身份证号字符数组
        char[] cIds = idNum.toCharArray();

        // 获取最后一位（身份证校验码）
        char oCode = cIds[ID_LENGTH];
        int[] iIds = new int[ID_LENGTH];
        int idSum = 0;// 身份证号第1-17位与系数之积的和
        int residue = 0;// 余数(用加出来和除以11，看余数是多少？)
        for (int i = 0; i < ID_LENGTH; i++) {
            iIds[i] = cIds[i] - '0';
            idSum += iIds[i] * ratioArr[i];
        }
        residue = idSum % 11;// 取得余数
        return Character.toUpperCase(oCode) == checkCodeList[residue];
    }
    
    /**
     * 校验身份证号(18位的)
    * @param idCard
    * @return
    * @Author: wangxingfei
    * @Date: 2016年4月1日
     */
    public static boolean verify(String idCard) {
    	if(idCard==null || idCard.length()!=18) return false;
        return verifyFormat(idCard) && verifyLastCode(idCard);
    }
    
   /**
    * 15位身份证格式校验
   * @param idNum
   * @return
   * @Author: wangxingfei
   * @Date: 2016年4月1日
    */
    private static boolean verifyFormat15(String idNum) {
        return idNum.matches("^(1[1-5]|2[1-3]|3[1-7]|4[1-6]|5[0-4]|6[1-5]|71|8[1-2])\\d{6}(((0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])))\\d{3}$");
    }
    
    /**
     * 校验15位身份证号
    * @param idCard
    * @return
    * @Author: wangxingfei
    * @Date: 2016年4月1日
     */
    public static boolean verify15(String idCard) {
    	if(idCard==null || idCard.length()!=15) return false;
        return verifyFormat15(idCard);//15位不用校验最后一位
    }

    public static void main(String[] args) {
//        String idNum = "430103197309300519";
//        String idNum = "210102820826411";
        String idNum = "410326880818551";
        System.out.println(verify15(idNum));
//        String idNum2 = "411111198808185510";
        String idNum2 = "410326198808185515";
        System.out.println(verify(idNum2));
    }
}