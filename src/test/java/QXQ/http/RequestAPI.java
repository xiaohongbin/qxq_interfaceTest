package QXQ.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aventstack.extentreports.ExtentTest;
import QXQ.Constants.InterfaceConstants;
import QXQ.listener.ExtentTestNGITestListener;
import org.apache.commons.io.FileUtils;
import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.*;

public class RequestAPI {

    ExtentTestNGITestListener el = new ExtentTestNGITestListener();
    ExtentTest log = el.getlog();


    CloseableHttpClient httpclient;
    HttpGet httpGet;
    HttpPost httpPost;
    HttpRequest httpRequest;
    public CloseableHttpResponse httpResponse;
    HashMap<String, String> responseHeads;
    int responseCode;
    String responseBody;
    JSONObject responseBodyJson;

    /**
     * 通过httpclient获取有参post请求的response
     *
     * @param url
     * @param params
     * @throws IOException
     */
    public HttpResponse http_post(String url, String params) throws IOException {
        httpclient = HttpClients.createDefault();
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(3000)
                .setConnectionRequestTimeout(3000)
                .setSocketTimeout(3000)
                .setContentCompressionEnabled(true)
                .setRedirectsEnabled(true)
                .build();
        //创建post请求对象
        httpPost = new HttpPost(url);
        //设置超时时间
        httpPost.setConfig(requestConfig);
        httpPost.setHeader("Accept", "text/html, application/json, text/javascript, */*; q=0.01");
        httpPost.setHeader("Content-Type", "text/html");

       /* log.info("+"+url);
        log.info("+"+params);*/


        //设置请求主体格式
//        httpPost.addHeader("Accept-Encoding","gzip");
//        StringEntity s = new StringEntity(params.toString());
        StringEntity s = new StringEntity(params);
        httpPost.setEntity(s);
        httpResponse = httpclient.execute(httpPost);
        return httpResponse;
    }

    /**
     * post Form 键值对请求
     * @param url 请求地址
     * @param map 请求参数
     * @return
     * @throws IOException
     */
    public HttpResponse http_Post_Form(String url, Map<String, String> map) throws IOException {
        httpclient = HttpClients.createDefault();
        httpPost = new HttpPost(url);
        //装填参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        httpPost.setEntity(new UrlEncodedFormEntity(nvps));

//        System.out.println("请求地址：" + url);
//        System.out.println("请求参数：" + nvps.toString());

        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
        httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        httpResponse = httpclient.execute(httpPost);
        return httpResponse;
    }


    /**
     * get 带参请求
     * @param url 请求地址
     * @param map 请求参数
     * @return
     * @throws IOException
     * @throws URISyntaxException
     */
    public HttpResponse http_Get_Form(String url, Map<String, String> map) throws IOException, URISyntaxException {
        httpclient = HttpClients.createDefault();
        URIBuilder uriBuilder = new URIBuilder(url);

        //装填参数
        List<NameValuePair> list = new LinkedList<>();
        for (Map.Entry<String,String> entry:map.entrySet()){
            list.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
        }
        uriBuilder.setParameters(list);

        httpGet = new HttpGet(uriBuilder.build());
        /*System.out.println("请求地址：" + url);
        System.out.println("请求参数：" + uriBuilder.toString());*/

        httpGet.setHeader("Content-type", "application/x-www-form-urlencoded");
        httpGet.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        httpResponse = httpclient.execute(httpGet);
        return httpResponse;
    }
    /**
     * get 无参数请求
     * @param url
     * @return
     * @throws IOException
     */
    public HttpResponse http_get(String url) throws IOException {
        //创建Httpclient对象
        httpclient = HttpClients.createDefault();
        //创建Httpclien 请求
        httpGet = new HttpGet(url);

        httpResponse = httpclient.execute(httpGet);
        String conten;
        if (httpResponse.getStatusLine().getStatusCode() == 200) {
            //请求体内容
            conten = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
            //内容写入文件
            FileUtils.writeStringToFile(new File("E:\\content\\1111.txt"), conten, "UTF-8");
        }
//        httpResponse = httpclient.execute(httpGet);

        return httpResponse;
    }


    /**
     * 以JSON格式获取到response body
     */
    public JSONObject getBodyInJSON() throws ParseException, IOException {
        HttpEntity entity;
        String entityToString;
        entity = httpResponse.getEntity();
        entityToString = EntityUtils.toString(entity, "utf-8");
        responseBodyJson = JSON.parseObject(entityToString);
//        System.out.println("This is your response body:Json格式" + responseBody1);
        responseBody = JSONObject.toJSONString(entityToString);
//        System.out.println("This is your response body:String格式" + responseBody);
        return responseBodyJson;
    }


    /**
     * 用哈希图准备请求头部信息
     */
    public String requestHeaderInHash(long timestamp, String aurl) throws IOException {
        String url;
//        String aurl =null;
        HashMap<String, String> pmap = new HashMap<String, String>();
        pmap.put("oh", InterfaceConstants.REGOH1 + timestamp + InterfaceConstants.REGOH2);
        pmap.put("_s", InterfaceConstants.REG_S);
        pmap.put("_t", ""+ timestamp );
        StringBuilder param = new StringBuilder("");
        for (String key : pmap.keySet()) {
            param.append(key + "=" + URLEncoder.encode(pmap.get(key), "UTF-8") + "&");
        }
        url = aurl + param.toString();
        url = url.substring(0, url.length() - 1);
        return url;
    }
    public String requestHeaderInHashA(long timestamp, String aurl, String token,String sid) throws IOException {
        String url;
//        String aurl =null;
        HashMap<String, String> pmap = new HashMap<String, String>();
        pmap.put("token",token);
        pmap.put("oh", InterfaceConstants.REGOH1 + timestamp + InterfaceConstants.REGOH2);
        pmap.put("_s", InterfaceConstants.REG_S);
        pmap.put("_t", ""+ timestamp );
        pmap.put("sid",sid);
        StringBuilder param = new StringBuilder("");
        for (String key : pmap.keySet()) {
            param.append(key + "=" + URLEncoder.encode(pmap.get(key), "UTF-8") + "&");
        }
        url = aurl + param.toString();
        url = url.substring(0, url.length() - 1);
        return url;
    }
    /**
     * 以哈希图的方式获取到响应头部
     */
    public HashMap<String, String> getHeaderInHash() {
        Header[] headers;
        headers = httpResponse.getAllHeaders();
        responseHeads = new HashMap<String, String>();
        for (Header header : headers) {
            responseHeads.put(header.getName(), header.getValue());
        }
//        System.out.println("This is your response header:" + responseHeads);
        return responseHeads;
    }

    /**
     * 获取response状态码
     */
    public int getCodeInNumber() {
        responseCode = httpResponse.getStatusLine().getStatusCode();
        return responseCode;
    }


    /**
     * 通过httpclient获取get请求的response
     */
    public void getResponse(String url) throws IOException {
        httpclient = HttpClients.createDefault();
        //创建get请求对象
        httpGet = new HttpGet(url);
        httpResponse = httpclient.execute(httpGet);
    }

    /**
     * 通过httpclient获取无参post请求的response
     *
     * @param url
     * @param params
     * @param headers
     * @throws IOException
     */
    public void sendPost(String url, StringEntity params, HashMap<String, String> headers) throws IOException {
        httpclient = HttpClients.createDefault();
        //创建post请求对象
        httpPost = new HttpPost(url);

//　　　设置请求主体格式
        httpPost.setEntity(params);
//      设置头部信息
        Set<String> set = headers.keySet();
        for (Iterator<String> iterator = set.iterator(); iterator.hasNext(); ) {
            String key = iterator.next();
            String value = headers.get(key);
            httpPost.addHeader(key, value);
        }
        httpPost.getURI();
        httpResponse = httpclient.execute(httpPost);
    }
}
