package com.tang.crawler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tang.bean.HistoryBean;
import com.tang.bean.Trend;
import com.tang.service.HistoryService;
import com.tang.service.TrendService;
import com.tang.utils.HttpUtils;
import com.tang.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author tang
 * @date 2022/5/15 19:28
 * @desc
 */
@Component
public class TrendCrawler {

    @Autowired
    private TrendService trendService;
    @Autowired
    private HistoryService historyService;

    @PostConstruct
    @Scheduled(cron = "0 0 12 * * ?")
    public void trendCrawler(){
        String time = TimeUtils.format(System.currentTimeMillis(),"yy-MM-dd HH:mm:ss");
        // 1、 爬取json
        QueryWrapper<HistoryBean> wrapper = new QueryWrapper<>();
        wrapper.eq("province_name","中国");
        List<HistoryBean> historyList = historyService.list(wrapper);
        String statisticsData = historyList.get(0).getStatisticsData();
        String html = HttpUtils.getHtml(statisticsData);
        // 2、取出data
        JSONObject json = JSON.parseObject(html);
        String data = json.getString("data");
        // 3、取出data
        List<Trend> list = JSON.parseArray(data, Trend.class);
        // 4、判断数据库是否存在分区
        if(trendService.list().size()<=0){
            for (Trend trend : list) {
                trend.setTime(time);
                trendService.save(trend);
            }
        }else {
            QueryWrapper<Trend> query = new QueryWrapper<>();
            Trend trend = list.get(list.size() - 1);
            trend.setTime(time);
            query.eq("date_id",trend.getDateId());
            trendService.saveOrUpdate(trend,query);
        }
        System.out.println("TrendCrawler==》新增数据变化");
    }
}
