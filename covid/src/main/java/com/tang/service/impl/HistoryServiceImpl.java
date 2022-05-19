package com.tang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tang.bean.HistoryBean;
import com.tang.mapper.HistoryMapper;
import com.tang.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tang
 * @date 2022/5/15 9:54
 * @desc
 */
@Service
public class HistoryServiceImpl extends ServiceImpl<HistoryMapper,HistoryBean> implements HistoryService {

}
