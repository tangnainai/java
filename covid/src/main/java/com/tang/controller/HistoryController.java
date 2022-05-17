package com.tang.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tang.bean.HistoryBean;
import com.tang.bean.IncrVo;
import com.tang.service.HistoryService;
import com.tang.service.IncrVoService;
import org.openqa.selenium.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author tang
 * @date 2022/5/15 9:33
 * @desc
 */
@RestController
public class HistoryController {
    @Autowired
    private HistoryService historyService;
    @Autowired
    private IncrVoService incrVoService;
    @PostMapping("/c1")
    public JSONObject history(){
        HistoryBean today = historyService.findToday();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("dead",today.getDeadCount());
        jsonObject.put("confirm",today.getCurrentConfirmedCount());
        jsonObject.put("heal",today.getCuredCount());
        jsonObject.put("nowConfirm",today.getConfirmedCount());
        return jsonObject;
    }
    @PostMapping("/time")
    public String time(){
        String date = DateFormat.getDateTimeInstance().format(new Date());
        return date;
    }
    @PostMapping("/r1")
    public JSONObject ecRight1(){
        IncrVo query = incrVoService.queryById();
        JSONObject json = new JSONObject();
        json.put("currentConfirmedIncr",query.getCurrentConfirmedIncr());
        json.put("confirmedIncr",query.getConfirmedIncr());
        return json;
    }
    @PostMapping("/r2")
    public JSONObject ecRight2(){
        IncrVo query = incrVoService.queryById();
        JSONObject json = new JSONObject();
        json.put("curedIncr",query.getCuredIncr());
        json.put("deadIncr",query.getDeadIncr());
        return json;
    }

}
