package com.dragon.reptile;

/**
 * 动态加载破解
 * @Author: 龙万恒
 * @CreateTime: 2019-08-03 14:19
 * @Description: ${Description}
 */

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class JDPriceSplider implements PageProcessor {
    private Site site = Site
            .me()
            .setDomain("https://item.jd.com")
            .setSleepTime(3000);
    @Override
    public void process(Page page) {

        String url = page.getUrl().get();
        String id = url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf("."));
        //拼接获取价格的url
        String priceUrl = "https://p.3.cn/prices/mgets?pduid=1504781656858214892980&skuIds=J_" + id;

        //获取价格json信息
        String priceJson = getHttpContent(priceUrl);
        if (priceJson != null) {
            // 解析json [{"op":"4899.00","m":"9999.00","id":"J_3133843","p":"4799.00"}] 将该json字符串封装成json对象
            if (priceJson.contains("error")) {   // 返回{"error":"pdos_captcha"}，说明价格url已经不可用，更换pduid再做解析
            } else {
                JSONArray priceJsonArray = new JSONArray(priceJson);
                JSONObject priceJsonObj = priceJsonArray.getJSONObject(0);
                String priceStr = priceJsonObj.getString("p").trim();
                Float price = Float.valueOf(priceStr);


                System.out.println(price);
            }
        }
    }

    //相当于页面进行ajax调用，单独获取价格
    public static String getHttpContent(String url) {

        CloseableHttpClient httpClient = HttpClients.custom().build();  // 创建httpclient对象

        HttpGet request = new HttpGet(url); // 构建htttp get请求
        request.setHeader("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.221 Safari/537.36 SE 2.X MetaSr 1.0");


        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(5000).setConnectionRequestTimeout(1000)
                .setSocketTimeout(5000).build();
        request.setConfig(requestConfig);

        try {
            CloseableHttpResponse response = httpClient.execute(request);

            return EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        //访问手机详情页面
        Spider spider = Spider.create(new JDPriceSplider());
        spider.addUrl("https://item.jd.com/6946605.html");
        spider.run();
    }

}
