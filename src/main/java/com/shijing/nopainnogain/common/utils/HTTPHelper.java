package com.shijing.nopainnogain.common.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.nio.charset.StandardCharsets;



public class HTTPHelper {

	private static final Logger logger = LoggerFactory.getLogger(HTTPHelper.class);

	/** 客户端调用底层服务时，若要指定连接时间，则用此参数名来设置，单位是秒 */
	public static final String TIMEOUT_IN_PARAMS = "_timeout_";
	/** 客户端模仿盗链时 */
	public static final String REFERRER_IN_PARAMS = "_referrer_";
	public static final String REFERRER_IN_HEADER = "referer";
	
	private static int DEFAULT_TIMEOUT = 60000; //默认的过期时间，毫秒
	private static int DEFAULT_TIMEOUT_UPLOAD = 60000; //默认的上传过期时间，毫秒


	public static String doGet(String url){
		String result = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpResponse response = null;

		HttpGet httpGet = new HttpGet(url);
		try {
			response = httpclient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			if(entity != null){
				result = EntityUtils.toString(entity,StandardCharsets.UTF_8.name());
			}
		} catch (IOException e) {
			logger.error(e.getLocalizedMessage(), e);
		} finally {
			HttpClientUtils.closeQuietly(response);
			HttpClientUtils.closeQuietly(httpclient);
		}
		return result;
	}

	public static String doPost(String url,String jsonString){
		String result = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpResponse response = null;

		HttpPost httppost = new HttpPost(url);
		try {
			StringEntity uefEntity = new StringEntity(jsonString, ContentType.APPLICATION_JSON);
			uefEntity.setContentEncoding(StandardCharsets.UTF_8.name());
			httppost.setEntity(uefEntity);

			response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			if(entity != null){
				result = EntityUtils.toString(entity,StandardCharsets.UTF_8.name());
			}
		} catch (IOException e) {
			logger.error(e.getLocalizedMessage(), e);
		} finally {
			HttpClientUtils.closeQuietly(response);
			HttpClientUtils.closeQuietly(httpclient);
		}
		return result;
	}

}
