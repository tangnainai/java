package com.tang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tang.bean.Details;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author tang
 * @date 2022/5/15 12:27
 * @desc
 */
@Mapper
public interface DetailsMapper extends BaseMapper<Details> {
    public Details detailsByName(@Param("name") String name);
    public void insertDetails(Details details);
    public void updateByName(Details details);
}
