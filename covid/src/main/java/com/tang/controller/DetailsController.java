package com.tang.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tang.bean.Details;
import com.tang.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author tang
 * @date 2022/5/15 12:55
 * @desc
 */
@RestController
public class DetailsController {
    @Autowired
    private DetailsService detailsService;

    @PostMapping("/c2")
    public JSONArray detailsJson(){
        JSONArray json = new JSONArray();
        List<Details> list = detailsService.list();
        for (int i = 0; i < list.size(); i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name",list.get(i).getProvinceShortName());
            jsonObject.put("value",list.get(i).getCurrentConfirmedCount());
            json.add(jsonObject);
        }
        return json;
    }
}
