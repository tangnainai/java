package com.tang.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tang
 * @date 2022/5/20 15:03
 * @desc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class World {
    private Integer id;
    private String time;
    private Integer confirmedCount; // 现存确诊
    private String provinceName; // 国家
}
