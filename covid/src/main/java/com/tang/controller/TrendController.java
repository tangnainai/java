package com.tang.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tang.bean.Trend;
import com.tang.service.TrendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tang
 * @date 2022/5/15 20:35
 * @desc
 */
@RestController
public class TrendController {
    @Autowired
    private TrendService trendService;
    @PostMapping("/l1")
    public JSONObject left1(){
        JSONObject json = new JSONObject();
        List<Trend> list = trendService.list();
        List<Integer> dateId = new ArrayList<>();
        List<Integer> deadCount = new ArrayList<>();
        List<Integer> currentConfirmedCount = new ArrayList<>();
        List<Integer> confirmedCount = new ArrayList<>();
        List<Integer> curedCount = new ArrayList<>();
        for (Trend trend : list) {
            dateId.add(trend.getDateId());
            deadCount.add(trend.getDeadCount());
            currentConfirmedCount.add(trend.getCurrentConfirmedCount());
            confirmedCount.add(trend.getConfirmedCount());
            curedCount.add(trend.getCuredCount());
        }
        json.put("dateId",dateId);
        json.put("deadCount",deadCount);
        json.put("currentConfirmedCount",currentConfirmedCount);
        json.put("confirmedCount",confirmedCount);
        json.put("curedCount",curedCount);
//        System.out.println(json);
        return json;
    }
    @PostMapping("/l2")
    public JSONObject left2(){
        JSONObject json = new JSONObject();
        List<Trend> list = trendService.list();
        List<Integer> dateId = new ArrayList<>();
        List<Integer> confirmedIncr = new ArrayList<>();
        List<Integer> curedIncr = new ArrayList<>();
        List<Integer> currentConfirmedIncr = new ArrayList<>();
        List<Integer> deadIncr = new ArrayList<>();
        for (Trend trend : list) {
            dateId.add(trend.getDateId());
            confirmedIncr.add(trend.getConfirmedIncr());
            curedIncr.add(trend.getCuredIncr());
            currentConfirmedIncr.add(trend.getCurrentConfirmedIncr());
            deadIncr.add(trend.getDeadIncr());
        }
        json.put("dateId",dateId);
        json.put("confirmedIncr",confirmedIncr);
        json.put("curedIncr",curedIncr);
        json.put("currentConfirmedIncr",currentConfirmedIncr);
        json.put("deadIncr",deadIncr);
        return json;
    }
}
