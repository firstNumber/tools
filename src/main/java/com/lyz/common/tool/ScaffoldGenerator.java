package com.lyz.common.tool;

import java.util.HashMap;
import java.util.Map;

import com.lyz.common.tool.scaffold.ScaffoldGen;

public class ScaffoldGenerator {
	public static String COMPANY_NAME = "lyz";

	public static Map<String, String> pathMap = new HashMap<String, String>() {
		{
			put("Model.txt", "D:/officeware/eclipse/workespace2/lige2hao/");
			put("SqlMap.txt", "D:/officeware/eclipse/workespace2/lige2hao/");
//			put("Service.txt", "D:/officeware/eclipse/workespace2/lige2hao/");
//			put("Dao.txt", "D:/officeware/eclipse/workespace2/lige2hao/");
//			put("DaoImpl.txt", "D:/officeware/eclipse/workespace2/lige2hao/");
//			put("Service.txt", "D:/officeware/eclipse/workespace2/lige2hao/");
//			put("ServiceImpl.txt", "D:/officeware/eclipse/workespace2/lige2hao/");

			// put("Model.txt",
			// "E:/Workspaces/gitlab/zhidian-wuliu-user/wuliu-api-user/");
			// put("SqlMap.txt",
			// "E:/Workspaces/gitlab/zhidian-wuliu-user/wuliu-service-user/");
			// put("Dao.txt",
			// "E:/Workspaces/gitlab/zhidian-wuliu-user/wuliu-service-user/");
			// put("DaoImpl.txt",
			// "E:/Workspaces/gitlab/zhidian-wuliu-user/wuliu-service-user/");
			// put("Service.txt",
			// "E:/Workspaces/gitlab/zhidian-wuliu-user/wuliu-api-user/");
			// put("ServiceImpl.txt",
			// "E:/Workspaces/gitlab/zhidian-wuliu-user/wuliu-service-user/");
		}
	};

	/**
	 * @param args
	 * @Author: liduo
	 * @Date: 2016年11月8日
	 */
	public static void main(String[] args) {
		ScaffoldGen generator = new ScaffoldGen("user", "Carbox", "carbox");
		// true 控制台 false 文件
		generator.execute(false);
	}

}
