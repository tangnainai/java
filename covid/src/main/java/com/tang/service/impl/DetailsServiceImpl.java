package com.tang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tang.bean.Details;
import com.tang.mapper.DetailsMapper;
import com.tang.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tang
 * @date 2022/5/15 12:29
 * @desc
 */
@Service
public class DetailsServiceImpl extends ServiceImpl<DetailsMapper, Details> implements DetailsService {
    @Autowired
    private DetailsMapper detailsMapper;

    @Override
    public boolean detailsByName(String name) {
        if (detailsMapper.detailsByName(name)==null) return true;
        else return false;
    }

    @Override
    public void insertDetails(Details details) {
        detailsMapper.insertDetails(details);
    }

    @Override
    public void updateByName(Details details) {
        detailsMapper.updateByName(details);
    }
}
