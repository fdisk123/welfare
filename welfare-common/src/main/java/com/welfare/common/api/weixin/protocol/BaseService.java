package com.welfare.common.api.weixin.protocol;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

import com.welfare.common.api.weixin.common.Configure;
import com.welfare.common.api.weixin.service.IServiceRequest;

/**
 * User: rizenguo Date: 2014/12/10 Time: 15:44:00 服务的基类
 */
public class BaseService {

	// API的地址
	private String apiURL;

	// 发请求的HTTPS请求器
	private IServiceRequest serviceRequest;

	@SuppressWarnings("rawtypes")
	public BaseService(String api) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		apiURL = api;
		Class c = Class.forName(Configure.HttpsRequestClassName);
		serviceRequest = (IServiceRequest) c.newInstance();
	}

	protected String sendPost(Object xmlObj) throws UnrecoverableKeyException, IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
		return serviceRequest.sendPost(apiURL, xmlObj);
	}

	/**
	 * 供商户想自定义自己的HTTP请求器用
	 * 
	 * @param request
	 *            实现了IserviceRequest接口的HttpsRequest
	 */
	public void setServiceRequest(IServiceRequest request) {
		serviceRequest = request;
	}
}
