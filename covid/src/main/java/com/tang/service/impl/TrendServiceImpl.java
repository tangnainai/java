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
}
