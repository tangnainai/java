package com.tang.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
        IPage<Trend> page = new Page<>(1, 30);
        QueryWrapper<Trend> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        IPage<Trend> list = trendService.page(page, wrapper);

        List<Integer> dateId = new ArrayList<>();
        List<Integer> deadCount = new ArrayList<>();
        List<Integer> currentConfirmedCount = new ArrayList<>();
        List<Integer> confirmedCount = new ArrayList<>();
        List<Integer> curedCount = new ArrayList<>();

        for (int i = list.getRecords().size() - 1; i >= list.getRecords().size()-30; i--) {
            dateId.add(list.getRecords().get(i).getDateId());
            deadCount.add(list.getRecords().get(i).getDeadCount());
            currentConfirmedCount.add(list.getRecords().get(i).getCurrentConfirmedCount());
            confirmedCount.add(list.getRecords().get(i).getConfirmedCount());
            curedCount.add(list.getRecords().get(i).getCuredCount());
        }

        json.put("dateId",dateId);
        json.put("deadCount",deadCount);
        json.put("currentConfirmedCount",currentConfirmedCount);
        json.put("confirmedCount",confirmedCount);
        json.put("curedCount",curedCount);

//        System.err.println("================"+dateId.size());
//        System.out.println(json);
        return json;
    }
    @PostMapping("/l2")
    public JSONObject left2(){
        JSONObject json = new JSONObject();
        IPage<Trend> page = new Page<>(1,30);
        QueryWrapper<Trend> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        IPage<Trend> list = trendService.page(page, wrapper);

        List<Integer> dateId =  new ArrayList<>();
        List<Integer> confirmedIncr = new ArrayList<>();
        List<Integer> curedIncr =  new ArrayList<>();
        List<Integer> currentConfirmedIncr =new ArrayList<>();
        List<Integer> deadIncr =new ArrayList<>();

        for (int i = list.getRecords().size() - 1; i >= list.getRecords().size()-30; i--) {
            dateId.add(list.getRecords().get(i).getDateId());
            confirmedIncr.add(list.getRecords().get(i).getConfirmedIncr());
            curedIncr.add(list.getRecords().get(i).getCuredIncr());
            currentConfirmedIncr.add(list.getRecords().get(i).getCurrentConfirmedIncr());
            deadIncr.add(list.getRecords().get(i).getDeadIncr());
        }

        json.put("dateId",dateId);
        json.put("confirmedIncr",confirmedIncr);
        json.put("curedIncr",curedIncr);
        json.put("currentConfirmedIncr",currentConfirmedIncr);
        json.put("deadIncr",deadIncr);
        return json;
    }
}
