package com.fooluodi.elf.common.http.http;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.Map.Entry;

/**
 * 
 * @author di
 * httpclient工具类
 */
@HttpUtil
public class HttpRequest {
    public static PoolingClientConnectionManager connectionManager = new PoolingClientConnectionManager();
    public static HttpClient client;
    static {
        connectionManager.setMaxTotal(1000);
        connectionManager.setDefaultMaxPerRoute(200);
        HttpParams my_httpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(my_httpParams, 5000);
        HttpConnectionParams.setSoTimeout(my_httpParams, 5000000);
        client = new DefaultHttpClient(connectionManager, my_httpParams);
    }
    public static final Logger logger = LoggerFactory.getLogger(HttpRequest.class);
    public static final String ENCODE = "utf-8";

    /**
     * 
     * 
     * @param url
     * 请求的资源ＵＲＬ
     * @param postData
     * POST请求时form表单封装的数据 没有时传null
     * @param header
     * request请求时附带的头信息(header) 没有时传null
     * @param encoding
     * response返回的信息编码格式 没有时传null
     * @return response返回的文本数据
     * @throws
     */
    public HttpResponseEntity doRequest(String url, Map<String, Object> postData, Map<String, Object> header,
            String encoding) throws Exception {
        // 头部请求信息
        Header[] headers = null;
        if (header != null) {
            Set<Entry<String, Object>> entrySet = header.entrySet();
            int dataLength = entrySet.size();
            headers = new Header[dataLength];
            int i = 0;
            for (Iterator<Entry<String, Object>> itor = entrySet.iterator(); itor.hasNext();) {
                Entry<String, Object> entry = (Entry<String, Object>) itor.next();
                headers[i++] = new BasicHeader(entry.getKey().toString(), entry.getValue().toString());
            }
        }
        // post方式
        if (postData != null) {
            return doPost(url, postData, header, encoding, headers);
        }
        // get方式
        else {
            return doGet(url, header, encoding, headers);
        }
    }

    private HttpResponseEntity doPost(String url, Map<String, Object> postData, Map<String, Object> header,
            String encoding, Header[] headers) throws UnsupportedEncodingException, Exception {
        HttpPost postRequest = new HttpPost(url.trim());
        if (headers != null) {
            for (int i = 0; i < headers.length; i++) {
                postRequest.setHeader(headers[i]);
            }
        }
        Set<Entry<String, Object>> entrySet = postData.entrySet();
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        for (Iterator<Entry<String, Object>> itor = entrySet.iterator(); itor.hasNext();) {
            Entry<String, Object> entry = (Entry<String, Object>) itor.next();
            params.add(new BasicNameValuePair(entry.getKey().toString(), entry.getValue().toString()));
        }
        postRequest.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
        try {
            return (this.executeMethod(postRequest, encoding, postData, header));
        } catch (Exception e) {
            logger.error("HTTP_ERROR", e);
            throw e;
        } finally {
            postRequest.releaseConnection();
        }
    }

    private HttpResponseEntity doGet(String url, Map<String, Object> header, String encoding, Header[] headers)
            throws Exception {
        HttpGet getRequest = new HttpGet(url.trim());
        if (headers != null) {
            for (int i = 0; i < headers.length; i++) {
                getRequest.setHeader(headers[i]);
            }
        }
        try {
            return (this.executeMethod(getRequest, encoding, null, header));
        } catch (Exception e) {
            logger.error("HTTP_ERROR", e);
            throw e;
        } finally {
            getRequest.releaseConnection();
        }
    }

    private HttpResponseEntity executeMethod(HttpUriRequest request, String encoding, Map<String, Object> postData,
            Map<String, Object> header) throws Exception {
        HttpResponse httpResponse = client.execute(request);

        Header locationHeader = request.getFirstHeader("location");
        // 返回代码为302,301时，表示页面己经重定向，则重新请求location的url。
        if (locationHeader != null) {
            String redirectUrl = locationHeader.getValue();
            this.doRequest(redirectUrl, postData, header, ENCODE);
        }
        HttpResponseEntity result = new HttpResponseEntity();
        result.setResponseCode(httpResponse.getStatusLine().getStatusCode());
        result.setResponseContent(EntityUtils.toString(httpResponse.getEntity()));
        return result;

    }
}
