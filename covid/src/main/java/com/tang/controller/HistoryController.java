package com.tang.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tang.bean.HistoryBean;
import com.tang.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author tang
 * @date 2022/5/15 9:33
 * @desc
 */
@RestController
public class HistoryController {
    @Autowired
    private HistoryService historyService;
    @PostMapping("/c1")
    public JSONObject history(){
        HistoryBean today = historyService.getById(1);
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
        HistoryBean byId = historyService.getById(1);
        String incrVo = byId.getIncrVo();
        JSONObject ivJson = JSON.parseObject(incrVo);
        System.out.println(ivJson);
        Integer currentConfirmedIncr = (Integer) ivJson.get("currentConfirmedIncr");
        Integer confirmedIncr = (Integer) ivJson.get("currentConfirmedIncr");
        Integer curedIncr = (Integer) ivJson.get("curedIncr");
        Integer deadIncr = (Integer) ivJson.get("deadIncr");
        JSONObject json = new JSONObject();
        json.put("currentConfirmedIncr",currentConfirmedIncr);
        json.put("confirmedIncr",confirmedIncr);
        json.put("curedIncr",curedIncr);
        json.put("deadIncr",deadIncr);
        return json;
    }
}
