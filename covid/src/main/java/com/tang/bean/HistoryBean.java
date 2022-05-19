package com.tang.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author tang
 * @date 2022/5/14 19:14
 * @desc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryBean {
    private Integer id;
    private String time; // 数据获取时间
    @TableField("current_confirmed_count")
    private Integer currentConfirmedCount;// 确诊人数
    private Integer confirmedCount; // 现存确诊
    private Integer curedCount; // 已治愈
    private Integer deadCount; // 死亡人数
    private String provinceName; // 国家
    private String incrVo; // 昨天数据
    private String statisticsData;// 链接

    public HistoryBean(String time, Integer currentConfirmedCount, Integer confirmedCount,
                       Integer curedCount, Integer deadCount, String provinceName,String statisticsData) {
        this.time = time;
        this.currentConfirmedCount = currentConfirmedCount;
        this.confirmedCount = confirmedCount;
        this.curedCount = curedCount;
        this.deadCount = deadCount;
        this.provinceName = provinceName;
        this.statisticsData=statisticsData;
    }
}
