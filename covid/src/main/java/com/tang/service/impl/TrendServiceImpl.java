package com.tang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tang.bean.Trend;
import com.tang.mapper.TrendMapper;
import com.tang.service.TrendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tang
 * @date 2022/5/15 19:55
 * @desc
 */
@Service
public class TrendServiceImpl extends ServiceImpl<TrendMapper, Trend>implements TrendService {
    @Autowired
    private TrendMapper trendMapper;
    @Override
    public boolean getByDateId(Integer dateId) {
        return (trendMapper.getByDateId(dateId)==null)?true:false;
    }

    @Override
    public List<Integer> dateId() {
        return trendMapper.dateId();
    }

    @Override
    public List<Integer> confirmedCount() {
        return trendMapper.confirmedCount();
    }

    @Override
    public List<Integer> curedCount() {
        return trendMapper.curedCount();
    }

    @Override
    public List<Integer> currentConfirmedCount() {
        return trendMapper.currentConfirmedCount();
    }

    @Override
    public List<Integer> deadCount() {
        return trendMapper.deadCount();
    }

    @Override
    public List<Integer> confirmedIncr() {
        return trendMapper.confirmedIncr();
    }

    @Override
    public List<Integer> curedIncr() {
        return trendMapper.curedIncr();
    }

    @Override
    public List<Integer> currentConfirmedIncr() {
        return trendMapper.currentConfirmedIncr();
    }

    @Override
    public List<Integer> deadIncr() {
        return trendMapper.deadIncr();
    }
}
