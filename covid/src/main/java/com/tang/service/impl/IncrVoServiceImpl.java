package com.tang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tang.bean.IncrVo;
import com.tang.mapper.IncrVoMapper;
import com.tang.service.IncrVoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tang
 * @date 2022/5/15 17:46
 * @desc
 */
@Service
public class IncrVoServiceImpl extends ServiceImpl<IncrVoMapper,IncrVo> implements IncrVoService {
    @Autowired
    private IncrVoMapper incrVoMapper;

    @Override
    public IncrVo queryById() {
        return incrVoMapper.queryById();
    }
}
