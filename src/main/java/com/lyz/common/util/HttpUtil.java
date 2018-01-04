package com.lyz.common.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * get,post 请求util类
 * *********************************
* @Description: TODO
* @author: wangxingfei
* @createdAt: 2016年5月24日下午12:01:36
**********************************
 */
public class HttpUtil {
	private final static Log logger = LogFactory.getLog(HttpUtil.class);
	private static RequestConfig requestConfig = RequestConfig.custom()  
            .setSocketTimeout(15000)  
            .setConnectTimeout(15000)  
            .setConnectionRequestTimeout(15000)  
            .build();  
	
	/**
	 * post请求
	* @param url	请求路径
	* @param paramMap	参数key=key,value=value
	* @return	响应文本
	* @Author: wangxingfei
	* @Date: 2016年5月24日
	 */
	public static String post(String url,Map<String,String> paramMap) {
		String result = null;
		CloseableHttpClient httpclient = null;
		CloseableHttpResponse response = null;
        try {
        	httpclient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            httpPost.setConfig(requestConfig);
            if(paramMap!=null){
                List <NameValuePair> nvps = new ArrayList <NameValuePair>();
                for(Entry<String,String> entry : paramMap.entrySet()){
                	nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }
                httpPost.setEntity(new UrlEncodedFormEntity(nvps));	
            }
            response = httpclient.execute(httpPost);
            result = EntityUtils.toString(response.getEntity(), "UTF-8");
            return result;
        }catch(Exception e){
        	logger.error("url:"+url+","+paramMap!=null?paramMap.toString():"null"+","+e.getMessage(), e);
        }finally {
        	try {
        		if(response!=null) response.close();
        		if(httpclient!=null) httpclient.close();
			} catch (IOException e) {
				logger.error("url:"+url+","+paramMap.toString()+","+e.getMessage(), e);
			}
        }
        return result;
	}
	
	/**
	 * get请求
	* @param url	请求路径+参数
	* @return	响应文本
	* @Author: wangxingfei
	* @Date: 2016年5月24日
	 */
	public static String get(String url) {
		String result = null;
		CloseableHttpClient httpclient = null;
		CloseableHttpResponse response = null;
        try {
        	httpclient = HttpClients.createDefault();
        	HttpGet httpGet = new HttpGet(url);
        	httpGet.setConfig(requestConfig);
            response = httpclient.execute(httpGet);
            result = EntityUtils.toString(response.getEntity(), "UTF-8");
            return result;
        }catch(Exception e){
        	logger.error("url:"+url+","+e.getMessage(), e);
        }finally {
        	try {
        		if(response!=null) response.close();
        		if(httpclient!=null) httpclient.close();
			} catch (IOException e) {
				logger.error("url:"+url+","+e.getMessage(), e);
			}
        }
        return result;
	}

	public static void main(String[] args) {
//		String url = "http://192.168.1.247:8080/logistics/group/user/login.action";
//		Map<String, String> hm = new HashMap<String, String>();
//		hm.put("loginName", "18910557277");
//		hm.put("password", "e10adc3949ba59abbe56e057f20f883e");
//		String str = post(url,hm);
//		System.out.println(str);a235fbae341071c2f4d1f7615546d05azdg5
		
		String url = "http://192.168.1.247:8080/logistics/group/lgOrder/list.action";
		System.out.println(get(url));
	}

}
