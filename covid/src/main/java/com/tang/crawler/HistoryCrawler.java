package com.tang.crawler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mysql.cj.Session;
import com.tang.bean.HistoryBean;
import com.tang.bean.IncrVo;
import com.tang.service.HistoryService;
import com.tang.service.IncrVoService;
import com.tang.utils.HttpUtils;
import com.tang.utils.TimeUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author tang
 * @date 2022/5/15 9:58
 * @desc
 */
@Component
public class HistoryCrawler {
    @Autowired
    private HistoryService historyService;
    @Autowired
    private IncrVoService incrVoService;
//
    @PostConstruct
    @Scheduled(cron = "0 0 12 * * ?")
    public void historyBean(){
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
        List<HistoryBean> list = JSON.parseArray(json, HistoryBean.class);
        for (HistoryBean bean : list) {
            if(bean.getProvinceName().equals("中国")){
                bean.setTime(time);
                HistoryBean historyBean = new HistoryBean(bean.getTime(),bean.getCurrentConfirmedCount(),
                        bean.getConfirmedCount(),bean.getCuredCount(),bean.getDeadCount(),bean.getProvinceName(),bean.getStatisticsData());
                QueryWrapper<HistoryBean> update = new QueryWrapper<>();
                update.eq("province_name","中国");
                historyService.saveOrUpdate(historyBean,update);
                // 右边的柱状图
                IncrVo incrVo = bean.getIncrVo();
                incrVo.setTime(time);
                incrVo.setId(1);
                incrVoService.updateById(incrVo);
                System.out.println("修改incrVo了");
            }
        }
        System.out.println("HistoryCrawler == >已修改头部数据");

    }

}
