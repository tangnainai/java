package com.tang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tang.bean.World;
import com.tang.mapper.WorldMapper;
import com.tang.service.WorldService;
import org.springframework.stereotype.Service;

/**
 * @author tang
 * @date 2022/5/20 15:19
 * @desc
 */
@Service
public class WorldServiceImpl extends ServiceImpl<WorldMapper, World> implements WorldService {
}
