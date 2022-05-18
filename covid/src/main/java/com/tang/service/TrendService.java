package com.tang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tang.bean.Trend;

import java.util.List;

/**
 * @author tang
 * @date 2022/5/15 19:55
 * @desc
 */
public interface TrendService extends IService<Trend> {
    boolean getByDateId(Integer dateId);
    List<Integer> dateId();
    List<Integer> confirmedIncr();
    List<Integer> curedIncr();
    List<Integer> currentConfirmedIncr();
    List<Integer> deadIncr();
}
