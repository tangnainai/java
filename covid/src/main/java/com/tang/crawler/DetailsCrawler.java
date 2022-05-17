package com.tang.crawler;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.org.apache.xml.internal.serialize.ElementState;
import com.tang.bean.Details;
import com.tang.service.DetailsService;
import com.tang.utils.HttpUtils;
import com.tang.utils.TimeUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author tang
 * @date 2022/5/15 12:27
 * @desc
 */
@Component
public class DetailsCrawler {
    @Autowired
    private DetailsService detailsService;

    @PostConstruct
    @Scheduled(cron = "0 0 12 * * ?")
    public void detailsCrawler(){
        String time = TimeUtils.format(System.currentTimeMillis(), "yy-MM-dd HH:mm:ss");
        // 1、爬取疫情数据页面
        String html = HttpUtils.getHtml("https://ncov.dxy.cn/ncovh5/view/pneumonia");
        // 2、解析页面中省份的JSON  id = getAreaStat
        Document doc = Jsoup.parse(html);
        String crawler = doc.select("script[id=getAreaStat]").toString();
        // 3、用正则表达式去掉 json前后数据
        String pattern = "\\[(.*)\\]"; // 定义正则规则
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(crawler);
        String json = "";
        if (matcher.find()) json = matcher.group(0);
        // 4、将json数据放入 实体类中
        List<Details> details = JSON.parseArray(json, Details.class);
        Details dt = new Details("南海诸岛",0,time);
        details.add(dt);
        for (Details detail : details) {
            detail.setTime(time);
            QueryWrapper<Details> Name = new QueryWrapper<>();
            Name.eq("province_short_name",detail.getProvinceShortName());
            detailsService.saveOrUpdate(detail);
        }
        System.out.println("DetailsCrawler==>已经修改地图数据");
    }
}
