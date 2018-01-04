package com.lyz.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.lyz.common.util.jsonlib.DateJsonBeanProcessor;
import com.lyz.common.util.jsonlib.DateJsonValueProcessor;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import net.sf.json.util.JSONUtils;

public class JsonUtil {
	
	private JsonUtil() {};
	
	//可转换的日期格式，即Json串中可以出现以下格式的日期与时间
	private static void setDateFormat() {
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new String[]{"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss",
				"MM/dd/yyyy HH:mm:ss", "MM/dd/yyyy"}));
	}
	
	/**
	 * 获得通用的JsonConfig
	 * @param excludes 排除的properties
	 * @return
	 */
	public static JsonConfig configJson(String[] excludes) {   
        JsonConfig jsonConfig = new JsonConfig();   
        if (excludes != null) jsonConfig.setExcludes(excludes);   
        jsonConfig.setIgnoreDefaultExcludes(false);   
        jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);   
        jsonConfig.registerJsonBeanProcessor(Date.class, new DateJsonBeanProcessor()); 
        jsonConfig.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor());
        return jsonConfig;   
    } 
	
	public static JsonConfig configJson() {
		return configJson(null);
	}
	
	/**
	 * javaObject to JsonObject
	 * @param javaObject
	 * @return
	 */
	public static JSONObject obj2Json(Object javaObject) {
		return JSONObject.fromObject(javaObject, configJson());
	}
	
	/**
	 * @param javaObject
	 * @param excludes 需要排除的property
	 * 例如: new String[]{"case", "empty"}
	 * @return
	 */
	public static JSONObject obj2Json(Object javaObject, String[] excludes) {
		return JSONObject.fromObject(javaObject, configJson(excludes));
	}
	
	/**
	 * java object to JsonArray Object
	 * @param javaObject
	 * @return
	 */
	public static JSONArray obj2JsonArray(Object javaObject) {
		return JSONArray.fromObject(javaObject, configJson());
	}
	
	public static JSONArray obj2JsonArray(Object javaObject, String[] excludes) {
		return JSONArray.fromObject(javaObject, configJson(excludes));
	}
	
	public static <T> List<T> json2JavaList(String jsonString, Class<T> clazz) throws Exception {
		return json2List(jsonString, clazz, null);
	}
	
	/**
	 * 根据jsonString生成List的对象
	* @param jsonString
	* @param clazz	List包含的类
	* @param excludes	需要去掉的属性
	* @return
	* @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> json2List(String jsonString, Class<T> clazz, String[] excludes) throws Exception {
		JSONArray ja = JSONArray.fromObject(jsonString, configJson(excludes));
		setDateFormat();
		Collection<T> c = JSONArray.toCollection(ja, clazz);
		if (c == null) {
			return null;
		}
		else {
			List<T> rl = new ArrayList<T>();
			rl.addAll(c);
			return rl;
		}
	}
	
	/**
	 * 将json字符串装换为对应的java对象
	 * @param jsonString
	 * @param clazz
	 * @param excludes
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static <T> T json2Obj(String jsonString, Class<T> clazz, String[] excludes) throws Exception {
		JSONObject jo = JSONObject.fromObject(jsonString, configJson(excludes));
		setDateFormat();
		return (T)JSONObject.toBean(jo, clazz);
	}
	
	public static <T> T json2Obj(String jsonString, Class<T> clazz) throws Exception {
		return json2Obj(jsonString, clazz, null);
	}

	/**
	 * java object to JsonArray Object
	 * 
	 * @param javaObject
	 * @return
	 */
	public static JSONArray javaObject2JsonArray(Object javaObject) {
		return JSONArray.fromObject(javaObject);
	}
	
	/**
	 * 将json串转为map类型
	 * @param object
	 * @return
	 */
	public static HashMap<String, Object> toHashMap(Object object) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		// 将json字符串转换成jsonObject
		JSONObject jsonObject = JSONObject.fromObject(object);
		Iterator it = jsonObject.keys();
		jsonObject.names();
		Collection values = jsonObject.values();
		
		// 遍历jsonObject数据，添加到Map对象
		while (it.hasNext()) {
			String key = String.valueOf(it.next());
			Object value = jsonObject.get(key);
			//JSONArray array = jsonObject.getJSONArray(key);
			data.put(key, value);
		}
		return data;
	}
	
	
}