package com.tang;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tang.bean.Details;
import com.tang.bean.Trend;
import com.tang.service.DetailsService;
import com.tang.service.TrendService;
import com.tang.utils.HttpUtils;
import com.tang.utils.TimeUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Covid19ApplicationTests {
    @Autowired
    private TrendService trendService;
    @Test
    void contextLoads() {
        IPage<Trend> page = new Page<>(1,30);
        QueryWrapper<Trend> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        IPage<Trend> list = trendService.page(page, wrapper);
        list.getRecords().forEach(System.out::println);

    }

}
