package com.lyz.common.util;

import org.apache.commons.lang.StringUtils;

/**
 * 一些常量
 */
public class SysConst {
	
	public static final Integer OPERATION_TIME = 5;	//一些更新操作动作默认缓存的秒数,用于防止重复提交
	public static final Integer TOKEN_VALID_TIME = 1200;	//token有效期,20分钟
	
	public static final Integer STATUS_COMMON = 1;
	public static final Integer STATUS_CLOSE = 2;
	
	public static final Integer ROLE_MANAGER = 1;	//管理员
	public static final Integer ROLE_COMMON = 2;	//普通用户
	
	public static final Integer ALL_CAR_TYPE = 99;	//司机不限车型
	public static final Float ALL_CAR_SIZE = 99f;	//司机不限车长
	
	
	/**
	 * 排序方式
	 * @author Administrator
	 *
	 */
	public enum SortBy{
		ASC,DESC;
	}
	
	/**
	 * 物流单状态
	 * *********************************
	* @Description: TODO
	* @author: wangxingfei
	* @createdAt: 2016年5月17日上午11:04:23
	**********************************
	 */
	public enum LgOrderStatus{
		已取消(1),待抢单(2),抢单中(3),待收货(4),已完成(5),待确认(6),未派车(7),待装车(8);
		private Integer value;
		LgOrderStatus(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
		
		/**
		 * 根据code,找枚举
		* @param status
		* @return
		* @Author: wangxingfei
		* @Date: 2016年5月24日
		 */
		public static LgOrderStatus code2Eunm(Integer status) {
			for(LgOrderStatus lg :LgOrderStatus.values()){
				if(lg.getCode().equals(status)){
					return lg;
				}
			}
			return null;
		}
	}
	
	/**
	 * 物流单明细状态
	 * *********************************
	* @Description: TODO
	* @author: wangxingfei
	* @createdAt: 2016年5月17日上午11:12:09
	**********************************
	 */
	public enum LgOrderDetailStatus{
//		未收货(2),已收货(3);
		待装车(21),发货人已确认装车(22),司机已确认装车(23),已收货(25);
		private Integer value;
		LgOrderDetailStatus(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	
	/**
	 * 物流单状态
	 * *********************************
	* @Description: TODO
	* @author: wangxingfei
	* @createdAt: 2016年5月17日上午11:04:23
	**********************************
	 */
	public enum DriverRobStatus{
		待确认(1),已确认(2),未被选中(3);
		private Integer value;
		DriverRobStatus(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	
	/**
	 * 司机抢单被取消的类型
	 * *********************************
	* @Description: TODO
	* @author: wangxingfei
	* @createdAt: 2016年6月2日上午9:27:46
	**********************************
	 */
	public enum RobCancelType{
		订单取消(1),已被确认(2),时间冲突(3);
		private Integer value;
		RobCancelType(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
	/**
	 * 客户端	来源 类型
	 * *********************************
	* @Description: TODO
	* @author: wangxingfei
	* @createdAt: 2015年8月19日下午4:07:44
	**********************************
	 */
	public enum FromType{
		web,ios,android;
		//判断类型是否正确
		public static boolean contains(String type){
			boolean b = false;
			if(StringUtils.isNotBlank(type)){
				for(FromType ft :FromType.values()){
					if(ft.toString().equalsIgnoreCase(type)){
						b = true;
						break;
					}
				}
			}
			return b;
		}
	}
	
	
	/**
	 * 骑士认证状态
	 */
	public enum QishiStatus{
		审核中(1),审核完成(2),审核未通过(3);
		private Integer value;
		QishiStatus(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
		
		public static String code2Name(Integer status) {
			for(QishiStatus qs :QishiStatus.values()){
				if(qs.getCode().equals(status)){
					return qs.toString();
				}
			}
			return null;
		}
	}
	
	
	/**
	 * 消息场景
	 */
	public enum SceneType{
		确认司机(1),确认收货(2),订单人工取消(3);
		private Integer value;
		SceneType(Integer value){
			this.value = value;
		}
		public Integer getCode(){
			return this.value;
		}
	}
	
}
