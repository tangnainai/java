package com.tang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tang.bean.World;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author tang
 * @date 2022/5/20 15:18
 * @desc
 */
@Mapper
public interface WorldMapper extends BaseMapper<World> {
}
