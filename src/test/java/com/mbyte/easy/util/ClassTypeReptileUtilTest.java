package com.mbyte.easy.util;

import com.mbyte.easy.class_type.entity.ClassType;
import com.mbyte.easy.class_type.mapper.ClassTypeMapper;
import com.mbyte.easy.class_type.service.IClassTypeService;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClassTypeReptileUtilTest {
    @Resource
    private ClassTypeMapper classTypeMapper;
    @Autowired
    private IClassTypeService classTypeService;
    @Test
//    @Transactional
    public  void test() {
        // 创建httpclient实例
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httpget实例
        HttpGet httpget = new HttpGet("https://blog.csdn.net/weixin_43611712");
        // 模拟浏览器，设置请求头✔
        httpget.setHeader("User-Agent",
                "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/60.0");
        RequestConfig config = RequestConfig.custom()
                //设置连接超时 ✔
                .setConnectTimeout(10000) // 设置连接超时时间 10秒钟
                .setSocketTimeout(10000) // 设置读取超时时间10秒钟
                .build();
        httpget.setConfig(config);
        // 执行get请求
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpget);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpEntity entity = response.getEntity();
        String content = null;
        try {
            content = EntityUtils.toString(entity, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(content);
        Document doc = Jsoup.parse(content);
        Elements elements =doc.getElementsByClass( "int1box");
        Elements classtypes =doc.getElementsByClass( "inlit");
        System.out.println("aaaaaaaaaaaaaa");
        List<ClassType> classTypeList=new ArrayList<ClassType>();
        for (Element element:elements) {
            Elements grade = element.select("span");
            Elements selects = element.select("li");
            for (Element select:selects) {
                ClassType classType=new ClassType();
                classType.setType(select.text());
                classType.setGrade(grade.text().replaceAll("\\>", ""));
                classType.setWebAddress("橡皮牛");
                classTypeList.add(classType);
            }
            System.out.println(element.text());
        }
        System.out.println(classTypeList);
//        for (int i = 0; i <classTypeList.size() ; i++) {
//            classTypeList.get(i).setId(i);
//        }
       classTypeService.saveBatch(classTypeList);
    }
}