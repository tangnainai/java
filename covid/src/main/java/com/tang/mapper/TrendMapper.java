package com.tang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tang.bean.Trend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author tang
 * @date 2022/5/15 19:48
 * @desc
 */
@Mapper
public interface TrendMapper extends BaseMapper<Trend> {
    Trend getByDateId(@Param("dateId")Integer dateId);
    List<Integer> dateId();
    List<Integer> confirmedCount();
    List<Integer> curedCount();
    List<Integer> currentConfirmedCount();
    List<Integer> deadCount();
    List<Integer> confirmedIncr();
    List<Integer> curedIncr();
    List<Integer> currentConfirmedIncr();
    List<Integer> deadIncr();
}
