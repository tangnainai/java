package com.tang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tang.bean.HistoryBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author tang
 * @date 2022/5/15 9:52
 * @desc
 */
@Mapper
public interface HistoryMapper extends BaseMapper<HistoryBean> {
    HistoryBean findToday();
    void insertBean(HistoryBean historyBean);
    String selectByName(@Param("name") String name);
}
