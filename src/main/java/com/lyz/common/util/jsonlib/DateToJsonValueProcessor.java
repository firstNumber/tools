package com.lyz.common.util.jsonlib;

import java.text.SimpleDateFormat;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class DateToJsonValueProcessor implements JsonValueProcessor {

	public Object processArrayValue(Object value, JsonConfig jsonConfig) {
		return process(value, jsonConfig);
	}

	public Object processObjectValue(String key, Object value,
			JsonConfig jsonConfig) {
		return process(value, jsonConfig);
	}
	
	private Object process(Object value, JsonConfig jsonConfig) {
		if (value != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String ds = sdf.format(value);
			return ds;
		}
		else {
			return null;
		}
	}

}
