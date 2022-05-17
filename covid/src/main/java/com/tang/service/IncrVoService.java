package com.tang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tang.bean.IncrVo;

/**
 * @author tang
 * @date 2022/5/15 17:45
 * @desc
 */
public interface IncrVoService extends IService<IncrVo> {
    IncrVo queryById();
}
