package com.dragon.reptile;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.io.IOException;
import java.util.*;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-08-03 14:06
 * @Description: ${Description}
 */

public class CsdnReadCount implements PageProcessor {


    // IP地址代理库Map
    private static Map<String, Integer> IPProxyRepository = new HashMap<>();
    private static List<String> keysArray = new ArrayList<>();
    private static int index;

    private Site site = Site
            .me()
            .setDomain("http://www.xicidaili.com/")
            .setSleepTime(3000).setUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");

    //按照顺序获取一个ip
    public static HttpHost getRandomProxy() {

        // 随机获取host:port，并构建代理对象
        String host = keysArray.get(index);
        if (index < keysArray.size() - 1) {
            index += 1;
        } else {
            index = 0;
        }

        int port = IPProxyRepository.get(host);
        HttpHost proxy = new HttpHost(host, port);  // 设置http代理
        return proxy;
    }

    //抓取西刺网前两页上代理IP，因为不稳定，所以不做过滤
    @Override
    public void process(Page page) {

        Html html = page.getHtml();
        List<String> hosts = html.xpath("//div[@id='body']/table/tbody/tr[@class='odd']/td[2]").replace("<td>", "").replace("</td>", "").all();
        List<String> ports = html.xpath("//div[@id='body']/table/tbody/tr[@class='odd']/td[3]").replace("<td>", "").replace("</td>", "").all();

        keysArray.addAll(hosts);
        for (int i = 0; i < hosts.size(); i++) {
            IPProxyRepository.put(hosts.get(i), Integer.valueOf(ports.get(i)));
        }
    }
    @Override
    public Site getSite() {
        return site;
    }

    //请求页面，返回页面html代码
    public static String getHttpContent(String url) throws IOException {

        HttpHost proxy = getRandomProxy();
        CloseableHttpClient httpClient = HttpClients.custom().setProxy(proxy).build();  // 创建httpclient对象


        HttpGet request = new HttpGet(url); // 构建htttp get请求
        request.setHeader("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.221 Safari/537.36 SE 2.X MetaSr 1.0");

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(5000).setConnectionRequestTimeout(1000)
                .setSocketTimeout(5000).build();

        request.setConfig(requestConfig);
        String host = null;
        Integer port = null;
        if (proxy != null) {
            host = proxy.getHostName();
            port = proxy.getPort();
        }

        request.setHeader("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.221 Safari/537.36 SE 2.X MetaSr 1.0");

        try {

            CloseableHttpResponse response = httpClient.execute(request);
            String result = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println("ip" + host + "连接成功" + index);
            System.out.println(result);
            System.out.println(new Date());
        } catch (Exception c) {
            System.out.println("ip" + host + "连接失败···");
            System.out.println("index:" + index);
            System.out.println(new Date());
        }

        return null;
    }

    public static void main(String[] args) throws InterruptedException, IOException {

        CsdnReadCount csdnReadCount = new CsdnReadCount();
        Spider spider = Spider.create(csdnReadCount);
        spider.addUrl("http://www.xicidaili.com/nn/1");
        spider.addUrl("http://www.xicidaili.com/nn/2");

        spider.run();

        getHttpContent("https://blog.csdn.net/caihaijiang/article/list/1");

    }
}