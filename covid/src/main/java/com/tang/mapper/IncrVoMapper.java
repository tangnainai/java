package com.tang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tang.bean.IncrVo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author tang
 * @date 2022/5/15 17:41
 * @desc
 */
@Mapper
public interface IncrVoMapper extends BaseMapper<IncrVo> {
    public IncrVo queryById();
}
