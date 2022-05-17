package com.tang.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tang
 * @date 2022/5/15 15:54
 * @desc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncrVo {
    private Integer id;
    private Integer currentConfirmedIncr; // 较昨日新增
    private Integer confirmedIncr; // 较昨日累计
    private Integer curedIncr; // 治愈
    private Integer deadIncr; // 死亡
    private String time; // 记录时间
}
