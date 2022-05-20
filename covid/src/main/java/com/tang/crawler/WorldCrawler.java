package com.tang.crawler;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tang.bean.World;
import com.tang.service.WorldService;
import com.tang.utils.HttpUtils;
import com.tang.utils.TimeUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author tang
 * @date 2022/5/20 15:05
 * @desc
 */
@Component
public class WorldCrawler {
    @Autowired
    private WorldService worldService;
    @Scheduled(cron = "0 0 12 * * ?")
    @PostConstruct
    public void worldCrawler(){
        String time = TimeUtils.format(System.currentTimeMillis(),"yy-MM-dd HH:mm:ss");
        // 1、爬取网页
        String html = HttpUtils.getHtml("https://ncov.dxy.cn/ncovh5/view/pneumonia");
        // 2、解析网页中的较昨日json //getListByCountryTypeService2true
        Document doc = Jsoup.parse(html);
        Elements element = doc.select("script[id=getListByCountryTypeService2true]");
        String crawler = element.toString();
        // 3、去掉多余的 用正则表达式
        Matcher matcher = Pattern.compile("\\[(.*)\\]").matcher(crawler);
        String json = "";
        if(matcher.find())
            json = matcher.group(0);
        // 4、将json数据放入 实体类中
        List<World> list = JSON.parseArray(json, World.class);
        for (World world : list) {
            world.setTime(time);
            QueryWrapper<World> wrapper = new QueryWrapper<>();
            wrapper.eq("province_name",world.getProvinceName());
            worldService.saveOrUpdate(world,wrapper);
        }
        System.out.println("worldCrawler ==> 数据修改成功");
    }
}
