package com.tang.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tang.bean.World;
import com.tang.service.WorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tang
 * @date 2022/5/20 15:24
 * @desc
 */
@RestController
public class WorldController {
    @Autowired
    private WorldService worldService;
    @PostMapping("/r2")
    public JSONObject world(){
        QueryWrapper<World> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("confirmed_count");
        IPage<World> page = new Page<>(1, 10);
        IPage<World> list = worldService.page(page, wrapper);

        JSONObject json = new JSONObject();
        List<Integer> confirmedCount = new ArrayList<>();
        List<String> provinceName = new ArrayList<>();
        for (int i = list.getRecords().size() - 1; i >= 0; i--) {
            confirmedCount.add(list.getRecords().get(i).getConfirmedCount());
            provinceName.add(list.getRecords().get(i).getProvinceName());
        }

        json.put("confirmedCount",confirmedCount);
        json.put("provinceName",provinceName);

        return json;
    }
}
