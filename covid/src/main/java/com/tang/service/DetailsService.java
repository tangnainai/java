package com.tang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tang.bean.Details;

/**
 * @author tang
 * @date 2022/5/15 12:29
 * @desc
 */
public interface DetailsService extends IService<Details> {
    public boolean detailsByName(String name);
    void insertDetails(Details details);
    public void updateByName(Details details);
}
